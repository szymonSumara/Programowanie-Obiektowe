package agh.cs.lab1;


public class Animal extends AbstractWorldMapElement{

    private MapDirection orientation = MapDirection.NORTH;

    public Animal(IWorldMap map){
        super(map, new Vector2d(2,2));
        map.place(this);
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(map, initialPosition);
        map.place(this);
    }

    @Override
    public String toString(){
        return this.orientation.toString();
    }

    public void move(MoveDirection direction){
        Vector2d tmpPosition;
        switch(direction){
            case RIGHT:orientation = orientation.next();break;
            case LEFT:orientation = orientation.previous();break;
            case FORWARD:
                tmpPosition = position.add(orientation.toUnitVector());
                if( map.canMoveTo(tmpPosition)){
                    position = tmpPosition;
                }
                break;
            case BACKWARD:
                tmpPosition = position.subtract(orientation.toUnitVector());
                if(map.canMoveTo(tmpPosition) )
                    position = tmpPosition;
                break;
        }

    }

}
