package sample;

import sample.DesirilizationFromServer.Deserilization;
import sample.Flat.Flat;
import sample.Launcher.StackRunner;
import sample.ServerWork.MultiThreadServer;
import sample.ServerWork.SendStackFlat;

import java.util.Stack;
//import Validator.ValidatorForStack;


public class Main {
    public static void main(String[] args) throws Exception{
        Deserilization.serializationFromServer(StackRunner.flats);
        MultiThreadServer.multiThreadServer();
    }
}
