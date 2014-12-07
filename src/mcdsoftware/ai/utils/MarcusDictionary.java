package mcdsoftware.ai.utils;

/**
 * Created by Tyler on 30/11/2014.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * When you create a new instance of dictionary (can it be static?)
 * We need a group of words that we can reference.
 * if X is contained int he questionmark dictionary
 */
public class MarcusDictionary {
    public Map<String, Type> questionDictionary;

    public MarcusDictionary() {
        questionDictionary = new HashMap<String, Type>();
        initQuestionWords();
        Util.logMessage(0, "Question Words have been initialized.", false);
    }

    public void initQuestionWords() {
        questionDictionary.put("What", Type.QUESTION);
        questionDictionary.put("How", Type.QUESTION);
        questionDictionary.put("Who", Type.QUESTION);
        questionDictionary.put("Where", Type.QUESTION);
        questionDictionary.put("Why", Type.QUESTION);
        questionDictionary.put("When", Type.QUESTION);
    }
}
