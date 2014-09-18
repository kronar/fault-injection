import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator {
    private static final Random INSTANCE = new Random();

    @Override
    public int get() {
        return INSTANCE.nextInt(1000);
    }
}
