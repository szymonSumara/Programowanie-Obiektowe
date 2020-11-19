package agh.cs.lab1;

import java.util.Random;

public class GrassField extends AbstractWorldMap{


    public GrassField(int n){
        int range = (int)Math.sqrt(n*10);
        this.mapVisualizer = new MapVisualizer(this);

        int inserted = 0;
        while(inserted < n){
            int x = new Random().nextInt(range);    // czy ten obiekt trzeba tworzyć 2 razy na obrót pętli?
            int y = new Random().nextInt(range);

            if(!isOccupied(new Vector2d(x,y))){
                mapElements.add(new Grass(this,new Vector2d(x,y)));
                inserted+=1;
            }
        }
    }

    protected Vector2d getNorthEastCorner(){
        northEastCorner = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        for(IMapElement mapElement:mapElements)
            northEastCorner = northEastCorner.upperRight(mapElement.getPosition());
        return northEastCorner;
    }

    protected Vector2d getSouthWestCorner(){
        southWestCorner = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        for(IMapElement mapElement:mapElements)
            southWestCorner = southWestCorner.lowerLeft(mapElement.getPosition());
        return southWestCorner;
    }

}
