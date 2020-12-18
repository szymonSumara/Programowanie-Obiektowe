package agh.cs.lab1;

abstract public class AbstractWorldMapElement {

    protected Vector2d position;
    protected  final EvolutionMap map;

    public AbstractWorldMapElement(EvolutionMap map,Vector2d position){
        this.position = position;
        this.map = map;
    }

    public Vector2d getPosition(){
        return position;
    }

}
