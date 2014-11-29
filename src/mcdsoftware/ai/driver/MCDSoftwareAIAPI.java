package mcdsoftware.ai.driver;

import mcdsoftware.ai.configuration.MCDSoftwareConfigManager;

/**
 * Created by Tyler on 29/11/2014.
 */
public class MCDSoftwareAIAPI {
    static MCDSoftwareConfigManager configManager;

    public MCDSoftwareAIAPI(){
        initConfigManager();
    }

    public static MCDSoftwareAIMain instance;


    public static MCDSoftwareConfigManager getConfigManager(){
        if(configManager == null){
            new MCDSoftwareConfigManager("MarcusAI.conf");
        }
        return configManager;
    }

    public void initConfigManager(){
        configManager = new MCDSoftwareConfigManager("MarcusAI.conf");
    }
}
