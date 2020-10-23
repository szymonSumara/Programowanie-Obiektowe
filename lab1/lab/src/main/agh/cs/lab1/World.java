package agh.cs.lab1;

public class World {
    public static void main(String[] args) {

        Animal animal = new Animal();

        MoveDirections [] movment = OptionsParser.parse(args);

        for (MoveDirections move:movment){
            animal.move(move);
            System.out.println(animal);
        }


    }
}
