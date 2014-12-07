package mcdsoftware.ai.driver;

import mcdsoftware.ai.Marcus.Marcus;
import mcdsoftware.ai.configuration.MCDSoftwareConfigManager;
import mcdsoftware.ai.utils.MarcusDictionary;
import mcdsoftware.ai.utils.Util;

/**
 * Created by Tyler on 29/11/2014.
 */
public class MCDSoftwareAIAPI {
    static MCDSoftwareConfigManager configManager;
    static Marcus marcus;
    static MarcusDictionary marcusDictionary;

    public MCDSoftwareAIAPI() {
        initConfigManager();
    }

    public static MCDSoftwareAIMain instance;


    public static MCDSoftwareConfigManager getConfigManager() {
        if (configManager == null) {
            new MCDSoftwareConfigManager("MarcusAI.conf");
        }
        return configManager;
    }

    public void initConfigManager() {
        configManager = new MCDSoftwareConfigManager("MarcusAI.conf");
        Util.logMessage(0, "Init ConfigManager finished...", true);
    }

    public static Marcus getMarcus() {
        if (marcus == null) {
            marcus = new Marcus();
        }
        return marcus;
    }

    public static MarcusDictionary getMarcusDictionary(){
        if(marcusDictionary == null){
            marcusDictionary = new MarcusDictionary();
        }
        return marcusDictionary;
    }
}
