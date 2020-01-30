package ua.khpi.oop.vasilchenko16.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ua.khpi.oop.vasilchenko16.Animation.MyButtonSkin;
import ua.khpi.oop.vasilchenko16.App.Main;

public class Search {

    @FXML
    private Label id;

    @FXML
    private Label company;

    @FXML
    private Label specialty;

    @FXML
    private Label conditions;

    @FXML
    private Label paymnet;

    @FXML
    private Label needs;

    @FXML
    private Label expirience;

    @FXML
    private Label education;

    @FXML
    private Label error;

    @FXML
    private Button okButton;


    private void show() {
        boolean confirm = false;
        if (Show.getSearchId().equals("")) {
            error.setText("No such values!");
        } else {
            for (int i = 0; i < Main.container.size(); i++) {
                if (String.valueOf(Main.container.getElementByIndex(i).getId()).equals(Show.getSearchId())) {
                    id.setText(String.valueOf(Main.container.getElementByIndex(i).getId()));
                    company.setText(String.valueOf(Main.container.getElementByIndex(i).getFirm()));
                    specialty.setText(String.valueOf(Main.container.getElementByIndex(i).getSpecialty()));
                    conditions.setText(String.valueOf(Main.container.getElementByIndex(i).getWorkingConditions()));
                    paymnet.setText(String.valueOf(Main.container.getElementByIndex(i).getPayment()));
                    if (Main.container.getElementByIndex(i).getConfirms()){
                        needs.setText(String.valueOf(Main.container.getElementByIndex(i).getNeedsSpeciality()));
                        expirience.setText(String.valueOf(Main.container.getElementByIndex(i).getExperience()));
                        education.setText(String.valueOf(Main.container.getElementByIndex(i).getEducation()));
                    }
                    confirm = true;
                    break;
                }
            }
        }
        if (!confirm) {
            error.setText("No such values!");
        }
    }

    @FXML
    void initialize() {
        show();

        okButton.setSkin(new MyButtonSkin(okButton));

        okButton.setOnAction(event -> {
            okButton.getScene().getWindow().hide();
        });
    }
}
