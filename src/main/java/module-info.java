module ca.georgian.chart {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ca.georgian.chart to javafx.fxml;
    exports ca.georgian.chart;
}