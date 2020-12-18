package agh.cs.lab1;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileReader {
    private JSONObject jsonObject;

    FileReader(String filePath) {
        try {
            String contents = new String((Files.readAllBytes(Paths.get(filePath))));
            this.jsonObject = new JSONObject(contents);
            System.out.println(jsonObject.get("startEnergy"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }


  int getGrassEnergy(){
      return Integer.parseInt(jsonObject.get("plantEnergy").toString());
  }
  int getDailyEnergyCost(){
      return Integer.parseInt( jsonObject.get("moveEnergy").toString());
  }

  int getGrassPerDayValue(){
      return 2;
  }

  int getWidth(){
      return Integer.parseInt( jsonObject.get("width").toString());
  }

    int getHeight(){
        return Integer.parseInt( jsonObject.get("height").toString());
    }

  int getJungleRatio(){
        return Integer.parseInt((jsonObject.get("jungleRatio").toString()));
  }
}
