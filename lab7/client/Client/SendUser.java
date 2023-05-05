//package Client;
//
//import AssemblyMultiMap.MultiMap;
//import Commands.CommandType;
//import Flat.User;
//
//import java.util.ArrayList;
//
//public class SendUser {
//    public static MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> senduser(){
//        String str;
//        str = User.getNameUser();
//        MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
//        ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
//        MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add(str);
//        multiMap.put(CommandType.HELP, arrayList);
//        arrayList1.add(multiMap);
//        multiMap1.put(CommandType.HELP, arrayList1);
//        return multiMap1;
//
//    }
//}
