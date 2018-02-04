
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
    private static final ArrayList<Meal> order = new ArrayList<>();

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

        } else if ("Menu".equals(intentName)) {
            String output = "Okay, which category would you like, " +
                    "salads <break time=\"0.2s\" />" +
                    "meals <break time=\"0.2s\" />" +
                    "sides <break time=\"0.2s\" />" +
                    "drinks <break time=\"0.2s\" />" +
                    "beers <break time=\"0.2s\" />" +
                    " or desserts <break time=\"0.2s\" />";

            String reprompt = "Please choose a category " +
                    "salads <break time=\"0.2s\" />" +
                    "meals <break time=\"0.2s\" />" +
                    "sides <break time=\"0.2s\" />" +
                    "drinks <break time=\"0.2s\" />" +
                    "beers <break time=\"0.2s\" />" +
                    " or desserts <break time=\"0.2s\" />";

            return newAskResponse("<speak>" + output + "</speak>", true, "<speak>" + reprompt + "</speak>", true);
        } else if ("MenuCategory".equals(intentName)) {
            return getItemsFromMenuCategory(intent, session);
        } else if ("DontHearMore".equals(intentName)) {
            PlainTextOutputSpeech output = new PlainTextOutputSpeech();
            output.setText("Ok");
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
                "Welcome to Carnival Cruises. To hear the menu just say "
                        + "what's the menu. For ordering a menu item just say something like order chicken tenders.";
        String repromptText =
                "You can hear the menu by saying what's the menu or order an item by saying something like order chicken tenders";

        return newAskResponse(speechText, false, repromptText, false);
    }

    /**
     * Wrapper for creating the Ask response from the input strings.
     *
     * @param stringOutput   the output to be spoken
     * @param isOutputSsml   whether the output text is of type SSML
     * @param repromptText   the reprompt for if the user doesn't reply or is misunderstood.
     * @param isRepromptSsml whether the reprompt text is of type SSML
     * @return SpeechletResponse the speechlet response
     */
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
        Meal menuItem = getMenuItem(intent.getSlot("Items"));
        StringBuilder speechOutput = new StringBuilder();
        StringBuilder repromptText = new StringBuilder();
        if (menuItem != null) {
            total += menuItem.price;
            order.add(menuItem);
            session.setAttribute("total", total);
            session.setAttribute("order", order);
            speechOutput.append("Adding " + menuItem.name + ", would you like order another item?");
            repromptText.append("Added " + menuItem.name + ", would you like order another item?");
            return newAskResponse(speechOutput.toString(), false, repromptText.toString(), false);
        } else {
            PlainTextOutputSpeech output = new PlainTextOutputSpeech();
            output.setText("That food item is not on the menu");
            return SpeechletResponse.newTellResponse(output);
        }
    }

    private SpeechletResponse getItemsFromMenuCategory(final Intent intent, final Session session) {
        Slot categorySlot = intent.getSlot("Category");
        StringBuilder speechOutput = new StringBuilder();
        StringBuilder repromptText = new StringBuilder();
        String lookupCategory = getCategory(categorySlot);
        if (lookupCategory != null) {
            speechOutput.append("Here are the " + lookupCategory + " <break time=\"0.2s\" />");
            repromptText.append("Here are the " + lookupCategory + " again, <break time=\"0.2s\" />");
            Menu menu = new Menu(1);
            for (Meal meal : new ArrayList<Meal>(menu.menu.get(lookupCategory).values())) {
                speechOutput.append(meal.name + "<break time=\"0.2s\" />");
                repromptText.append(meal.name + "<break time=\"0.2s\" />");
            }
            return newAskResponse("<speak>" + speechOutput.toString() + "</speak>", true, "<speak>" + repromptText.toString() + "</speak>", true);
        } else {

            // The category didn't match one of our predefined categories. Reprompt the user.
            speechOutput.append("I'm not sure what the category is, please try again");
            repromptText.append(
                    "I'm not sure what the category is, you can say " +
                            "salads <break time=\"0.2s\" />" +
                            "meals <break time=\"0.2s\" />" +
                            "sides <break time=\"0.2s\" />" +
                            "drinks <break time=\"0.2s\" />" +
                            "beers <break time=\"0.2s\" />" +
                            " or desserts <break time=\"0.2s\" />");
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

    private Meal getMenuItem(Slot slot) {
        Meal meal = null;
        int time = 1;

        Menu menu = new Menu(time);
        if (slot != null && slot.getValue() != null) {
            // Lower case the incoming slot and remove spaces
            String category =
                    slot.getValue().toLowerCase();
            for (TreeMap<String, Meal> item : new ArrayList<>(menu.menu.values())) {
                if (item.containsKey(category)) {
                    meal = item.get(category);
                    break;
                }
            }


        }
        return meal;

    }
}
