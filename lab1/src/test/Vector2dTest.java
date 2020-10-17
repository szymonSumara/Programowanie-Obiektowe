package test;
import agh.cs.lab1.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;
public class Vector2dTest {

    @Test
    public void equalsTest(){
        boolean everythinkIsOk = true;
        System.out.println("______________________ \nVector2.equal()  \n----------------------");
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(1,2);
        Vector2d vec3 = new Vector2d(4,3);
        Object vec4 = new Object();

        if(vec1.equals(vec1) == true){
            System.out.println(" Test 1: ok");
        }
        else {
            System.out.println(" Test 1: falirue");
            everythinkIsOk = false;
        }

        if(vec1.equals(vec2) == true){
            System.out.println(" Test 2: ok");
        }
        else {
            System.out.println(" Test 2: falirue");
            everythinkIsOk = false;
        }

        if(vec1.equals(vec3) == false){
            System.out.println(" Test 3: ok");
        }
        else {
            System.out.println(" Test 3: falirue");
            everythinkIsOk = false;
        }

        if(vec1.equals(vec4) == false){
            System.out.println(" Test 4: ok");
        }
        else {
            System.out.println(" Test 4: falirue");
            everythinkIsOk = false;
        }
        if(!everythinkIsOk)
            fail();
        System.out.println("______________________");

    }
    @Test
    public void toStringTest(){
        boolean everythinkIsOk = true;
        System.out.println("______________________ \nVector2d.toString()  \n----------------------");
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(89,-10);
        Vector2d vec3 = new Vector2d(-123,0);
        Vector2d vec4 = new Vector2d(-9999,-9999);

        if(vec1.toString().equals("(1,2)")){
            System.out.println(" Test 1: ok");
        }
        else {
            System.out.println(" Test 1: falirue");
            everythinkIsOk = false;
        }

        if(vec2.toString().equals( "(89,-10)")){
            System.out.println(" Test 2: ok");
        }
        else {
            System.out.println(" Test 2: falirue");
            everythinkIsOk = false;
        }

        if(vec3.toString().equals("(-123,0)")){
            System.out.println(" Test 3: ok");
        }
        else {
            System.out.println(" Test 3: falirue");
            everythinkIsOk = false;
        }

        if(vec4.toString().equals("(-9999,-9999)")){
            System.out.println(" Test 4: ok");
        }
        else {
            System.out.println(" Test 4: falirue");
            everythinkIsOk = false;
        }
        if(!everythinkIsOk)
            fail();
        System.out.println("______________________");

    }

    @Test
    public void precedesTest(){
        boolean everythinkIsOk = true;
        List<Vector2d> testsVectors =   new ArrayList<Vector2d>();
        testsVectors.add(new Vector2d(1,2));
        testsVectors.add(new Vector2d(7,8));
        testsVectors.add(new Vector2d(-1,10));
        testsVectors.add(new Vector2d(-20,8));
        testsVectors.add(new Vector2d(7,8));
        System.out.println("______________________ \nVector2d.precedes()  \n----------------------");
        if(testsVectors.get(0).precedes(testsVectors.get(1)) == true){
            System.out.println(" Test 1: ok");
        }
        else{
            System.out.println(" Test 1: falirue");
            everythinkIsOk = false;
        }

        if(testsVectors.get(1).precedes(testsVectors.get(1)) == true){
            System.out.println(" Test 2: ok");
        }
        else{
            System.out.println(" Test 2: falirue");
            everythinkIsOk = false;
        }

        if(testsVectors.get(3).precedes(testsVectors.get(1)) == true){
            System.out.println(" Test 3: ok");
        }
        else{
            System.out.println(" Test 3: falirue");
            everythinkIsOk = false;
        }

        if(testsVectors.get(3).precedes(testsVectors.get(0)) == false){
            System.out.println(" Test 4: ok");
        }
        else{
            System.out.println(" Test 4: falirue");
            everythinkIsOk = false;
        }

        if(!everythinkIsOk)
            fail();
        System.out.println("______________________");

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
