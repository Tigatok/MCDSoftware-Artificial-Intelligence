package mcdsoftware.ai.driver;

import mcdsoftware.ai.configuration.MCDSoftwareConfigManager;

/**
 * Created by Tyler on 29/11/2014.
 */
public class MCDSoftwareAIAPI {
    static MCDSoftwareConfigManager configManager;

    public static MCDSoftwareAIMain instance;
    public static MCDSoftwareConfigManager getConfigManager(){
        if(configManager == null){
            new MCDSoftwareConfigManager("MarcusAI.conf");
        }
        return configManager;
    }
}
