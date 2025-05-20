package tmk.bdd.Controller.Articulo.VentanaAñadir;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tmk.bdd.Controller.Articulo.ArticuloLanzador;

public class AñadirLanzador {
    public static void abrirVentanaModal() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ArticuloLanzador.class.getResource("/tmk/bdd/Controller/Articulo/VentanaAñadir/AñadirVentana.fxml"));
            Parent root = fxmlLoader.load();

            root.getStylesheets().add(AñadirLanzador.class.getResource("tmk/bdd/Controller/Articulo/VentanaAñadir/AñadirEstilos.css").toExternalForm());

            Stage stage = new Stage();
            stage.setTitle("Ventana Modificar Articulo");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
