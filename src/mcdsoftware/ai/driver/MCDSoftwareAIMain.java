package mcdsoftware.ai.driver;

import mcdsoftware.ai.Marcus.Marcus;
import mcdsoftware.ai.utils.Util;

/**
 * Created by Tyler on 29/11/2014.
 */
public class MCDSoftwareAIMain {

    public static void main(String[] args) {
        new MCDSoftwareAIAPI();
        Util.logMessage(0, "Configuration Manager loaded Successfully.", true);
        Marcus marcus = new Marcus();
        Util.logMessage(0, "Initializing Marcus.", true);
        marcus.start();
    }
}
