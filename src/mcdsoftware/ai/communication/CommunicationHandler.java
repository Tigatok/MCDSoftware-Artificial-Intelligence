package mcdsoftware.ai.communication;

import mcdsoftware.ai.utils.MarcusDictionary;

/**
 * Created by Tyler on 27/11/2014.
 */
public class CommunicationHandler {
    public MarcusDictionary marcusDictionary;
    private String temporaryString;

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
                marcusDictionary = new MarcusDictionary();
                if(isQuestion(instruction)){

                }
    }

    public char getLastCharacter(String word){
        return word.charAt(word.length() -1 );
    }
    public String firstWord(String sentence){
        return sentence.substring(0, sentence.indexOf(" "));
    }

    public boolean isQuestion(String question){
        if(getLastCharacter(question) == '?' || marcusDictionary.questionDictionary.containsKey(question)){
            System.out.println("Is a question");
            return true;
        }
        return false;
    }
}
