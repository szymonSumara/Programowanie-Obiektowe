package agh.cs.lab1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap {

    private final Map<Vector2d, Grass> grasses = new HashMap<>();
    private final MapBoundary mapBoundary = new MapBoundary();

    public GrassField(int n) {
        int range = (int) Math.sqrt(n * 10);

        int inserted = 0;
        while (inserted < n) {

            Random rand = new Random();
            int x = rand.nextInt(range);
            int y = rand.nextInt(range);

            if (!isOccupied(new Vector2d(x, y))) {
                Grass tmpGrass = new Grass(this, new Vector2d(x, y));
                grasses.put(new Vector2d(x, y), tmpGrass);
                mapBoundary.place(tmpGrass);
                inserted += 1;
            }
        }
    }

    public boolean place(Animal animal) {
        super.place(animal);
        animal.addObserver(mapBoundary);
        mapBoundary.place(animal);
        return true;
    }

    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object != null)
            return object;
        return grasses.get(position);
    }

    protected Vector2d getSouthWestCorner() {
        return mapBoundary.getSouthWestCorner();
    }

    protected Vector2d getNorthEastCorner() {
        return mapBoundary.getNorthEastCorner();
    }

}
