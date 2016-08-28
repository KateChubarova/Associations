package com.ekaterinachubarova.associations.fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ekaterinachubarova.associations.R;
import com.ekaterinachubarova.associations.activities.FrogActivity;
import com.ekaterinachubarova.associations.activities.LevelsActivity;
import com.ekaterinachubarova.associations.essences.Country;
import com.ekaterinachubarova.associations.essences.CountryLab;
import com.ekaterinachubarova.associations.essences.Language;
import com.ekaterinachubarova.associations.essences.Settings;
import com.ekaterinachubarova.associations.square_view.PictureButton;

import java.util.Timer;

public class GameFragment extends Fragment implements Animation.AnimationListener{

    private Animation answerAnimation;
    private Animation disappearAnimation;
    private Animation appearAnimation;
    private Animation rotateAnimation;
    private int animationIndex;

    private Button check;
    private EditText editText;
    private TextView levelText;
    private TextView moneyText;

    private LinearLayout backgroundLayout;
    private PictureButton[] images;
    private PictureButton countryPicture;
    private int indexPicture;
    private int count = 6;

    private Timer timer;
    private int timeLimit;

    private final int ANIMATION_INDEX_PICTURE = 4;
    private final int ANIMATION_INDEX_DIALOG = 1;
    private final int ANIMATION_INDEX_ZERO = 0;

    private Context context;
    private Country country;

    public static final String EXTRA_GAME_ID = "country_id";
    private Language language = Language.getCurrentLanguage(context);
    private CountryLab countryLab = CountryLab.get(context);
    private Settings settings = Settings.get(context);

