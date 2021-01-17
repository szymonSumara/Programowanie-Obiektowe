package sumara.pathfindingVisualizer.aplication;

import sumara.pathfindingVisualizer.Visualization.IUserInterface;

public class Application {

    IUserInterface userInterface;


    public Application(IUserInterface userInterface){
        this.userInterface = userInterface;
        userInterface.showUserInterface();


    }


}
