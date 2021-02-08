package sumara.pathfindingVisualizer.Board;

import java.awt.*;

public class BoardField {

    BoardFieldContest boardFieldContest = BoardFieldContest.FREENODE;

    private final Board relatedBoard;
    private final Vector2d position;
    private boolean visited = false;
    private BoardField parent;


    public BoardField(Vector2d position, Board board) {
        this.relatedBoard = board;
        this.position = position;

    }

    public void setParent(BoardField parent) {
        if (this.parent == null)
            this.parent = parent;
    }

    public BoardField getParent() {
        return parent;
    }

    public void placeWall() {
        if (this.boardFieldContest != BoardFieldContest.STARTNODE && this.boardFieldContest != BoardFieldContest.ENDNODE) {
            this.boardFieldContest = BoardFieldContest.WALLNODE;
            this.notifyBoard();

        } else
            removeWall();
    }

    public void removeWall() {
        if (this.boardFieldContest == BoardFieldContest.WALLNODE) {
            this.boardFieldContest = BoardFieldContest.FREENODE;
            this.notifyBoard();
        }
    }

    public void clear() {
        this.visited = false;
        this.parent = null;
        if (boardFieldContest == BoardFieldContest.ONPATH || boardFieldContest == BoardFieldContest.VISITED || boardFieldContest == BoardFieldContest.ACTUALNODE)
            this.boardFieldContest = BoardFieldContest.FREENODE;
        this.notifyBoard();
    }

    public void setAsFree() {
        this.boardFieldContest = BoardFieldContest.FREENODE;
        this.notifyBoard();
    }

    public boolean setAsStart() {
        if (this.boardFieldContest != BoardFieldContest.ENDNODE
                && this.boardFieldContest != BoardFieldContest.STARTNODE) {
            this.boardFieldContest = BoardFieldContest.STARTNODE;
            this.notifyBoard();
            return true;
        }
        return false;
    }

    public boolean setAsEnd() {
        if (this.boardFieldContest != BoardFieldContest.STARTNODE
                && this.boardFieldContest != BoardFieldContest.ENDNODE) {
            this.boardFieldContest = BoardFieldContest.ENDNODE;
            this.notifyBoard();
            return true;
        }
        return false;
    }

    public Vector2d getPosition() {
        return this.position;

    }

    private void notifyBoard() {
        relatedBoard.updateFieldAt(this.getPosition());
    }

    public Color getColor() {
        return this.boardFieldContest.getColor();
    }

    public boolean canBeVisit() {
        return !visited && this.boardFieldContest != BoardFieldContest.WALLNODE;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setAsVisited() {
        if (this.boardFieldContest != BoardFieldContest.ENDNODE && this.boardFieldContest != BoardFieldContest.STARTNODE)
            this.boardFieldContest = BoardFieldContest.VISITED;
        this.visited = true;
        this.notifyBoard();
    }

    public void setAsOnPath() {
        if (this.boardFieldContest != BoardFieldContest.ENDNODE && this.boardFieldContest != BoardFieldContest.STARTNODE)
            this.boardFieldContest = BoardFieldContest.ONPATH;
        this.notifyBoard();
    }

    public void setAsActual() {
        if (this.boardFieldContest != BoardFieldContest.ENDNODE && this.boardFieldContest != BoardFieldContest.STARTNODE) {
            this.boardFieldContest = BoardFieldContest.ACTUALNODE;
            this.notifyBoard();
        }
    }

}
