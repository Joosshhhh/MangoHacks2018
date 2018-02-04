
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.OutputSpeech;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SsmlOutputSpeech;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CarnivalCruiseSpeechlet implements SpeechletV2 {

    private double total = 0;

    private static final Map<String, String> menuCategories = new TreeMap<String, String>(
            String.CASE_INSENSITIVE_ORDER);

    @Override
    public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> speechletRequestEnvelope) {
        menuCategories.put("salads", "salads");
        menuCategories.put("meals", "meals");
        menuCategories.put("sides", "sides");
        menuCategories.put("drinks", "drinks");
        menuCategories.put("beers", "beers");
        menuCategories.put("desserts", "desserts");
    }

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> speechletRequestEnvelope) {
        return getWelcomeResponse();
    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> speechletRequestEnvelope) {
        IntentRequest request = speechletRequestEnvelope.getRequest();
        Session session = speechletRequestEnvelope.getSession();

        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;
        if ("Order".equals(intentName)) {
            return orderMeal(intent, session);

        } else if ("Alexa.Menu".equals(intentName)) {
            String output = "Okay, which category would you like, " +
                    "salads <break time=\\\"0.2s\\\" />" +
                    "meals <break time=\\\"0.2s\\\" />" +
                    "sides <break time=\\\"0.2s\\\" />" +
                    "drinks <break time=\\\"0.2s\\\" />" +
                    "beers <break time=\\\"0.2s\\\" />" +
                    "desserts <break time=\\\"0.2s\\\" />";

            String reprompt = "Please choose a category " +
                    "salads <break time=\\\"0.2s\\\" />" +
                    "meals <break time=\\\"0.2s\\\" />" +
                    "sides <break time=\\\"0.2s\\\" />" +
                    "drinks <break time=\\\"0.2s\\\" />" +
                    "beers <break time=\\\"0.2s\\\" />" +
                    "desserts <break time=\\\"0.2s\\\" />";

            return newAskResponse("<speak>" + output + "</speak>", true, reprompt, true);
        } else if ("MenuCategory".equals(intentName)) {
            return getItemsFromMenuCategory(intent, session);
        } else if ("DontHearMore".equals(intentName)) {
            PlainTextOutputSpeech output = new PlainTextOutputSpeech();
            output.setText("");
            return SpeechletResponse.newTellResponse(output);
        } else if ("AMAZON.StopIntent".equals(intentName)) {
            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText("Goodbye");
            return SpeechletResponse.newTellResponse(outputSpeech);
        } else if ("AMAZON.CancelIntent".equals(intentName)) {
            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText("Goodbye");
            return SpeechletResponse.newTellResponse(outputSpeech);
        } else {
            String errorSpeech = "This is unsupported. Please try something else.";
            return newAskResponse(errorSpeech, false, errorSpeech, false);
        }

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
                "Welcome to the Carnival. To hear the menu just say "
                        + "what's the menu. For ordering a menu item just say order chicken tenders.";
        String repromptText =
                "You can hear the menu by saying what's the menu or order a item by saying order chicken tenders";

        return newAskResponse(speechText, false, repromptText, false);
    }

    private SpeechletResponse newAskResponse(String stringOutput, boolean isOutputSsml,
                                             String repromptText, boolean isRepromptSsml) {
        OutputSpeech outputSpeech, repromptOutputSpeech;
        if (isOutputSsml) {
            outputSpeech = new SsmlOutputSpeech();
            ((SsmlOutputSpeech) outputSpeech).setSsml(stringOutput);
        } else {
            outputSpeech = new PlainTextOutputSpeech();
            ((PlainTextOutputSpeech) outputSpeech).setText(stringOutput);
        }

        if (isRepromptSsml) {
            repromptOutputSpeech = new SsmlOutputSpeech();
            ((SsmlOutputSpeech) repromptOutputSpeech).setSsml(repromptText);
        } else {
            repromptOutputSpeech = new PlainTextOutputSpeech();
            ((PlainTextOutputSpeech) repromptOutputSpeech).setText(repromptText);
        }
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptOutputSpeech);
        return SpeechletResponse.newAskResponse(outputSpeech, reprompt);
    }

    private SpeechletResponse orderMeal(final Intent intent, final Session session) {


        return newAskResponse("", false, "", false);
    }

    private SpeechletResponse getItemsFromMenuCategory(final Intent intent, final Session session) {
        Slot categorySlot = intent.getSlot("Category");
        StringBuilder speechOutput = new StringBuilder();
        StringBuilder repromptText = new StringBuilder();
        String lookupCategory = getCategory(categorySlot);
        if (lookupCategory != null) {
            speechOutput.append("Here are the " + lookupCategory + " ");
            repromptText.append("Here are the " + lookupCategory + " again, ");
            Menu menu = new Menu(1);
            for (Meal meal : new ArrayList<Meal>(menu.menu.get(lookupCategory).values())) {
                speechOutput.append(meal.name + "<break time=\\\"0.2s\\\" />");
                repromptText.append(meal.name + "<break time=\\\"0.2s\\\" />");
            }
            return newAskResponse("<speak>" + speechOutput.toString() + "</speak>", true, "<speak>" + repromptText + "</speak>", true);
        } else {

            // The category didn't match one of our predefined categories. Reprompt the user.
            speechOutput.append("I'm not sure what the category is, please try again");
            repromptText.append(
                    "I'm not sure what the category is, you can say " +
                            "salads <break time=\\\"0.2s\\\" />" +
                            "meals <break time=\\\"0.2s\\\" />" +
                            "sides <break time=\\\"0.2s\\\" />" +
                            "drinks <break time=\\\"0.2s\\\" />" +
                            "beers <break time=\\\"0.2s\\\" />" +
                            "desserts <break time=\\\"0.2s\\\" />");
            return newAskResponse(speechOutput.toString(), false, "<speak>" + repromptText.toString() + "</speak>", true);
        }

    }

    private String getCategory(Slot slot) {
        String lookupCategory = null;
        if (slot != null && slot.getValue() != null) {
            // Lower case the incoming slot and remove spaces
            String category =
                    slot
                            .getValue()
                            .toLowerCase()
                            .replaceAll("\\s", "")
                            .replaceAll("\\.", "")
                            .replaceAll("three", "3");
            lookupCategory = menuCategories.get(category);
        }
        return lookupCategory;
    }
}
