package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private Vector2d northEastCorner;   // może być finalne
    private Vector2d southWestCorner;
    public List<Animal> animals = new ArrayList<>();    // to nie może być publiczne


    public RectangularMap(int width,int lenght){
        this.southWestCorner = new Vector2d(0,0);
        this.northEastCorner = new Vector2d(width,lenght);  // width - 1
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
                isEmpty = true; // nie lepiej od razu return? zaoszczędzimy na przeglądaniu reszty listy
        }
        return isEmpty;
    }

    public Object objectAt(Vector2d position){  // wygląda prawie jak isOccupied
        for(Animal animal: animals) {
            if (position.equals(animal.getPosition()))
                return animal;
        }
        return null;
    }

    public String toString(){
        return  new MapVisualizer(this).draw(southWestCorner,northEastCorner);  // czy ten visualizer trzeba tworzyć co wywołanie?
    }
}
