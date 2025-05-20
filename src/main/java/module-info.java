module tmk.bdd {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    // Abrir paquetes para que FXMLLoader pueda acceder (reflexión)
    opens tmk.bdd.Controller.Articulo to javafx.fxml;
    opens tmk.bdd.Controller.Articulo.VentanaAñadir to javafx.fxml;
    opens tmk.bdd.Controller.Articulo.VentanaModificar to javafx.fxml;
    opens tmk.bdd.Controller.Main to javafx.fxml;
    opens tmk.bdd.Database.ConexionBDD to javafx.fxml;
    opens tmk.bdd.Model to javafx.fxml;

    // Exportar paquetes para acceso público (opcional, según necesidad)
    exports tmk.bdd.Controller.Articulo;
    exports tmk.bdd.Controller.Articulo.VentanaAñadir;
    exports tmk.bdd.Controller.Articulo.VentanaModificar;
    exports tmk.bdd.Controller.Main;
    exports tmk.bdd.Database.ConexionBDD;
    exports tmk.bdd.Model;
}
