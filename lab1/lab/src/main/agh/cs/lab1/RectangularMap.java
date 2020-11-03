package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private Vector2d northEastCorner;
    private Vector2d southWestCorner;
    public List<Animal> animals = new ArrayList<>();


    public RectangularMap(int width,int lenght){
        this.southWestCorner = new Vector2d(0,0);
        this.northEastCorner = new Vector2d(width,lenght);
    }

    public boolean canMoveTo(Vector2d position){
        return  position.precedes(this.northEastCorner)
                && position.follows(this.southWestCorner)
                && !isOccupied(position);
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
        boolean isEmpty=false;
        for(Animal animal: animals) {
            if (position.equals(animal.getPosition()))
                isEmpty = true;
        }
        return isEmpty;
    }

    public Object objectAt(Vector2d position){
        for(Animal animal: animals) {
            if (position.equals(animal.getPosition()))
                return animal;
        }
        return null;
    }

    public String toString(){
        return  new MapVisualizer(this).draw(southWestCorner,northEastCorner);
    }
}
