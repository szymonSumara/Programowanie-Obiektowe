package sumara.pathfindingVisualizer.Algoritms;

import sumara.pathfindingVisualizer.Aplication.Application;
import sumara.pathfindingVisualizer.Board.Board;
import sumara.pathfindingVisualizer.Board.BoardField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public abstract class algorithm  implements IPathFindingAlgorithm, ActionListener {

    public final Board board;
    public Collection<BoardField> collection;
    private final Timer timer;
    private boolean wasStarted = false;
    public BoardField lastField = null;
    private final Application application;

    public algorithm(Board board,Application application){
        this.board = board;
        this.application = application;
        this.timer = new Timer( this.application.delay,this);
    }

    public void run() throws InterruptedException {
        if (!wasStarted) {
            wasStarted = true;
            collection.add(board.getStartNode());
        }
        timer.start();
    }

    public void step(){
        this.timer.setDelay(this.application.delay);
    }

    public void clearAlgorithmData(){
        this.lastField = null;
        this.wasStarted = false;
        this.collection.clear();
    }

    public void stop(){
        timer.stop();
    }

    public void actionPerformed(ActionEvent e) {
        if(this.board.getEndNode().isVisited()){
            if(lastField != null )
                lastField.setAsVisited();
            this.timer.stop();
            AlgorithmVisualizer algorithmVisualizer = new AlgorithmVisualizer(application,board);
            algorithmVisualizer.run();
        }
        else if(collection.isEmpty())
            timer.stop();
        else
            this.step();
    }

}
