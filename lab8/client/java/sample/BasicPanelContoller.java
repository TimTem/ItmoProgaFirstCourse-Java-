package sample;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Client.AssemblyRemoveElementForServer;
import sample.Client.AssemblyRemoveLastForServer;
import sample.Client.SendToServer;
import sample.Flat.Flat;
import sample.Flat.User;
import sample.ImplementationCommand.RemoveElementCommand;
import sample.ImplementationCommand.UpdateCommand;
import sample.Launcher.ClientLauncher;
import sample.Localisation.LocalizationManager;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BasicPanelContoller{
    @FXML
    private Text userText;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button commands;

    @FXML
    private TableColumn<Flat, Double> XColumn;

    @FXML
    private TableColumn<Flat, Double> YColumn;

    @FXML
    private TableColumn<Flat, Long> areaColumn;

    @FXML
    private Button changeButton;

    @FXML
    private Button createButton;

    @FXML
    private TableColumn<Flat, LocalDate> dateColumn;

    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<Flat, String> furnishColumn;

    @FXML
    private TableColumn<Flat, Integer> idColumn;

    @FXML
    private TableColumn<Flat, Boolean> isNewColumn;

    @FXML
    private TableColumn<Flat, String> loginColumn;

    @FXML
    private TableColumn<Flat, String> nameFlatColumn;

    @FXML
    private TableColumn<Flat, String> nameHouseColumn;

    @FXML
    private TableColumn<Flat, Long> numColumn;

    @FXML
    private TableColumn<Flat, Long> numberHouseColumn;

//    @FXML
//    private Button removeButton;

    @FXML
    private TableView<Flat> tableForDataToDB;

    @FXML
    private TableColumn<Flat, String> transportColumn;

    @FXML
    private Button visualization;

    @FXML
    private TableColumn<Flat, Integer> yearHouseColumn;
    public static ObservableList<Flat> observableList;
    String belongs;
    String dont;
    String notSelected;

    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Flat, Integer>("id"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<Flat,String>("nameUser"));
        nameFlatColumn.setCellValueFactory(new PropertyValueFactory<Flat, String>("name"));
        XColumn.setCellValueFactory(new PropertyValueFactory<Flat, Double>("coordinatesX"));
        YColumn.setCellValueFactory(new PropertyValueFactory<Flat, Double>("coordinatesY"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Flat, LocalDate>("creationDate"));
        areaColumn.setCellValueFactory(new PropertyValueFactory<Flat, Long>("area"));
        numColumn.setCellValueFactory(new PropertyValueFactory<Flat, Long>("numberOfRooms"));
        isNewColumn.setCellValueFactory(new PropertyValueFactory<Flat, Boolean>("New"));
        furnishColumn.setCellValueFactory(new PropertyValueFactory<Flat, String>("furnishName"));
        transportColumn.setCellValueFactory(new PropertyValueFactory<Flat, String>("transportsName"));
        nameHouseColumn.setCellValueFactory(new PropertyValueFactory<Flat, String>("houseName"));
        yearHouseColumn.setCellValueFactory(new PropertyValueFactory<Flat, Integer>("houseYear"));
        numberHouseColumn.setCellValueFactory(new PropertyValueFactory<Flat, Long>("numberOfFlatsOnFloor"));
        observableList = FXCollections.observableArrayList(ClientLauncher.stack);
        tableForDataToDB.setItems(observableList);
        tableForDataToDB.refresh();
        exitButton.setOnAction(actionEvent -> {
            ClientLauncher.user.setNameUser("");
            changeButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/hello-view.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        });
        visualization.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/visualation-panel.fxml"));
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
        changeButton.setOnAction(actionEvent -> {
            SelectionModel<Flat> selectionModel = tableForDataToDB.getSelectionModel();
            Flat selectedFlat = selectionModel.getSelectedItem();
            if(selectedFlat != null){
                UpdateCommand.setFlat(selectedFlat);
                if(ClientLauncher.user.getNameUser().equals(UpdateCommand.flat.getNameUser())){
                    changeButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/change-window.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Parent parent = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(parent));
                    stage.show();
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText(belongs + UpdateCommand.flat.getNameUser()+ dont);
                    alert.showAndWait();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText(notSelected);
                alert.showAndWait();
            }
        });
        createButton.setOnAction(actionEvent -> {
            createButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/create-window.fxml"));
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
        commands.setOnAction(actionEvent -> {
            commands.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/command-window.fxml"));
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
//        removeButton.setOnAction(actionEvent -> {
//            SelectionModel<Flat> selectionModel = tableForDataToDB.getSelectionModel();
//            Flat selectedFlat = selectionModel.getSelectedItem();
//            if(selectedFlat != null){
//                RemoveElementCommand.removeElement(selectedFlat.getId());
//                SendToServer.sendMultiMap((AssemblyRemoveElementForServer.removeElementForServer(selectedFlat.getId())));
//                tableForDataToDB.refresh();
//            }else{
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Information");
//                alert.setHeaderText(null);
//                alert.setContentText(notSelected);
//                alert.showAndWait();
//            }
//        });
    }
    private void updateUI(){
        userText.setText(LocalizationManager.getInstance().getString("label_user") +  " " +ClientLauncher.user.getNameUser());
        exitButton.setText(LocalizationManager.getInstance().getString("button_exit"));
        createButton.setText(LocalizationManager.getInstance().getString("button_create"));
        changeButton.setText(LocalizationManager.getInstance().getString("button_change"));
        visualization.setText(LocalizationManager.getInstance().getString("button_visualisation"));
        commands.setText(LocalizationManager.getInstance().getString("button_command"));
//        removeButton.setText(LocalizationManager.getInstance().getString("button_delete"));
        belongs = LocalizationManager.getInstance().getString("belongs");
        dont = LocalizationManager.getInstance().getString("dont");
        notSelected = LocalizationManager.getInstance().getString("notSelected");
    }
}