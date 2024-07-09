package ca.georgian.chart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class DataController {
    @FXML
    private Label welcomeText;

    @FXML
    private TableView<Sales> tableView;
    @FXML
    private TableColumn<Sales, Integer> id;
    @FXML
    private TableColumn<Sales, String> region;
    @FXML
    private TableColumn<Sales, String> client;
    @FXML
    private TableColumn<Sales, String> vendor;
    @FXML
    private TableColumn<Sales, Float> value;
    @FXML
    private TableColumn<Sales, Integer> quantity;

    private final ObservableList<Sales> sales = FXCollections.observableArrayList();
    private final SortedList<Sales> sortedSales = new SortedList<>(sales);


    @FXML
    public void initialize() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        region.setCellValueFactory(new PropertyValueFactory<>("region"));
        client.setCellValueFactory(new PropertyValueFactory<>("client"));
        vendor.setCellValueFactory(new PropertyValueFactory<>("vendor"));
        value.setCellValueFactory(new PropertyValueFactory<>("value"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        sortedSales.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedSales);

        addSales();
    }

    @FXML
    protected void onGraphButtonClick() {
        HelloApplication.openMain();
    }

    private void addSales() {
        try {
            DatabaseConnector dbConnector = new DatabaseConnector();
            Connection connection = dbConnector.connect();


            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");
            while (resultSet.next()) {
                sales.add(new Sales(
                        resultSet.getInt("id_order"),
                        resultSet.getString("regio"),
                        resultSet.getString("client_name"),
                        resultSet.getString("id_vendor"),
                        resultSet.getFloat("value"),
                        resultSet.getInt("quantity")
                        ));
            }

        } catch (SQLException e) { e.printStackTrace();
        }
    }

}
