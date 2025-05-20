package tmk.bdd.Articulo.VentanaAñadir;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tmk.bdd.Articulo.VentanaModificar.ModificarControlador;
import tmk.bdd.ConexionBDD.ConexionMySQL;
import tmk.bdd.LanzarPopups;

import java.sql.*;

public class AñadirControlador {
    private Connection conexion = ConexionMySQL.getConexion();
    @FXML private TextField campoNombre;
    @FXML private TextField campoPrecio;
    @FXML private TextField campoCodigoP;
    @FXML private TextField campoGrupoPertenece;



    public void añadirArticulos() throws SQLException {
        String nombre = campoNombre.getText();
        String codigo = campoCodigoP.getText();
        String precioStr = campoPrecio.getText();
        String grupoStr = campoGrupoPertenece.getText();

        boolean nombreValido = false;
        boolean precioValido = false;
        boolean codigoValido = false;
        boolean grupoValido = false;

        int precio = 0;
        int grupo = 0;

        if (nombre.isBlank()) {
            LanzarPopups.lanzarError("El campo nombre está vacío");
        } else {
            nombreValido = true;
        }

        if (precioStr.isBlank()) {
            LanzarPopups.lanzarError("El campo precio está vacío");
        } else {
            try {
                precio = Integer.parseInt(precioStr);
                precioValido = true;
            } catch (NumberFormatException e) {
                LanzarPopups.lanzarError("El campo precio debe ser un número entero");
            }
        }

        if (codigo.isBlank()) {
            LanzarPopups.lanzarError("El campo código está vacío");
        } else {
            codigoValido = true;
        }

        if (grupoStr.isBlank()) {
            LanzarPopups.lanzarError("El campo grupo está vacío");
        } else {
            try {
                grupo = Integer.parseInt(grupoStr);
                grupoValido = true;
            } catch (NumberFormatException e) {
                LanzarPopups.lanzarError("El campo grupo debe ser un número entero");
            }
        }

        if (nombreValido && precioValido && codigoValido && grupoValido) {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO articulos (nombre, precio, codigo, grupo) VALUES (?,?,?,?)");
            ps.setString(1, nombre);
            ps.setInt(2, precio);
            ps.setString(3, codigo);
            ps.setInt(4, grupo);
            if (ps.executeUpdate()>=1){
                System.out.println("Introduction exitosa");

                Stage stage = (Stage) campoNombre.getScene().getWindow();
                stage.close();
            }
        }
    }
}
