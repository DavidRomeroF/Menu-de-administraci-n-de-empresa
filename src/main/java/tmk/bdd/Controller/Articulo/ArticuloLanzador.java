package tmk.bdd.Controller.Articulo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ArticuloLanzador {
    public static void abrirVentanaModal() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ArticuloLanzador.class.getResource("/tmk/bdd/Controller/Articulo/ArticuloVista.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Administrador Artículos");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
