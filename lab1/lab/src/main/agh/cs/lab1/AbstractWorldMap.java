package agh.cs.lab1;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap , IPositionChangeObserver{

    private final Map<Vector2d,Animal> animals = new HashMap<>();
    private final MapVisualizer mapVisualizer  = new MapVisualizer(this);

    public boolean canMoveTo(Vector2d position){
        return  !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal){
        if(!canMoveTo(animal.getPosition())){
            throw new IllegalArgumentException("cant add animal to " + animal.getPosition());
        }
        animals.put(animal.getPosition(),animal);
        animal.addObserver(this);
        return true;
    }

    public boolean isOccupied(Vector2d position){
        return !(objectAt(position) == null);
    }

    public Object objectAt(Vector2d position){
        return animals.get(position);
    }

    @Override
    public String toString(){
        return  mapVisualizer.draw(getSouthWestCorner(),getNorthEastCorner());
    }

    protected abstract Vector2d getNorthEastCorner();

    protected abstract Vector2d getSouthWestCorner();

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        if(animals.get(oldPosition).getPosition().equals(newPosition)) {
            animals.put(newPosition, animals.get(oldPosition));
            animals.remove(oldPosition);
        }
    }
}

