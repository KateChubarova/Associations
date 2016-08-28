package com.ekaterinachubarova.associations.banks;
import com.ekaterinachubarova.associations.R;

import java.util.ArrayList;

/**
 * Created by Veronika on 17.08.2015.
 */
public class BankFourth {
    public static ArrayList<Integer> bank;

    static {
        bank = new ArrayList<>();
        bank.add(R.drawable.ic_india4);
        bank.add(R.drawable.ic_france4);
        bank.add(R.drawable.ic_japan4);
        bank.add(R.drawable.ic_spain4);
        bank.add(R.drawable.ic_germany4);
        bank.add(R.drawable.ic_hawaii4);
        bank.add(R.drawable.ic_israel4);
        bank.add(R.drawable.ic_latvia4);
        bank.add(R.drawable.ic_turkey4);
        bank.add(R.drawable.ic_greece4);
        bank.add(R.drawable.ic_holland4);
        bank.add(R.drawable.ic_italy4);
        bank.add(R.drawable.ic_mexico4);
        bank.add(R.drawable.ic_moldova4);
        bank.add(R.drawable.ic_slovakia4);
        bank.add(R.drawable.ic_hungary4);
        bank.add(R.drawable.ic_lithuania4);
        bank.add(R.drawable.ic_portugal4);
        bank.add(R.drawable.ic_malta4);
        bank.add(R.drawable.ic_poland4);
        bank.add(R.drawable.ic_slovenia4);
        bank.add(R.drawable.ic_romania4);
        bank.add(R.drawable.ic_ireland4);
        bank.add(R.drawable.ic_sweden4);
        bank.add(R.drawable.ic_luxembourg4);
    }

    public static int get(int i){
        return bank.get(i);
    }
}