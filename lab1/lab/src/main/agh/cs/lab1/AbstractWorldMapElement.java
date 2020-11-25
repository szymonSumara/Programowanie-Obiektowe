package agh.cs.lab1;

abstract public class AbstractWorldMapElement implements IMapElement{

    protected Vector2d position;
    protected  IWorldMap map;   // to pole może być finalne

    public AbstractWorldMapElement(IWorldMap map,Vector2d position){
        this.position = position;
        this.map = map;
    }

    public Vector2d getPosition(){
        return position;
    }

}
