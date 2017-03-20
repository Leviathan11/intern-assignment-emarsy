/**
 * Created by leviathan on 2017.03.20..
 */

import java.util.ArrayList;
import java.util.List;

public class Tour {
    private String name;
    private List<Location> locations;
    private List<Location> locationSequence;

    public Tour(String name, List<Location> locations){
        this.name = name;
        this.locations = new ArrayList<Location>();
        for (Location location: locations){
            this.locations.add(location);
        }
    }

    //method that creates the logically ordered list from the locations
    public List<Location> calculateSequence(){
        locationSequence = new ArrayList<Location>();
        for (Location location: locations){
            addToSequence(location);
            if (locationSequence.size() == locations.size()) { break; }
        }
        return locationSequence;
    }

    // recursive method for adding the dependencies if needed
    private void addToSequence(Location location){
        if (locationSequence.contains(location)) { return; }
        Location dependency = location.getCloserLocation();
        if (dependency != null && locations.contains(dependency)){
            addToSequence(dependency);
        }
        locationSequence.add(location);
    }
}
