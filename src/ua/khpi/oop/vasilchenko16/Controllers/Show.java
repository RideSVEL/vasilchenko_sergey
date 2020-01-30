package ua.khpi.oop.vasilchenko16.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import ua.khpi.oop.vasilchenko16.Animation.MyButtonSkin;
import ua.khpi.oop.vasilchenko16.Animation.Shake;
import ua.khpi.oop.vasilchenko16.App.Main;
import ua.khpi.oop.vasilchenko16.Head.Recruitment;
import ua.khpi.oop.vasilchenko16.Util.Util;

import java.io.IOException;

public class Show {

    private ObservableList<Recruitment> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Recruitment> tableViewId;

    @FXML
    private TableColumn<Recruitment, String> companyId;

    @FXML
    private TableColumn<Recruitment, String> specialtyId;

    @FXML
    private TableColumn<Recruitment, String> conditionsId;

    @FXML
    private TableColumn<Recruitment, Integer> paymentId;

    @FXML
    private TableColumn<Recruitment, String> needsId;

    @FXML
    private TableColumn<Recruitment, Integer> expirienceId;

    @FXML
    private TableColumn<Recruitment, String> educationId;

    @FXML
    private TableColumn<Recruitment, Integer> idVacancy;

    @FXML
    private ImageView refresh;

    @FXML
    private Button deleteId;

    @FXML
    private ImageView back;

    @FXML
    private TextField idField;

    @FXML
    private Button searchButton;

    private static String searchId;

    public static String getSearchId() {
        return searchId;
    }

    private void search() {
        searchId = idField.getText();
        if (searchId.equals("")){
            Shake shake = new Shake(idField);
            shake.playAnim();
        }
        Util.createNewScene("search.fxml", "Search");
    }

    @FXML
    void initialize() {
        searchButton.setSkin(new MyButtonSkin(searchButton));
        deleteId.setSkin(new MyButtonSkin(deleteId));

        initData();

        companyId.setCellValueFactory(new PropertyValueFactory<Recruitment, String>("firm"));
        specialtyId.setCellValueFactory(new PropertyValueFactory<Recruitment, String>("specialty"));
        conditionsId.setCellValueFactory(new PropertyValueFactory<Recruitment, String>("workingConditions"));
        paymentId.setCellValueFactory(new PropertyValueFactory<Recruitment, Integer>("payment"));
        needsId.setCellValueFactory(new PropertyValueFactory<Recruitment, String>("needsSpeciality"));
        educationId.setCellValueFactory(new PropertyValueFactory<Recruitment, String>("education"));
        expirienceId.setCellValueFactory(new PropertyValueFactory<Recruitment, Integer>("experience"));
        idVacancy.setCellValueFactory(new PropertyValueFactory<Recruitment, Integer>("id"));

        tableViewId.setItems(list);

        deleteId.setOnAction(event -> {
            Main.container.remove(tableViewId.getSelectionModel().getSelectedItem());
            try {
                Util.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        refresh.setOnMouseClicked(event -> {
            refresh.getScene().getWindow().hide();
            Util.createNewScene("show.fxml", "Show");
        });

        back.setOnMouseClicked(event -> {
            Util.createNewScene("home.fxml", "Recruitment");
            back.getScene().getWindow().hide();
        });

        searchButton.setOnAction(event -> search());

    }

    private void initData() {
        for (int i = 0; i < Main.container.size(); i++) {
            list.add(Main.container.getElementByIndex(i));
        }
    }
}
