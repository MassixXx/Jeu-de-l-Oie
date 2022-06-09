package com.example.goose;
import Kernel.SaveObjectFiles;
import Kernel.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class EntrezVotreNomController1 {

    @FXML
    private TextField nameIn;
    @FXML
    private  String chaine ;
    @FXML
    public  void getNom(ActionEvent event)
    {
        chaine = nameIn.getText();

       //chaine = (String) nameIn.getCharacters();
        System.out.println(chaine);
    }
    @FXML
    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
        getNom(event);
        User user = new User();
//        if (SaveObjectFiles.isInTextFile("le path",chaine)){
//
//        }
////            user.getFromFile(jeu);
//        else
//        {
//            user.setNom(chaine);
////            user.saveToFile();
//        }


        FXMLLoader entrezVotreNomParent  = new FXMLLoader(getClass().getResource("menu.fxml"));
        Scene entrezVotreNomScene = new Scene(entrezVotreNomParent.load());
        MenuController menuController = entrezVotreNomParent.getController();
        menuController.setUserName(chaine);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(entrezVotreNomScene);
        window.show();
    }

}
