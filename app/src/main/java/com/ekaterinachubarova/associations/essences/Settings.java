package com.ekaterinachubarova.associations.essences;

import android.content.Context;

import com.ekaterinachubarova.associations.save.SettingsJSONSerializer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;

/**
 * Created by ekaterinachubarova on 25.08.16.
 */
public class Settings {
    private static int money;
    private static int level;
    private static boolean language;
    private static final String FILENAME = "settings.json";
    public static final String JSON_MONEY = "money";
    public static final String JSON_LEVEL = "level";
    public static final String JSON_LANGUAGE = "language";
    private static Context context;
    private static Settings settings;
    HashMap <String, Integer> settingsMap;
    SettingsJSONSerializer settingsJSONSerializer ;

    public JSONObject toJSON() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(JSON_MONEY, money);
        System.out.println(language);
        if (language) {
            jsonObject.put(JSON_LANGUAGE, 1);
        }
        else if (!language){
            jsonObject.put(JSON_LANGUAGE, 0);
        }
        jsonObject.put(JSON_LEVEL, level);
        System.out.println(jsonObject);
        return jsonObject;
    }

    private Settings (Context context){
        this.context = context;
        settingsJSONSerializer = new SettingsJSONSerializer(context, FILENAME);
        try {
            settingsMap = settingsJSONSerializer.loadSettings();
            System.out.println("Load settings in constructor in class Settings");
            setSettings();
        } catch (Exception e) {
            System.out.println(e + " first write in settings in constructor");
            level = 1;
            money = 35;
            language = true;
        }

    }

    public static Settings get (Context context){
        if (settings == null) {
            settings = new Settings(context);
        } return settings;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isLanguage() {
        return language;
    }

    public void setLanguage(boolean language) {
        this.language = language;
    }

    public void setSettings (){
        this.language = settingsMap.get(JSON_LANGUAGE) != 0;
        this.level = settingsMap.get(JSON_LEVEL);
        this.money = settingsMap.get(JSON_MONEY);
    }

    public boolean saveSettings () {
        try {
            settingsJSONSerializer.saveSettings(settings);
            return true;
        } catch (Exception e) {
            System.out.println(e + "  Exception in Settings in method saveSettings");
            return false;
        }
    }
    public int decAndGetMoney () {
        money -= 1;
        return money;
    }

    public void incLevel () {
        level+=1;
    }

}
