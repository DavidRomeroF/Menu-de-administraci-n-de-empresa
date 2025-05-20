package tmk.bdd.Controller.Articulo;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import tmk.bdd.Controller.Articulo.VentanaAñadir.AñadirLanzador;
import tmk.bdd.Controller.Articulo.VentanaModificar.ModificarControlador;
import tmk.bdd.Controller.Articulo.VentanaModificar.ModificarLanzador;
import tmk.bdd.Database.ConexionBDD.ConexionMySQL;

import java.sql.*;

public class ArticuloControlador {
    private Connection conexion;
    @FXML private ListView listaArticulos;

    public void initialize() throws SQLException {
        conexion = ConexionMySQL.getConexion();
        Statement st = conexion.createStatement();
        ResultSet consulta = st.executeQuery("SELECT * FROM articulos");

        while (consulta.next()){
            String insercion = String.format("Nombre: %s Precio: %d Código: %s Grupo: %d"
            ,consulta.getString("nombre"),consulta.getInt("precio"),consulta.getString("codigo"),consulta.getInt("grupo"));
            listaArticulos.getItems().add(insercion);
        }
    }

    public void añadirArticulo() throws SQLException {
        AñadirLanzador.abrirVentanaModal();
        actualizarLista();
    }

    public void modificarArticulo() throws SQLException {
        String seleccionado = listaArticulos.getSelectionModel().getSelectedItem().toString();
        if (seleccionado != null) {
            ModificarControlador.recuperarDatos(seleccionado);
            ModificarLanzador.abrirVentanaModal();
        }
        actualizarLista();
    }

    public  void actualizarLista() throws SQLException {
        listaArticulos.getItems().clear();
        initialize();
    }

    public void eliminarArticulo() throws SQLException {
        String seleccionado = listaArticulos.getSelectionModel().getSelectedItem().toString();
        String[] lista = seleccionado.split(" ");
        String codigo = lista[lista.length - 3];

        PreparedStatement ps = conexion.prepareStatement("DELETE FROM articulos WHERE codigo = ?");
        ps.setString(1, codigo);

        ps.executeUpdate();

        actualizarLista();
    }
}
