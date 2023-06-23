package sample.Client;

import sample.AssemblyMultiMap.MultiMap;
import sample.Commands.CommandType;
import sample.Flat.User;
import sample.Launcher.ClientLauncher;

import java.util.ArrayList;

public class AssemblyClearForServer {
    public static MultiMap clearForServer(){
        MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
        ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
        MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(ClientLauncher.user.getNameUser());
        multiMap.put(CommandType.CLEAR, arrayList);
        arrayList1.add(multiMap);
        multiMap1.put(CommandType.CLEAR, arrayList1);
        return multiMap1;
    }
}
