/**
 * Created by leviathan on 2017.03.20..
 */
public class Location {
    private String name;
    private Location closerLocation;

    public Location(String name){
        this.name = name;
    }

    public Location(String name, Location closerLocation) {
        this.name = name;
        this.closerLocation = closerLocation;
    }
}
