package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.ImplementationCommand.AddInObservableList;
import sample.Client.AssemblyAddForServer;
import sample.Client.SendToServer;
import sample.Flat.Furnish;
import sample.Flat.Transports;
import sample.Localisation.LocalizationManager;

import java.io.IOException;

public class CreateWindowController {


    @FXML
    private Button add;

    @FXML
    private Spinner<Integer> area;

    @FXML
    private Label area1;

    @FXML
    private Button exit;

    @FXML
    private Label finishing;

    @FXML
    private ComboBox<String> finishingBurger;

    @FXML
    private TextField name;

    @FXML
    private TextField nameHouse;

    @FXML
    private Label name_flat;

    @FXML
    private Label name_house;

    @FXML
    private Label never;

    @FXML
    private Spinner<Integer> numberOfApartments;

    @FXML
    private Spinner<Integer> numberOfRooms;

    @FXML
    private Label number_apps;

    @FXML
    private Label number_of_rooms;

    @FXML
    private Label quality;

    @FXML
    private ComboBox<Boolean> qualityBurger;

    @FXML
    private Label transport;

    @FXML
    private ComboBox<String> transportBurger;

    @FXML
    private Label x;

    @FXML
    private Spinner<Double> xCoordinates;

    @FXML
    private Label y;

    @FXML
    private Spinner<Double> yCoordinates;

    @FXML
    private Label years;

    @FXML
    private Spinner<Integer> yearsHouse;

    String element;
    String added;
    @FXML
    void initialize() {
        //X
        SpinnerValueFactory<Double> spinner = new SpinnerValueFactory.DoubleSpinnerValueFactory(-100,100,0,0.1);
        this.xCoordinates.setValueFactory(spinner);

        //Y
        SpinnerValueFactory<Double> spinner1 = new SpinnerValueFactory.DoubleSpinnerValueFactory(-100,100,0,0.1);
        this.yCoordinates.setValueFactory(spinner1);
        //area
        SpinnerValueFactory<Integer> spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
        this.area.setValueFactory(spinner2);
        //nemberOfRooms
        SpinnerValueFactory<Integer> spinner3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
        this.numberOfRooms.setValueFactory(spinner3);
        //years
        SpinnerValueFactory<Integer> spinner4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
        this.yearsHouse.setValueFactory(spinner4);
        //numberOfApps
        SpinnerValueFactory<Integer> spinner5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
        this.numberOfApartments.setValueFactory(spinner5);

        add.setOnAction(actionEvent -> {
            SendToServer.sendMultiMap(AssemblyAddForServer.add(name.getText(),xCoordinates.getValue(),yCoordinates.getValue(),area.getValue(),numberOfRooms.getValue(),qualityBurger.getValue(),finishingBurger.getValue(),transportBurger.getValue(),nameHouse.getText(),yearsHouse.getValue(),numberOfApartments.getValue()));
            AddInObservableList.addInObserverList(name.getText(),xCoordinates.getValue(),yCoordinates.getValue(),area.getValue(),numberOfRooms.getValue(),qualityBurger.getValue(),finishingBurger.getValue(),transportBurger.getValue(),nameHouse.getText(),yearsHouse.getValue(),numberOfApartments.getValue());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText(element + name.getText() + added);
            alert.showAndWait();
        });
        //quality
        ObservableList<Boolean> optionsQuality = FXCollections.observableArrayList();
        optionsQuality.add(true);
        optionsQuality.add(false);
        qualityBurger.setItems(optionsQuality);
        //transports
        ObservableList<String> optionsTransoprts = FXCollections.observableArrayList();
        for (Transports furnish : Transports.values()) {
            optionsTransoprts.add(furnish.getName());
        }
        transportBurger.setItems(optionsTransoprts);
        //furnish
        ObservableList<String> optionsFurnish = FXCollections.observableArrayList();
        for (Furnish furnish : Furnish.values()) {
            optionsFurnish.add(furnish.getName());
        }
        finishingBurger.setItems(optionsFurnish);
        exit.setOnAction(actionEvent -> {
            exit.getScene().getWindow().hide();
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
        never.setText(LocalizationManager.getInstance().getString("label_never"));
        name_flat.setText(LocalizationManager.getInstance().getString("label_name_flat"));
        x.setText(LocalizationManager.getInstance().getString("label_x"));
        y.setText(LocalizationManager.getInstance().getString("label_y"));
        area1.setText(LocalizationManager.getInstance().getString("label_area"));
        number_of_rooms.setText(LocalizationManager.getInstance().getString("label_number_of_rooms"));
        quality.setText(LocalizationManager.getInstance().getString("label_quality"));
        finishing.setText(LocalizationManager.getInstance().getString("label_finishing"));
        transport.setText(LocalizationManager.getInstance().getString("label_transport"));
        name_house.setText(LocalizationManager.getInstance().getString("label_name_house"));
        years.setText(LocalizationManager.getInstance().getString("label_years"));
        number_apps.setText(LocalizationManager.getInstance().getString("label_number_apps"));
        exit.setText(LocalizationManager.getInstance().getString("button_exit"));
        add.setText(LocalizationManager.getInstance().getString("button_add"));
        element = LocalizationManager.getInstance().getString("element");
        added = LocalizationManager.getInstance().getString("added");
    }
}

