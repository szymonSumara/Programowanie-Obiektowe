package sumara.pathfindingVisualizer.Algoritms;

import sumara.pathfindingVisualizer.Aplication.Application;
import sumara.pathfindingVisualizer.Board.Board;
import sumara.pathfindingVisualizer.Board.BoardField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AlgorithmVisualizer implements ActionListener {
    private BoardField actualFieldInPathConstructing = null;
    private final Board board;
    private final Application relatedApplication;
    private Timer timer;


    AlgorithmVisualizer(Application relatedApplication , Board board){
        this.board = board;
        this.actualFieldInPathConstructing = board.getEndNode();
        this.relatedApplication = relatedApplication;
        this.timer = new Timer(this.relatedApplication.getDelay(),this);
    }

    public void run(){
        this.timer.start();
    }

    public void actionPerformed(ActionEvent e) {

        if(actualFieldInPathConstructing == board.getStartNode())
            this.timer.stop();
        else
            constructPathStep();

    }

    public void constructPathStep(){
        actualFieldInPathConstructing.setAsOnPath();
        actualFieldInPathConstructing = actualFieldInPathConstructing.getParent();
    }
}
