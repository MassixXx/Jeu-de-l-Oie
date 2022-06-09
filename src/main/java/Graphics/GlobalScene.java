package Graphics;

import javafx.scene.Scene;

public class GlobalScene {
    static Scene gScene;

    public static void setScene(Scene s) {
        gScene = s;
    }

    public static Scene getgScene() {
        return gScene;
    }
}
