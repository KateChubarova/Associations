package com.ekaterinachubarova.associations.banks;
import com.ekaterinachubarova.associations.R;

import java.util.ArrayList;

/**
 * Created by Veronika on 17.08.2015.
 */
public class BankSecond {
    public static ArrayList<Integer> bank;

    static{
        bank = new ArrayList<>();
        bank.add(R.drawable.ic_india2);
        bank.add(R.drawable.ic_france2);
        bank.add(R.drawable.ic_japan2);
        bank.add(R.drawable.ic_spain2);
        bank.add(R.drawable.ic_germany2);
        bank.add(R.drawable.ic_hawaii2);
        bank.add(R.drawable.ic_israel2);
        bank.add(R.drawable.ic_latvia2);
        bank.add(R.drawable.ic_turkey2);
        bank.add(R.drawable.ic_greece2);
        bank.add(R.drawable.ic_holland2);
        bank.add(R.drawable.ic_italy2);
        bank.add(R.drawable.ic_mexico2);
        bank.add(R.drawable.ic_moldova2);
        bank.add(R.drawable.ic_slovakia2);
        bank.add(R.drawable.ic_hungary2);
        bank.add(R.drawable.ic_lithuania2);
        bank.add(R.drawable.ic_portugal2);
        bank.add(R.drawable.ic_malta2);
        bank.add(R.drawable.ic_poland2);
        bank.add(R.drawable.ic_slovenia2);
        bank.add(R.drawable.ic_romania2);
        bank.add(R.drawable.ic_ireland2);
        bank.add(R.drawable.ic_sweden2);
        bank.add(R.drawable.ic_luxembourg2);
    }

    public static int get(int i){
        return bank.get(i);
    }
}
