package agh.cs.lab1;


import java.util.*;

public class Animal extends AbstractWorldMapElement implements IPositionChangeObserver,Comparable{

    private MapDirection orientation = MapDirection.NORTH;
    private final List<IPositionChangeObserver> observers = new LinkedList<>();
    private Integer energy= 1000;
    private Integer daysOfLive = 1;
    private  final int minEnergyToMultiplication = 20;
    public GeneticCode geneticCode;
    public int childrenNum = 0;

    public Animal(EvolutionMap map, Vector2d initialPosition){
        super(map, initialPosition);
        this.map.place(this);
        this.geneticCode = new GeneticCode();
    }

    private Animal(EvolutionMap map, Vector2d initialPosition,Animal strongerParent,Animal weakerParent,int energy ){
        super(map, initialPosition);
        this.map.place(this);
        this.energy=energy;
        this.geneticCode = new GeneticCode(strongerParent.geneticCode,weakerParent.geneticCode);
    }

    public int getLiveTime(){
        return this.daysOfLive;
    }

    public int getEnergy(){
        return this.energy;
    }

    public void improveEnergy(int energy){
        this.energy += energy;
    }

    public void reduceEnergy(int energy){
        this.energy -= energy;
    }

    public boolean isDead(){
        return this.energy < 0;
    }

    public boolean canReproduce(){
        return this.energy > this.minEnergyToMultiplication;
    }

    @Override
    public String toString(){
        return this.orientation.toString();
    }

    public boolean addObserver(IPositionChangeObserver observer){
        if(!observers.contains(observer)) {
            observers.add(observer);
            return observers.contains(observer);
        }
        return false;
    }

    public boolean removeObserver(IPositionChangeObserver observer){

        if(observers.contains(observer)){
            observers.remove(observer);
            return !observers.contains(observer);
        }
        return false;
    }



    public Animal reproduce(Animal other){
        this.childrenNum+=1;
        other.childrenNum+=1;
        int gaveEnergyFromThis = this.energy/4;

        this.reduceEnergy(gaveEnergyFromThis);

        int gaveEnergyFromOther = other.energy/4;
        other.reduceEnergy(gaveEnergyFromOther);

        return new Animal(this.map,this.position,this,other, gaveEnergyFromThis +gaveEnergyFromOther);
        //child.move();

    }



    public void move(){
        this.daysOfLive+=1;
        this.orientation = orientation.rotate(this.geneticCode.getRandomGene());
        Vector2d oldPosition = this.position;
        this.position = this.position.add(this.orientation.toUnitVector());
        this.position = this.position.convertToBounds(map.getNorthEastCorner(), map.getSouthWestCorner());
        this.positionChanged(oldPosition,this.position,this);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition,AbstractWorldMapElement abstractWorldMapElement){
        for( IPositionChangeObserver observer : observers )
            observer.positionChanged(oldPosition, newPosition,this);
    }

    @Override
    public int compareTo(Object o) {
        return this.energy.compareTo(((Animal)o).energy);
    }
}
