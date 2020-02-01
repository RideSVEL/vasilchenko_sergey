package ua.khpi.oop.vasilchenko16.Util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ua.khpi.oop.vasilchenko16.App.Main;
import ua.khpi.oop.vasilchenko16.Container.Container;
import ua.khpi.oop.vasilchenko16.Controllers.ControllerWelcome;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Util {

    public static void save() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("src/ua/khpi/oop/vasilchenko16/Save/data.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(Main.container);
        objectOutputStream.close();
    }

    public static void read() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("src/ua/khpi/oop/vasilchenko16/Save/data.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Main.container = (Container) objectInputStream.readObject();
    }

    public static void createNewScene(String fxml, String name){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ControllerWelcome.class.getResource("/ua/khpi/oop/vasilchenko16/View/" + fxml));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.getIcons().add(new Image("file:/ua/khpi/oop/vasilchenko16/Assist/customer_person_people_man_you_1625.ico"));
        stage.setTitle(name);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
