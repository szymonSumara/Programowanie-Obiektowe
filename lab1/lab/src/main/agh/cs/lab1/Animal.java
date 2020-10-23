package agh.cs.lab1;


public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientatnion = MapDirection.NORTH;

    public String toString(){
        return "Animal position : " + position + " orientation: " + this.orientatnion;
    }

    public void move(MoveDirections direction){
        Vector2d tmpPosition;
        switch(direction){
            case RIGHT:orientatnion = orientatnion.next();break;
            case LEFT:orientatnion = orientatnion.previous();break;
            case FORWARD:
                tmpPosition = position.add(orientatnion.toUnitVector());
                if( tmpPosition.follows(new Vector2d(0,0)) && tmpPosition.precedes(new Vector2d(4,4)))
                    position = tmpPosition;
                break;
            case BACKWARD:
                tmpPosition = position.subtract(orientatnion.toUnitVector());
                if( tmpPosition.follows(new Vector2d(0,0)) && tmpPosition.precedes(new Vector2d(4,4)))
                    position = tmpPosition;break;
        }

    }

}
