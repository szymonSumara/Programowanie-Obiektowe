package agh.cs.lab1;

public class Grass extends AbstractWorldMapElement{

    public Grass(IWorldMap map, Vector2d initialPosition){
        super(map,initialPosition);
    }

    @Override
    public String toString(){
        return "*";
    }

}
