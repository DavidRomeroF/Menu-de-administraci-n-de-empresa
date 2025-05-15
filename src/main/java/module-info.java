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

    opens tmk.bdd.Articulo.VentanaAñadir to javafx.fxml;
    opens tmk.bdd.Articulo.VentanaModificar to javafx.fxml;
    opens tmk.bdd to javafx.fxml;
    exports tmk.bdd;
    exports tmk.bdd.ConexionBDD;
    opens tmk.bdd.ConexionBDD to javafx.fxml;
    exports tmk.bdd.Articulo;
    opens tmk.bdd.Articulo to javafx.fxml;
}