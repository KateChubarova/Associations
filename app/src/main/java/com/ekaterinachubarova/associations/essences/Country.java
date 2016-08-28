package com.ekaterinachubarova.associations.essences;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ekaterinachubarova on 22.08.16.
 */
public class Country {
    private int englishName;
    private int russianName;
    private int picturesSmall[];
    private int mainPicture;
    private boolean isOpenPicture[];
    private int isOpen;
    private int count = 6;
    private int color;

    private static final String JSON_ENGLISH_NAME = "english_name";
    private static final String JSON_RUSSIAN_NAME = "russian_name";
    private static final String JSON_PICTURES_SMALL = "pictures_small";
    private static final String JSON_MAIN_PICTURE = "main_picture";
    private static final String JSON_IS_OPEN_PICTURES = "is_open_pictures";
    private static final String JSON_IS_OPEN = "is_open";
    private static final String JSON_COLOR = "color";

    public static final int LEVEL_OPENED = 2;
    public static final int LEVEL_SOLVED = 1;
    public static final int LEVEL_CLOSED = 3;

    public Country (){
        isOpen = 3;
        isOpenPicture = new boolean[count];
        picturesSmall = new int[count];
        for (int i=0; i<count; i++)
            isOpenPicture[i] = false;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(JSON_ENGLISH_NAME, englishName);
        jsonObject.put(JSON_RUSSIAN_NAME, russianName);
        jsonObject.put(JSON_PICTURES_SMALL, picturesSmall);
        jsonObject.put(JSON_MAIN_PICTURE, mainPicture);
        jsonObject.put(JSON_IS_OPEN_PICTURES, isOpenPicture);
        jsonObject.put(JSON_IS_OPEN, isOpen);
        jsonObject.put(JSON_COLOR, color);

        //System.out.println(jsonObject);

        return jsonObject;
    }

    public Country (JSONObject jsonObject) throws JSONException {
        englishName = jsonObject.getInt(JSON_ENGLISH_NAME);
        russianName = jsonObject.getInt(JSON_RUSSIAN_NAME);
        picturesSmall = (int[]) jsonObject.get(JSON_PICTURES_SMALL);
        mainPicture = jsonObject.getInt(JSON_MAIN_PICTURE);
        isOpenPicture = (boolean [])jsonObject.get(JSON_IS_OPEN_PICTURES);
        isOpen = jsonObject.getInt(JSON_IS_OPEN);
        color = jsonObject.getInt(JSON_COLOR);
    }

    public int getEnglishName() {
        return englishName;
    }

    public void setEnglishName(int englishName) {
        this.englishName = englishName;
    }

    public int getRussianName() {
        return russianName;
    }

    public void setRussianName(int russianName) {
        this.russianName = russianName;
    }

    public int[] getPicturesSmall() {
        return picturesSmall;
    }

    public void setPicturesSmall(int index, int pictureSmall) {
        this.picturesSmall[index] = pictureSmall;
    }

    public int getSmallOpenPicture (int index) {
        return picturesSmall[index];
    }

    public int getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(int mainPicture) {
        this.mainPicture = mainPicture;
    }

    public boolean getIsOpenPicture(int i) {
        return isOpenPicture[i];
    }

    public void setIsOpenPicture(boolean[] isOpenPicture) {
        this.isOpenPicture = isOpenPicture;
    }

    public int isOpen() {
        return isOpen;
    }

    public int decOpen() {
        isOpen -= 1;
        return isOpen;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setIsOpen (int isOPen){
        this.isOpen = isOPen;
    }

    public void setIsOpenPicture (int index) {
        isOpenPicture[index] = true;
    }

    public int getIsOpen (){
        return isOpen;
    }
}
