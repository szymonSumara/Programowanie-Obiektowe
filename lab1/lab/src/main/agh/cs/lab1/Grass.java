package agh.cs.lab1;

public class Grass extends AbstractWorldMapElement{

    public Grass(Vector2d position){
        this.position = position;
    }

    @Override
    public String toString(){
        return "*";
    }

}
