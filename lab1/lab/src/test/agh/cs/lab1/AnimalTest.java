package agh.cs.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    @Test
    public void toStringTest(){
        Animal animal = new Animal();
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
        Animal animal = new Animal();
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
        Animal animal = new Animal();

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
