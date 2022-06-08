package Graphics;

import Kernel.Cases.Case;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageButton extends Group {
    private QuestionImage questionImage;

    public ImageButton(QuestionImage qi,String imgPath,double size,boolean val){
        super();
        questionImage = qi;
        ImageView img = null;
        try{
            img = new ImageView(new Image(new FileInputStream(ImageButton.class.getResource("images/" + imgPath).getFile())));
        }catch (FileNotFoundException ex){
            System.out.println("Image introuvable : " + imgPath);
            ex.printStackTrace();
        }

        ImageView finalImg = img;
        finalImg.setFitWidth(size);
        finalImg.setFitHeight(size);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                finalImg.setStyle("-fx-border-style: solid;\n" +
                        "-fx-border-color: "
                         + ((val)?"red;\n":"green;") +
                        "-fx-border-width: 5;\n");
            Delayer.delay(3000,()->onClicked());
            }
        };
        finalImg.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        getChildren().addAll(finalImg);
    }

    private void onClicked(){

    }

}
