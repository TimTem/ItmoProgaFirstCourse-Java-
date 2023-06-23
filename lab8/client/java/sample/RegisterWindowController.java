package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.ConnectionDB.Registration.RegistUser;
import sample.Localisation.LocalizationManager;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterWindowController {

    @FXML
    private Hyperlink backInWindowAuth;

    @FXML
    private Label broiler;

    @FXML
    private Label broiler_enter;

    @FXML
    private TextField loginField;

    @FXML
    private Label login_label;

    @FXML
    private Label pass_label;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Label remember;

    @FXML
    void initialize() {
//        broiler.setText(HelloController.rb.getString("label_broiler"));
//        broiler_enter.setText(HelloController.rb.getString("label_enter"));
//        registerButton.setText(HelloController.rb.getString("button_registr"));
//        login_label.setText(HelloController.rb.getString("label_login_value"));
//        loginField.setAccessibleText(HelloController.rb.getString("label_login_value"));
//        pass_label.setText(HelloController.rb.getString("label_password_value"));
//        passwordField.setAccessibleText(HelloController.rb.getString("label_password_value"));
//        remember.setText(HelloController.rb.getString("label_remember"));
//        backInWindowAuth.setText(HelloController.rb.getString("link_login"));
        registerButton.setOnAction(actionEvent -> {
            String login = loginField.getText().trim();
            String password = passwordField.getText().trim();
            if(login.equals("") && password.equals("")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("User data is empty, please enter data!");
                alert.showAndWait();
            }else{
                loginField.setText("");
                passwordField.setText("");
                try {
                    RegistUser.registUser(login,password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        backInWindowAuth.setOnAction(actionEvent -> {
            backInWindowAuth.getScene().getWindow().hide();
//            Stage stage1 = (Stage) backInWindowAuth.getScene().getWindow();
//            stage1.close();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/hello-view.fxml"));
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
        broiler.setText(LocalizationManager.getInstance().getString("label_broiler"));
        broiler_enter.setText(LocalizationManager.getInstance().getString("label_enter"));
        registerButton.setText(LocalizationManager.getInstance().getString("button_registr"));
        login_label.setText(LocalizationManager.getInstance().getString("label_login_value"));
        loginField.setPromptText(LocalizationManager.getInstance().getString("label_login_value"));
        pass_label.setText(LocalizationManager.getInstance().getString("label_password_value"));
        passwordField.setPromptText(LocalizationManager.getInstance().getString("label_password_value"));
        remember.setText(LocalizationManager.getInstance().getString("label_remember"));
        backInWindowAuth.setText(LocalizationManager.getInstance().getString("link_login"));
    }
}
