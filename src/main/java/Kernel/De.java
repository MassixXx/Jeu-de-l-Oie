package Kernel;

import java.util.Random;

public class De {
    private int value1;
    private int value2;
    private Partie partie;
    public De(Partie partie){
        this.partie = partie;
        throwDice();
    }

    public void throwDice() {
        Random random = new Random();
        this.value1 = random.nextInt(6) + 1;
        this.value2 = random.nextInt(6) + 1;
    }

    public int getValue1() {
        return value1;
    }
    public int getValue2() {
        return value2;
    }
    public int getSum(){return value1 + value2;}

}
