package mcdsoftware.ai.configuration;

import mcdsoftware.ai.utils.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tyler on 29/11/2014.
 */
public class MCDSoftwareConfigManager {
    public String marcusVersionNumber;
    private List<String> configLines;
    private List<String> temp;

    public MCDSoftwareConfigManager(String pathToConfigFile){
        configLines = new ArrayList<String>();
        temp = new ArrayList<String>();
        buildConfigFile(pathToConfigFile);
    }

    /**
     * Returns a list of strings which are each line of the config file.
     * If the line starts with a #, ignore that line.
     */
    public List<String> buildConfigFile(String pathToFile){
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
            fileReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return configLines;
    }
}
