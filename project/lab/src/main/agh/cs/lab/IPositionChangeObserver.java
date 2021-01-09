package agh.cs.lab;

public interface IPositionChangeObserver {
    void positionChanged(Vector2d oldPosition, Vector2d newPosition,Animal animal); // jest potrzeba przekazywać nową pozycję, skoro przekazuje Pan całe zwierzę?
}
