package mcdsoftware.ai.memory;

import mcdsoftware.ai.Marcus.Marcus;
import mcdsoftware.ai.driver.MCDSoftwareAIAPI;
import mcdsoftware.ai.utils.Util;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Tyler on 06/12/2014.
 */
public class Memory {
    private int questionCounter;
    public static ConcurrentHashMap<String, QuestionType> questionTypeMemory = new ConcurrentHashMap<String, QuestionType>();
//Question types are: Curiosity, wondering, general
    public Memory(){
        Util.logMessage(0, "Initializing Memory", true);
        questionCounter = 0;
    }

    public void addQuestion(String questionType){
        if(!QuestionType.questionTypeIDMap.contains(questionType)){
            QuestionType.questionTypeIDMap.put(new QuestionType(questionType), QuestionType.questionTypeID++);
        }
        if(questionCounter >= 10){
            MCDSoftwareAIAPI.getMarcus().marcusSay("Congratulations! You have asked me 10 questions.\nAchievement Get!");
            //Write achievement to the database.
        }
        this.questionCounter++;
        Util.logMessage(0, "Question Asked...", true);
        Util.logMessage(0, "Questions Asked in Total: "+questionCounter, true);
    }

    public String[] getQuestionPieces(String questionToParse){
        return questionToParse.split(" ");
    }

    public void parseQuestion(String[] questionPieces){
        //What is your name?
        //Where questionPieces is the english length. What is you = 3.
        if(questionPieces.length > 1) {
            if (questionPieces[0].equalsIgnoreCase("what")) {
                if(questionPieces.length >= 2) {
                    String questionAdditionWord = questionPieces[1];
                    if (questionAdditionWord.equalsIgnoreCase("is")) {
                        Util.logMessage(0, "Curiosity Question", true);
                        questionTypeMemory.put("Curiosity", new QuestionType("Curiosty"));
                    } else if (questionAdditionWord.equalsIgnoreCase("are")) {

                    } else if (questionAdditionWord.equalsIgnoreCase("am")) {

                    } else if (questionAdditionWord.equalsIgnoreCase("do")) {

                    } else if (questionAdditionWord.equalsIgnoreCase("has")) {

                    } else {
                        //do logic here for words that we are going to be adding to the db already.
                    }
                }
            }
        } else {
            MCDSoftwareAIAPI.getMarcus().marcusSay("I am sorry, did you forget to finish the question?");
            Util.logMessage(1, "Listening for user input. Possible error here.", true);
            if(!MCDSoftwareAIAPI.getMarcus().scannerInput.nextLine().startsWith("n") || !MCDSoftwareAIAPI.getMarcus().scannerInput.nextLine().startsWith("N")){
                Util.logMessage(1, "User error, we are safe.", true);
                MCDSoftwareAIAPI.getMarcus().marcusSay("Please re-enter your question.");
            }
        }
    }
}
