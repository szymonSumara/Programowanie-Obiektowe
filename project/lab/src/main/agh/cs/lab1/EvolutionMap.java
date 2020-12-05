package agh.cs.lab1;


import javafx.util.Pair;

import java.util.*;

public class EvolutionMap extends AbstractWorldMap{


    private final Vector2d southWestCorner = new Vector2d(0,0);
    private final Vector2d northEastCorner = new Vector2d(100,30);


    private final List<Vector2d> freeFieldsInJungle = new LinkedList<>();
    private final List<Vector2d> freeFieldsOutJungle = new LinkedList<>();

    private final Vector2d jungleSouthWestCorner = new Vector2d(45,10);
    private final Vector2d jungleNorthEastCorner = new Vector2d(55,20);

    private final Map<Vector2d, Grass> grasses = new HashMap<>();
    public EvolutionMap(int n){
        new Animal(this,new Vector2d(50,15));
        for(int i = 0;i<100;i++)
            for(int j=0;j<30;j++)
                if( i > 45 && i < 55 && j > 10 && j < 20 )
                    freeFieldsInJungle.add(new Vector2d(i,j));
                else
                    freeFieldsOutJungle.add(new Vector2d(i,j));
    }

    protected Vector2d getNorthEastCorner(){
        return northEastCorner;
    };

    protected Vector2d getSouthWestCorner(){
        return southWestCorner;
    };

    public void moveAllAnimals(){
        for(Animal animal : animals.values())
            animal.move();
    }

    public  void growGrass(){
        for(int i=0;i<2;i++)
            if(freeFieldsInJungle.size() > 0){
                int randomIndex = new Random().nextInt(freeFieldsInJungle.size());
                Vector2d vec = freeFieldsInJungle.get(randomIndex);
                freeFieldsInJungle.remove(randomIndex);
                Grass grass = new Grass(this,vec);
                grasses.put(vec,grass);
            }
            else
                break;

        for(int i=0;i<2;i++)
            if(freeFieldsOutJungle.size() > 0){
                int randomIndex = new Random().nextInt(freeFieldsOutJungle.size());
                Vector2d vec = freeFieldsOutJungle.get(randomIndex);
                freeFieldsOutJungle.remove(randomIndex);
                Grass grass = new Grass(this,vec);
                grasses.put(vec,grass);
            }
            else
                break;
    }

    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object != null)
            return object;
        return grasses.get(position);
    }

}
