package Graphics;

import Kernel.Cases.Case;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Infos extends StackPane {
    private String name;
    private int score;
    private int currentPos;
    public Infos(String name){
        this.name =name;
        score = 1000;
        currentPos = 1;
        build();

    }

    private void build(){
        try{
            ImageView shape = new ImageView(new Image(new FileInputStream(Infos.class.getResource("shape.png").getFile())));
            double h = 400.;
            double w = 300.0;
            shape.setFitHeight(h);
            shape.setFitWidth(w);
            VBox vBox = new VBox();
            vBox.setMaxHeight(h);
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(50.);

            Text nTxt = new Text(name);
            nTxt.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            Text scoreTxt = new Text("score : " + String.valueOf(score));
            scoreTxt.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            Text cpTxt = new Text("position : " + String.valueOf(currentPos) + " / 100");
            cpTxt.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            vBox.getChildren().addAll(nTxt,scoreTxt,cpTxt);

            getChildren().clear();
            getChildren().addAll(shape,vBox);
        }catch (FileNotFoundException ex) {
            System.out.println("shape.png introuvable");
            ex.printStackTrace();
        }
    }

    public void addScore(int s) {
        score += s;
        build();
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
        build();
    }
}
