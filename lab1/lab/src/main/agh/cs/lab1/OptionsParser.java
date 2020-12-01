package agh.cs.lab1;

import java.util.Arrays;

public class OptionsParser {
    static public MoveDirection[] parse(String[] args) {
        return Arrays.stream(args).map(temp -> {
            switch (temp) {
                case "f":
                case "forward":
                    return MoveDirection.FORWARD;
                case "b":
                case "backward":
                    return MoveDirection.BACKWARD;
                case "l":
                case "left":
                    return MoveDirection.LEFT;
                case "r":
                case "right":
                    return MoveDirection.RIGHT;
            }
            throw new IllegalArgumentException(temp + " is not legal move specification");
        }).toArray(MoveDirection[]::new);
    }
}
