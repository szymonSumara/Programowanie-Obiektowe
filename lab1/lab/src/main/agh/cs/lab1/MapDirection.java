package agh.cs.lab1;

public enum  MapDirection {
    NORTH("Północ",new Vector2d(0,1)),
    EAST("Wschód",new Vector2d(1,0)),
    SOUTH("Południe",new Vector2d(0,-1)),
    WEST("Zachód",new Vector2d(-1,0));

    private Vector2d unitVector;
    private String   stringRepresentation;


    private MapDirection(String stringRepresentation , Vector2d unitVector){
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