package agh.cs.lab1;


public class Animal {
    private Vector2d position;// = new Vector2d(2,2);
    private MapDirection orientatnion = MapDirection.NORTH;
    private IWorldMap map;

    public Animal(IWorldMap map){
        if (!map.isOccupied(new Vector2d(2,2))){
            this.position = new Vector2d(2,2);
            map.place(this);
            this.map = map;
        }

    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        if (!map.isOccupied(initialPosition)){
            this.position = initialPosition;
            map.place(this);
            this.map = map;
        }
    }

    public Animal(){
        this.map = new RectangularMap(4,4);
        position = new Vector2d(2,2);
        this.map.place(this);
    }

    Vector2d getPosition(){
        return position;
    }


    public String toString(){
        return "Animal position : " + position + " orientation: " + this.orientatnion;
    }

    public void move(MoveDirection direction){
        Vector2d tmpPosition;
        switch(direction){
            case RIGHT:orientatnion = orientatnion.next();break;
            case LEFT:orientatnion = orientatnion.previous();break;
            case FORWARD:
                tmpPosition = position.add(orientatnion.toUnitVector());
                if( map.canMoveTo(tmpPosition))
                    position = tmpPosition;
                break;
            case BACKWARD:
                tmpPosition = position.subtract(orientatnion.toUnitVector());
                if(map.canMoveTo(tmpPosition) )
                    position = tmpPosition;break;
        }

    }

}
