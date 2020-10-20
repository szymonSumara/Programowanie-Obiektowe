package agh.cs.lab1;



public class World {
    public static void main(String[] args) {

        MapDirection direction = MapDirection.NORTH;
        System.out.println(direction.next().toUnitVector());
        System.out.println(direction.next().next().toUnitVector());
        System.out.println(direction.next().next().next().toUnitVector());
        System.out.println(direction.next().next().next().next().toUnitVector());


    }
}
