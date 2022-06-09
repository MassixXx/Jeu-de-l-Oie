package Graphics;

import Kernel.Cases.Case;
import Kernel.NotTheRightCaseException;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CaseField extends HBox {

    private int nbCases;
    private int current;
    private String str;
    private QuestionQuiz qq;
    private ImageView backButton;
    private CaseText caseTexts[];
    public CaseField(QuestionQuiz qq,int nbCases){
        super();
        this.nbCases = nbCases;
        this.qq = qq;
        this.str = "";
        this.current = 0;
        this.caseTexts = new CaseText[nbCases];
        try{
            backButton = new ImageView(new Image(new FileInputStream(CaseField.class.getResource("back.png").getFile())));
        } catch (FileNotFoundException ex) {
            System.out.println("back.png not found.");
            ex.printStackTrace();
        }

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                popLetter();
            }
        };

        backButton.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);

        for (int i=0;i<nbCases;i++){
            caseTexts[i] = new CaseText(this);
            getChildren().add(caseTexts[i]);
        }
        getChildren().add(backButton);

        setAlignment(Pos.CENTER);
        setSpacing(40.0);

    }

    public void addLetter(char c){
        if (str.length() < nbCases){
            str += c;
            rebuild();
        }
    }

    public void popLetter(){
        if(!str.isEmpty()) {
            str = str.substring(0, str.length() - 1);
            rebuild();
        }
    }

    private void rebuild(){
        getChildren().clear();
        for (int i = 0;i < str.length();i++){
            caseTexts[i] = new CaseText(this,str.charAt(i));
            getChildren().add(caseTexts[i]);
        }
        for (int i=str.length();i<nbCases;i++){
            caseTexts[i] = new CaseText(this);
            getChildren().add(caseTexts[i]);
        }
        getChildren().add(backButton);
    }

    public boolean validate(String target) {
        boolean val = str.equalsIgnoreCase(target);
        for (int i = 0;i<nbCases;i++){
            caseTexts[i].animate(val);
        }
        Delayer.delay(750,()-> {
        });
        return val;
    }
}
