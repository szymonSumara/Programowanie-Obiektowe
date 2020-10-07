package agh.cs.lab1;

public class World {
    public static void main(String[] args) {
        System.out.print("Start\n");
        Direction[] modifyData = convertStringsToEnum(args);
        run(modifyData);
        System.out.print("Stop");
    }

    public static Direction[] convertStringsToEnum(String[] args) {
        int arrayLenght = args.length;
        Direction[] resoult = new Direction[arrayLenght];

        int i = 0;
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
        }
        return resoult;
    }

    public static void run(Direction[] args){
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
    }
}
