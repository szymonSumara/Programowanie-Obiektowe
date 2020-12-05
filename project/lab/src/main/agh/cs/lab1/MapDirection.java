package agh.cs.lab1;

public enum  MapDirection {
    NORTH("^",new Vector2d(0,1)),
    NORTHEAST("\\",new Vector2d(1,1)),
    EAST(">",new Vector2d(1,0)),
    SOUTHEAST("\\",new Vector2d(1,-1)),
    SOUTH("v",new Vector2d(0,-1)),
    SOUTHWEST("/",new Vector2d(-1,-1)),
    WEST("<",new Vector2d(-1,0)),
    NORTHWEST("/",new Vector2d(-1,1));


    private final Vector2d unitVector;
    private final String   stringRepresentation;

    MapDirection(String stringRepresentation , Vector2d unitVector){
        this.unitVector = unitVector;
        this.stringRepresentation = stringRepresentation;
    }

    public String toString() {
        return stringRepresentation;
    }

    public MapDirection rotate(int angle){return values()[(this.ordinal() + angle) % values().length];}

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