package agh.cs.lab1;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap , IPositionChangeObserver{

    Map<Vector2d,Animal> animals = new HashMap<>(); // czy świadomie Pan wybrał ten modyfikator dostępu?
    protected MapVisualizer mapVisualizer  = new MapVisualizer(this);;  // to pole może być finalne i prywatne

    public boolean canMoveTo(Vector2d position){
        return  !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal){
        if(!canMoveTo(animal.getPosition())){
            return false;
        }
        animals.put(animal.getPosition(),animal);
        animal.addObserver(this);
        return true;
    }

    public boolean isOccupied(Vector2d position){
        if(objectAt(position) == null)  // można pisać return warunek
            return false;
        return true;
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

