package agh.cs.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    public void isOccupiedTest(){
        RectangularMap  map = new  RectangularMap(7,5);
        new Animal(map,new Vector2d(6,4));
        new Animal(map,new Vector2d(3,0));
        assertTrue(map.isOccupied(new Vector2d(6,4)));
        assertFalse(map.isOccupied(new Vector2d(3,4)));
        assertFalse(map.isOccupied(new Vector2d(0,3)));
    }


    @Test
    public void canMoveToTest(){
        RectangularMap  map = new  RectangularMap(5,5);
        assertTrue(map.canMoveTo(new Vector2d(4,4)));
        assertTrue(map.canMoveTo(new Vector2d(0,4)));
        assertTrue(map.canMoveTo(new Vector2d(4,0)));
        assertTrue(map.canMoveTo(new Vector2d(0,0)));
        assertTrue(!map.canMoveTo(new Vector2d(-1,5)));
        assertTrue(map.canMoveTo(new Vector2d(3,3)));
    }


    @Test
    public void objectAtAndPlaceTest(){
        RectangularMap  map = new  RectangularMap(7,5);
        Animal animal1 = new Animal(map,new Vector2d(3,1));
        Animal animal2 = new Animal(map,new Vector2d(6,4));
        assertEquals(null,map.objectAt(new Vector2d(0,0)));
        assertEquals(animal1,map.objectAt(new Vector2d(3,1)));
        assertEquals(animal2,map.objectAt(new Vector2d(6,4)));

    }

}
