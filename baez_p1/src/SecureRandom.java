import java.util.Random;

public class SecureRandom {
    private int num1;
    private int num2;

    public SecureRandom(int bound) {
        Random rand = new Random();
        num1 = rand.nextInt(bound);
        num2 = rand.nextInt(bound);
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public void addtoNum2() {
        this.num2 = this.num2 + 1;
    }

    public void reroll(int bound) {
        Random rand = new Random();
        num1 = rand.nextInt(bound);
        num2 = rand.nextInt(bound);
    }
}
