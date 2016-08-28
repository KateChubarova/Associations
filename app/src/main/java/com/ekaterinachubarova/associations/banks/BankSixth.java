package com.ekaterinachubarova.associations.banks;
import com.ekaterinachubarova.associations.R;

import java.util.ArrayList;

/**
 * Created by Veronika on 17.08.2015.
 */
public class BankSixth {
    public static ArrayList<Integer> bank;

    static {
        bank = new ArrayList<>();
        bank.add(R.drawable.ic_india6);
        bank.add(R.drawable.ic_france6);
        bank.add(R.drawable.ic_japan6);
        bank.add(R.drawable.ic_spain6);
        bank.add(R.drawable.ic_germany6);
        bank.add(R.drawable.ic_hawaii6);
        bank.add(R.drawable.ic_israel6);
        bank.add(R.drawable.ic_latvia6);
        bank.add(R.drawable.ic_turkey6);
        bank.add(R.drawable.ic_greece6);
        bank.add(R.drawable.ic_holland6);
        bank.add(R.drawable.ic_italy6);
        bank.add(R.drawable.ic_mexico6);
        bank.add(R.drawable.ic_moldova6);
        bank.add(R.drawable.ic_slovakia6);
        bank.add(R.drawable.ic_hungary6);
        bank.add(R.drawable.ic_lithuania6);
        bank.add(R.drawable.ic_portugal6);
        bank.add(R.drawable.ic_malta6);
        bank.add(R.drawable.ic_poland6);
        bank.add(R.drawable.ic_slovenia6);
        bank.add(R.drawable.ic_romania6);
        bank.add(R.drawable.ic_ireland6);
        bank.add(R.drawable.ic_sweden6);
        bank.add(R.drawable.ic_luxembourg6);
    }

    public static int get(int i){
        return bank.get(i);
    }
}