package agh.cs.lab1;

public enum  MapDirection {
    NORTH("Północ",new Vector2d(0,1)),
    EAST("Wschód",new Vector2d(1,0)),
    SOUTH("Południe",new Vector2d(0,-1)),
    WEST("Zachód",new Vector2d(-1,0));

    private Vector2d unitVector;
    private String   stringRepresentation;

    private static MapDirection[] vals = values();

    private MapDirection(String stringRepresentation , Vector2d unitVector){
        this.unitVector = unitVector;
        this.stringRepresentation = stringRepresentation;
    }

    public String toString() {
        return stringRepresentation;
    }

    public MapDirection next() {
        return vals[(this.ordinal() + 1) % vals.length];
    }

    public MapDirection previous() {
        return vals[(this.ordinal() - 1 + vals.length) % vals.length];
    }

    public  Vector2d toUnitVector(){
        return unitVector;
    }

}