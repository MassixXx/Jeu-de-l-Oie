package com.example.demo6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
        Parent entrezVotreNomParent  = FXMLLoader.load(getClass().getResource("entrez-votre-nom.fxml"));
        Scene entrezVotreNomScene = new Scene(entrezVotreNomParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(entrezVotreNomScene);
        window.show();


    }

}