package agh.cs.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    public void parseTest(){

        assertArrayEquals(new MoveDirection[]{MoveDirection.FORWARD}, OptionsParser.parse(new String[]{"f"}));
       Exception exeptnion1 = assertThrows( IllegalArgumentException.class,() -> {
           OptionsParser.parse(new String[]{"bla", "b", "r", "f", "ds", "daw"});
        });

        assertTrue(exeptnion1.toString().contains("bla"));




        assertArrayEquals(new MoveDirection[]{MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.RIGHT},
                OptionsParser.parse(new String[]{"backward", "r", "forward", "left", "right"}));
        assertArrayEquals(new MoveDirection[]{}, OptionsParser.parse(new String[]{}));


    }
}
