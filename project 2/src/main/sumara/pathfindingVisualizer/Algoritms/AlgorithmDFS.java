package sumara.pathfindingVisualizer.Algoritms;

import sumara.pathfindingVisualizer.Board.Board;
import sumara.pathfindingVisualizer.Board.BoardField;
import sumara.pathfindingVisualizer.Aplication.Application;

import java.util.Stack;

public class AlgorithmDFS extends Algorithm {

    public AlgorithmDFS(Board board, Application application) {
        super(board, application);
        super.collection = new Stack<>();
    }

    public void step() {
        super.step();
        if (super.collection instanceof Stack) {
            Stack<BoardField> stack = (Stack<BoardField>) super.collection;
            BoardField boardField = stack.lastElement();
            BoardField next = null;

            while (!stack.empty()) {
                for (BoardField child : board.getNeighbors(boardField.getPosition()))
                    if (child.canBeVisit())
                        next = child;
                if (next != null)
                    break;

                boardField = stack.pop();
            }

            if (next != null) {

                if (lastField != null)
                    lastField.setAsVisited();


                lastField = boardField;
                next.setParent(boardField);
                boardField.setAsActual();
                stack.add(next);
            }
        }
    }
}
