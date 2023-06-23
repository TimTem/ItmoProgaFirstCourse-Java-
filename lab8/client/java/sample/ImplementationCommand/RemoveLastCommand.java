package sample.ImplementationCommand;

import javafx.scene.control.Alert;
import sample.BasicPanelContoller;
import sample.Flat.Flat;
import sample.Launcher.ClientLauncher;

import java.util.Stack;

public class RemoveLastCommand {
    public static void removeLast(){
        if(ClientLauncher.stack.size() != 0){
            ClientLauncher.stack.pop();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Последний элемент коллекции был очищен!");
            alert.show();
        }else{
            ClientLauncher.stack.clear();
            BasicPanelContoller.observableList.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Коллекция пуста!");
            alert.showAndWait();
            return;
        }
    }
}
