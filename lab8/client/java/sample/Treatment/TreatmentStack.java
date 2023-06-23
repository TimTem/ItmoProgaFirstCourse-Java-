package sample.Treatment;

import sample.Flat.Flat;
import sample.Launcher.ClientLauncher;


import java.util.Stack;

public class TreatmentStack {
    private static Stack<Flat> flatStack;
    public static void treatmentStackForClient(Stack<Flat> stack) {
        if (ClientLauncher.stack.isEmpty()) {
            ClientLauncher.stack = stack;
            for (Flat flat : stack) {
                if (Flat.count <= flat.getId()) {
                    Flat.count = flat.getId();
                }
            }
        }else{
            flatStack = stack;
        }
    }
}
