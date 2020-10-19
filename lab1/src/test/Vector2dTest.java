package test;
import agh.cs.lab1.Vector2d;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector2dTest {

    @Test
    public void equalsTest(){

        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(1,2);
        Vector2d vec3 = new Vector2d(4,3);
        Object vec4 = new Object();

        assertEquals(true,vec1.equals(vec2));
        assertEquals(false,vec2.equals(vec3));
        assertEquals(false,vec3.equals(vec4));

    }
    @Test
    public void toStringTest(){

        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(89,-10);
        Vector2d vec3 = new Vector2d(-123,0);
        Vector2d vec4 = new Vector2d(-9999,-9999);


        assertEquals("(1,2)",vec1.toString());
        assertEquals("(89,-10)",vec2.toString());
        assertEquals("(-123,0)",vec3.toString());
        assertEquals("(-9999,-9999)",vec4.toString());

    }

    @Test
    public void precedesTest(){

        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(7,8);
        Vector2d vec3 = new Vector2d(-1,10);
        Vector2d vec4 = new Vector2d(-20,8);
        Vector2d vec5 = new Vector2d(7,8);

        assertEquals(true,vec1.precedes(vec2));
        assertEquals(true,vec2.precedes(vec2));
        assertEquals(true,vec4.precedes(vec2));

        assertEquals(false,vec4.precedes(vec1));

    }


    @Test
    public void followTest(){
        Vector2d vec1 = new Vector2d(-1,3);
        Vector2d vec2 = new Vector2d(3,4);
        Vector2d vec3 = new Vector2d(0,0);
        Vector2d vec4 = new Vector2d(132,-123);

        assertEquals(false,vec1.follows(vec2), "(-1,3) is  following (3,4)");
        assertEquals(true,vec2.follows(vec3), "(3,4) is not following (0,0)");
        assertEquals(false,vec3.follows(vec4), "(0,0) is not following (132,-132)");

    }
    @Test
    public void upperRightTest(){
        Vector2d vec1 = new Vector2d(-1,3);
        Vector2d vec2 = new Vector2d(3,4);
        Vector2d vec3 = new Vector2d(0,0);
        Vector2d vec4 = new Vector2d(132,-123);

        assertEquals(new Vector2d(3,4),vec1.upperRight((vec2)));
        assertEquals(new Vector2d(3,4),vec2.upperRight((vec3)));
        assertEquals(new Vector2d(132,0),vec3.upperRight((vec4)));
    }


    @Test
    public void lowerLeftTest(){
        Vector2d vec1 = new Vector2d(-1,3);
        Vector2d vec2 = new Vector2d(3,4);
        Vector2d vec3 = new Vector2d(0,0);
        Vector2d vec4 = new Vector2d(132,-123);

        assertEquals(new Vector2d(-1,3),vec1.lowerLeft(vec2));
        assertEquals(new Vector2d(0,0),vec2.lowerLeft(vec3));
        assertEquals(new Vector2d(0 ,0),vec3.lowerLeft(vec3));
        assertEquals(new Vector2d(3 ,-123 ),vec4.lowerLeft(vec2));
    }

    @Test
    public void addTest(){
        Vector2d vec1 = new Vector2d(-1,3);
        Vector2d vec2 = new Vector2d(3,4);
        Vector2d vec3 = new Vector2d(0,0);
        Vector2d vec4 = new Vector2d(132,-123);

        assertEquals(new Vector2d(2,7),vec1.add(vec2),"(-1 + 3 , 3 + 4 ) != (2,7)");
        assertEquals(new Vector2d(3,4),vec2.add(vec3),"( 3  + 0 , 4  + 0) != (3,4)");
        assertEquals(new Vector2d(132,-123),vec3.add(vec4),"( 132  + 0 , -123  + 0) != (132,-123)");

    }

    @Test
    public void subtractTest(){
        Vector2d vec1 = new Vector2d(-1,3);
        Vector2d vec2 = new Vector2d(3,4);
        Vector2d vec3 = new Vector2d(0,0);
        Vector2d vec4 = new Vector2d(132,-123);

        assertEquals(new Vector2d(-4,-1),vec1.subtract(vec2));
        assertEquals(new Vector2d(3,4),vec2.subtract(vec3));
        assertEquals(new Vector2d(0,0),vec3.subtract(vec3));
        assertEquals(new Vector2d(129,-127),vec4.subtract(vec2));

    }

    @Test
    public void oppositeTest(){
        Vector2d vec1 = new Vector2d(-1,3);
        Vector2d vec2 = new Vector2d(3,4);
        Vector2d vec3 = new Vector2d(0,0);
        Vector2d vec4 = new Vector2d(132,-123);

        assertEquals(new Vector2d(1,-3),vec1.opposite());
        assertEquals(new Vector2d(-3,-4),vec2.opposite());
        assertEquals(new Vector2d(0,0),vec3.opposite());
        assertEquals(new Vector2d(-132,123),vec4.opposite());

    }


}
