package com.ekaterinachubarova.associations.square_view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by ekaterinachubarova on 18.08.16.
 */
public class LevelsButton extends SquareButton {
    private int index;

    public LevelsButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public LevelsButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LevelsButton(Context context) {
        super(context);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }




}
