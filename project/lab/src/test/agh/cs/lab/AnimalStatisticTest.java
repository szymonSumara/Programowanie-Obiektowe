package agh.cs.lab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalStatisticTest{


    @Test
    public void getAverageAnimalsEnergy(){
        Statistic stat = new Statistic();
        EvolutionMap map = new EvolutionMap(20,20,3,100);

        Animal animalOne =  new Animal(map,new Vector2d(2,2));
        Animal animalTwo = new Animal(map,new Vector2d(10,10));

        stat.changeObjectState(animalOne,StatisticEvent.ADD_ELEMENT);
        assertEquals(100,stat.getAverageAnimalsEnergy());


        stat.changeObjectState(animalTwo,StatisticEvent.ADD_ELEMENT);

        assertEquals(100,stat.getAverageAnimalsEnergy());

        stat.changeObjectState(animalOne.reproduce(animalTwo),StatisticEvent.ADD_ELEMENT);

        assertEquals(66,(int)stat.getAverageAnimalsEnergy());


    }



    //@Test getAverageChildNumberForLivingAnimals()

}
