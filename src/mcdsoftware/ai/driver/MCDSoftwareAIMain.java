package mcdsoftware.ai.driver;

import mcdsoftware.ai.configuration.MCDSoftwareConfigManager;

/**
 * Created by Tyler on 29/11/2014.
 */
public class MCDSoftwareAIMain {

    public static void main(String[] args){
//        Util.logMessage(0, "Starting MCDSoftwareConfigManager...");
        new MCDSoftwareConfigManager("MarcusAI.conf");
//        Util.logMessage(0, "Finished MCFSoftwareConfigManager!");
    }
}
