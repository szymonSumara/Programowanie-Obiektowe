package agh.cs.lab1;


public class Animal {
    private Vector2d position = new Vector2d(2, 2);   // lepiej ustawiać pole tylko w konstruktorze, albo tylko inicjalizatorem
    private MapDirection orientatnion = MapDirection.NORTH; // literówka
    private IWorldMap map;  // to może być finalne

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.map = map;
    }

    public Animal() {
        this.map = new RectangularMap(4, 4); // nie najlepszy pomysł, lepiej usunąć konstruktor
        this.map.place(this);   // tutaj jest place, a w pozostałych nie ma
    }

    Vector2d getPosition() {
        return position;
    }


    public String toString() {
        return this.orientatnion.toString();
    }

    public void move(MoveDirection direction) {
        Vector2d tmpPosition;
        switch (direction) {
            case RIGHT:
                orientatnion = orientatnion.next();
                break;
            case LEFT:
                orientatnion = orientatnion.previous();
                break;
            case FORWARD:
                tmpPosition = position.add(orientatnion.toUnitVector());
                if (map.canMoveTo(tmpPosition)) {
                    position = tmpPosition;
                }
                break;
            case BACKWARD:
                tmpPosition = position.subtract(orientatnion.toUnitVector());
                if (map.canMoveTo(tmpPosition))
                    position = tmpPosition;
                break;
        }

    }

}
