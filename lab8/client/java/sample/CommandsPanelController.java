package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Client.AssemblyClearForServer;
import sample.Client.AssemblyInfoForServer;
import sample.Client.AssemblyRemoveLastForServer;
import sample.Client.SendToServer;
import sample.ImplementationCommand.*;
import sample.Launcher.ClientLauncher;
import sample.Localisation.LocalizationManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CommandsPanelController {

    @FXML
    private Button averageNumber;

    @FXML
    private Button clear;

    @FXML
    private Button closeWindow;

    @FXML
    private Button infoCollection;

    @FXML
    private Label losing;

    @FXML
    private Button removeLast;

    String cleared;

    @FXML
    void initialize() {
        averageNumber.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText(AverageCommand.averageOfNumberOfRooms());
            alert.show();
        });
        infoCollection.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText(InfoCommand.implementationInfo());
            alert.show();
        });
        clear.setOnAction(actionEvent ->{
            ClearCommand.clearCommand();
            SendToServer.sendMultiMap(AssemblyClearForServer.clearForServer());
        });
        removeLast.setOnAction((actionEvent -> {
            RemoveLastCommand.removeLast();
            SendToServer.sendMultiMap(AssemblyRemoveLastForServer.removeLastForServer());
        }));
        closeWindow.setOnAction(actionEvent -> {
            closeWindow.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/basic-panel.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        });
        updateUI();
    }
    private void updateUI(){
    losing.setText(LocalizationManager.getInstance().getString("label_losing"));
    clear.setText(LocalizationManager.getInstance().getString("button_clear"));
    removeLast.setText(LocalizationManager.getInstance().getString("button_remove_last"));
    infoCollection.setText(LocalizationManager.getInstance().getString("button_info"));
    averageNumber.setText(LocalizationManager.getInstance().getString("button_average"));
    closeWindow.setText(LocalizationManager.getInstance().getString("button_close"));
    cleared = LocalizationManager.getInstance().getString("cleared");
    }
}
