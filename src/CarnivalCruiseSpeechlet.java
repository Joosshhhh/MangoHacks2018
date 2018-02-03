import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;

public class CarnivalCruiseSpeechlet implements SpeechletV2 {


    @Override
    public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> speechletRequestEnvelope) {

    }

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> speechletRequestEnvelope) {
        return null;
    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> speechletRequestEnvelope) {
        IntentRequest request = speechletRequestEnvelope.getRequest();
        Session session = speechletRequestEnvelope.getSession();

        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;
        if ("Order".equals(intentName)) {

        }

        return null;
    }

    @Override
    public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> speechletRequestEnvelope) {

    }

    /**
     * Creates and returns a {@code SpeechletResponse} with a welcome message.
     *
     * @return SpeechletResponse spoken and visual welcome message
     */
    private SpeechletResponse getWelcomeResponse() {
        // Create the welcome message.
        String speechText =
                "Welcome to the Carnival. Please tell me your favorite color by "
                        + "saying, my favorite color is red";
        String repromptText =
                "Please tell me your favorite color by saying, my favorite color is red";

        return getSpeechletResponse(speechText, repromptText, true);
    }

    /**
     * Returns a Speechlet response for a speech and reprompt text.
     */
    private SpeechletResponse newAskResponse(String stringOutput,
                                             String repromptText) {
        OutputSpeech outputSpeech, repromptOutputSpeech;
        outputSpeech = new PlainTextOutputSpeech();
        ((PlainTextOutputSpeech) outputSpeech).setText(stringOutput);

        repromptOutputSpeech = new PlainTextOutputSpeech();
        ((PlainTextOutputSpeech) repromptOutputSpeech).setText(repromptText);
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptOutputSpeech);
        return SpeechletResponse.newAskResponse(outputSpeech, reprompt);
    }
}
