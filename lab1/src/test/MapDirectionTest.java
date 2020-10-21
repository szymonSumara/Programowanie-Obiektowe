package test;   // test to nie pakiet, tylko folder; struktura pakietowa powinna być taka sama jak w main

import agh.cs.lab1.MapDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    @Test
    public void nextTest(){
        assertEquals(MapDirection.EAST,MapDirection.NORTH.next());
        assertEquals(MapDirection.NORTH,MapDirection.WEST.next());
        assertEquals(MapDirection.WEST,MapDirection.SOUTH.next());
        assertEquals(MapDirection.SOUTH,MapDirection.EAST.next());
    }

    @Test
    public void previousTest(){
        assertEquals(MapDirection.WEST,MapDirection.NORTH.previous());
        assertEquals(MapDirection.SOUTH,MapDirection.WEST.previous());
        assertEquals(MapDirection.EAST,MapDirection.SOUTH.previous());
        assertEquals(MapDirection.NORTH,MapDirection.EAST.previous());
    }

}
