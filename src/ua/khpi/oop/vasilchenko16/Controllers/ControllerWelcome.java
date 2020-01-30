package ua.khpi.oop.vasilchenko16.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ua.khpi.oop.vasilchenko16.Animation.MyButtonSkin;
import ua.khpi.oop.vasilchenko16.Util.Util;

import java.io.IOException;

public class ControllerWelcome {

    @FXML
    private Button doItButton;

    @FXML
    void initialize() {
        doItButton.setSkin(new MyButtonSkin(doItButton));

        doItButton.setOnAction(event -> {
            Util.createNewScene("home.fxml", "Recruitment");
            try {
                Util.read();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            doItButton.getScene().getWindow().hide();
        });

    }
}
