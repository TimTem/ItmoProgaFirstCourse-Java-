package FieldInitialization;

import Flat.Furnish;
import Flat.Transports;
import Flat.User;

import java.util.ArrayList;

public class AddInArrayListDefault {
    public static void addInArrayList(ArrayList<String> arrayList, String name){
        System.out.println("Команда выполняется");
        arrayList.add(name);
        arrayList.add("0");
        arrayList.add("0");
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("false");
        arrayList.add(Furnish.NONE.getName());
        arrayList.add(Transports.NONE.getName());
        arrayList.add("none");
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add(User.getNameUser());
    }
}
