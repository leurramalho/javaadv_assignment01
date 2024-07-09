package ca.georgian.chart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stage;
    private static Scene mainScene;
    private static Scene dataScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        stage.setTitle("Chart");

        Parent fxmMain = FXMLLoader.load(getClass().getResource("chart-view.fxml"));
        mainScene = new Scene(fxmMain);

        Parent fxmData = FXMLLoader.load(getClass().getResource("data-view.fxml"));
        dataScene = new Scene(fxmData);

        stage.setScene(mainScene);
        stage.show();
    }

    public static void openMain(){
        stage.setScene(mainScene);
    }
    public static void openData(){
        stage.setScene(dataScene);
    }

    public static void main(String[] args) {
        launch();
    }
}