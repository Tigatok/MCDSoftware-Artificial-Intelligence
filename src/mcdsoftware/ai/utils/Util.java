package mcdsoftware.ai.utils;

import mcdsoftware.ai.driver.MCDSoftwareAIAPI;

/**
 * Created by Tyler on 29/11/2014.
 */
public class Util {

    /**
     *
     * @param severeness Depending on the severity of the log, display with a different pre-fix.
     * @param messageToLog The message we want to display in the Log file.
     * @return
     */
    public static String logMessage(int severeness, String messageToLog){
        String prefix = "[Marcus V]"+ MCDSoftwareAIAPI.getConfigManager().marcusVersionNumber;


        return "";
    }
}
