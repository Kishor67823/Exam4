import java.util.concurrent.ThreadLocalRandom;

public class Die {
    private int numSides;
    private int value;

    public Die(int numSides, int value) {
        this.numSides = 6;
        this.value = 1;
    }

    public Die(int numSides) {
        this.numSides = numSides;
        this.value = 1;
    }

    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNumSides() {
        return numSides;
    }

    public int getValue() {
        return value;
    }

    public void roll() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, numSides + 1);
        this.value = randomNum;
    }

    @Override
    public String toString() {
        return "Numsides: " + numSides + " value: " + value;
    }
}

