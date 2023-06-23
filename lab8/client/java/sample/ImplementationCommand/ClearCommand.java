package sample.ImplementationCommand;

import javafx.scene.control.Alert;
import sample.BasicPanelContoller;
import sample.Flat.Flat;
import sample.Launcher.ClientLauncher;
import sample.Localisation.LocalizationManager;

import java.util.Iterator;

public class ClearCommand {
    static String cleared;
    public static void clearCommand(){
        cleared = LocalizationManager.getInstance().getString("cleared");
        if(ClientLauncher.stack.size() == 0 ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Collection is empty");
            alert.showAndWait();
            return;
        }else{
            Iterator<Flat> iterator =ClientLauncher.stack.iterator();
            while(iterator.hasNext()){
                Flat flat = iterator.next();
                if(flat.getNameUser().equals(ClientLauncher.user.getNameUser())){
                    iterator.remove();
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText(cleared);
                alert.showAndWait();
            }
        }
    }
}
