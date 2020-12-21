package agh.cs.lab;

public class AnimalTest {
   /* @Test
    public void toStringTest() {
        IWorldMap map = new RectangularMap(4, 4);
        Animal animal = new Animal(map, new Vector2d(2, 2));

        assertEquals("^", animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals(">", animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("v", animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("<", animal.toString());
    }

    @Test
    public void orientationTest() {
        IWorldMap map = new RectangularMap(4, 4);
        Animal animal = new Animal(map, new Vector2d(2, 2));

        assertEquals("^", animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals(">", animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("v", animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("<", animal.toString());
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        assertEquals("^", animal.toString());

    }

    @Test
    public void borderTest() {
        IWorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(map, new Vector2d(2, 2));

        for (int i = 0; i < 5; i++)
            animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 4), animal.getPosition());
        animal.move(MoveDirection.RIGHT);

        for (int i = 0; i < 5; i++)
            animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4, 4), animal.getPosition());
        animal.move(MoveDirection.RIGHT);

        for (int i = 0; i < 5; i++)
            animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4, 0), animal.getPosition());
        animal.move(MoveDirection.RIGHT);

        for (int i = 0; i < 5; i++)
            animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(0, 0), animal.getPosition());

    }

    @Test
    public void addAndRemoveObserverTest() {
        IWorldMap map1 = new RectangularMap(4, 4);
        IWorldMap map2 = new RectangularMap(4, 4);
        IWorldMap map3 = new GrassField(10);

        Animal animal = new Animal(map1, new Vector2d(2, 2));

        assertFalse(animal.addObserver((IPositionChangeObserver) map1));
        assertTrue(animal.addObserver((IPositionChangeObserver) map2));
        assertFalse(animal.addObserver((IPositionChangeObserver) map2));
        assertTrue(animal.removeObserver((IPositionChangeObserver) map2));
        assertTrue(animal.addObserver((IPositionChangeObserver) map2));
        assertTrue(animal.addObserver((IPositionChangeObserver) map3));
    }

*/
}
