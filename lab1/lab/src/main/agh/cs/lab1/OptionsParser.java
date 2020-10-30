package agh.cs.lab1;
import java.util.Arrays;

public  class OptionsParser {
    static public MoveDirection [] parse(String args[]){
        MoveDirection[] resoult = Arrays.stream(args).
                filter(temp -> temp.equals( "f") || temp.equals( "b") || temp.equals( "r") || temp.equals( "l") ||
                        temp.equals( "forward") || temp.equals( "backward") || temp.equals( "left") || temp.equals( "right")  ).map( temp -> {
            switch (temp) {
                case "f":
                case "forward":
                    return  MoveDirection.FORWARD;
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
           return null;
        }).toArray(MoveDirection[]::new);
        return resoult;

    }

}
