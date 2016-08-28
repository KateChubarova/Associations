package com.ekaterinachubarova.associations.banks;

import com.ekaterinachubarova.associations.R;

import java.util.ArrayList;

public class BankOfCountries {

    public static ArrayList<Integer> bank = new ArrayList<>();
    public static ArrayList<Integer> bankR = new ArrayList<>();

    static{
        bank.add(R.string.id_1);
        bank.add(R.string.id_2);
        bank.add(R.string.id_3);
        bank.add(R.string.id_4);
        bank.add(R.string.id_5);
        bank.add(R.string.id_6);
        bank.add(R.string.id_7);
        bank.add(R.string.id_8);
        bank.add(R.string.id_9);
        bank.add(R.string.id_10);
        bank.add(R.string.id_11);
        bank.add(R.string.id_12);
        bank.add(R.string.id_13);
        bank.add(R.string.id_14);
        bank.add(R.string.id_15);
        bank.add(R.string.id_16);
        bank.add(R.string.id_17);
        bank.add(R.string.id_18);
        bank.add(R.string.id_19);
        bank.add(R.string.id_20);
        bank.add(R.string.id_21);
        bank.add(R.string.id_22);
        bank.add(R.string.id_23);
        bank.add(R.string.id_24);
        bank.add(R.string.id_25);

        bankR.add(R.string.id_26);
        bankR.add(R.string.id_27);
        bankR.add(R.string.id_28);
        bankR.add(R.string.id_29);
        bankR.add(R.string.id_30);
        bankR.add(R.string.id_31);
        bankR.add(R.string.id_32);
        bankR.add(R.string.id_33);
        bankR.add(R.string.id_34);
        bankR.add(R.string.id_35);
        bankR.add(R.string.id_36);
        bankR.add(R.string.id_37);
        bankR.add(R.string.id_38);
        bankR.add(R.string.id_39);
        bankR.add(R.string.id_40);
        bankR.add(R.string.id_41);
        bankR.add(R.string.id_42);
        bankR.add(R.string.id_43);
        bankR.add(R.string.id_44);
        bankR.add(R.string.id_45);
        bankR.add(R.string.id_46);
        bankR.add(R.string.id_47);
        bankR.add(R.string.id_48);
        bankR.add(R.string.id_49);
        bankR.add(R.string.id_50);
    }

    public int get(int i){
        return bank.get(i-1);
    }


    public int getR(int i){
        return bankR.get(i-1);
    }
}


