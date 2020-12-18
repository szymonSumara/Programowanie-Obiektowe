package agh.cs.lab1;

public class SimulationApplication {
    private final SimulationUserInterface simulationUserInterface;
    private final FileReader fileReader;

    SimulationApplication(){
        this.simulationUserInterface = new SimulationUserInterface(this);
        //simulationUserInterface.showUserInterface();
        this.fileReader = new FileReader("D:\\Studies\\Computer Sience 2019-2024\\Semester 3\\Programowanie Obiektowe\\project\\lab\\src\\main\\agh\\cs\\lab1\\data.jsonc");

        new SimulationEngine(new EvolutionMap( new Vector2d(fileReader.getWidth(),fileReader.getHeight()),fileReader.getJungleRatio()),
                new Statistic(),
                fileReader.getGrassEnergy(),
                fileReader.getDailyEnergyCost(),
                fileReader.getGrassPerDayValue()).run();;


    }

    public  void oneSimulationStart() {

        //this.simulationUserInterface.hideUserInterface();
        /*new SimulationEngine(new EvolutionMap(), new Statistic(),
                simulationUserInterface.getGrassEnergy(),
                simulationUserInterface.getDailyEnergyCost(),
                simulationUserInterface.getGrassPerDayValue()).run();;

        //this.simulationUserInterface.showUserInterface();*/
    }

    public  void twoSimulationStart() {

        //this.simulationUserInterface.hideUserInterface();
       /* System.out.println("ala");
        new SimulationEngine(new EvolutionMap(), new Statistic(),
                simulationUserInterface.getGrassEnergy(),
                simulationUserInterface.getDailyEnergyCost(),
                simulationUserInterface.getGrassPerDayValue()).run();;
        System.out.println("ala");
        new SimulationEngine(new EvolutionMap(), new Statistic(),
                simulationUserInterface.getGrassEnergy(),
                simulationUserInterface.getDailyEnergyCost(),
                simulationUserInterface.getGrassPerDayValue()).run();;
        System.out.println("ala");
        //this.simulationUserInterface.showUserInterface();*/
    }


}
