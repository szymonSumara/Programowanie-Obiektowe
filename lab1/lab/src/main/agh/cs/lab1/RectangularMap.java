package agh.cs.lab1;


public class RectangularMap extends AbstractWorldMap{

    public RectangularMap(int width,int lenght){
        this.southWestCorner = new Vector2d(0,0);
        this.northEastCorner = new Vector2d(width,lenght);
        this.mapVisualizer   = new MapVisualizer(this);
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return  position.precedes(this.northEastCorner)
                && position.follows(this.southWestCorner)
                && !isOccupied(position);
    }
    @Override
    public String toString(){
        return mapVisualizer.draw(southWestCorner,northEastCorner);
    }
}
