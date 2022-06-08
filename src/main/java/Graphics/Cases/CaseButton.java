package Graphics.Cases;

import Graphics.Delayer;
import Graphics.PlateauGrid;
import Graphics.Tip;
import Kernel.Cases.Case;
import Kernel.Cases.CaseParcours;
import Kernel.Couleur;
import Kernel.NotTheRightCaseException;
import Kernel.Pawn;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class CaseButton extends StackPane{
    public CaseButton(Case casee,PlateauGrid pg) throws FileNotFoundException {
        super();
        this.plateauG = pg;
        current = false;
        tip = null;
        double size = 35.0f;
        this.casee = casee;
        Rectangle box = new Rectangle();
        box.setHeight(size);
        box.setWidth(size);
        box.setArcHeight(15.0f);
        box.setArcWidth(15.0f);
//        box.setStroke(Color.BLACK);
        box.setFill(colorConverter(casee.getCouleur()));
        ImageView img = new ImageView(new Image(new FileInputStream(Case.class.getResource(casee.getIconPath()).getFile())));
        img.setFitHeight(size);
        img.setFitWidth(size);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (plateauG.getEnabled()){
                    try {
                        casee.action();
                        plateauG.setPawn();
                        //On bloque le plateau
                        plateauG.setEnabled(false);
                        //On débloque le dé
                        plateauG.getPartieG().setEnabledDice(true);

                    } catch (NotTheRightCaseException ex) {
                        plateauG.showTip();
                    }
                }
            }
        };

        addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);

        super.getChildren().addAll(box,img);

        if (casee instanceof CaseParcours){
            super.getChildren().add(new Text(String.valueOf(casee.getNum()+1)));
        }
    };


    private Color colorConverter(Couleur color){
        Map<Couleur, Color> colorMap = Map.of(
                Couleur.Black,Color.BLACK,
                Couleur.Blue,Color.BLUE,
                Couleur.Green,Color.GREEN,
                Couleur.Orange,Color.ORANGE,
                Couleur.Pink,Color.PINK,
                Couleur.Yellow, Color.YELLOW,
                Couleur.Red,Color.RED,
                Couleur.White,Color.WHITE
        );
        return colorMap.get(color);
    }

    public void setCurrent(boolean val) {
        try {
            current = val;
            if (current) {
                pawn = new Pawn();
                getChildren().add(pawn);
            } else {
                getChildren().remove(pawn);
                pawn = null;
            }
        }
        catch (FileNotFoundException e){
        }
    }



    public void showTip(){
        try{
            tip = new Tip();
            getChildren().add(tip);
            plateauG.setEnabled(false);
            Delayer.delay(1000, () -> {
                getChildren().remove(tip);
                tip = null;
                plateauG.setEnabled(true);
            });
        }catch (FileNotFoundException e){}
    }


    private Case casee;
    private boolean current;
    private Pawn pawn;
    private Tip tip;
    private PlateauGrid plateauG;
}
