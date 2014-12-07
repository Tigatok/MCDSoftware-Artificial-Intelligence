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
        questionDictionary.put("what", Type.QUESTION);
        questionDictionary.put("how", Type.QUESTION);
        questionDictionary.put("who", Type.QUESTION);
        questionDictionary.put("where", Type.QUESTION);
        questionDictionary.put("why", Type.QUESTION);
        questionDictionary.put("when", Type.QUESTION);
    }
}
