package sumara.pathfindingVisualizer.Algoritms;

import sumara.pathfindingVisualizer.Board.Board;
import sumara.pathfindingVisualizer.Board.BoardField;
import sumara.pathfindingVisualizer.Aplication.Application;

import java.util.LinkedList;
import java.util.Queue;


public class AlgorithmBFS extends Algorithm {


    private boolean wasStarted = false;
    private BoardField actualFieldInPathConstructing = null;

    public AlgorithmBFS(Board board, Application application) {
        super(board, application);
        super.collection = new LinkedList();
    }


    public void step() {
        super.step();

        if (super.collection instanceof Queue) {
            Queue<BoardField> q = (Queue) super.collection;
            BoardField boardField = q.poll();

            while (!boardField.canBeVisit() && !q.isEmpty())
                boardField = q.poll();

            if (boardField.canBeVisit()) {
                if (lastField != null)
                    lastField.setAsVisited();
                lastField = boardField;
                boardField.setAsActual();
                for (BoardField child : board.getNeighbors(boardField.getPosition()))
                    if (child.canBeVisit()) child.setParent(boardField);
                collection.addAll(board.getNeighbors(boardField.getPosition()));
            }
        }
    }


}
