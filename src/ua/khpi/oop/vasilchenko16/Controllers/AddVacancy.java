package ua.khpi.oop.vasilchenko16.Controllers;

import java.io.IOException;
import java.util.NoSuchElementException;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import ua.khpi.oop.vasilchenko16.Animation.Shake;
import ua.khpi.oop.vasilchenko16.App.Main;
import ua.khpi.oop.vasilchenko16.Head.Recruitment;
import ua.khpi.oop.vasilchenko16.Util.Util;

public class AddVacancy {

    @FXML
    private MenuItem backMenuItem;

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private MenuItem clearMenuItem;

    @FXML
    private ImageView backImage;

    @FXML
    private TextField comanyField;

    @FXML
    private TextField specialtyField;

    @FXML
    private TextField workoiongField;

    @FXML
    private TextField paymentField;

    @FXML
    private RadioButton yesRadioButton;

    @FXML
    private RadioButton noRadioButton;

    @FXML
    private TextField needsSpecialtyField;

    @FXML
    private TextField educationField;

    @FXML
    private TextField expirienceField;

    @FXML
    private Button saveButton;

    @FXML
    private AnchorPane additionalPane;

    private void shakesField(){
        Shake shake = new Shake(comanyField);
        Shake shake1 = new Shake(educationField);
        Shake shake2 = new Shake(needsSpecialtyField);
        Shake shake3 = new Shake(expirienceField);
        Shake shake4 = new Shake(paymentField);
        Shake shake5 = new Shake(workoiongField);
        Shake shake6 = new Shake(specialtyField);
        shake.playAnim();
        shake1.playAnim();
        shake2.playAnim();
        shake3.playAnim();
        shake4.playAnim();
        shake5.playAnim();
        shake6.playAnim();
    }

    private void errorMessage() {
        Util.createNewScene("error.fxml", "Error");
    }


    private Recruitment addVacancy() {
        Recruitment recruitment = new Recruitment();
        try {
            recruitment.setFirm(comanyField.getText());
            recruitment.setSpecialty(specialtyField.getText());
            recruitment.setWorkingConditions(workoiongField.getText());
            recruitment.setPayment(Integer.parseInt(paymentField.getText()));
            if (yesRadioButton.isSelected()) {
                recruitment.setConfirm(true);
                recruitment.setNeedsSpeciality(needsSpecialtyField.getText());
                recruitment.setEducation(educationField.getText());
                recruitment.setExperience(Integer.parseInt(expirienceField.getText()));
            } else if (noRadioButton.isSelected()) {
                recruitment.setConfirm(false);
            }

        } catch (Exception e) {
            throw new NoSuchElementException();
        }
        return recruitment;
    }

    @FXML
    void initialize() {

        backImage.setOnMouseClicked(event -> {
            Util.createNewScene("home.fxml", "Recruitment");
            backImage.getScene().getWindow().hide();
        });

        backMenuItem.setOnAction(event -> {
            Util.createNewScene("home.fxml", "Recruitment");
            backImage.getScene().getWindow().hide();
        });

        exitMenuItem.setOnAction(event -> {
            backImage.getScene().getWindow().hide();
        });


        saveButton.setOnAction(event -> {
            try {
                Main.container.add(addVacancy());
            } catch (Exception e) {
                System.out.println("Repeat entered:");
                errorMessage();
                shakesField();
                Main.container.add(addVacancy());
            }
            try {
                Util.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Util.createNewScene("home.fxml", "Recruitment");
            saveButton.getScene().getWindow().hide();
        });

        ToggleGroup group = new ToggleGroup();
        yesRadioButton.setToggleGroup(group);
        noRadioButton.setSelected(true);
        noRadioButton.setToggleGroup(group);

        /*связывание состояния обьекта yesRadioButton
         * при изменение состояния
         * также будет изменяться состояние видимости*/
        additionalPane.visibleProperty().bind(yesRadioButton.selectedProperty());

        clearMenuItem.setOnAction(event -> {
            expirienceField.setText("");
            educationField.setText("");
            paymentField.setText("");
            expirienceField.setText("");
            needsSpecialtyField.setText("");
            comanyField.setText("");
            workoiongField.setText("");
            specialtyField.setText("");
        });
    }
}
