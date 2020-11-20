package agh.cs.lab1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap{

    private Map<Vector2d,Grass> grasses = new HashMap<>();

    public GrassField(int n){
        int range = (int)Math.sqrt(n*10);
        this.mapVisualizer = new MapVisualizer(this);

        int inserted = 0;
        while(inserted < n){
            int x = new Random().nextInt(range);
            int y = new Random().nextInt(range);

            if(!isOccupied(new Vector2d(x,y))){
                grasses.put(new Vector2d(x,y),new Grass(this,new Vector2d(x,y)));
                inserted+=1;
            }
        }
    }

    public Object objectAt(Vector2d position) {
        Object object =  super.objectAt(position);
        if( object != null)
            return object;
        return  grasses.get(position);
    }

    protected Vector2d getNorthEastCorner(){
        Vector2d northEastCorner = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        for(IMapElement mapElement:grasses.values())
            northEastCorner = northEastCorner.upperRight(mapElement.getPosition());
        for(IMapElement mapElement:animals.values())
            northEastCorner = northEastCorner.upperRight(mapElement.getPosition());

        return northEastCorner;
    }

    protected Vector2d getSouthWestCorner(){
        Vector2d southWestCorner = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        for(IMapElement mapElement: grasses.values())
            southWestCorner = southWestCorner.lowerLeft(mapElement.getPosition());
        for(IMapElement mapElement: animals.values())
            southWestCorner = southWestCorner.lowerLeft(mapElement.getPosition());
        return southWestCorner;
    }

}
