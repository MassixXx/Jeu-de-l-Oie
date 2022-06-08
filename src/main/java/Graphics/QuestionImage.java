package Graphics;

import Kernel.Cases.Case;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class QuestionImage extends StackPane {

    private String question;
    private String[] answers;


    public QuestionImage(String quest,String[] ans){
        super();

        question = quest;
        answers = ans;
        double w = 500.0f,h = 100.0f;
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
        double imgSize = 50.0;
        etiqu.setFitWidth(imgSize);
        etiqu.setFitWidth(imgSize);
        AnchorPane.setTopAnchor(etiqu,- imgSize / 2);

        VBox vBox = new VBox();


    }

}
