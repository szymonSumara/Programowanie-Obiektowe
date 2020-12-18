package agh.cs.lab1;

import java.util.LinkedList;
import java.util.List;

public class Statistic {
    private List<Animal> liveAnimals = new LinkedList<>();
    private int deadAnimalsCounter = 0;
    private int grassCounter = 0;
    private float averageLifeTime=0;
    public List<Integer>  animalsDataToPlot;
    public List<Integer> grassDataToPlot;
    private final PlotRender plotRender;

    public Statistic(){
        this.animalsDataToPlot= new LinkedList<>();
        this.grassDataToPlot= new LinkedList<>();
        this.plotRender = new PlotRender(this);
    }

    public boolean addAnimal(Animal animal){
        liveAnimals.add(animal);
        return true;
    }

    public boolean addGrass(){
        grassCounter+=1;
        return true;
    }

    public boolean removeGrass(){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + grassCounter);
        grassCounter-=1;
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + grassCounter);
        return true;
    }

    public PlotRender getPlotRender() {
        return plotRender;
    }

    public void updatePlot(){
        this.plotRender.updateLabels();
        animalsDataToPlot.add(liveAnimals.size());
        if(animalsDataToPlot.size()>100)
            animalsDataToPlot.remove(0);

        grassDataToPlot.add(grassCounter);
        if(grassDataToPlot.size()>100)
            grassDataToPlot.remove(0);


    }

    public int getGrasCounter(){
        return this.grassCounter;
    }

    public boolean removeAnimal(Animal animal){
        this.averageLifeTime = (this.averageLifeTime*this.deadAnimalsCounter + animal.getLiveTime())/(this.deadAnimalsCounter + 1);
        this.deadAnimalsCounter+=1;

        liveAnimals.remove(animal);
        return true;
    }

    public float getAverageAnimalsEnergy(){
        float energySum=0;

        for(Animal animal:liveAnimals)
            energySum += animal.getEnergy();

        return energySum/liveAnimals.size();

    }

    public float getAverageChildNumberForLivingAnimals(){
        float childNumber=0;
        for(Animal animal:liveAnimals)
            childNumber+=animal.childrenNum;
        return childNumber/liveAnimals.size();

    }

    public float getAnimalsNumber(){
        return liveAnimals.size();

    }

    public float getAverageLifeTime(){
        return averageLifeTime;
    }

    @Override
    public String toString(){
        return "Live animals:" + this.liveAnimals.size() + " Dead animals:" + this.deadAnimalsCounter +
                " averageLifeTime:" +  averageLifeTime + " averageEnergy: " + getAverageAnimalsEnergy() +
                " averageChildNum: " + getAverageChildNumberForLivingAnimals() + " grassOnMap: " + getGrasCounter() ;
    }


}
