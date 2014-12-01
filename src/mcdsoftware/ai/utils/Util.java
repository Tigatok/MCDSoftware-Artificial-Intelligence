package mcdsoftware.ai.utils;

import mcdsoftware.ai.driver.MCDSoftwareAIAPI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Tyler on 29/11/2014.
 */
public class Util {

    /**
     * @param severeness   Depending on the severity of the log, display with a different pre-fix.
     * @param messageToLog The message we want to display in the Log file.
     * @return
     */
    public static void logMessage(int severeness, String messageToLog, boolean display) {
        Date now = new Date();
        String prefix = now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds() + " " + "[Marcus-" + MCDSoftwareAIAPI.getConfigManager().getMarcusVersionNumber() + "]";
        if (severeness == 0) {
            prefix = prefix.concat(" Level: Warning, Message: ");
        } else if (severeness > 0) {
            prefix = prefix.concat(" Level: Low, Message: ");
        } else if (severeness >= 1) {
            prefix = prefix.concat(" Level: Med, Message: ");
        } else if (severeness >= 2) {
            prefix = prefix.concat(" Level: High, Message: ");
        } else if (severeness >= 3) {
            prefix = prefix.concat(" Level: Urgent, Message: ");
        }
        if (display) {
            if (severeness <= 1) {
                System.out.println(prefix + " " + messageToLog);
            } else {
                System.err.println(prefix + " " + messageToLog);
            }
        }
        writeToLogFile(prefix + messageToLog, now);
    }

    private static void writeToLogFile(String messageToLog, Date now) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Logs\\MarcusLog_" + now.getDay() + now.getMonth() + now.getYear(), true));
            bufferedWriter.write(messageToLog);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
