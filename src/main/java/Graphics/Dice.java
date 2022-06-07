package Graphics;

import Kernel.De;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Dice extends StackPane {
    public Dice(De dice){
        de = dice;
        Rectangle box = new Rectangle();
        double size = 100.0f;
        box.setHeight(size);
        box.setWidth(size);
        box.setArcHeight(30.0f);
        box.setArcWidth(30.0f);

        box.setFill(Color.web("#a0a8af"));
        box.setStroke(Color.web("#545454"));
        box.setStrokeWidth(5.0f);

        this.diceG = new GridPane();
        diceG.add(getDiceimg(de.getValue1()),0,0);
        diceG.add(getDiceimg(de.getValue2()),1,1);

        diceG.setAlignment(Pos.CENTER);

        getChildren().addAll(box,diceG);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                rethrow();
            }
        };
        addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
    }


    private ImageView getDiceimg(int i){
        String dice;
        switch (i){
            case 1: dice = "one";
            break;
            case 2: dice = "two";
                break;
            case 3: dice = "three";
                break;
            case 4: dice = "four";
                break;
            case 5 : dice = "five";
                break;
            case 6 : dice = "six";
                break;
            default: dice = "";
            break;
        }
        try{
            ImageView imgD = new ImageView(new Image(new FileInputStream(Dice.class.getResource(dice + ".png").getFile())));
            double diceSize = 30.0f;
            imgD.setFitHeight(diceSize);
            imgD.setFitWidth(diceSize);
            return imgD;
        }catch (FileNotFoundException ex){
            System.out.println("Image de dé introuvable");
            ex.printStackTrace();
        }
        return null;
    }

    private void rethrow(){
        de.throwDice();
        int d1 = de.getValue1();
        int d2 = de.getValue2();

        diceG.getChildren().clear();

        diceG.add(getDiceimg(d1),0,0);
        diceG.add(getDiceimg(d2),1,1);

    }

    private GridPane diceG;
    private De de;
}
