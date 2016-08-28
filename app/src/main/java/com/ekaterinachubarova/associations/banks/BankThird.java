package com.ekaterinachubarova.associations.banks;
import com.ekaterinachubarova.associations.R;

import java.util.ArrayList;

/**
 * Created by Veronika on 17.08.2015.
 */
public class BankThird {
    public static ArrayList<Integer> bank;

    static{
        bank = new ArrayList<>();
        bank.add(R.drawable.ic_india3);
        bank.add(R.drawable.ic_france3);
        bank.add(R.drawable.ic_japan3);
        bank.add(R.drawable.ic_spain3);
        bank.add(R.drawable.ic_germany3);
        bank.add(R.drawable.ic_hawaii3);
        bank.add(R.drawable.ic_israel3);
        bank.add(R.drawable.ic_latvia3);
        bank.add(R.drawable.ic_turkey3);
        bank.add(R.drawable.ic_greece3);
        bank.add(R.drawable.ic_holland3);
        bank.add(R.drawable.ic_italy3);
        bank.add(R.drawable.ic_mexico3);
        bank.add(R.drawable.ic_moldova3);
        bank.add(R.drawable.ic_slovakia3);
        bank.add(R.drawable.ic_hungary3);
        bank.add(R.drawable.ic_lithuania3);
        bank.add(R.drawable.ic_portugal3);
        bank.add(R.drawable.ic_malta3);
        bank.add(R.drawable.ic_poland3);
        bank.add(R.drawable.ic_slovenia3);
        bank.add(R.drawable.ic_romania3);
        bank.add(R.drawable.ic_ireland3);
        bank.add(R.drawable.ic_sweden3);
        bank.add(R.drawable.ic_luxembourg3);
    }

    public static int get(int i){
        return bank.get(i);
    }
}
