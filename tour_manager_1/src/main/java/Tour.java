import java.util.ArrayList;
import java.util.List;

/**
 * Created by leviathan on 2017.03.20..
 */
public class Tour {
    private String name;
    private List<Location> locations;
    private List<Location> locationSequence;

    public Tour(String name, List<Location> locations){
        this.name = name;
        this.locations = new ArrayList<Location>();
        for (Location location: locations){
            locations.add(location);
        }
    }

    public List<Location> calculateSequence(){
        return null;
    }
}
