package agh.cs.lab1;
import java.util.Arrays;

public  class OptionsParser {
    static public MoveDirections [] parse(String args[]){
        MoveDirections[] resoult = Arrays.stream(args).
                filter(temp -> temp.equals( "f") || temp.equals( "b") || temp.equals( "r") || temp.equals( "l") ||
                        temp.equals( "forward") || temp.equals( "backward") || temp.equals( "left") || temp.equals( "right")  ).map( temp -> {
            switch (temp) {
                case "f":
                case "forward":
                    return  MoveDirections.FORWARD;
                case "b":
                case "backward":
                    return MoveDirections.BACKWARD;
                case "l":
                case "left":
                    return MoveDirections.LEFT;
                case "r":
                case "right":
                    return MoveDirections.RIGHT;
            }
           return null;
        }).toArray(MoveDirections[]::new);
        return resoult;

    }

}
