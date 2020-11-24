package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


public class SimulationEngine implements IEngine{

    private MoveDirection []  directions;
    private IWorldMap map;
    private List<Animal> animals= new ArrayList<>();

    public SimulationEngine(MoveDirection []  directions, IWorldMap map, Vector2d [] positions){

        this.directions = directions;
        this.map = map;

        for(Vector2d position: positions) {
            Animal animalToInsert = new Animal(map,position);
            if (map.objectAt(animalToInsert.position) == animalToInsert)
                animals.add(animalToInsert);
        }
    }

    public void run(){
        Window win = new Window(new JLabel(map.toString()));
        int actualAnimalIndex = 0;

        for(MoveDirection direction:this.directions){
            animals.get(actualAnimalIndex).move(direction);
            actualAnimalIndex =(actualAnimalIndex +1)%animals.size();
            System.out.println(map);
            win.updateContent(map.toString());

        }
    }
}
