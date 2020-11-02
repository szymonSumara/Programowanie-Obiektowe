package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private int width;
    private int lenght;
    private int map[][];
    private int lastFreeIndex=0;
    private Vector2d northEastCorner;
    private Vector2d southWestCorner;
    private List<Animal> animals = new ArrayList<>();


    public RectangularMap(int width,int lenght){
        this.width  = width;
        this.lenght = lenght;
        this.southWestCorner = new Vector2d(0,0);
        this.northEastCorner = new Vector2d(4,4);
        this.map = new int[width + 1][lenght+ 1];
    }

    public boolean canMoveTo(Vector2d position){
        return  position.precedes(this.northEastCorner)
                && position.follows(this.southWestCorner)
                && map[position.x][position.y] == 0;
    }

    public boolean place(Animal animal){
        Vector2d tmpPositjon = animal.getPosition();
        if(isOccupied(tmpPositjon)){
            return false;
        }
        animals.add(lastFreeIndex,animal);
        map[tmpPositjon.x][tmpPositjon.y] = lastFreeIndex;
        lastFreeIndex+=1;
        return true;

    }


    public void run(MoveDirection[] directions){
        int numberOfAnimals = animals.size();
        if(numberOfAnimals < 1)
            return;
        int actualAnimal = 0;
        for(MoveDirection direction : directions){
            animals.get(actualAnimal).move(direction);
            actualAnimal=(actualAnimal+1)%numberOfAnimals;
            MapVisualizer mv = new MapVisualizer(this);
            System.out.println(mv.draw(new Vector2d(0,0),new Vector2d(width,lenght)));

        }
    }


    public boolean isOccupied(Vector2d position){
        return  map[position.x][position.y] != 0;
    }

    public Object objectAt(Vector2d position){
        if(map[position.x][position.y] == 0)
            return null;
        return animals.get(map[position.x][position.y]);
    }

}
