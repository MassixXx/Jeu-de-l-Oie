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
    private StackPane pop;
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

    public void closePop(){
        getChildren().remove(pop);
    }

    public void setSc(Scene s){scene = s;}
    public Scene getSc(){return scene;}

    @Override
    public void onQuizQues() {
        pop = new QuestionQuiz(this,"Comment appelle-t-on un chien en anglais?","dog");
        getChildren().add((QuestionQuiz) pop);
    }

    @Override
    public void onImgQues() {
        String ans [] = {"cat.jpg","dog.jpg","fox.jpg","mouse.jpg"};
        pop = new QuestionImage(this,"Where is the cat?",ans);
        getChildren().add((QuestionImage) pop);
    }

    @Override
    public void onFinal() {
        pop = new FinalBox(getPartie().getScore());
        getChildren().add(pop);
    }

    public Partie getPartie() {
        return partie;
    }

    public PlateauGrid getPlateauG() {
        return plateauG;
    }
}
