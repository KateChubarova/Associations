package com.ekaterinachubarova.associations.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.ekaterinachubarova.associations.R;
import com.ekaterinachubarova.associations.banks.BankFifth;
import com.ekaterinachubarova.associations.banks.BankFirst;
import com.ekaterinachubarova.associations.banks.BankFourth;
import com.ekaterinachubarova.associations.banks.BankOfColors;
import com.ekaterinachubarova.associations.banks.BankSecond;
import com.ekaterinachubarova.associations.banks.BankSixth;
import com.ekaterinachubarova.associations.banks.BankThird;
import com.ekaterinachubarova.associations.square_view.SquareImageView;


public class ImageActivity extends Activity {

    private int level;
    private int pictureIndex;
    private SquareImageView image;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_fragment);

        layout = (LinearLayout)findViewById(R.id.background);
        image = (SquareImageView) findViewById(R.id.image);
        level = Integer.parseInt(getIntent().getStringExtra("level"));
        pictureIndex = Integer.parseInt(getIntent().getStringExtra("pictureIndex"));

        layout.setBackgroundResource(BankOfColors.get(level-1));

        switch (pictureIndex) {
            case 0:
                image.setBackgroundResource(BankFirst.get(level - 1));
                break;
            case 1:
                image.setBackgroundResource(BankSecond.get(level - 1));
                break;
            case 2:
                image.setBackgroundResource(BankThird.get(level - 1));
                break;
            case 3:
                image.setBackgroundResource(BankFourth.get(level - 1));
                break;
            case 4:
                image.setBackgroundResource(BankFifth.get(level - 1));
                break;
            case 5:
                image.setBackgroundResource(BankSixth.get(level - 1));
                break;
        }

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}