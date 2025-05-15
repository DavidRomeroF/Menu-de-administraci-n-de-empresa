package tmk.bdd.Articulo.VentanaAñadir;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tmk.bdd.Articulo.VentanaModificar.ModificarControlador;
import tmk.bdd.ConexionBDD.ConexionMySQL;

import java.sql.*;

public class AñadirControlador {
    private Connection conexion = ConexionMySQL.getConexion();
    @FXML private TextField campoNombre;
    @FXML private TextField campoPrecio;
    @FXML private TextField campoCodigoP;
    @FXML private TextField campoGrupoPertenece;



    public void añadirArticulos() throws SQLException {
        int precio,grupo;
        String nombre,codigo;

        nombre = campoNombre.getText();
        precio = Integer.parseInt(campoPrecio.getText());
        codigo = campoCodigoP.getText();
        grupo = Integer.parseInt(campoGrupoPertenece.getText());

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
