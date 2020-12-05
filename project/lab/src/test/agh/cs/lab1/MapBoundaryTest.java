package agh.cs.lab1;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapBoundaryTest {
    @Test
    public void placeAndGetsTest(){
        MapBoundary mapBoundary = new MapBoundary();
        GrassField map = new GrassField(0);
        mapBoundary.place(new Animal(map,new Vector2d(1,2)));

        assertEquals(new Vector2d(1,2),mapBoundary.getNorthEastCorner());
        assertEquals(new Vector2d(1,2),mapBoundary.getSouthWestCorner());

        mapBoundary.place(new Animal(map,new Vector2d(3,7)));

        assertEquals(new Vector2d(1,2),mapBoundary.getSouthWestCorner());
        assertEquals(new Vector2d(3,7),mapBoundary.getNorthEastCorner());

        mapBoundary.place(new Animal(map,new Vector2d(-10,12)));

        assertEquals(new Vector2d(-10,2),mapBoundary.getSouthWestCorner());
        assertEquals(new Vector2d(3,12),mapBoundary.getNorthEastCorner());

        mapBoundary.place(new Animal(map,new Vector2d(1,8)));

        assertEquals(new Vector2d(-10,2),mapBoundary.getSouthWestCorner());
        assertEquals(new Vector2d(3,12),mapBoundary.getNorthEastCorner());

        mapBoundary.place(new Grass(map,new Vector2d(100,1)));

        assertEquals(new Vector2d(-10,1),mapBoundary.getSouthWestCorner());
        assertEquals(new Vector2d(100,12),mapBoundary.getNorthEastCorner());
    }
}
