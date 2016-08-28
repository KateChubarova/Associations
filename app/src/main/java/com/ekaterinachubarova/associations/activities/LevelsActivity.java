package com.ekaterinachubarova.associations.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ekaterinachubarova.associations.R;
import com.ekaterinachubarova.associations.essences.Country;
import com.ekaterinachubarova.associations.essences.CountryLab;
import com.ekaterinachubarova.associations.essences.Language;
import com.ekaterinachubarova.associations.essences.Settings;
import com.ekaterinachubarova.associations.square_view.LevelsButton;


public class LevelsActivity extends Activity {

    private TextView chooseLevel;
    private ImageView replay;

    private LevelsButton[] buttons;


    Language language ;
    CountryLab countryLab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);

        countryLab = CountryLab.get(this);
        language = Language.getCurrentLanguage(this);

        chooseLevel = (TextView)findViewById(R.id.choose_level);

        chooseLevel.setText(language.getChooseLevel());

        replay = (ImageView)findViewById(R.id.replay);



        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LevelsActivity.this);

                builder.setTitle(language.getNewGame()).setMessage(language.getNewGameQuestion()).setIcon(R.drawable.ic_true)
                        .setCancelable(false).setPositiveButton(language.getYes(),
                        new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        finish();
                        Intent i = new Intent(LevelsActivity.this, LevelsActivity.class);
                        startActivity(i);
                    }
                }).setNegativeButton(language.getNo(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        Typeface face = Typeface.createFromAsset(getAssets(), getString(R.string.head));
        chooseLevel.setTypeface(face);

        buttons = new LevelsButton[25];

        buttons[0] = (LevelsButton) findViewById(R.id.button1);
        buttons[1] = (LevelsButton) findViewById(R.id.button2);
        buttons[2] = (LevelsButton) findViewById(R.id.button3);
        buttons[3] = (LevelsButton) findViewById(R.id.button4);
        buttons[4] = (LevelsButton) findViewById(R.id.button5);
        buttons[5] = (LevelsButton) findViewById(R.id.button6);
        buttons[6] = (LevelsButton) findViewById(R.id.button7);
        buttons[7] = (LevelsButton) findViewById(R.id.button8);
        buttons[8] = (LevelsButton) findViewById(R.id.button9);
        buttons[9] = (LevelsButton) findViewById(R.id.button10);
        buttons[10] = (LevelsButton) findViewById(R.id.button11);
        buttons[11] = (LevelsButton) findViewById(R.id.button12);
        buttons[12] = (LevelsButton) findViewById(R.id.button13);
        buttons[13] = (LevelsButton) findViewById(R.id.button14);
        buttons[14] = (LevelsButton) findViewById(R.id.button15);
        buttons[15] = (LevelsButton) findViewById(R.id.button16);
        buttons[16] = (LevelsButton) findViewById(R.id.button17);
        buttons[17] = (LevelsButton) findViewById(R.id.button18);
        buttons[18] = (LevelsButton) findViewById(R.id.button19);
        buttons[19] = (LevelsButton) findViewById(R.id.button20);
        buttons[20] = (LevelsButton) findViewById(R.id.button21);
        buttons[21] = (LevelsButton) findViewById(R.id.button22);
        buttons[22] = (LevelsButton) findViewById(R.id.button23);
        buttons[23] = (LevelsButton) findViewById(R.id.button24);
        buttons[24] = (LevelsButton) findViewById(R.id.button25);

        setLevels();

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LevelsButton button = (LevelsButton)view;
            if (countryLab.getCountry(button.getIndex()).getIsOpen() != Country.LEVEL_CLOSED) {
                Intent i = new Intent(LevelsActivity.this, GameActivity.class);
                i.putExtra("level", Integer.toString(button.getIndex()));
                startActivityForResult(i, 1);
            } else {
                //dialog
            }
        }
    };

    public void setLevels () {
        for (int i=0; i<25; i++) {
            switch (countryLab.getCountry(i).isOpen()) {
                case Country.LEVEL_CLOSED:
                    buttons[i].setBackgroundResource(R.drawable.levellocked);
                    break;
                case Country.LEVEL_OPENED:
                    buttons[i].setBackgroundResource(R.drawable.levelunlocked);
                    break;
                case Country.LEVEL_SOLVED:
                default:
                    buttons[i].setBackgroundResource(R.drawable.levelcompleted);
                    break;

            }
            buttons[i].setIndex(i);
            buttons[i].setOnClickListener(onClickListener);
        }
    }

    @Override
    public  void onBackPressed(){
        Intent i = new Intent(LevelsActivity.this, StartActivity.class);
        startActivity(i);
    }

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        setLevels();
    }

    @Override
    public void onPause () {
        super.onPause();
        System.out.println("ON PAUSE GAME ACTIVITY");
        if (countryLab.saveCountries()){
            System.out.println("All is ok in levels activity, information saved");
        }
        //settings.saveSettings();
    }

}
