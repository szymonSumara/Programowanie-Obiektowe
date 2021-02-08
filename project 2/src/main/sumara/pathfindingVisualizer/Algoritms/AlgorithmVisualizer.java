package sumara.pathfindingVisualizer.Algoritms;

import sumara.pathfindingVisualizer.Aplication.Application;
import sumara.pathfindingVisualizer.Board.Board;
import sumara.pathfindingVisualizer.Board.BoardField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AlgorithmVisualizer implements ActionListener {
    private BoardField actualFieldInPathConstructing;
    private final Board board;
    private final Timer timer;


    AlgorithmVisualizer(Application relatedApplication, Board board) {
        this.board = board;
        this.actualFieldInPathConstructing = board.getEndNode();

        this.timer = new Timer(relatedApplication.getDelay(), this);
    }

    public void run() {
        this.timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (actualFieldInPathConstructing == board.getStartNode())
            this.timer.stop();
        else
            this.constructPathStep();
    }

    public void constructPathStep() {
        this.actualFieldInPathConstructing.setAsOnPath();
        this.actualFieldInPathConstructing = this.actualFieldInPathConstructing.getParent();
    }

    public boolean isRunning() {
        return this.timer.isRunning();
    }

    public void clearData() {
        this.actualFieldInPathConstructing = this.board.getEndNode();
    }
}
