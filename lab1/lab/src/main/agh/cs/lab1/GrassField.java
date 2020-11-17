package agh.cs.lab1;

import java.util.Random;

public class GrassField extends AbstractWorldMap{


    public GrassField(int n){
        int range = (int)Math.sqrt(n*10);
        this.mapVisualizer = new MapVisualizer(this);

        int inserted = 0;
        while(inserted < n){
            int x = new Random().nextInt(range);
            int y = new Random().nextInt(range);

            if(!isOccupied(new Vector2d(x,y))){
                new Grass(this,new Vector2d(x,y));
                inserted+=1;
            }
        }
    }

    @Override
    public boolean place(IMapElement mapElement){
        if(mapElement instanceof Animal)
            return super.place(mapElement);
        else if(mapElement instanceof Grass){
            mapElements.add(mapElement);
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
         southWestCorner = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
         northEastCorner = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);

        for(IMapElement mapElement:mapElements){
            southWestCorner = southWestCorner.lowerLeft(mapElement.getPosition());
            northEastCorner = northEastCorner.upperRight(mapElement.getPosition());
        }

        return  mapVisualizer.draw(southWestCorner,northEastCorner);
    }
}
