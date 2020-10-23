package agh.cs.lab1;
import java.util.Arrays;

public  class OptionsParser {
    static public MoveDirections [] parse(String args[]){
        MoveDirections[] resoult = Arrays.stream(args).
                filter(temp -> temp.equals( "f") || temp.equals( "b") || temp.equals( "r") || temp.equals( "l")  ).map( temp -> {
            switch (temp) {
                case "f":
                    return  MoveDirections.FORWARD;
                case "b":
                    return MoveDirections.BACKWARD;
                case "l":
                    return MoveDirections.LEFT;
                case "r":
                    return MoveDirections.RIGHT;
            }
           return null;
        }).toArray(MoveDirections[]::new);
        return resoult;

    }

}
