package mcdsoftware.ai.communication;

import mcdsoftware.ai.Marcus.Marcus;
import mcdsoftware.ai.driver.MCDSoftwareAIAPI;
import mcdsoftware.ai.utils.MarcusDictionary;
import mcdsoftware.ai.utils.Util;

/**
 * Created by Tyler on 27/11/2014.
 */
public class CommunicationHandler {
    public MarcusDictionary marcusDictionary;
    private String temporaryString;
    private Marcus marcus;

    /**
     * Todo - Tyler
     * Is this supposed to just be a listener?
     * Are we just going to do scanner.ins for all of this in a loop?
     * <p/>
     * <p/>
     * Todo - Answered
     * No, I thought we might create a class for every
     * instruction sent. If it was a valid instruction
     * we extract data from it.
     * <p/>
     * If it was an invalid instruction set it to null
     * and destroy the object.
     */
    public CommunicationHandler(String instruction) {
        marcus = MCDSoftwareAIAPI.getMarcus();
        marcusDictionary = MCDSoftwareAIAPI.getMarcusDictionary();
        if (isQuestion(instruction)) {
            MCDSoftwareAIAPI.getMemory().addQuestion(instruction);
            Util.logMessage(0, "Instruction is a question", true);
            String[] pieces = instruction.split(" ");
            if(pieces[0].equalsIgnoreCase("what") ||
                    pieces[0].equalsIgnoreCase("who") ||
                    pieces[0].equalsIgnoreCase("when") ||
                    pieces[0].equalsIgnoreCase("where") ||
                    pieces[0].equalsIgnoreCase("why") ||
                    pieces[0].equalsIgnoreCase("how")){
                Util.logMessage(0, "Starting addQuestion and parseQuestion", true);
                String[] questionParts = MCDSoftwareAIAPI.getMemory().getQuestionPieces(instruction);
                MCDSoftwareAIAPI.getMemory().parseQuestion(questionParts);
            }
        }
        if (instruction.toLowerCase().contains("hello")) {
            marcus.introduceMarcus();
        }
    }

    public char getLastCharacter(String word) {
        return word.charAt(word.length() - 1);
    }

    public String firstWord(String sentence) {
        return sentence.substring(0, sentence.indexOf(" "));
    }

    public boolean isQuestion(String question) {
        if (getLastCharacter(question) == '?' || marcusDictionary.questionDictionary.containsKey(question)) {
            return true;
        }
        return false;
    }
}
