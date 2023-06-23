//package Command.ImplementationCommands;
//
//import Flat.Flat;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.util.Stack;
//
//public class ImplementationCommandSave {
//    public static void save(Stack<Flat> flats){
//        try {
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/studs/s371814/proga/lab6/server/file.txt"));
////            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(" file.txt"));
//            bufferedWriter.write(Serializer.serializer(flats));
//            bufferedWriter.close();
//            System.out.println("Стек успешно сохранен.");
//        }
//        catch (Exception exception){
//           exception.printStackTrace();
//        }
//
//    }
//}
