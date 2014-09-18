import java.util.Random;

public class GeneratorFaultDecorator implements RandomGenerator{
    private final FaultModeManager faultModeManager;
    private final RandomGenerator delegate;

    public GeneratorFaultDecorator(FaultModeManager faultModeManager, RandomGenerator delegate) {
        this.faultModeManager = faultModeManager;
        this.delegate = delegate;
    }


    @Override
    public int get() {
        if (faultModeManager.isEnabled()){
            return new Random().nextInt(1);
        }
        return delegate.get();
    }
}
