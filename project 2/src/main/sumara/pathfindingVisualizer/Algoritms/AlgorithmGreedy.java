package sumara.pathfindingVisualizer.Algoritms;

import sumara.pathfindingVisualizer.Board.Board;
import sumara.pathfindingVisualizer.Board.BoardField;
import sumara.pathfindingVisualizer.Aplication.Application;

import java.util.Stack;

public class AlgorithmGreedy extends Algorithm {

    public AlgorithmGreedy(Board board, Application application) {
        super(board, application);
        super.collection = new Stack<>();
    }

    private BoardField actualFieldInPathConstructing = null;

    public void step() {
        super.step();
        if (super.collection instanceof Stack) {
            Stack<BoardField> stack = (Stack<BoardField>) super.collection;

            BoardField boardField = stack.lastElement();

            BoardField nearest = null;

            for (BoardField boardField1 : board.getNeighbors(boardField.getPosition())) {
                if (boardField1.canBeVisit()) {
                    nearest = boardField1;
                    break;
                }
            }

            for (BoardField boardField1 : board.getNeighbors(boardField.getPosition())) {
                if (boardField1.canBeVisit()) {
                    if (nearest == null) {
                        nearest = boardField1;
                    } else if (nearest.getPosition().distance(this.board.getEndNode().getPosition()) >
                            boardField1.getPosition().distance(this.board.getEndNode().getPosition())) {
                        nearest = boardField1;
                    }
                    boardField1.setParent(boardField);
                }
            }

            if (nearest == null) {
                stack.pop();
                if (!stack.empty())
                    this.step();
                return;
            }

            stack.push(nearest);

            if (lastField != null)
                lastField.setAsVisited();

            lastField = nearest;
            nearest.setAsActual();
        }
    }


}
