package com.ekaterinachubarova.associations.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import com.ekaterinachubarova.associations.R;
import com.ekaterinachubarova.associations.essences.CountryLab;
import com.ekaterinachubarova.associations.essences.Settings;
import com.ekaterinachubarova.associations.fragments.GameFragment;

import java.util.Set;

public class GameActivity extends Activity{

    private CountryLab countryLab;
    private Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        settings = Settings.get(this);
        countryLab = CountryLab.get(this);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.gameContainer,
                GameFragment.newInstance(Integer.parseInt(getIntent().getStringExtra("level")))).commit();
    }

    @Override
    public void onBackPressed (){
        super.onBackPressed();
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onPause () {
        super.onPause();
        System.out.println("ON PAUSE GAME ACTIVITY");
        countryLab.saveCountries();
        settings.saveSettings();
    }


}

