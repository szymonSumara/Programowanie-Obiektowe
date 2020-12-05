package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


public class SimulationEngine implements IEngine{

    private final MoveDirection []  directions;
    private final EvolutionMap map;
    private final List<Animal> animals= new ArrayList<>();


    public SimulationEngine(MoveDirection []  directions, EvolutionMap map, Vector2d [] positions){

        this.directions = directions;
        this.map = map;

    }

    public void run(){
        Window win = new Window(new JLabel(map.toString()));

        while(true){
            map.moveAllAnimals();
            map.growGrass();
            win.updateContent(map.toString());
        }
    }
}
