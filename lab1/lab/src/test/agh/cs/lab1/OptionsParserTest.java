package agh.cs.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsParserTest {
    @Test
    public void parseTest(){

        assertArrayEquals(new MoveDirection[]{MoveDirection.FORWARD}, OptionsParser.parse(new String[]{"f"}));
        assertArrayEquals(new MoveDirection[]{MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD},
                OptionsParser.parse(new String[]{"bla", "b", "r", "f", "ds", "daw"}));
        assertArrayEquals(new MoveDirection[]{MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.RIGHT},
                OptionsParser.parse(new String[]{"bla", "backward", "r", "forward", "ds", "left", "right", "daw"}));
        assertArrayEquals(new MoveDirection[]{}, OptionsParser.parse(new String[]{"Bla Bla Bla "}));
        assertArrayEquals(new MoveDirection[]{}, OptionsParser.parse(new String[]{}));


    }
}
