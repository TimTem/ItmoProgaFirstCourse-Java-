package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Client.ClientWork;
import sample.ConnectionDB.Authentication.AuthForLogin;
import sample.ConnectionDB.Authentication.AuthForPassword;
import sample.Launcher.ClientLauncher;
import sample.Localisation.LocalizationManager;
import sample.Localisation.UTF8Control;


import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_login;

    @FXML
    private Label label_login_your_acc;

    @FXML
    private Label label_password;

    @FXML
    private Label label_welcome;

    @FXML
    private ComboBox<String> language;

    @FXML
    private TextField login_field;

    @FXML
    private Button main_button_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Hyperlink regist_field;

    @FXML
    private Label dnt;
    @FXML
    void initialize() {
        ObservableList<String> optionsQuality = FXCollections.observableArrayList();
        optionsQuality.add("Русский");
        optionsQuality.add("Чешский");
        optionsQuality.add("Греческий");
        optionsQuality.add("Испанский");
        language.setItems(optionsQuality);
//        Locale current = new Locale(lan,country);
//        rb = ResourceBundle.getBundle(file,current);
//        label_welcome.setText(rb.getString("label_welcome"));
//        label_login_your_acc.setText(rb.getString("label_login"));
//        label_login.setText(rb.getString("label_login_value"));
//        login_field.setPromptText(rb.getString("label_login_value"));
//        password_field.setPromptText(rb.getString("label_password_value"));
//        label_password.setText(rb.getString("label_password_value"));
//        main_button_field.setText(rb.getString("button_login"));
//        dnt.setText(rb.getString("label_dont_account"));
//        regist_field.setText(rb.getString("link_register"));
        language.setOnAction(event -> {
            String selectedLanguage = language.getSelectionModel().getSelectedItem();
            LocalizationManager.getInstance().setLanguage(selectedLanguage);
            updateUI();
//            if (selectedLanguage.equals("Русский")) {
////               lan = "ru";
////               country = "RU";
////               file = "text_ru_RU";
////                label_welcome.setText(rb.getString("label_welcome"));
////                label_login_your_acc.setText(rb.getString("label_login"));
////                label_login.setText(rb.getString("label_login_value"));
////                login_field.setPromptText(rb.getString("label_login_value"));
////                password_field.setPromptText(rb.getString("label_password_value"));
////                label_password.setText(rb.getString("label_password_value"));
////                main_button_field.setText(rb.getString("button_login"));
////                dnt.setText(rb.getString("label_dont_account"));
////                regist_field.setText(rb.getString("link_register"));
//                String selectedLanguage = language.getSelectionModel().getSelectedItem();
//                System.out.println("Выбран русский язык");
//            } else if (selectedLanguage.equals("Чешский")) {
//                // Выполните действия, которые требуется выполнить при выборе "Чешский"
//                System.out.println("Выбран чешский язык");
//            } else if (selectedLanguage.equals("Греческий")) {
//                // Выполните действия, которые требуется выполнить при выборе "Греческий"
//                System.out.println("Выбран греческий язык");
//            } else if (selectedLanguage.equals("Испанский")) {
//                // Выполните действия, которые требуется выполнить при выборе "Испанский"
//                System.out.println("Выбран испанский язык");
//            }
        });
        main_button_field.setOnAction(actionEvent -> {
            String login = login_field.getText().trim();
            String password = password_field.getText().trim();
            if(login.equals("") && password.equals("")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("User data is empty, please enter data!");
                alert.show();
            }else{
                login_field.setText("");
                password_field.setText("");
                try {
                    if(AuthForLogin.checkLogin(login) && AuthForPassword.checkPassword(password,login)){
                        ClientLauncher.user.setNameUser(login);
                        if(ClientWork.connectToServer()){
                            main_button_field.getScene().getWindow().hide();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/sample/basic-panel.fxml"));
                            loader.load();
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.show();
                        }else{
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Information");
                            alert.setHeaderText(null);
                            alert.setContentText("Сервер отключен подключение не возможно!");
                            alert.showAndWait();
                        }
                    }else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information");
                        alert.setHeaderText(null);
                        alert.setContentText("Пароль или логин неверный!");
                        alert.showAndWait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        regist_field.setOnAction(actionEvent -> {
            regist_field.getScene().getWindow().hide();
//            Stage stage1 = (Stage) regist_field.getScene().getWindow();
//            stage1.close();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/register_window.fxml"));
            //loader.setLocation(getClass().getResource("\\main\\resources\\sample\\lab8try1\\register_window.fxml"));
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
        label_welcome.setText(LocalizationManager.getInstance().getString("label_welcome"));
        label_login_your_acc.setText(LocalizationManager.getInstance().getString("label_login"));
        label_login.setText(LocalizationManager.getInstance().getString("label_login_value"));
        login_field.setPromptText(LocalizationManager.getInstance().getString("label_login_value"));
        password_field.setPromptText(LocalizationManager.getInstance().getString("label_password_value"));
        label_password.setText(LocalizationManager.getInstance().getString("label_password_value"));
        main_button_field.setText(LocalizationManager.getInstance().getString("button_login"));
        dnt.setText(LocalizationManager.getInstance().getString("label_dont_account"));
        regist_field.setText(LocalizationManager.getInstance().getString("link_register"));
    }

}
