package tmk.bdd;

import javafx.scene.control.Alert;

public class LanzarPopups {

    public static void lanzarError(String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
