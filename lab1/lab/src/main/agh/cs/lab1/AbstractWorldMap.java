package agh.cs.lab1;

import java.util.LinkedList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap{
    protected Vector2d northEastCorner;
    protected Vector2d southWestCorner;
    protected List<IMapElement> mapElements = new LinkedList<>();
    protected MapVisualizer mapVisualizer;

    public boolean canMoveTo(Vector2d position){
        return  !(objectAt(position) instanceof Animal);
    }

    public boolean place(IMapElement mapElement){
        Vector2d tmpPosition = mapElement.getPosition();
        if(!canMoveTo(tmpPosition)){
            return false;
        }
        mapElements.add(0,mapElement);
        return true;
    }

    public boolean isOccupied(Vector2d position){
        if(objectAt(position) == null)
            return false;
        return true;
    }

    public Object objectAt(Vector2d position){
        for(IMapElement mapElement: mapElements) {
            if (position.equals(mapElement.getPosition()))
                return mapElement;
        }
        return null;
    }

}
