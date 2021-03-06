package agh.cs.lab1;

public enum  MapDirection {
    NORTH("^",new Vector2d(0,1)),
    EAST(">",new Vector2d(1,0)),
    SOUTH("v",new Vector2d(0,-1)),
    WEST("<",new Vector2d(-1,0));

    private final Vector2d unitVector;
    private final String   stringRepresentation;

    MapDirection(String stringRepresentation , Vector2d unitVector){
        this.unitVector = unitVector;
        this.stringRepresentation = stringRepresentation;
    }

    public String toString() {
        return stringRepresentation;
    }

    public MapDirection next() {
        return values()[(this.ordinal() + 1) % values().length];
    }

    public MapDirection previous() {
        return values()[(this.ordinal() - 1 + values().length) % values().length];
    }

    public  Vector2d toUnitVector(){
        return unitVector;
    }

}