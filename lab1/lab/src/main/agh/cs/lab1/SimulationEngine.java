package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{

    private MoveDirection []  directions;
    private IWorldMap map;
    private List<Vector2d> animalsPositions = new ArrayList<>();

    public SimulationEngine(MoveDirection []  directions, IWorldMap map, Vector2d [] positions){

        this.directions = directions;
        this.map = map;

        for(Vector2d position: positions) {
            if (this.map.place(new Animal(this.map, position)))
                animalsPositions.add(position);
        }
    }

    public void run(){
        int actualAnimalIndex = 0;
        for(MoveDirection direction:this.directions){
            Object object = map.objectAt(animalsPositions.get(actualAnimalIndex));
            if(object instanceof Animal) {
                Animal animal = (Animal) object;
                animal.move(direction);
                animalsPositions.set(actualAnimalIndex, animal.getPosition());
                actualAnimalIndex =(actualAnimalIndex +1)%animalsPositions.size();
                System.out.println(map);
            }
        }
    }
}