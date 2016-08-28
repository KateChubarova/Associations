package com.ekaterinachubarova.associations.activities;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.ekaterinachubarova.associations.R;
import com.ekaterinachubarova.associations.square_view.SquareImageView;


public class FrogActivity extends Activity implements Animation.AnimationListener{


    private Animation frogAnimation;
    private Animation buttonAnimation;

    private SquareImageView frog;
    private SquareImageView sliptint;
    private SquareImageView flags;
    private SquareImageView slipcolors;
    private SquareImageView anagrams;
    private SquareImageView countries;
    private SquareImageView associations;

    private int animationNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frog);


        final Typeface face = Typeface.createFromAsset(getAssets(), getString(R.string.roboto_head));
        ((TextView)findViewById(R.id.text1)).setTypeface(face);
        ((TextView)findViewById(R.id.text2)).setTypeface(face);
        ((TextView)findViewById(R.id.text3)).setTypeface(face);
        ((TextView)findViewById(R.id.text4)).setTypeface(face);
        ((TextView)findViewById(R.id.text5)).setTypeface(face);
        ((TextView)findViewById(R.id.text6)).setTypeface(face);

        frogAnimation = AnimationUtils.loadAnimation(FrogActivity.this, R.anim.froganimation);
        frogAnimation.setAnimationListener(FrogActivity.this);

        buttonAnimation = AnimationUtils.loadAnimation(FrogActivity.this, R.anim.startbutton);
        buttonAnimation.setAnimationListener(FrogActivity.this);

        frog = (SquareImageView)findViewById(R.id.frog);
        sliptint = (SquareImageView)findViewById(R.id.view1);
        flags = (SquareImageView)findViewById(R.id.view2);
        slipcolors = (SquareImageView)findViewById(R.id.view3);
        anagrams = (SquareImageView)findViewById(R.id.view4);
        countries = (SquareImageView)findViewById(R.id.view5);
        associations = (SquareImageView)findViewById(R.id.view6);


        frog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationNumber = 7;
                frog.startAnimation(frogAnimation);
            }
        });

        sliptint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationNumber = 1;
                sliptint.startAnimation(buttonAnimation);
            }
        });

        flags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationNumber = 2;
                flags.startAnimation(buttonAnimation);
            }
        });

        slipcolors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationNumber = 3;
                slipcolors.startAnimation(buttonAnimation);
            }
        });

        anagrams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationNumber = 4;
                anagrams.startAnimation(buttonAnimation);
            }
        });

        countries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationNumber = 5;
                countries.startAnimation(buttonAnimation);
            }
        });

        associations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationNumber = 6;
                associations.startAnimation(buttonAnimation);
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {}

    @Override
    public void onAnimationEnd(Animation animation) {

        if (animationNumber == 1) {
            Uri uri = Uri.parse("market://details?id=com.kateChubarova.head.sliptint2");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {}
        }
        if (animationNumber == 2) {
            Uri uri = Uri.parse("market://details?id=com.katechubarova.head.flags");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {}
        }
        if (animationNumber == 3) {
            Uri uri = Uri.parse("market://details?id=com.katechubarova.head.slipcolors");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {}
        }
        if (animationNumber == 5) {
            Uri uri = Uri.parse("market://details?id=");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {}
        }
        if (animationNumber == 4) {
          /*  Uri uri = Uri.parse("market://details?id=");// ВСТАВИТЬ ССЫЛКУ НА АНАГРАММЫ
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {}
            */
        }
        if (animationNumber == 6) {
            Uri uri = Uri.parse("market://details?id=com.kateChubarova.head.associations");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {}
        }
        animationNumber = 0;
    }

    @Override
    public void onAnimationRepeat(Animation animation) {}

    @Override
    public  void onBackPressed() {
        Intent i = new Intent(FrogActivity.this, StartActivity.class);
        startActivity(i);
    }
}