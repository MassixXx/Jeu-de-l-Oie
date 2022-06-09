package com.example.goose;

import Graphics.PartieG;
import Kernel.Partie;
import Kernel.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @FXML
    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
//        getNom(event);

        FXMLLoader entrezVotreNomParent  = FXMLLoader.load(getClass().getResource("menu.fxml"));
//        entrezVotreNomParent.getController();
        Scene entrezVotreNomScene = new Scene(entrezVotreNomParent.load());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(entrezVotreNomScene);
        window.show();

    }

    @FXML
    public void onNouvellePartie(ActionEvent event)throws IOException{
        Partie partie = new Partie(new User(userName));
        PartieG pg = new PartieG(partie);
        Scene scene = new Scene(pg);
        pg.setSc(scene);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void onChargerPartie(ActionEvent event)throws IOException{

    }

    @FXML
    public void onMeilleursScores(ActionEvent event)throws IOException{

    }
}
