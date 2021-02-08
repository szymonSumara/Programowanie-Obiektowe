package sumara.pathfindingVisualizer.Algoritms;

import sumara.pathfindingVisualizer.Aplication.Application;
import sumara.pathfindingVisualizer.Board.Board;
import sumara.pathfindingVisualizer.Board.BoardField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public abstract class Algorithm implements IPathFindingAlgorithm, ActionListener {

    public final Board board;
    protected Collection<BoardField> collection;
    private final Timer timer;
    private boolean wasStarted = false;
    protected BoardField lastField = null;
    private final Application application;
    private final AlgorithmVisualizer algorithmVisualizer;

    public Algorithm(Board board, Application application) {
        this.board = board;
        this.application = application;
        this.timer = new Timer(this.application.getDelay(), this);
        this.algorithmVisualizer = new AlgorithmVisualizer(application, board);
    }

    public void run() {

        if (wasStarted && !board.getEndNode().canBeVisit())
            this.clearAlgorithmData();

        if (!wasStarted) {
            wasStarted = true;
            collection.add(board.getStartNode());
        }

        timer.start();
    }

    protected void step() {
        this.timer.setDelay(this.application.getDelay());
    }

    public void clearAlgorithmData() {
        this.lastField = null;
        this.wasStarted = false;
        this.collection.clear();
        this.board.clear();
        this.algorithmVisualizer.clearData();
    }

    public void stop() {
        timer.stop();
    }

    public void actionPerformed(ActionEvent e) {
        if (this.board.getEndNode().isVisited()) {

            if (lastField != null)
                lastField.setAsVisited();

            this.timer.stop();
            algorithmVisualizer.run();
        } else if (collection.isEmpty())
            timer.stop();
        else
            this.step();
    }


    public boolean isRunning() {
        return this.timer.isRunning() || this.algorithmVisualizer.isRunning();
    }

}
