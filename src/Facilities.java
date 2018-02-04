import java.util.TreeMap;

public class Facilities {
    private static TreeMap<String, String> facilities = new TreeMap<>();

    Facilities(){
        facilities.put("Casino", "0 Minutes");
        facilities.put("Cloud 9 Spa", "0 Minutes");
        facilities.put("Carnival Spa", "0 Minutes");
        facilities.put("Cherry On Top", "0 Minutes");
        facilities.put("Carnival Players Club", "0 Minutes");
        facilities.put("Havana Bar", "0 Minutes");
        facilities.put("Guy's Pig and Anchor", "0 Minutes");
        facilities.put("Red Frog Pub and Brewery", "0 Minutes");
        facilities.put("Alchemy Bar", "0 Minutes");
    }

    public String getWaitTime(String name){
        if (!facilities.containsKey(name))
            return "This is not a facility on Carnival";
        else return facilities.get(name);
    }
}
