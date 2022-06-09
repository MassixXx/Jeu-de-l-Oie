package Graphics;

import Kernel.Cases.Case;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageButton extends StackPane {
    private QuestionImage questionImage;

    public ImageButton(QuestionImage qi,String imgPath,double size,boolean val){
        super();
        questionImage = qi;
        try{
            ImageView img;
            img = new ImageView(new Image(new FileInputStream(ImageButton.class.getResource( imgPath).getFile())));

            Rectangle box = new Rectangle();
            box.setHeight(size + 10);
            box.setWidth(size + 10);
            box.setFill(Color.WHITE);
            box.setArcWidth(30.0);
            box.setArcHeight(30.0);

        ImageView finalImg = img;
        finalImg.setFitWidth(size);
        finalImg.setFitHeight(size);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("coucou");
                box.setFill((val)?Color.GREEN:Color.RED);
            Delayer.delay(750,()->qi.finish(val));
            }
        };
        finalImg.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        getChildren().addAll(box,finalImg);
        }catch (FileNotFoundException ex){
            System.out.println("Image introuvable : " + imgPath);
            ex.printStackTrace();
        }
    }



}
