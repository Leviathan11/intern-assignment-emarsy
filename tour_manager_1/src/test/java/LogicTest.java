/**
 * Created by leviathan on 2017.03.20..
 */
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LogicTest {
    private Tour testTour;

    @Before
    public void setup(){
        Location x = new Location("X");
        Location y = new Location("Y", x);
        Location u = new Location("U");
        Location z = new Location("Z", u);
        testTour = new Tour("Super Test Tour", Arrays.asList(x, y, z, u));
    }

    @Test
    public void exampleTest1(){
        Location x = new Location("X");
        testTour = new Tour("Super Test Tour", Arrays.asList(x));
        List<Location> returned = testTour.calculateSequence();
        assertEquals(1, returned.size());
        assertEquals(x, returned.get(0));
    }

    @Test
    public void exampleTest2(){
        Location x = new Location("X");
        Location y = new Location("Y");
        Location z = new Location("Z");
        testTour = new Tour("Super Test Tour", Arrays.asList(x, y, z));
        List<Location> returned = testTour.calculateSequence();
        assertEquals(3, returned.size());
        for (Location location: Arrays.asList(x, y, z)){
            assertTrue(returned.contains(location));
        }
    }

    @Test
    public void exampleTest3(){
        Location x = new Location("X");
        Location z = new Location("Z");
        Location y = new Location("Y", z);
        testTour = new Tour("Super Test Tour", Arrays.asList(x, y, z));
        List<Location> returned = testTour.calculateSequence();
        assertEquals(3, returned.size());
        for (Location location: Arrays.asList(x, y, z)){
            assertTrue(returned.contains(location));
        }
        assertTrue(returned.indexOf(y) > returned.indexOf(z));
    }

    @Test
    public void exampleTest4(){
        Location u = new Location("U");
        Location x = new Location("X", u);
        Location z = new Location("Z");
        Location w = new Location("W", z);
        Location v = new Location("V", w);
        Location y = new Location("Y", v);
        testTour = new Tour("Super Test Tour", Arrays.asList(u, v, w, x, y, z));
        List<Location> returned = testTour.calculateSequence();
        assertEquals(6, returned.size());
        for (Location location: Arrays.asList(u, v, w, x, y, z)){
            assertTrue(returned.contains(location));
        }
        assertTrue(returned.indexOf(v) > returned.indexOf(w));
        assertTrue(returned.indexOf(w) > returned.indexOf(z));
        assertTrue(returned.indexOf(x) > returned.indexOf(u));
        assertTrue(returned.indexOf(y) > returned.indexOf(v));
    }

    @Test
    public void emptyListTest(){
        testTour = new Tour("Super Test Tour", new ArrayList<Location>());
        assertEquals(0, testTour.calculateSequence().size());
    }

    @Test
    public void locationDependencyMissingTest(){
        Location u = new Location("U");
        Location x = new Location("X", u);
        Location z = new Location("Z");
        Location w = new Location("W", z);
        testTour = new Tour("Super Test Tour", Arrays.asList(u, w, x));
        List<Location> returned = testTour.calculateSequence();
        assertEquals(3, returned.size());
        for (Location location: Arrays.asList(u, w, x)){
            assertTrue(returned.contains(location));
        }
        assertTrue(returned.indexOf(x) > returned.indexOf(u));
    }
}
