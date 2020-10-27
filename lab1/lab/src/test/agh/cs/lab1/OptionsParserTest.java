package agh.cs.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsParserTest {
    @Test
    public void parseTest() {
        assertArrayEquals(new MoveDirections[]{MoveDirections.FORWARD}, OptionsParser.parse(new String[]{"f"}));
        assertArrayEquals(new MoveDirections[]{MoveDirections.BACKWARD, MoveDirections.RIGHT, MoveDirections.FORWARD},
                OptionsParser.parse(new String[]{"bla", "b", "r", "f", "ds", "daw"}));
        assertArrayEquals(new MoveDirections[]{MoveDirections.BACKWARD, MoveDirections.RIGHT, MoveDirections.FORWARD,MoveDirections.LEFT,MoveDirections.RIGHT},
                OptionsParser.parse(new String[]{"bla", "backward", "r", "forward", "ds", "left", "right", "daw"}));
        assertArrayEquals(new MoveDirections[]{}, OptionsParser.parse(new String[]{"Bla Bla Bla "}));
        assertArrayEquals(new MoveDirections[]{}, OptionsParser.parse(new String[]{}));


    }
}
