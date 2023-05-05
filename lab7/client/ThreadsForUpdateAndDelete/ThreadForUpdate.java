//package ThreadsForUpdateAndDelete;
//
//import AssemblyMultiMap.MultiMap;
//import Commands.CommandType;
//import FieldInitialization.UpdateArrayList;
//import Flat.User;
//import Launcher.ClientLauncher;
//import RegularExpressions.RegExpUpdate;
//
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//import java.util.ArrayList;
//
//public class ThreadForUpdate implements Runnable{
//    private static Socket socket;
//    private static int collectionItemNumber;
//    private static ArrayList<String> arrayList = new ArrayList<>();
//
//    public static void setSocket(Socket socket) {
//        ThreadForUpdate.socket = socket;
//    }
//
//    public static void setCollectionItemNumber(int collectionItemNumber) {
//        ThreadForUpdate.collectionItemNumber = collectionItemNumber;
//    }
//
//    @Override
//    public void run(){
//        try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());){
//            arrayList.add(String.valueOf(collectionItemNumber));
//            arrayList.add(User.getNameUser());
//            out.writeObject(arrayList);
//            if(inputStream.readObject().equals("Этот элемент принадлежит не вам!")){
//                System.out.println("Этот элемент принадлежит не вам!");
//                return;
//            }
//            if(inputStream.readObject().equals("Такого элемента в коллекции нет!")){
//                System.out.println(inputStream.readObject());
//                return;
//            }
//            if(inputStream.readObject().equals("Введите данные, которые хотите изменить!")){
//                MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
//                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
//                MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
//                ArrayList<String> arrayList = new ArrayList<>();
//                UpdateArrayList.addInArrayList(arrayList, RegExpUpdate.updateReg(str));
//                multiMap.put(CommandType.UPDATE, arrayList);
//                arrayList1.add(multiMap);
//                multiMap1.put(CommandType.UPDATE, arrayList1);
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
