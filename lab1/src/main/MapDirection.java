package agh.cs.lab1;

public enum  MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;



    private static MapDirection[] vals = values();


    public String toString() {
        switch (this) {
            case NORTH:return "Północ";
            case SOUTH: return "Południe";
            case EAST : return "Wschód";
            case WEST : return "Zachód";
            default: return "ERR: MoveDirection.toString()";
        }
    }

    public MapDirection next() {
        return vals[(this.ordinal() + 1) % vals.length];
    }

    public MapDirection previous() {
        return vals[(this.ordinal() - 1 + vals.length) % vals.length];
    }

    public  Vector2d toUnitVector(){
        switch(this){
            case EAST :return new Vector2d(1,0);
            case NORTH:return new Vector2d(0,1);
            case WEST :return new Vector2d(-1,0);
            case SOUTH:return new Vector2d(0,-1);
        }
        return null;
    }

}