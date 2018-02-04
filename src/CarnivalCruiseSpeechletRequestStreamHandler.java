
import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.Set;

public class CarnivalCruiseSpeechletRequestStreamHandler extends
        SpeechletRequestStreamHandler {

    private static final Set<String> supportedApplicationIds;

    static {
        /*
         * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
         * Alexa Skill and put the relevant Application Ids in this Set.
         */
        supportedApplicationIds = new HashSet<String>();
        supportedApplicationIds.add("amzn1.ask.skill.2ad67246-d79c-4e32-ad72-3102fa2ad2ce");
    }

    public CarnivalCruiseSpeechletRequestStreamHandler() {
        super(new CarnivalCruiseSpeechlet(), supportedApplicationIds);
    }
}
