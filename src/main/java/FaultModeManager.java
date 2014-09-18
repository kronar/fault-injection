import java.util.logging.Logger;

public class FaultModeManager {

    private boolean mode = false;
    private static final Logger LOGGER = Logger.getLogger(FaultModeManager.class.getName());


    public FaultModeManager() {
    }

    public boolean isEnabled(){
        return mode;
    }

    public void enable(){
        mode = true;
        LOGGER.info("Fault mode enabled");
    }

    public void disable(){
        mode = false;
        LOGGER.info("Fault mode disabled");
    }
}
