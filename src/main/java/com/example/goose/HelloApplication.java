package com.example.goose;

import Graphics.PlateauGrid;
import Kernel.Plateau;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import Kernel.LoginPage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Plateau plateau = new Plateau();

        PlateauGrid plateauGrid = new PlateauGrid(plateau);
        Scene scene = new Scene(plateauGrid, 500, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}