package test;

import agh.cs.lab1.MapDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class MapDirectionTest {

    @Test
    public void nextTest(){
        boolean everythinkIsOk = true;
        System.out.println("______________________ \nMapDirection.next()  \n----------------------");
        if( MapDirection.NORTH.next() == MapDirection.WEST)
            System.out.println("NORTH.next() test ok");
        else{
            System.out.println("NORTH.next() test fali");
            everythinkIsOk = false;
        }

        if( MapDirection.WEST.next() == MapDirection.SOUTH)
            System.out.println("WEST.next() test ok");
        else{
            System.out.println("WEST.next() test fali");
            everythinkIsOk = false;
        }

        if( MapDirection.SOUTH.next() == MapDirection.EAST)
            System.out.println("SOUTH.next() test ok");
        else{
            System.out.println("SOUTH.next() test fali");
            everythinkIsOk = false;
        }

        if( MapDirection.EAST.next() == MapDirection.NORTH)
            System.out.println("EAST.next() test ok");
        else{
            System.out.println("EAST.next() test fali");
            everythinkIsOk = false;
        }

        if(!everythinkIsOk)
            fail();
        System.out.println("______________________");
    }

    @Test
    public void previousTest(){
        boolean everythinkIsOk = true;
        System.out.println("______________________ \nMapDirection.previous()  \n----------------------");
        if( MapDirection.NORTH.previous() == MapDirection.EAST)
            System.out.println("NORTH.previous() test ok");
        else{
            System.out.println("NORTH.previous() test fali");
            everythinkIsOk = false;
        }

        if( MapDirection.WEST.previous() == MapDirection.NORTH)
            System.out.println("WEST.previous() test ok");
        else{
            System.out.println("WEST.previous() test fali");
            everythinkIsOk = false;
        }

        if( MapDirection.SOUTH.previous() == MapDirection.WEST)
            System.out.println("SOUTH.previous() test ok");
        else{
            System.out.println("SOUTH.previous() test fali");
            everythinkIsOk = false;
        }

        if( MapDirection.EAST.previous() == MapDirection.SOUTH)
            System.out.println("EAST.previous() test ok");
        else{
            System.out.println("EAST.previous() test fali");
            everythinkIsOk = false;
        }

        if(!everythinkIsOk)
            fail();
        System.out.println("______________________");
    }

}
