package sumara.pathfindingVisualizer.Aplication;

import sumara.pathfindingVisualizer.Algoritms.*;
import sumara.pathfindingVisualizer.Board.Board;
import sumara.pathfindingVisualizer.Board.BoardFieldContest;
import sumara.pathfindingVisualizer.Board.RandomWallGenerator;
import sumara.pathfindingVisualizer.Board.Vector2d;
import sumara.pathfindingVisualizer.Visualization.ApplicationInterface;

public class Application {

    ApplicationInterface userInterface;
    public Board board;
    public IPathFindingAlgorithm pathFindingAlgorithm = null;
    public Integer delay = 2;
    public Integer InsertWallChange = 25;
    public Integer boardSize = 50;


    public Application(){
        this.board = new Board(boardSize,boardSize);
        this.userInterface = new ApplicationInterface(this,board.getVisualisation());
    }


    public void runAlgorithm() throws InterruptedException {
        if(pathFindingAlgorithm != null)
            pathFindingAlgorithm.run();
    }

    public void selectAlgorithm(String algorithmName){
        switch (algorithmName) {
            case "algorithmBFS":
                this.pathFindingAlgorithm=new algorithmBFS(this.board,this);
                break;
            case "algorithmDFS":
                this.pathFindingAlgorithm=new algorithmDFS(this.board,this);
                break;
            case "algorithmGreedy":
                this.pathFindingAlgorithm=new algorithmGreedy(this.board,this);
        }
    }


    public void addElementAt(BoardFieldContest itemToInsert, Vector2d boardField){
            if (itemToInsert == BoardFieldContest.STARTNODE)
                this.board.addStartNode(boardField);
            if (itemToInsert == BoardFieldContest.ENDNODE)
                this.board.addEndNode(boardField);
            if (itemToInsert == BoardFieldContest.WALLNODE)
                this.board.addWallNode(boardField);
    }


    public void setInsertWallChange(Integer insertWallChange) {
        InsertWallChange = insertWallChange;
    }

    public void setBoardSize(Integer boardSize) {
        if(this.boardSize != boardSize) {
            this.boardSize = boardSize;
            this.board = new Board(boardSize,boardSize);
            this.userInterface.changeBoardVisualisation(this.board.getVisualisation());
        }
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public Integer getDelay() {
        return delay;
    }

    public Integer getBoardSize() {
        return boardSize;
    }

    public Integer getInsertWallChange() {
        return InsertWallChange;
    }

    public void generateRandomWalls(){
        this.clearWalls();
        RandomWallGenerator.generateWall(InsertWallChange/100.0,this.board);
    }

    public void clearWalls(){
        this.board.clearWalls();
    }

    public void clear(){
        this.stopPathFindingAlgorithm();
        this.pathFindingAlgorithm.clearAlgorithmData();
        this.board.clear();
    }

    public void stopPathFindingAlgorithm(){
        pathFindingAlgorithm.stop();
    }
}
