package com.ekaterinachubarova.associations.banks;

import com.ekaterinachubarova.associations.R;

import java.util.ArrayList;

/**
 * Created by Veronika on 17.08.2015.
 */
public class BankMainPictures{
    public static ArrayList<Integer> bank;

    static{
        bank = new ArrayList<>();
        bank.add(R.drawable.ic_india);
        bank.add(R.drawable.ic_france);
        bank.add(R.drawable.ic_japan);
        bank.add(R.drawable.ic_spain);
        bank.add(R.drawable.ic_germany);
        bank.add(R.drawable.ic_hawaii);
        bank.add(R.drawable.ic_israel);
        bank.add(R.drawable.ic_latvia);
        bank.add(R.drawable.ic_turkey);
        bank.add(R.drawable.ic_greece);
        bank.add(R.drawable.ic_holland);
        bank.add(R.drawable.ic_italy);
        bank.add(R.drawable.ic_mexico);
        bank.add(R.drawable.ic_moldova);
        bank.add(R.drawable.ic_slovakia);
        bank.add(R.drawable.ic_hungary);
        bank.add(R.drawable.ic_lithuania);
        bank.add(R.drawable.ic_portugal);
        bank.add(R.drawable.ic_malta);
        bank.add(R.drawable.ic_poland);
        bank.add(R.drawable.ic_slovenia);
        bank.add(R.drawable.ic_romania);
        bank.add(R.drawable.ic_ireland);
        bank.add(R.drawable.ic_sweden);
        bank.add(R.drawable.ic_luxembourg);
    }

    public static int get(int i){
        return bank.get(i);
    }
}