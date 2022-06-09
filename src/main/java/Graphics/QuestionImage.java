package Graphics;

import Kernel.Cases.Case;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class QuestionImage extends StackPane {

    private String question;
    private String[] answers;
    private PartieG pg;

    public QuestionImage(PartieG pg,String quest,String[] ans){
        super();
        this.pg = pg;
        question = quest;
        answers = ans;
        double w = 500.0f,h = 300.0f;
        Rectangle box = new Rectangle();
        box.setHeight(h);
        box.setWidth(w);
        box.setFill(Color.WHITE);
        box.setEffect(new DropShadow(20,Color.BLACK));

        AnchorPane anchr = new AnchorPane();
        anchr.setMaxHeight(h);
        anchr.setMaxWidth(w);
        ImageView etiqu = null;
        try{
            etiqu = new ImageView(new Image(new FileInputStream(QuestionImage.class.getResource("redQ.png").getFile())));
        }catch (FileNotFoundException ex){
            System.out.println("Image redQ non trouvé");
            ex.printStackTrace();
        }
        double imgSize =70.0;
        etiqu.setFitWidth(imgSize);
        etiqu.setFitWidth(imgSize);
        AnchorPane.setTopAnchor(etiqu,- imgSize / 2);
        AnchorPane.setLeftAnchor(etiqu,w / 2 - imgSize / 2);
        anchr.getChildren().add(etiqu);

        VBox vBox = new VBox();
        vBox.setMaxHeight(h);
        vBox.setAlignment(Pos.CENTER);
//        vBox.setSpacing(50.0);

        Text qText = new Text(question);
        qText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        HBox ansPics = new HBox();
        ImageButton imgs [] = {new ImageButton(this,ans[0],imgSize,true),new ImageButton(this,ans[1],imgSize,false),new ImageButton(this,ans[2],imgSize,false),new ImageButton(this,ans[3],imgSize,false)};


        Random rnd = new Random();
        for (int i=0;i<20;i++){
            int i1 = rnd.nextInt(4);
            int i2 = rnd.nextInt(4);
            var temp =imgs[i1];
            imgs[i1] =imgs[i2];
            imgs[i2] = temp;
        }

        for (int i = 0;i<4;i++){
            ansPics.getChildren().add(imgs[i]);
        }
        ansPics.setSpacing(50.0);
        ansPics.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(qText,ansPics);

        this.getChildren().addAll(box,anchr,vBox);
    }

    public void finish(boolean val){
        pg.closePop();
        if(val) {
            pg.getPartie().addScore(40);
            pg.getInfos().addScore(40);
            pg.getPartie().getPlateau().avancer(4);
        }
        else {
            pg.getPartie().subScore(20);
            pg.getInfos().addScore(-20);
            pg.getPartie().getPlateau().reculer(4);
        }
        pg.getPlateauG().setPawn();
    };

}
