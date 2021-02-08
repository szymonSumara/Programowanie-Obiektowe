package sumara.pathfindingVisualizer.Board;

import java.util.LinkedList;
import java.util.List;

public class Board {

    private final BoardField[][] board;
    private BoardField startNode = null;
    private BoardField endNode = null;
    private final BoardVisualisation boardVisualisation;
    private final Vector2d boardSize;


    public Board(int x, int y) {
        this.boardSize = new Vector2d(x - 1, y - 1);
        this.board = new BoardField[x][y];

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                board[i][j] = new BoardField(new Vector2d(i, j), this);

        this.boardVisualisation = new BoardVisualisation(this);
    }

    public void addStartNode(Vector2d position) {
        if (board[position.x][position.y].setAsStart()) {
            if (startNode != null)
                startNode.setAsFree();
            startNode = board[position.x][position.y];
        }
    }

    public void addEndNode(Vector2d position) {
        if (board[position.x][position.y].setAsEnd()) {
            if (endNode != null)
                endNode.setAsFree();
            endNode = board[position.x][position.y];
        }
    }

    public void addWallNode(Vector2d position) {
        board[position.x][position.y].placeWall();
        this.updateFieldAt(position);

    }

    public BoardVisualisation getVisualisation() {
        return boardVisualisation;
    }

    public BoardField getFieldAt(Vector2d position) {
        return board[position.x][position.y];
    }

    public List<BoardField> getNeighbors(Vector2d position) {
        List<BoardField> toReturn = new LinkedList<>();

        if (position.x + 1 < this.boardSize.x)
            toReturn.add(this.board[position.x + 1][position.y]);

        if (position.y + 1 < this.boardSize.y)
            toReturn.add(this.board[position.x][position.y + 1]);

        if (position.x - 1 >= 0)
            toReturn.add(this.board[position.x - 1][position.y]);

        if (position.y - 1 >= 0)
            toReturn.add(this.board[position.x][position.y - 1]);

        return toReturn;
    }

    public void updateFieldAt(Vector2d position) {
        this.boardVisualisation.updateField(position);
    }

    public Vector2d getBoardSize() {
        return boardSize;
    }

    public void clearWalls() {
        for (int i = 0; i < this.boardSize.x; i++)
            for (int j = 0; j < this.boardSize.y; j++)
                board[i][j].removeWall();
    }

    public void clear() {
        for (int i = 0; i < this.boardSize.x; i++)
            for (int j = 0; j < this.boardSize.y; j++)
                board[i][j].clear();
    }

    public BoardField getStartNode() {
        return startNode;
    }

    public BoardField getEndNode() {
        return endNode;
    }
}
