package agh.cs.lab1;
/*
    Odpowiadając na pytanie problemowe można by utworzyć klasę Board
    z takimi metodami jak

    itsPosibleToMoveThere(vector2d vec)
        zwracającą wartość bool i mówiącą nam czy nie wychodzimy  poza mapę
        i czy nie staniemy na innym zwierzaku

    GiveFirstFreeField
        zwracającą pierwsze wolne pole
        Używalibyśmy tej metody w konstruktorze Animal do wyznaczania wartości początkowych position


 */
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
