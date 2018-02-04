import sun.security.provider.Sun;

import java.util.TreeMap;

public class Events {
    private static TreeMap<String, String> SunEvents = new TreeMap<String, String>();
    private static TreeMap<String, String> MonEvents = new TreeMap<String, String>();
    private static TreeMap<String, String> TueEvents = new TreeMap<String, String>();
    private static TreeMap<String, String> WedEvents = new TreeMap<String, String>();
    private static TreeMap<String, String> ThurEvents = new TreeMap<String, String>();
    private static TreeMap<String, String> FriEvents = new TreeMap<String, String>();
    private static TreeMap<String, String> SatEvents = new TreeMap<String, String>();

    public Events(String day){
        SunEvents.put("Green Eggs and Ham Breakfast", "9 AM");
        SunEvents.put("Trivia", "4 PM");
        SunEvents.put("DJ Irie", "8 PM");
        MonEvents.put("Camp Ocean", "11 AM");
        MonEvents.put("Stage Show", "6 PM");
        TueEvents.put("Camp Ocean", "11 AM");
        TueEvents.put("Bingo", "4 PM");
        WedEvents.put("Camp Ocean", "11 AM");
        WedEvents.put("Stage Show", "6 PM");
        ThurEvents.put("Hasbro Show", "3 PM");
        ThurEvents.put("Dodge ball", "4 PM");
        ThurEvents.put("Main Deck Party", "8 PM");
        FriEvents.put("Sky Ride", "12 PM");
        FriEvents.put("Salsa Class", "4 PM");
        FriEvents.put("Carnival LIVE", "8 PM");
        SatEvents.put("Yoga", "10 AM");
        SatEvents.put("Clue: Murder Mystery", "4 PM");
        SatEvents.put("Lip Sync Battle", "8 PM");
    }

    public void setEvent(TreeMap map, String name, String time){
        map.put(name, time);
    }

    public String getEvent(TreeMap map, String name){
        if(!map.containsKey(name))
            return "Event does not exist";
        else{
            return map.get(name).toString();
        }
    }
}
