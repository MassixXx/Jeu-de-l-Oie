package Kernel;

import java.util.Random;

public class De {
    private int value;

    public void throwDie() {
        Random random = new Random();
        this.value = random.nextInt(6) + 1;
    }

    public int getValue() {
        return value;
    }
}
