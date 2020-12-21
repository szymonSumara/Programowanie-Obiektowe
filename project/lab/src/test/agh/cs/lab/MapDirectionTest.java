package agh.cs.lab;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    @Test
    public void nextTest(){
        assertEquals(MapDirection.NORTHEAST,MapDirection.NORTH.next());
        assertEquals(MapDirection.NORTHWEST,MapDirection.WEST.next());
        assertEquals(MapDirection.SOUTHWEST,MapDirection.SOUTH.next());
        assertEquals(MapDirection.SOUTHEAST,MapDirection.EAST.next());
        assertEquals(MapDirection.NORTH,MapDirection.NORTHWEST.next());
    }

    @Test
    public void previousTest(){
        assertEquals(MapDirection.NORTHWEST,MapDirection.NORTH.previous());
        assertEquals(MapDirection.SOUTHWEST,MapDirection.WEST.previous());
        assertEquals(MapDirection.SOUTHEAST,MapDirection.SOUTH.previous());
        assertEquals(MapDirection.NORTHEAST,MapDirection.EAST.previous());
        assertEquals(MapDirection.WEST,MapDirection.NORTHWEST.previous());
    }

    @Test
    public void rotateTest(){
        assertEquals(MapDirection.NORTHEAST,MapDirection.NORTH.rotate(1));
        assertEquals(MapDirection.EAST,MapDirection.WEST.rotate(4));
        assertEquals(MapDirection.NORTH,MapDirection.SOUTH.rotate(4));
        assertEquals(MapDirection.SOUTHEAST,MapDirection.NORTHWEST.rotate(4));
    }

}