    public static GameFragment newInstance (int id) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_GAME_ID, id);
        GameFragment gameFragment = new GameFragment();
        gameFragment.setArguments(args);
        return gameFragment;
    }

    private void adverb () {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(language.getTitle()).setMessage(language.getMessage()).setIcon(R.drawable.ic_true)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            AlertDialog alert = builder.create();
            alert.show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();

        animationIndex = ANIMATION_INDEX_ZERO;

        disappearAnimation = AnimationUtils.loadAnimation(context, R.anim.disappear);
        disappearAnimation.setAnimationListener(GameFragment.this);

        appearAnimation = AnimationUtils.loadAnimation(context, R.anim.appear);
        appearAnimation.setAnimationListener(GameFragment.this);

        answerAnimation = AnimationUtils.loadAnimation(context, R.anim.correctanswer);
        answerAnimation.setAnimationListener(GameFragment.this);

        rotateAnimation = AnimationUtils.loadAnimation(context, R.anim.froganimation);
        rotateAnimation.setAnimationListener(GameFragment.this);

        settings.setLevel((int)getArguments().getSerializable(EXTRA_GAME_ID));
        country = countryLab.getCountry(settings.getLevel());


    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.game_fragment, parent, false);

        levelText = (TextView)v.findViewById(R.id.levelText);
        moneyText = (TextView)v.findViewById(R.id.moneyText);
        moneyText.setText(Integer.toString(settings.getMoney()));
        String textLevel = language.getLevel() + " " + Integer.toString(settings.getLevel()+1);
        levelText.setText(textLevel);


        editText = (EditText)v.findViewById(R.id.editText);
        check = (Button)v.findViewById(R.id.check_button);
        check.setText(language.getCheck());
        check.setOnClickListener(checkClick);

        backgroundLayout = (LinearLayout)v.findViewById(R.id.back);
        backgroundLayout.setBackgroundResource(country.getColor());

        Typeface face = Typeface.createFromAsset(context.getAssets(), getString(R.string.head));
        levelText.setTypeface(face);
        check.setTypeface(face);
        moneyText.setTypeface(face);


        images = new PictureButton[count];
        images[0] = (PictureButton)v. findViewById(R.id.imageView1);
        images[1] = (PictureButton)v. findViewById(R.id.imageView2);
        images[2] = (PictureButton)v. findViewById(R.id.imageView3);
        images[3] = (PictureButton)v. findViewById(R.id.imageView4);
        images[4] = (PictureButton)v. findViewById(R.id.imageView5);
        images[5] = (PictureButton)v. findViewById(R.id.imageView6);

        countryPicture = (PictureButton)v. findViewById(R.id.imageViewCountry);

        for (int i = 0; i < count ; i++) {
            images[i].setUsed(country.getIsOpenPicture(i));

            if (country.getIsOpenPicture(i)) {
                images[i].setBackgroundResource(country.getSmallOpenPicture(i));
            }

            images[i].setIndex(i);
            images[i].setOnClickListener(imageClick);
        }
        countryPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countryPicture.startAnimation(rotateAnimation);
            }
        });
        return v;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    View.OnClickListener imageClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            PictureButton button = (PictureButton)view;

            if (!button.isUsed()) {
                indexPicture = button.getIndex();
                ///
                country.setIsOpenPicture(indexPicture);
                ////
                //if (click) return;
                if (settings.getMoney() <= 0) {
                    adverb();
                    return;
                }

                //click = true;
                view.startAnimation(disappearAnimation);
                animationIndex = ANIMATION_INDEX_PICTURE;
                button.setUsed(true);
                moneyText.setText(Integer.toString(settings.decAndGetMoney()));
            }
            if (button.isUsed()) {
//                MainPictureFragment mainPictureFragment = MainPictureFragment.newInstance(1),
//                        button.getIndex());
//                FragmentManager fragmentManager = getFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.gameContainer, mainPictureFragment);
            }

        }
    };



    View.OnClickListener checkClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (editText.getText().toString().equalsIgnoreCase(getResources().getString(country.getEnglishName())) ||
                    editText.getText().toString().equalsIgnoreCase(getResources().getString(country.getRussianName()))) {
                check.setClickable(false);
                country.setIsOpen(Country.LEVEL_SOLVED);
                animationIndex = ANIMATION_INDEX_DIALOG;
                countryPicture.setBackgroundResource(country.getMainPicture());
                countryPicture.startAnimation(answerAnimation);

            } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(language.getIncorrectMessage()).setMessage(language.getIncorrectAnswer()).setIcon(R.drawable.ic_false)
                        .setCancelable(false).setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }

    };
    public void updateLevelNext () {
        country = CountryLab.get(context).getCountry(settings.getLevel());

        if (country.getIsOpen() != Country.LEVEL_SOLVED) {
            country.setIsOpen(Country.LEVEL_OPENED);
        }

        check.setClickable(true);
        for (int i=0; i<count; i++) {
            images[i].setUsed(false);
            images[i].setBackgroundResource(R.drawable.ic_empty);
        }
        countryPicture.setBackgroundResource(R.drawable.ic_frog);
        animationIndex = 0;
        editText.setText("");   // сбросить текст ввода
        backgroundLayout.setBackgroundResource(country.getColor());   // поменять фон
        levelText.setText(language.getLevel() + " " + Integer.toString(settings.getLevel()+1));

    }


    @Override
    public void onAnimationEnd(Animation animation) {
        if (animationIndex == ANIMATION_INDEX_PICTURE) {
            images[indexPicture].setBackgroundResource(country.getSmallOpenPicture(indexPicture));
            animationIndex = ANIMATION_INDEX_ZERO;
            images[indexPicture].startAnimation(appearAnimation);
        }

        if (animationIndex == ANIMATION_INDEX_DIALOG) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(language.getTitle()).setIcon(R.drawable.ic_true).setCancelable(false);
            if (settings.getLevel() <= 25) {
                if (2 > 1) {
                    builder.setMessage(language.getMessage()).setPositiveButton(language.getButton(), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            settings.incLevel();
                            updateLevelNext();
                        }
                    });
                } else {
                    builder.setMessage(language.getFinalMessage()).
                            setNegativeButton(language.getNo(), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent i = new Intent(context, FrogActivity.class);
                                    startActivity(i);
                                }
                            }).setPositiveButton(language.getYes(), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            Intent i = new Intent(context, LevelsActivity.class);
                            startActivity(i);
                        }
                    });
                }
                AlertDialog alert = builder.create();
                alert.show();
            }
            animationIndex = ANIMATION_INDEX_ZERO;
            //click = false;
        }
    }

    @Override
    public void onAnimationRepeat (Animation animation){
        countryPicture.setBackgroundResource(country.getMainPicture());
    }
}

