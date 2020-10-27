package agh.cs.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    @Test
    public void toStringTest(){
        Animal animal = new Animal();
        assertEquals("Animal position : (2,2) orientation: Północ",animal.toString());
        animal.move(MoveDirections.RIGHT);
        assertEquals("Animal position : (2,2) orientation: Wschód",animal.toString());
        animal.move(MoveDirections.FORWARD);
        assertEquals("Animal position : (3,2) orientation: Wschód",animal.toString());
        animal.move(MoveDirections.RIGHT);
        assertEquals("Animal position : (3,2) orientation: Południe",animal.toString());
    }

    @Test
    public void orientationTest(){
        Animal animal = new Animal();
        assertEquals("Animal position : (2,2) orientation: Północ",animal.toString());
        animal.move(MoveDirections.RIGHT);
        assertEquals("Animal position : (2,2) orientation: Wschód",animal.toString());
        animal.move(MoveDirections.RIGHT);
        assertEquals("Animal position : (2,2) orientation: Południe",animal.toString());
        animal.move(MoveDirections.RIGHT);
        assertEquals("Animal position : (2,2) orientation: Zachód",animal.toString());
        animal.move(MoveDirections.LEFT);
        animal.move(MoveDirections.LEFT);
        animal.move(MoveDirections.LEFT);
        assertEquals("Animal position : (2,2) orientation: Północ",animal.toString());

    }

    @Test
    public void borderTest(){
        Animal animal = new Animal();
        for(int i=0;i<5;i++)
            animal.move(MoveDirections.FORWARD);
        assertEquals("Animal position : (2,4) orientation: Północ",animal.toString());
        animal.move(MoveDirections.RIGHT);
        for(int i=0;i<5;i++)
            animal.move(MoveDirections.FORWARD);
        assertEquals("Animal position : (4,4) orientation: Wschód",animal.toString());
        animal.move(MoveDirections.RIGHT);
        for(int i=0;i<5;i++)
            animal.move(MoveDirections.FORWARD);
        assertEquals("Animal position : (4,0) orientation: Południe",animal.toString());
        animal.move(MoveDirections.RIGHT);
        for(int i=0;i<5;i++)
            animal.move(MoveDirections.FORWARD);
        assertEquals("Animal position : (0,0) orientation: Zachód",animal.toString());

    }




}
