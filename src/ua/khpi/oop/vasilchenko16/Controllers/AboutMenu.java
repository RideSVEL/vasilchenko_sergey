package ua.khpi.oop.vasilchenko16.Controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ua.khpi.oop.vasilchenko16.Animation.MyButtonSkin;

public class AboutMenu {

    @FXML
    private Button okButton;

    @FXML
    void initialize() {
        okButton.setSkin(new MyButtonSkin(okButton));

        okButton.setOnAction(event -> okButton.getScene().getWindow().hide());

    }
}
