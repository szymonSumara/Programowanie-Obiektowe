package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;


abstract class AbstractWorldMap implements IWorldMap{
    protected Vector2d northEastCorner;
    protected Vector2d southWestCorner;
    protected List<Animal> animals = new ArrayList<>();

    public boolean canMoveTo(Vector2d position){
        return  !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal){
        Vector2d tmpPosition = animal.getPosition();
        if(!canMoveTo(tmpPosition)){
            return false;
        }
        animals.add(animal);
        return true;
    }

    public boolean isOccupied(Vector2d position){
        if(objectAt(position) == null)
            return false;
        return true;
    }

    public Object objectAt(Vector2d position){
        for(Animal animal: animals) {
            if (position.equals(animal.getPosition()))
                return animal;
        }
        return null;
    }

}
