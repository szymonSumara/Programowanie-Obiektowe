package agh.cs.lab1;

import com.sun.javafx.image.BytePixelSetter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements ActionListener {



    private final EvolutionMap map;
    private final Statistic statistic;

    private final List<Animal> animals = new LinkedList<>();

    private final int grassEnergy ;
    private final int dayEnergyCost ;
    private final int grassPerDay;
    private final SimulationWindow simulationWindow;
    private final Timer timer = new Timer(20,this);

    public SimulationEngine( EvolutionMap map,Statistic statistic, int grassEnergy,int dayEnergyCost,int grassPerDay){
        this.map = map;
        this.statistic      = statistic;
        this.grassEnergy    = grassEnergy;
        this.dayEnergyCost  = dayEnergyCost;
        this.grassPerDay    = grassPerDay;
        this.simulationWindow  = new SimulationWindow(map.getVisualistaion(),statistic.getPlotRender());

        animals.add(new Animal(map,new Vector2d(45,15)));
        animals.add(new Animal(map,new Vector2d(45,15)));
        animals.add(new Animal(map,new Vector2d(45,15)));
        animals.add(new Animal(map,new Vector2d(45,15)));

        for(Animal animal :animals)
            statistic.addAnimal(animal);
    }



    public void run(){
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        this.removeDeadAnimals();
        this.moveAllAnimals();
        this.animalEatGrass();
        this.multiplicationAnimals();
        this.growGrass();
        this.statistic.updatePlot();
        this.simulationWindow.updateContent();
        //System.out.println(statistic.toString());
    }

    public void moveAllAnimals(){
        for(Animal animal : animals) {
            animal.reduceEnergy(this.dayEnergyCost);
            animal.move();
        }
    }

    public void growGrass(){
        for(int i=0;i<grassPerDay;i++)
            if(map.placeGrassInJungle()) {
                System.out.println("i" + i);
                statistic.addGrass();
            }else
                break;

        for(int i=0;i<grassPerDay;i++)
            if(map.placeGrassOutJungle())
                statistic.addGrass();
            else
                break;

    }

    public  void animalEatGrass(){
        for(int i=0;i<map.getNorthEastCorner().x;i++)
            for(int j=0;j<map.getNorthEastCorner().y;j++) {
                if (map.getAnimalsAt(new Vector2d(i, j)).isEmpty() || map.getGrassAt(new Vector2d(i, j)) == null)
                    continue;

                List<Animal> animalsAt = map.getAnimalsAt(new Vector2d(i, j));
                Animal firstAnimal = animalsAt.get(0);

                int strongestAnimalsCounter = 0;

                for(Animal animal : animalsAt)
                    if(animal.compareTo(firstAnimal) == 0)
                        strongestAnimalsCounter+=1;
                    else
                        break;

                if((int)(this.grassEnergy/strongestAnimalsCounter)*strongestAnimalsCounter != this.grassEnergy)
                    firstAnimal.improveEnergy(1);

                for(Animal animal : animalsAt)
                    if(animal.compareTo(firstAnimal) == 0)
                        firstAnimal.improveEnergy(this.grassEnergy/strongestAnimalsCounter);
                    else
                        break;

                map.removeGrass(new Vector2d(i, j));
                System.out.println("ala ma asa");
                statistic.removeGrass();
                System.out.println("ala ma asa");
            }
    }


    public void removeDeadAnimals(){

        for(int i=0;i<animals.size();i++)
            if (animals.get(i).isDead()) {
                map.removeAnimal(animals.get(i));
                statistic.removeAnimal(animals.get(i));
                animals.remove(i);

            }
    }

    public void multiplicationAnimals(){
        for(int i=0;i<map.getNorthEastCorner().x;i++)
            for(int j=0;j<map.getNorthEastCorner().y;j++)
                if(map.getAnimalsAt(new Vector2d(i,j)).size() >1) {
                    List<Animal> animalsAt = map.getAnimalsAt(new Vector2d(i, j));
                    if(animalsAt.get(0).canReproduce() && animalsAt.get(1).canReproduce()) {
                        Animal newAnimal = animalsAt.get(0).reproduce(animalsAt.get(1));

                        animals.add(newAnimal);
                        statistic.addAnimal(newAnimal);
                    }
                }
    }
}
