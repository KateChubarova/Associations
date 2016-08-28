package com.ekaterinachubarova.associations.essences;

import android.content.Context;

import com.ekaterinachubarova.associations.save.CountryJSONSerializer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ekaterinachubarova on 22.08.16.
 */
public class CountryLab {
    private static CountryLab countryLab;
    private Context context;
    private HashMap<Integer, Country> countries;
    private static final String FILENAME = "countries.json";
    private CountryJSONSerializer countryJSONSerializer;



    private CountryLab (Context context) {
        this.context = context;
        countryJSONSerializer = new CountryJSONSerializer(context, FILENAME);
        try {
            countries = countryJSONSerializer.loadCountries();
            System.out.println(countries);
            System.out.println("ALL IS SUPER READ INFORMATION IN CLASS COUNTRY LAB in constructor");
        } catch (Exception e) {

        }
    }

    public boolean saveCountries () {
        try {
            countryJSONSerializer.saveCrimes(countries);
            System.out.println("ALL IS OK in method saveCrimes in saveCountriew");
            return true;
        } catch (Exception e) {
            System.out.println("ECEPTION IN COUNTRYLAB in method saveCountr " + e);
            return false;

        }
    }

    public static CountryLab get (Context context){
        if (countryLab == null) {
            countryLab = new CountryLab(context);
        } return countryLab;
    }

    public HashMap<Integer, Country> getCountries (){
        return countries;
    }

    public Country getCountry (int id){
        System.out.println(id + " " + countries.get(id).getEnglishName());
        return countries.get(id);
    }
}
