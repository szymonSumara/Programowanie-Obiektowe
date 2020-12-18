package agh.cs.lab1;


import java.util.*;
import java.util.stream.Collectors;

public class EvolutionMap implements IPositionChangeObserver {


    private final Vector2d southWestCorner = new Vector2d(0,0);
    private final Vector2d northEastCorner;
    private final Vector2d jungleSouthWestCorner;
    private final Vector2d jungleNorthEastCorner;


    protected final Map<Vector2d, List<Animal>> animals = new HashMap<>();
    private final MapVisualizer mapVisualizer;

    private final List<Vector2d> freeFieldsInJungle = new LinkedList<>();
    private final List<Vector2d> freeFieldsOutJungle = new LinkedList<>();

    private final Map<Vector2d, Grass> grasses = new HashMap<>();


    public EvolutionMap(Vector2d northEastCorner,int jungleRatio){
        this.northEastCorner = northEastCorner;

        int jungleWidth = northEastCorner.x/jungleRatio;
        int jungleHeight = northEastCorner.y/jungleRatio;

        this.jungleSouthWestCorner = new Vector2d((northEastCorner.x - jungleWidth)/2,(northEastCorner.y - jungleHeight)/2);
        this.jungleNorthEastCorner = new Vector2d(jungleSouthWestCorner.x + jungleWidth,jungleSouthWestCorner.y + jungleHeight);

        this.mapVisualizer  = new MapVisualizer(this);
        for(int i = 0;i<=this.northEastCorner.x;i++)
            for(int j=0;j<=this.northEastCorner.y;j++) {
                this.animals.put(new Vector2d(i, j), new LinkedList<>());

                if( isInJungle(new Vector2d(i,j)) )
                    this.freeFieldsInJungle.add(new Vector2d(i,j));
                else
                    this.freeFieldsOutJungle.add(new Vector2d(i,j));

            }

    }

    public boolean placeGrassInJungle(){
        System.out.println(freeFieldsInJungle.size());
        if(freeFieldsInJungle.isEmpty()){
            System.out.println("ala ma asa");
            return false;
        }
        int randomIndex = new Random().nextInt(freeFieldsInJungle.size());
        grasses.put(freeFieldsInJungle.get(randomIndex),new Grass(this,freeFieldsInJungle.get(randomIndex)));
        freeFieldsInJungle.remove(randomIndex);
        return true;
    }

    public boolean placeGrassOutJungle(){
        if(freeFieldsOutJungle.isEmpty())
            return false;
        int randomIndex = new Random().nextInt(freeFieldsOutJungle.size());
        grasses.put(freeFieldsOutJungle.get(randomIndex),new Grass(this,freeFieldsOutJungle.get(randomIndex)));
        freeFieldsOutJungle.remove(randomIndex);
        return true;
    }

    public boolean canMoveTo(Vector2d position){
        if(position.follows(getSouthWestCorner()) && position.precedes(getNorthEastCorner()))
            return true;
        return false;
    }


    public Object objectAt(Vector2d position){
        if(!animals.get(position).isEmpty())
            return animals.get(position).get(0);
        return grasses.get(position);
    }


    public Object getObjectAt(Vector2d position){
        if(!getAnimalsAt(position).isEmpty())
            return getAnimalsAt(position).get(0);
        if(getGrassAt(position)!=null)
            return getGrassAt(position);
        return null;
    }

    public Grass getGrassAt(Vector2d position){
        return grasses.get(position);
    }

    public List<Animal> getAnimalsAt(Vector2d position){
        return animals.get(position).stream()
                    .sorted((o1,o2) -> o1.compareTo(o2))
                    .collect(Collectors.toList());
    }

    public void removeGrass(Vector2d position){
        grasses.remove(position);System.out.println(grasses.size());;
    }

    public void removeAnimal(Animal animal){
        if(this.animals.get( animal.getPosition()).size() == 1)
            if(this.isInJungle(animal.getPosition()))
                this.freeFieldsInJungle.add(animal.getPosition());
            else
                this.freeFieldsOutJungle.add(animal.getPosition());
        animals.get(animal.getPosition()).remove(animal);
    }

    public MapVisualizer getVisualistaion(){
        return  mapVisualizer;
    }


    public Vector2d getNorthEastCorner(){
        return northEastCorner;
    };

    public Vector2d getSouthWestCorner(){
        return southWestCorner;
    };



    private boolean isInJungle(Vector2d position){
        return  position.follows(jungleSouthWestCorner) && position.precedes(jungleNorthEastCorner);
    }

    public boolean place(Animal animal){
        List<Animal> animalsAtList= animals.get(animal.getPosition());
        animalsAtList.add(animal);
        animal.addObserver(this);
        if( isInJungle(animal.getPosition()) )
            freeFieldsInJungle.remove(animal.getPosition());
        else
            freeFieldsOutJungle.remove(animal.getPosition());


        return true;
    }


    public void positionChanged(Vector2d oldPosition,Vector2d newPosition,AbstractWorldMapElement element){
        if(!(element instanceof Animal))
            return;

        List<Animal> animalsListR = animals.get(oldPosition);
        List<Animal> animalsListI = animals.get(newPosition);
        animalsListI.add((Animal) element);
        animalsListR.remove(element);

        if( isInJungle(newPosition) )
            freeFieldsInJungle.remove(newPosition);
        else
            freeFieldsOutJungle.remove(newPosition);

        if(animalsListR.isEmpty())
            if (isInJungle(oldPosition))
                freeFieldsInJungle.add(oldPosition);
            else
                freeFieldsOutJungle.add(oldPosition);

    }


}
