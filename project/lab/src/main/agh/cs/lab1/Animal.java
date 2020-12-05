package agh.cs.lab1;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Animal extends AbstractWorldMapElement{

    private MapDirection orientation = MapDirection.NORTH;
    private final List<IPositionChangeObserver> observers = new LinkedList<>();
    private int energy;
    private final int[] genType={0,0,0,0,1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7};

    public Animal(IWorldMap map){
        this(map,new Vector2d(2,2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(map, initialPosition);
        map.place(this);
    }

    public boolean addObserver(IPositionChangeObserver observer){
        if(!observers.contains(observer)) {
            observers.add(observer);
            return observers.contains(observer);
        }
        return false;
    }

    public boolean removeObserver(IPositionChangeObserver observer){

        if(observers.contains(observer)){
            observers.remove(observer);
            return !observers.contains(observer);
        }
        return false;
    }



    @Override
    public String toString(){
        return this.orientation.toString();
    }

    public void move(){
        this.orientation = orientation.rotate(this.genType[new Random().nextInt(genType.length)]);
        Vector2d oldPosition = this.position;
        this.position = this.position.add(this.orientation.toUnitVector());
        this.positionChanged(oldPosition,this.position);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for( IPositionChangeObserver observer : observers )
            observer.positionChanged(oldPosition, newPosition);
    }

}
