/**
 * Created by leviathan on 2017.03.20..
 */

import java.util.Arrays;

public class Main {
    //example4
    public static void main(String[] args) {
        Location u = new Location("U");
        Location x = new Location("X", u);
        Location z = new Location("Z");
        Location w = new Location("W", z);
        Location v = new Location("V", w);
        Location y = new Location("Y", v);
        Tour testTour = new Tour("Super Test Tour", Arrays.asList(u, v, w, x, y, z));
        for (Location location: testTour.calculateSequence()){
            System.out.printf(location.getName());
        }
    }
}
