package Graphics;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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

public class QuestionQuiz extends StackPane {


    private String question;
    private CaseField cf;
    private Scene scene;
    private String answer;
    private PartieG pg;

    public void setSc(){
        scene = pg.getSc();
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().isLetterKey()) {
                cf.addLetter(event.getText().charAt(0));
                event.consume();
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
            if (ev.getCode() == KeyCode.ENTER) {
                boolean val = cf.validate(answer);
                ev.consume();
                Delayer.delay(750,()->{
                    pg.closeQuestion();
                    if(val) {
                        pg.getPartie().addScore(40);
                        pg.getPartie().getPlateau().avancer(4);
                    }
                    else {
                        pg.getPartie().subScore(20);
                        pg.getPartie().getPlateau().reculer(4);
                    }
                    pg.getPlateauG().setPawn();

                });
            }});

    }

    public QuestionQuiz(PartieG pg,String quest,String ans){
        super();
        cf = new CaseField(this,ans.length());
        this.pg = pg;
        question = quest;
        answer = ans;
        setSc();
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
            etiqu = new ImageView(new Image(new FileInputStream(QuestionImage.class.getResource("blueQ.png").getFile())));
        }catch (FileNotFoundException ex){
            System.out.println("Image bleueQ non trouvé");
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



        setFocusTraversable(true);
//        this.requestFocus();
//        this.setFocused(true);

        vBox.getChildren().addAll(qText,cf);

        this.getChildren().addAll(box,anchr,vBox);
    }
}