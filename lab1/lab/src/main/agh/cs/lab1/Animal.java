package agh.cs.lab1;


import java.util.LinkedList;
import java.util.List;

public class Animal extends AbstractWorldMapElement{

    private MapDirection orientation = MapDirection.NORTH;
    private List<IPositionChangeObserver> observers = new LinkedList<>();

    public Animal(IWorldMap map){
        super(map, new Vector2d(2,2));
        map.place(this);
    }

    public boolean addObserver(IPositionChangeObserver observer){
        observers.add(observer);
        return true;//dodac kontrole błędów
    }

    public boolean removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
        return true;//dodac kontrole błędów;
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
                    positionChanged(position,tmpPosition);
                    position = tmpPosition;
                }
                break;
            case BACKWARD:
                tmpPosition = position.subtract(orientation.toUnitVector());
                if(map.canMoveTo(tmpPosition) )
                    positionChanged(position,tmpPosition);
                    position = tmpPosition;
                break;
        }

    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for( IPositionChangeObserver observer : observers )
            observer.positionChanged(oldPosition, newPosition);
    }

}
