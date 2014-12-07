package mcdsoftware.ai.memory;

import mcdsoftware.ai.Marcus.Marcus;
import mcdsoftware.ai.driver.MCDSoftwareAIAPI;
import mcdsoftware.ai.utils.Util;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Tyler on 06/12/2014.
 */
public class QuestionType {
    public static int questionTypeID = 0;
    private String questionTypeTitle;
    private QuestionType questionType;
    public static ConcurrentHashMap<QuestionType, Integer> questionTypeIDMap = new ConcurrentHashMap<QuestionType, Integer>();

    public QuestionType(String quesitonTypeTitle){
        questionType = this;
        questionTypeIDMap.put(questionType, questionTypeID++);
        Util.logMessage(0, "New Question Type...\nThis is question type number: " + questionTypeIDMap.size() + " ", true);
        MCDSoftwareAIAPI.getMarcus().marcusSay("Sorry, I have never heard this type of question before." +
                "\nCare to explain what it means");
        this.questionTypeTitle = quesitonTypeTitle;
    }
}
