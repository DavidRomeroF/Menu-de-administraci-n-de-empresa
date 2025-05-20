package tmk.bdd.Controller.Articulo.VentanaModificar;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tmk.bdd.Database.ConexionBDD.ConexionMySQL;
import tmk.bdd.LanzarPopups;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModificarControlador {
    private static String codigo;
    private Connection conexion = ConexionMySQL.getConexion();
    @FXML
    private Label seccionID;
    @FXML private TextField campoNombre;
    @FXML private TextField campoPrecio;
    @FXML private TextField campoCodigoP;
    @FXML private TextField campoGrupoPertenece;

    public static void recuperarDatos(String seleccionado){
        String[] lista = seleccionado.split(" ");
        codigo = lista[lista.length - 3];
    }

    public void initialize() throws SQLException {
        String codigo = ModificarControlador.codigo, precio;

        PreparedStatement ps = conexion.prepareStatement("SELECT * FROM articulos WHERE codigo = ?");
        ps.setString(1, codigo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            precio = rs.getString("precio").split("\\.")[0];
            seccionID.setText("ID: " + rs.getInt("id"));
            campoNombre.setText(rs.getString("nombre"));
            campoPrecio.setText(precio);
            campoCodigoP.setText(rs.getString("codigo"));
            campoGrupoPertenece.setText(rs.getString("grupo"));
        }
    }

    public void modificarArticulos() throws SQLException {
        int id = Integer.parseInt(seccionID.getText().split(" ")[1]);
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
            PreparedStatement ps = conexion.prepareStatement(
                    "UPDATE articulos SET nombre=?, precio=?, codigo=?, grupo=? WHERE id=?"
            );
            ps.setString(1, nombre);
            ps.setInt(2, precio);
            ps.setString(3, codigo);
            ps.setInt(4, grupo);
            ps.setInt(5, id);

            if (ps.executeUpdate() >= 1) {
                System.out.println("Modificación exitosa");
                Stage stage = (Stage) seccionID.getScene().getWindow();
                stage.close();
            }
        }
    }
}
