package game;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationId;
    private final String description;
    private final Map<String,Integer> exits;

    public Location(int locationId, String description) {
        this.locationId = locationId;
        this.description = description;
        this.exits= new HashMap<>();
        exits.put("Q",0);
    }
    public void addExit(String description, int location){
        this.exits.put(description,location);

    }
    public void printall(){
        for(String key: exits.keySet()){
            System.out.println(exits.get(key));
        }
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
