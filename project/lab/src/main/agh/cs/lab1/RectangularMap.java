package agh.cs.lab1;


public class RectangularMap extends AbstractWorldMap{

    private final Vector2d southWestCorner = new Vector2d(0,0);
    private final Vector2d northEastCorner;

    public RectangularMap(int width,int length){
        this.northEastCorner = new Vector2d(width-1,length-1);
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return  position.precedes(this.northEastCorner)
                && position.follows(this.southWestCorner)
                && super.canMoveTo(position);
    }

    protected Vector2d getNorthEastCorner(){
        return northEastCorner;
    }

    protected Vector2d getSouthWestCorner(){
        return southWestCorner;
    }

}
