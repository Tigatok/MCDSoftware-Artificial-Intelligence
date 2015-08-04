package mcdsoftware.ai.configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tyler on 29/11/2014.
 */
public class MCDSoftwareConfigManager {
    private List<String> configLines;
    private List<String> temp;
    public String marcusVersionNumber;
    public boolean debugMode;


    /*
    @TODO - Create a default loading config file if there is no file already created.
        Check to see if the file exists. If not, create_one() and populate() with defaults.
     */
    public MCDSoftwareConfigManager(String pathToConfigFile){
        configLines = new ArrayList<String>();
        temp = new ArrayList<String>();
        buildConfigFile(pathToConfigFile);
        marcusVersionNumber =  assignStringConfigurables("marcus-version");
        debugMode = assignBooleanConfigurables("debug-mode");
    }

    /**
     * Returns a list of strings which are each line of the config file.
     * If the line starts with a #, ignore that line.
     */
    public List<String> buildConfigFile(String pathToFile){
//        Util.logMessage(0, "Initializing buildConfigFile...");
        try {
            String currentLine;
            FileReader fileReader = new FileReader(pathToFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((currentLine = bufferedReader.readLine()) != null) {
                    temp.add(currentLine);
            }
            for(String s : temp) {
                if(s.length() > 0) {
                    if (!(s.substring(0, 1).equalsIgnoreCase("#"))) {
                        configLines.add(s);
                    }
                }
            }
            temp = null;
            fileReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return configLines;
    }

    /**
     * Go through all the meaningful lines in the config,
     * Grab the string between the colon(:) and the semi-colon (;).
     * Replace the single quotes with spaces.
     * Trim the remaining whitespace off the beginning of the command.
     * if the configValue is null, set it to "Not Set".
     * @param configName The name we want to grab the value for.
     * @return the value of the configurable.
     */
    public String assignStringConfigurables(String configName){
        String configValue = null;
        for(String s : configLines){
            if(s.substring(0, s.lastIndexOf(":")).equalsIgnoreCase(configName)){
                configValue = (s.substring(s.indexOf(" "), s.lastIndexOf(";"))).replace('\'', ' ');
                configValue = configValue.trim();
            }
        }
        if(configValue == null){
//            Util.logMessage(1, "ConfigValue for "+ configName + " is null and has not been set.");
            configValue = "Not Set";
        }
        return configValue;
    }
    public boolean assignBooleanConfigurables(String configName){
        String configValue = null;
        Boolean flag = false;
        for(String s : configLines){
            if(s.substring(0, s.lastIndexOf(":")).equalsIgnoreCase(configName)){
                configValue = (s.substring(s.indexOf(" "), s.lastIndexOf(";"))).replace('\'', ' ');
                configValue = configValue.trim();
                if(configValue.equalsIgnoreCase("true")){
                    flag=true;
                }
            }
        }
        if(configValue == null){
//            Util.logMessage(1, "ConfigValue for "+ configName + " is null and has not been set.");
            configValue = "Not Set";
        }
        return flag;
    }
}
