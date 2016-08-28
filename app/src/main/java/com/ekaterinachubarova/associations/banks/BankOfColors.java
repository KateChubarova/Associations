package com.ekaterinachubarova.associations.banks;

import com.ekaterinachubarova.associations.R;

import java.util.ArrayList;


public class BankOfColors {
    public static ArrayList<Integer> bank;

    static{
        bank = new ArrayList<>();

        bank.add(R.color.india);
        bank.add(R.color.france);
        bank.add(R.color.japan);
        bank.add(R.color.spain);
        bank.add(R.color.germany);
        bank.add(R.color.hawaii);
        bank.add(R.color.israel);
        bank.add(R.color.latvia);
        bank.add(R.color.turkey);
        bank.add(R.color.greece);
        bank.add(R.color.holland);
        bank.add(R.color.italy);
        bank.add(R.color.mexico);
        bank.add(R.color.moldova);
        bank.add(R.color.slovakia);
        bank.add(R.color.hungary);
        bank.add(R.color.lithuania);
        bank.add(R.color.portugal);
        bank.add(R.color.malta);
        bank.add(R.color.poland);
        bank.add(R.color.slovenia);
        bank.add(R.color.romania);
        bank.add(R.color.ireland);
        bank.add(R.color.sweden);
        bank.add(R.color.luxembourg);
    }

    public static int get(int i){
        if (i >= bank.size())
            return bank.get(0);
        else return bank.get(i);
    }
}
