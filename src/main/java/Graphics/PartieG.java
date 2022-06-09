package Graphics;

import Kernel.Cases.Case;
import Kernel.Notify;
import Kernel.Partie;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PartieG extends StackPane implements Notify {
    private Partie partie;
    private Scene scene;
    private PlateauGrid plateauG;
    private Dice de;
    private StackPane question;
    private Infos infos;

    public PartieG(Partie partie){
        super();
        partie.setListener(this);
        BorderPane bdp = new BorderPane();
        try {
         ImageView bg = new ImageView(new Image(new FileInputStream(PartieG.class.getResource("bg.jpg").getFile())));
            bg.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
            bg.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());

        this.partie = partie;
        this.plateauG = new PlateauGrid(partie.getPlateau(),this);
        this.de = new Dice(partie.getDice(),this);
        bdp.setCenter(plateauG);

        infos = new Infos("user's name");
            double margin = 20.0f;
//            HBox.setMargin(infos,new Insets(0,0,0,margin));

        HBox hb = new HBox();
        hb.getChildren().add(de);
        hb.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(de,new Insets(0,0,margin,margin));
        bdp.setBottom(hb);

        AnchorPane anchr = new AnchorPane();
        AnchorPane.setLeftAnchor(infos,-20.);
        AnchorPane.setTopAnchor(infos,0.);
        anchr.getChildren().add(infos);

        partie.setInfos(infos);

        this.getChildren().addAll(bg,anchr,bdp);

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
            System.out.println("Fichier bg.jpg introuvable");
        }

        setFocusTraversable(true);
    }
    public Infos getInfos(){return infos;};
    public void setEnabledPlateau(boolean val){
        plateauG.setEnabled(val);
    }

    public void setEnabledDice(boolean val){
        de.setEnabled(val);
    }

    public void closeQuestion(){
        getChildren().remove(question);
    }

    public void setSc(Scene s){scene = s;}
    public Scene getSc(){return scene;}

    @Override
    public void onQuizQues() {
        question = new QuestionQuiz(this,"Une question dvckjsndv?","dog");
        getChildren().add((QuestionQuiz) question);
    }

    @Override
    public void onImgQues() {
        String ans [] = {"bg.png","five.png","four.png","three.png"};
        question = new QuestionImage(this,"Une question dvckjsndv?",ans);
        getChildren().add((QuestionImage) question);
    }

    public Partie getPartie() {
        return partie;
    }

    public PlateauGrid getPlateauG() {
        return plateauG;
    }
}
