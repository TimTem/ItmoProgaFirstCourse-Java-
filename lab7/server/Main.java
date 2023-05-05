import DesirilizationFromServer.Deserilization;
import Flat.Flat;
//import Json.DesirializeFromJson;
import Launcher.StackRunner;
import ServerWork.*;
//import Validator.ValidatorForStack;


public class Main {
    public static void main(String[] args) throws Exception{
//    DesirializeFromJson.fromJson();
        Deserilization.serializationFromServer(StackRunner.flats);
//        for(Flat flat : StackRunner.flats){
//            System.out.println(flat.getId());
//        }
        MultiThreadServer.multiThreadServer();
    }
}
