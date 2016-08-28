package com.ekaterinachubarova.associations.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.ekaterinachubarova.associations.R;
import com.ekaterinachubarova.associations.essences.CountryLab;
import com.ekaterinachubarova.associations.essences.Language;
import com.ekaterinachubarova.associations.essences.Settings;
import com.ekaterinachubarova.associations.square_view.SquareImageView;


public class StartActivity extends Activity implements Animation.AnimationListener{

    private int animationIndex = 0;
    private final int ANIMATION_INDEX_ZERO = 0;
    private final int ANIMATION_INDEX_NEW_INTENT = 1;
    private final int ANIMATION_INDEX_GO_TO_MARKET = 2;
    private final int ANIMATION_INDEX_CHANGE_LANGUAGE = 3;
    private final int ANIMATION_INDEX_ROTATE_FROG = 4;

    private Animation myAnimation;
    private Animation frogAnimation;

    private SquareImageView playButton;
    private SquareImageView rateBtn;
    private SquareImageView helpBtn;

    private SquareImageView rus;
    private SquareImageView eng;

    private SquareImageView frogView;
    private TextView appName;

    private Language language;
    private Context context;
    private Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        language = Language.getCurrentLanguage(this);
        settings = Settings.get(this);

        rus = (SquareImageView)findViewById(R.id.rus);
        eng = (SquareImageView)findViewById(R.id.eng);

        rus.setBackgroundResource(language.getPictureId1());
        eng.setBackgroundResource(language.getPictureId2());

        context = this;


        final View.OnClickListener languageCLick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                language = Language.changeAndGetCurrentLanguage(context);
                rus.setBackgroundResource(language.getPictureId1());
                eng.setBackgroundResource(language.getPictureId2());

            }
        };

        myAnimation = AnimationUtils.loadAnimation(StartActivity.this, R.anim.startbutton);
        myAnimation.setAnimationListener(StartActivity.this);

        frogAnimation = AnimationUtils.loadAnimation(StartActivity.this, R.anim.froganimation);
        frogAnimation.setAnimationListener(StartActivity.this);

        playButton = (SquareImageView)findViewById(R.id.playButton);
        rateBtn = (SquareImageView)findViewById(R.id.rateBtn);
        helpBtn = (SquareImageView)findViewById(R.id.helpBtn);

        rus.setOnClickListener(languageCLick);
        eng.setOnClickListener(languageCLick);

        frogView = (SquareImageView)findViewById(R.id.frogView);
        appName = (TextView)findViewById(R.id.appName);

        Typeface face = Typeface.createFromAsset(getAssets(), getString(R.string.roboto_head));
        appName.setTypeface(face);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationIndex = ANIMATION_INDEX_NEW_INTENT;
                myAnimation.setAnimationListener(StartActivity.this);
                playButton.startAnimation(myAnimation);
            }
        });

        rateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationIndex = ANIMATION_INDEX_GO_TO_MARKET;
                rateBtn.startAnimation(myAnimation);
            }
        });

        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationIndex = ANIMATION_INDEX_CHANGE_LANGUAGE;
                helpBtn.startAnimation(myAnimation);
            }
        });

        frogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationIndex = ANIMATION_INDEX_ROTATE_FROG;
                frogView.startAnimation(frogAnimation);
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        switch (animationIndex) {
            case ANIMATION_INDEX_NEW_INTENT:
                animationIndex = ANIMATION_INDEX_ZERO;
                Intent i = new Intent(StartActivity.this, LevelsActivity.class);
                startActivity(i);
                break;
            case ANIMATION_INDEX_GO_TO_MARKET:
                animationIndex = ANIMATION_INDEX_ZERO;
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {}
                break;
            case ANIMATION_INDEX_CHANGE_LANGUAGE:
                animationIndex = ANIMATION_INDEX_ZERO;
                AlertDialog.Builder builder = new AlertDialog.Builder(StartActivity.this);
                builder.setTitle(language.getGameRulesTitle()).setMessage(language.getGameRules()).setTitle(language.getGameRulesTitle());

                builder.setIcon(R.drawable.ic_help)
                        .setCancelable(false).setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                break;
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {}

    @Override
    public  void onBackPressed() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                StartActivity.this);
        quitDialog.setTitle(language.getExit()).setPositiveButton(language.getYes(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveTaskToBack(true);
                finish();
            }
        }).setNegativeButton(language.getNo(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        quitDialog.show();
        //super.onBackPressed();
    }

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

    }

    @Override
    public void onPause () {
        super.onPause();
        //CountryLab.get(this).saveCountries();
        System.out.println("ON PAUSE IN START ACTIVITY");
        if (settings.saveSettings()){
            System.out.println("INFORMATION IN STARTACTIVITY SAVED SUS");
        }
    }





}