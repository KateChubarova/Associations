package com.ekaterinachubarova.associations.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ekaterinachubarova.associations.R;
import com.ekaterinachubarova.associations.essences.CountryLab;
import com.ekaterinachubarova.associations.square_view.SquareImageView;

/**
 * Created by ekaterinachubarova on 23.08.16.
 */
public class MainPictureFragment extends Fragment {

    public static final String PICTURE_INDEX = "picture_index";
    private int pictureId;
    private int level;
    SquareImageView mainPicture;
    LinearLayout layout;
    private Context context;

    public static MainPictureFragment newInstance(int level, int index){
        Bundle args = new Bundle();
        args.putSerializable(PICTURE_INDEX, index);
        args.putSerializable(GameFragment.EXTRA_GAME_ID, level);
        MainPictureFragment mainPictureFragment = new MainPictureFragment();
        mainPictureFragment.setArguments(args);
        return mainPictureFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pictureId = (int)getArguments().getSerializable(PICTURE_INDEX);
        level = (int)getArguments().getSerializable(GameFragment.EXTRA_GAME_ID);
        context = getActivity();
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.image_fragment, parent, false);

        mainPicture = (SquareImageView)v.findViewById(R.id.image);
        mainPicture.setBackgroundResource(pictureId);

        layout = (LinearLayout)v.findViewById(R.id.background);
        layout.setBackgroundResource(CountryLab.get(context).getCountry(level).getColor());

        return v;
    }

}
