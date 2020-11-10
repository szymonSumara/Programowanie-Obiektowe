package agh.cs.lab1;

abstract public class AbstractWorldMapElement implements IMapElement{
    protected Vector2d position;
    protected  IWorldMap map;

    public Vector2d getPosition(){
        return position;
    }

}
