package agh.cs.lab1;

import java.util.Arrays;

public class World {
    public static void main(String[] args) {
       /* Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
*/

        MapDirection direction = MapDirection.NORTH;
        System.out.println(direction.next().toUnitVector());
        System.out.println(direction.next().next().toUnitVector());
        System.out.println(direction.next().next().next().toUnitVector());
        System.out.println(direction.next().next().next().next().toUnitVector());


    }

   /* public static Direction[] convertStringsToEnum(String[] args) {
        //int arrayLenght = args.length;
        Direction[] resoult = Arrays.stream(args).map( temp -> {
            Direction toReturn = null ;
            switch (temp) {
                case "f":
                    toReturn =  Direction.FORWARD;
                    break;
                case "b":
                    toReturn = Direction.BACKWARD;
                    break;
                case "l":
                    toReturn = Direction.LEFT;
                    break;
                case "r":
                    toReturn = Direction.RIGHT;
                    break;
                default:
                    System.out.println("ERR: Input error");
                    System.exit(0);
            }
            return toReturn;
        }).toArray(Direction[]::new);

      *//*  int i = 0;
        for (String argument : args) {
            switch (argument) {
                case "f":
                    resoult[i] = Direction.FORWARD;
                    break;
                case "b":
                    resoult[i] = Direction.BACKWARD;
                    break;
                case "l":
                    resoult[i] = Direction.LEFT;
                    break;
                case "r":
                    resoult[i] = Direction.RIGHT;
                    break;
                default:
                    System.out.println("ERR: Input error");
                    System.exit(0);
            }
            i++;
        }*//*
        return resoult;
    }*/

    /*public static void run(Direction[] args){
        // System.out.print("Animal is going foreward\n");
        //boolean isFirst = true;
        //for(String argument : args) {
        //    if(!isFirst){
        //    }
        //    System.out.print(argument);
        //    isFirst = false;
        //}

        for(Direction argument : args) {
            switch (argument){
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skręca w lewo");
                    break;
            }
        }
    }*/
}