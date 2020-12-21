package agh.cs.lab;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class StartDataFileReader implements ISimulationDataCollector {
    private JSONObject jsonObject;

    StartDataFileReader(String filePath) {
        try {
            String contents = new String((Files.readAllBytes(Paths.get(filePath))));
            this.jsonObject = new JSONObject(contents);
            System.out.println(jsonObject.get("startEnergy"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getGrassEnergy() {
        return Integer.parseInt(jsonObject.get("plantEnergy").toString());
    }

    public int getDailyEnergyCost() {
        return Integer.parseInt(jsonObject.get("moveEnergy").toString());
    }

    public int getGrassPerDayValue() {
        return 20;
    }

    public int getMapWidth() {
        return Integer.parseInt(jsonObject.get("width").toString());
    }

    public int getMapHeight() {
        return Integer.parseInt(jsonObject.get("height").toString());
    }

    public int getJungleRatio() {
        return Integer.parseInt((jsonObject.get("jungleRatio").toString()));
    }

    public int getStartEnergy() {
        return Integer.parseInt((jsonObject.get("startEnergy").toString()));
    }

    public int getStartAnimalNum() {
        return Integer.parseInt(jsonObject.get("startAnimalNum").toString());
    }

}
