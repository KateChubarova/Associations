package com.ekaterinachubarova.associations.save;

import android.content.Context;

import com.ekaterinachubarova.associations.essences.Country;
import com.ekaterinachubarova.associations.essences.Settings;

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
import java.util.Set;

/**
 * Created by ekaterinachubarova on 26.08.16.
 */
public class SettingsJSONSerializer {
    private Context context;
    private String fileName;

    public SettingsJSONSerializer (Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    public void saveSettings (Settings settings) throws JSONException, IOException {
        JSONObject jsonObject = settings.toJSON();

        Writer writer = null;
        try {
            OutputStream outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(outputStream);
            writer.write(jsonObject.toString());
        } finally {
            if (writer != null)
                writer.close();;
        }
    }

    public HashMap<String, Integer> loadSettings () throws IOException, JSONException {
        HashMap<String,Integer > settings = new HashMap<>();
        BufferedReader bufferedReader = null;

        try {

            InputStream inputStream = context.openFileInput(fileName);


            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder jsonString = new StringBuilder();
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                jsonString.append(line);
            }

            JSONObject object = (JSONObject) new JSONTokener(jsonString.toString()).nextValue();
            settings.put(Settings.JSON_LANGUAGE, object.getInt(Settings.JSON_LANGUAGE));
            settings.put(Settings.JSON_LEVEL, object.getInt(Settings.JSON_LEVEL));
            settings.put(Settings.JSON_MONEY, object.getInt(Settings.JSON_MONEY));

        } catch (IOException e) {
            System.out.println("EXCEPTION IN SETTINGS LAB " + e);
            //writeFirst(context);
        } finally {
            if (bufferedReader != null)
                bufferedReader.close();
        }
        return settings;
    }

}
