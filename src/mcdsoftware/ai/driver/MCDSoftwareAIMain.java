package mcdsoftware.ai.driver;

import mcdsoftware.ai.configuration.MCDSoftwareConfigManager;
import mcdsoftware.ai.utils.Util;

/**
 * Created by Tyler on 29/11/2014.
 */
public class MCDSoftwareAIMain {

    public static void main(String[] args){
        Util.logMessage(0, "Starting MCDSoftwareConfigManager...");
        new MCDSoftwareConfigManager("test.conf");
        Util.logMessage(0, "Finished MCFSoftwareConfigManager!");
    }
}
