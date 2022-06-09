package Graphics;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class CaseText extends StackPane {

    private Rectangle box;
    public CaseText(CaseField cf){
        super();
        this.box = new Rectangle();
        System.out.println(Screen.getPrimary().getBounds());
        double size = 50.0;
        box.setWidth(size);
        box.setHeight(size);
        box.setFill(Color.YELLOW);
        getChildren().add(box);
    }

    public CaseText(CaseField cf,char c){
        super();
        this.box = new Rectangle();
        double size = 50.0;
        box.setWidth(size);
        box.setHeight(size);
        box.setStroke(Color.BLACK);
        box.setFill(Color.YELLOW);
        Text ch = new Text(String.valueOf(c));
        System.out.println(c);
        ch.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        getChildren().addAll(box,ch);
    }

    public void animate(boolean val){
        box.setStroke((val)? Color.GREEN:Color.RED);
    }
}
