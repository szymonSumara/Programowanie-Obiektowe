package agh.cs.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SymulatorEngineTest{
    @Test
    public void runTest(){


        MoveDirection[] directions = new OptionsParser().parse(new String [] {"f", "b", "r", "l", "f", "f", "r", "r","f","f","f","f","f","f","f","f"});

        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertFalse(map.objectAt(new Vector2d(0,0)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(2,0)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(3,5)) instanceof Animal);

    }



}
