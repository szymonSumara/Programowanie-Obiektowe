package sumara.pathfindingVisualizer.Algoritms;

import sumara.pathfindingVisualizer.Board.Board;
import sumara.pathfindingVisualizer.Board.BoardField;
import sumara.pathfindingVisualizer.Aplication.Application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class algorithmDFS extends algorithm  {

    public algorithmDFS(Board board,Application application){
        super(board,application);
        super.collection = new Stack<>();
    }

    public void step(){
        super.step();
        if(super.collection instanceof Stack ) {
            Stack<BoardField> s = (Stack) super.collection;
            BoardField boardField = s.lastElement();
            BoardField next = null;

            while(!s.empty()){
                System.out.println("aaa");
                for (BoardField child : board.getNeighbors(boardField.getPosition()))
                    if (child.canBeVisit()) {
                        next = child;
                    }

                if(next != null)
                    break;

                boardField = s.pop();
            }
            System.out.println(s.size());
            System.out.println(next);
            if ( next != null) {

                if(lastField != null) {
                    lastField.setAsVisited();

                }
                lastField = boardField;
                next.setParent(boardField);
                boardField.setAsActual();

                s.add(next);
            }
        }
    }
}
