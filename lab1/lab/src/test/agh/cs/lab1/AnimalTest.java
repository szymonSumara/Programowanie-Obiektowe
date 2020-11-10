package agh.cs.lab1;

import org.junit.jupiter.api.Test;
import sun.plugin.dom.css.Rect;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    @Test
    public void toStringTest(){
        IWorldMap map = new RectangularMap(4,4);
        Animal animal = new Animal(map, new Vector2d(2,2));

        assertEquals("^",animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals(">",animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("v",animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("<",animal.toString());
    }

    @Test
    public void orientationTest(){
        IWorldMap map = new RectangularMap(4,4);
        Animal animal = new Animal(map, new Vector2d(2,2));
        
        assertEquals("^",animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals(">",animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("v",animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("<",animal.toString());
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        assertEquals("^",animal.toString());

    }

    @Test
    public void borderTest(){
        IWorldMap map = new RectangularMap(4,4);
        Animal animal = new Animal(map, new Vector2d(2,2));

        for(int i=0;i<5;i++)
            animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4),animal.getPosition());
        animal.move(MoveDirection.RIGHT);

        for(int i=0;i<5;i++)
            animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4,4),animal.getPosition());
        animal.move(MoveDirection.RIGHT);

        for(int i=0;i<5;i++)
            animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4,0),animal.getPosition());
        animal.move(MoveDirection.RIGHT);

        for(int i=0;i<5;i++)
            animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(0,0),animal.getPosition());

    }




}
