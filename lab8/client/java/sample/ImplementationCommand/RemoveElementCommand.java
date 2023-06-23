package sample.ImplementationCommand;

import javafx.scene.control.Alert;
import sample.AssemblyMultiMap.MultiMap;
import sample.BasicPanelContoller;
import sample.Commands.CommandType;
import sample.Flat.Flat;
import sample.Launcher.ClientLauncher;

import java.util.ArrayList;

public class RemoveElementCommand {
    private static boolean available;

    public static void removeElement(int id) {
        for (Flat flat : ClientLauncher.stack) {
            if (flat.getId() == id) {
                if (flat.getNameUser().equals(ClientLauncher.user.getNameUser())) {
                    available = true;
                    break;
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Вы не являетесь владельцем элемента!");
                    alert.showAndWait();
                    return;
                }
            }
            if (!available) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Такого элемента нет в коллекции!");
                alert.showAndWait();
                return;
            } else {
                ClientLauncher.stack.removeIf(flat1 -> flat1.getId() == id);
                for(Flat flat1 : ClientLauncher.stack){
                    if (flat1.getId() > id){
                        flat1.setIdWithParametrs(flat1.getId() - 1);
                    }
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Элемент " + id + " был удален!");
                alert.showAndWait();
            }
            }




        //------------
        for (Flat flat : BasicPanelContoller.observableList) {
            if (flat.getId() == id) {
                if (flat.getNameUser().equals(ClientLauncher.user.getNameUser())) {
                    available = true;
                    break;
                } else {
                }
            }
            if (!available) {
            } else {
               BasicPanelContoller.observableList.removeIf(flat1 -> flat1.getId() == id);
                for(Flat flat1 : BasicPanelContoller.observableList){
                    if (flat1.getId() > id){
                        flat1.setIdWithParametrs(flat1.getId() - 1);
                    }
                }
            }
        }
        }
    }
