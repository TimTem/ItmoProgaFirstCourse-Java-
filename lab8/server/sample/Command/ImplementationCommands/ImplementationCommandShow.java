package sample.Command.ImplementationCommands;


import sample.Flat.Flat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class ImplementationCommandShow implements Serializable {
    public static ArrayList<Flat> arrayList = new ArrayList<Flat>();
    public static String str = "";

    public static void ImplementationShow(Stack<Flat> flats, ObjectOutputStream out) throws IOException {
        if (flats.size() == 0) {
            out.writeObject("Stack is empty. Command wasn`t executed.");
            out.flush();
        } else {
            Iterator var1 = flats.iterator();

//            while(var1.hasNext()) {
//                Flat flat = (Flat) var1.next();
//                arrayList.add(flat);
//            }
            for (Flat flatsForString : flats) {
                str += flatsForString;
            }
            out.writeObject(flats.toString());
            out.flush();
        }
    }
}
