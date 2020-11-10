package agh.cs.lab1;


public class Animal extends AbstractWorldMapElement{

    private MapDirection orientatnion = MapDirection.NORTH;

    public Animal(IWorldMap map){
        this.map = map;
        this.position = new Vector2d(2,2);
        this.map.place(this);
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.position = initialPosition;
        this.map = map;
        this.map.place(this);
    }

    @Override
    public String toString(){
        return this.orientatnion.toString();
    }

    public void move(MoveDirection direction){
        Vector2d tmpPosition;
        switch(direction){
            case RIGHT:orientatnion = orientatnion.next();break;
            case LEFT:orientatnion = orientatnion.previous();break;
            case FORWARD:
                tmpPosition = position.add(orientatnion.toUnitVector());
                if( map.canMoveTo(tmpPosition)){
                    position = tmpPosition;
                }
                break;
            case BACKWARD:
                tmpPosition = position.subtract(orientatnion.toUnitVector());
                if(map.canMoveTo(tmpPosition) )
                    position = tmpPosition;
                break;
        }

    }

}
