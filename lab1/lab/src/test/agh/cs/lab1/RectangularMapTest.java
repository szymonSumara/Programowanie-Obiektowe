package agh.cs.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RectangularMapTest {

    @Test
    public void canMoveToTest(){
        RectangularMap  map = new  RectangularMap(4,4);
        assertTrue(map.canMoveTo(new Vector2d(4,4)));
        assertTrue(map.canMoveTo(new Vector2d(0,4)));
        assertTrue(map.canMoveTo(new Vector2d(4,0)));
        assertTrue(map.canMoveTo(new Vector2d(0,0)));
        assertTrue(!map.canMoveTo(new Vector2d(-1,5)));
        assertTrue(map.canMoveTo(new Vector2d(3,3)));



    }
}
