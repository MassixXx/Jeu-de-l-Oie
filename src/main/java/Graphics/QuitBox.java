package Graphics;

import Kernel.NotTheRightCaseException;
import Kernel.SaveObjectFiles;
import com.example.goose.MenuController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class QuitBox extends StackPane {

    private PartieG pg;

    public QuitBox(PartieG pg){
        this.pg = pg;
        Rectangle box = new Rectangle();
        box.setFill(Color.WHITE);
        double w = 500.0f,h = 300.0f;
        box.setWidth(w);
        box.setHeight(h);

        Rectangle buttonQuit = new Rectangle();
        buttonQuit.setFill(Color.GREEN);
        buttonQuit.setWidth(75);
        buttonQuit.setHeight(150);
        StackPane bq = new StackPane();
        Text txt = new Text("Quitter");
        txt.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        bq.getChildren().addAll(buttonQuit,txt);
        bq.setMaxHeight(150);
        bq.setMaxWidth(75);
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //TODO:  save
                pg.getPartie().addPartie();
                pg.getPartie().save();
                //quit
                FXMLLoader entrezVotreNomParent  = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
                Scene entrezVotreNomScene = null;
                try {
                    entrezVotreNomScene = new Scene(entrezVotreNomParent.load());
                } catch (IOException e) {
                    System.out.println("File main.fxml not found");
                    e.printStackTrace();
                }
                MenuController menuController = entrezVotreNomParent.getController();
                menuController.setUserName(pg.getPartie().getUserName());
                Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
                window.setScene(entrezVotreNomScene);
                window.show();
            }
        };
        bq.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
        bq.setAlignment(Pos.CENTER);

        Rectangle close = new Rectangle();
        buttonQuit.setFill(Color.RED);
        buttonQuit.setWidth(150);
        buttonQuit.setHeight(75);
        StackPane bqc = new StackPane();
        Text txtC = new Text("Fermer");
        txtC.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        bqc.getChildren().addAll(close,txtC);
        bqc.setMaxHeight(75);
        bqc.setMaxHeight(150);
        bqc.setAlignment(Pos.CENTER);

        box.setEffect(new DropShadow(60,Color.BLACK));
        EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pg.closePop();
            }
        };
    bqc.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler2);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(bq,bqc);
        hBox.setSpacing(50.);
        hBox.setAlignment(Pos.CENTER);


        getChildren().addAll(box,hBox);


    }
}
