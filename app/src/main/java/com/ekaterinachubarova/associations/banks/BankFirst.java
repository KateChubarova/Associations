package com.ekaterinachubarova.associations.banks;
import com.ekaterinachubarova.associations.R;

import java.util.ArrayList;

/**
 * Created by Veronika on 17.08.2015.
 */
public class BankFirst {
    public static ArrayList<Integer> bank;

    static{
        bank = new ArrayList<>();
        bank.add(R.drawable.ic_india1);
        bank.add(R.drawable.ic_france1);
        bank.add(R.drawable.ic_japan1);
        bank.add(R.drawable.ic_spain1);
        bank.add(R.drawable.ic_germany1);
        bank.add(R.drawable.ic_hawaii1);
        bank.add(R.drawable.ic_israel1);
        bank.add(R.drawable.ic_latvia1);
        bank.add(R.drawable.ic_turkey1);
        bank.add(R.drawable.ic_greece1);
        bank.add(R.drawable.ic_holland1);
        bank.add(R.drawable.ic_italy1);
        bank.add(R.drawable.ic_mexico1);
        bank.add(R.drawable.ic_moldova1);
        bank.add(R.drawable.ic_slovakia1);
        bank.add(R.drawable.ic_hungary1);
        bank.add(R.drawable.ic_lithuania1);
        bank.add(R.drawable.ic_portugal1);
        bank.add(R.drawable.ic_malta1);
        bank.add(R.drawable.ic_poland1);
        bank.add(R.drawable.ic_slovenia1);
        bank.add(R.drawable.ic_romania1);
        bank.add(R.drawable.ic_ireland1);
        bank.add(R.drawable.ic_sweden1);
        bank.add(R.drawable.ic_luxembourg1);
    }

    public static int get(int i){
        return bank.get(i);
    }
}
