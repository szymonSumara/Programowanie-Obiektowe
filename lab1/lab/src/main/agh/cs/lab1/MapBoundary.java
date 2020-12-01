package agh.cs.lab1;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class MapBoundary implements IPositionChangeObserver {
    private final List<Pair<Vector2d, AbstractWorldMapElement>> mapElementsOrderedX = new LinkedList<>();
    private final List<Pair<Vector2d, AbstractWorldMapElement>> mapElementsOrderedY = new LinkedList<>();

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

        AbstractWorldMapElement changedPosition = mapElementsOrderedX.get(0).getValue();

        for (Pair<Vector2d, AbstractWorldMapElement> element : mapElementsOrderedY)
            if (element.getKey().equals(oldPosition) && element.getValue().getPosition().equals(newPosition)) {
                changedPosition = element.getValue();
                mapElementsOrderedY.remove(element);
                break;
            }

        for (Pair<Vector2d, AbstractWorldMapElement> element : mapElementsOrderedX)
            if (element.getKey().equals(oldPosition) && element.getValue().getPosition().equals(newPosition)) {
                mapElementsOrderedX.remove(element);
                break;
            }

        this.place(newPosition, changedPosition);
    }

    public void place(AbstractWorldMapElement mapElement) {
        this.place(mapElement.getPosition(), mapElement);
    }

    private void place(Vector2d position, AbstractWorldMapElement mapElement) {
        int yOrderIndex = 0;
        int xOrderIndex = 0;

        for (Pair<Vector2d, AbstractWorldMapElement> element : mapElementsOrderedX) {
            if (position.equals(element.getKey()) && mapElement instanceof Animal)
                break;
            else if (position.isAfterInXOrder(element.getKey()))
                xOrderIndex += 1;
            else
                break;
        }

        mapElementsOrderedX.add(xOrderIndex, new Pair<>(mapElement.getPosition(), mapElement));

        for (Pair<Vector2d, AbstractWorldMapElement> element : mapElementsOrderedY) {
            if (position.isAfterInYOrder(element.getKey()))
                yOrderIndex += 1;
            else
                break;
        }

        mapElementsOrderedY.add(yOrderIndex, new Pair<>(mapElement.getPosition(), mapElement));
    }


    public Vector2d getSouthWestCorner() {
        return mapElementsOrderedX.get(0).getKey().lowerLeft(mapElementsOrderedY.get(0).getKey());
    }

    public Vector2d getNorthEastCorner() {
        return mapElementsOrderedX.get(mapElementsOrderedX.size() - 1).getKey().upperRight(mapElementsOrderedY.get(mapElementsOrderedY.size() - 1).getKey());
    }

}
