package sumara.pathfindingVisualizer.Aplication;

import sumara.pathfindingVisualizer.Algoritms.*;
import sumara.pathfindingVisualizer.Board.Board;
import sumara.pathfindingVisualizer.Board.BoardFieldContest;
import sumara.pathfindingVisualizer.Board.RandomWallGenerator;
import sumara.pathfindingVisualizer.Board.Vector2d;
import sumara.pathfindingVisualizer.UserInterface.ApplicationInterface;

public class Application {

    ApplicationInterface userInterface;
    private Board board;
    private IPathFindingAlgorithm pathFindingAlgorithm = null;
    private Integer delay = 2;
    private Integer InsertWallChange = 25;
    private Integer boardSize = 50;


    public Application() {
        this.board = new Board(boardSize, boardSize);
        this.userInterface = new ApplicationInterface(this, board.getVisualisation());
    }


    public void runAlgorithm() {

        if (pathFindingAlgorithm != null)
            pathFindingAlgorithm.run();
    }

    public void selectAlgorithm(String algorithmName) {
        switch (algorithmName) {
            case "algorithmBFS":
                this.pathFindingAlgorithm = new AlgorithmBFS(this.board, this);
                break;
            case "algorithmDFS":
                this.pathFindingAlgorithm = new AlgorithmDFS(this.board, this);
                break;
            case "algorithmGreedy":
                this.pathFindingAlgorithm = new AlgorithmGreedy(this.board, this);
        }
        this.board.clear();
    }


    public void addElementAt(BoardFieldContest itemToInsert, Vector2d boardField) {
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
        System.out.println(this.boardSize.toString() + " " + boardSize);
        if (this.boardSize != (int) boardSize) {
            this.boardSize = boardSize;
            this.board = new Board(boardSize, boardSize);
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

    public void generateRandomWalls() {
        if (!pathFindingAlgorithm.isRunning()) {
            this.clearWalls();
            RandomWallGenerator.generateWall(InsertWallChange / 100.0, this.board);
        }
    }

    public void clearWalls() {
        if (!pathFindingAlgorithm.isRunning())
            this.board.clearWalls();
    }

    public void clear() {
        if (!pathFindingAlgorithm.isRunning()) {
            this.stopPathFindingAlgorithm();
            this.pathFindingAlgorithm.clearAlgorithmData();
            this.board.clear();
        }
    }

    public void stopPathFindingAlgorithm() {
        pathFindingAlgorithm.stop();
    }
}
