package agh.cs.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    public List<Grass> grasses = new ArrayList<>();

    public GrassField(int n){
        int range = (int)Math.sqrt(n*10);

        int inserted = 0;
        while(inserted < n){
            int x = new Random().nextInt(range);
            int y = new Random().nextInt(range);

            if(!isOccupied(new Vector2d(x,y))){
                grasses.add(new Grass(new Vector2d(x,y)));
                inserted+=1;
            }
        }
    }

    public Object objectAt(Vector2d position){
        Object object = super.objectAt(position);
        if(object instanceof Animal)
            return object;
        for(Grass grass:grasses){
            if(grass.getPosition().equals(position)){
                return grass;
            }
        }
        return null;
    }

    public String toString(){
         southWestCorner = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
         northEastCorner = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);

        for(Animal animal:animals){
           southWestCorner = southWestCorner.lowerLeft(animal.getPosition());
           northEastCorner = northEastCorner.upperRight(animal.getPosition());
        }

        for(Grass grass:grasses){
            southWestCorner = southWestCorner.lowerLeft(grass.getPosition());
            northEastCorner = northEastCorner.upperRight(grass.getPosition());
        }

        return  new MapVisualizer(this).draw(southWestCorner,northEastCorner);
    }
}
