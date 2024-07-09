package ca.georgian.chart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.io.Console;
import java.net.URL;
import java.sql.*;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private BarChart<String, Integer> barChart;
    @FXML
    private CategoryAxis categoryAxis;
    @FXML
    private NumberAxis numberAxis;

    @FXML
    protected void onDataButtonClick() {
        HelloApplication.openData();
    }

    private ObservableList<String> observableListRegio = FXCollections.observableArrayList();
    private void addData() {
        try {
            DatabaseConnector dbConnector = new DatabaseConnector();
            Connection connection = dbConnector.connect();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT regio, SUM(value) as sum_value from orders\n" +
                    "group by regio");

            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.setName("Cumulative sales");
            while (resultSet.next()) {
                 System.out.println(
                        resultSet.getString("regio") + " " +
                        resultSet.getInt("sum_value")
                );

                observableListRegio.add(resultSet.getString("regio"));
                series.getData().add(new XYChart.Data<>(resultSet.getString("regio"),
                                                        resultSet.getInt("sum_value")));


            }
            categoryAxis.setCategories(observableListRegio);
            barChart.getData().add(series);
            System.out.println(observableListRegio);

        } catch (SQLException e) { e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addData();
    }
}