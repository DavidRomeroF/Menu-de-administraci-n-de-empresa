package tmk.bdd.Articulo.VentanaModificar;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tmk.bdd.Articulo.ArticuloLanzador;

public class ModificarLanzador {
    public static void abrirVentanaModal() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ArticuloLanzador.class.getResource("/tmk/bdd/Articulo/VentanaModificar/ModificarVentana.fxml"));
            Parent root = fxmlLoader.load();

            root.getStylesheets().add(ModificarLanzador.class.getResource("/tmk/bdd/Articulo/VentanaModificar/ModificarEstilos.css").toExternalForm());

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
