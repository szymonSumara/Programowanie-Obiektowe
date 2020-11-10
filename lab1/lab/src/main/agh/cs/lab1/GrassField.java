package agh.cs.lab1;

import java.util.Random;

public class GrassField extends AbstractWorldMap{


    public GrassField(int n){
        int range = (int)Math.sqrt(n*10);
        mapView = new MapVisualizer(this);

        int inserted = 0;
        while(inserted < n){
            int x = new Random().nextInt(range);
            int y = new Random().nextInt(range);

            if(!isOccupied(new Vector2d(x,y))){
                mapElements.add(new Grass(new Vector2d(x,y)));
                inserted+=1;
            }
        }
    }

    @Override
    public String toString(){
         southWestCorner = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
         northEastCorner = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);

        for(IMapElement mapElement:mapElements){
            southWestCorner = southWestCorner.lowerLeft(mapElement.getPosition());
            northEastCorner = northEastCorner.upperRight(mapElement.getPosition());
        }

        return  mapView.draw(southWestCorner,northEastCorner);
    }
}
