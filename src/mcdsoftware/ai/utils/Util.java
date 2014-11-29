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
        String prefix = "[Marcus-"+ MCDSoftwareAIAPI.getConfigManager().marcusVersionNumber +"";
        if(severeness == 0){
            prefix = prefix.concat(", Level: Warning]");
        }
        else if(severeness >0){
            prefix = prefix.concat(", Level: Low]");
        }
        else if(severeness >=1){
            prefix = prefix.concat(", Level: Med]");
        }
        else if(severeness >=2){
            prefix = prefix.concat(", Level: High]");
        }
        else if(severeness >=3){
            prefix = prefix.concat(", Level: Urgent]");
        }
        return prefix;
    }
}
