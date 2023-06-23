module sample {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens sample to javafx.fxml;
    opens sample.Flat to javafx.base;
    exports sample;
}