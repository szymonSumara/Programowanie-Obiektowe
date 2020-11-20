package agh.cs.lab1;


public class RectangularMap extends AbstractWorldMap{

    private Vector2d southWestCorner;
    private Vector2d northEastCorner;

    public RectangularMap(int width,int lenght){
        this.southWestCorner = new Vector2d(0,0);
        this.northEastCorner = new Vector2d(width,lenght);
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return  position.precedes(this.northEastCorner)
                && position.follows(this.southWestCorner)
                && !isOccupied(position);
    }

    protected Vector2d getNorthEastCorner(){
        return new Vector2d(northEastCorner.x , northEastCorner.y);
    }

    protected Vector2d getSouthWestCorner(){
        return new Vector2d(southWestCorner.x , southWestCorner.y);
    }

}
