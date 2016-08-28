package com.ekaterinachubarova.associations.square_view;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by ekaterinachubarova on 15.08.16.
 */
public class PictureButton extends SquareImageView {

    private int index;
    private boolean isUsed;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public PictureButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    public PictureButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PictureButton(Context context) {
        super(context);
    }


}
