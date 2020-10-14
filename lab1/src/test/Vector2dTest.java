package test;
import agh.cs.lab1.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<Vector2d> testsVectors =   new ArrayList<Vector2d>();
        testsVectors.add(new Vector2d(1,2));
        testsVectors.add(new Vector2d(7,8));
        testsVectors.add(new Vector2d(-1,10));
        testsVectors.add(new Vector2d(-20,8));
        testsVectors.add(new Vector2d(7,8));

        




    }

}
