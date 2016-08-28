package com.ekaterinachubarova.associations.banks;
import com.ekaterinachubarova.associations.R;

import java.util.ArrayList;

/**
 * Created by Veronika on 17.08.2015.
 */
public class BankFifth {
    public static ArrayList<Integer> bank;

    static {
        bank = new ArrayList<>();
        bank.add(R.drawable.ic_india5);
        bank.add(R.drawable.ic_france5);
        bank.add(R.drawable.ic_japan5);
        bank.add(R.drawable.ic_spain5);
        bank.add(R.drawable.ic_germany5);
        bank.add(R.drawable.ic_hawaii5);
        bank.add(R.drawable.ic_israel5);
        bank.add(R.drawable.ic_latvia5);
        bank.add(R.drawable.ic_turkey5);
        bank.add(R.drawable.ic_greece5);
        bank.add(R.drawable.ic_holland5);
        bank.add(R.drawable.ic_italy5);
        bank.add(R.drawable.ic_mexico5);
        bank.add(R.drawable.ic_moldova5);
        bank.add(R.drawable.ic_slovakia5);
        bank.add(R.drawable.ic_hungary5);
        bank.add(R.drawable.ic_lithuania5);
        bank.add(R.drawable.ic_portugal5);
        bank.add(R.drawable.ic_malta5);
        bank.add(R.drawable.ic_poland5);
        bank.add(R.drawable.ic_slovenia5);
        bank.add(R.drawable.ic_romania5);
        bank.add(R.drawable.ic_ireland5);
        bank.add(R.drawable.ic_sweden5);
        bank.add(R.drawable.ic_luxembourg5);
    }

    public static int get(int i){
        return bank.get(i);
    }
}