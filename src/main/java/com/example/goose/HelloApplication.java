package com.example.goose;

import Graphics.*;
import Kernel.Partie;
import Kernel.Plateau;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import Kernel.LoginPage;

import java.io.IOException;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Partie partie = new Partie(null);



        PartieG prt = new PartieG(partie);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                prt.requestFocus();
            }
        });
        String ans [] = {"bg.png","five.png","four.png","three.png"};
        Scene scene = new Scene(prt, 500, 400);
        prt.setSc(scene);
        GlobalScene.setScene(scene);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}
