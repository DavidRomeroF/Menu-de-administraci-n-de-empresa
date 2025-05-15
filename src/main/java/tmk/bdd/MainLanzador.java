package tmk.bdd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainLanzador extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainLanzador.class.getResource("MainVista.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 610, 340);
        scene.getStylesheets().add(getClass().getResource("/tmk/bdd/MainEstilo.css").toExternalForm());
        stage.setTitle("Administrador Empresa");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}