package agh.cs.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void isOccupiedTest(){
        IWorldMap  map = new GrassField(10);
        new Animal(map,new Vector2d(6,4));
        new Animal(map,new Vector2d(3,0));
        assertTrue(map.isOccupied(new Vector2d(6,4)));
        assertTrue((!map.isOccupied(new Vector2d(3,4))) || (map.objectAt(new Vector2d(3,4)) instanceof Grass));
        assertTrue((!map.isOccupied(new Vector2d(0,3))) || (map.objectAt(new Vector2d(0,3)) instanceof Grass));
    }


    @Test
    public void canMoveToTest(){
        IWorldMap  map =  new GrassField(10);
        Animal animal = new Animal(map,new Vector2d(4,4));
        assertFalse(map.canMoveTo(new Vector2d(4,4)));
        assertTrue(map.canMoveTo(new Vector2d(0,4)));
        assertTrue(map.canMoveTo(new Vector2d(4,0)));
        assertTrue(map.canMoveTo(new Vector2d(0,0)));
        assertTrue(map.canMoveTo(new Vector2d(-1,5)));
        assertTrue(map.canMoveTo(new Vector2d(3,3)));
    }


    @Test
    public void objectAtAndPlaceTest(){
        IWorldMap  map = new GrassField(10);
        Animal animal1 = new Animal(map,new Vector2d(3,1));
        Animal animal2 = new Animal(map,new Vector2d(6,4));
        assertTrue(  map.objectAt(new Vector2d(0,0)) == null
                || map.objectAt(new Vector2d(0,0)) instanceof Grass);
        assertEquals(animal1,map.objectAt(new Vector2d(3,1)));
        assertEquals(animal2,map.objectAt(new Vector2d(6,4)));

    }

}
