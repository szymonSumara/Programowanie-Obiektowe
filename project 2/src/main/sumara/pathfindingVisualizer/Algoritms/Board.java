package sumara.pathfindingVisualizer.Algoritms;

public class Board {

    private BoardField [][] board ;
    private BoardField startNode;
    private BoardField endNode;

    public Board(int x,int y){
        this.board = new BoardField[x][y];
        this.startNode = null;
        this.endNode = null;
    }

    public boolean addStartNode(int x,int y){
        if(startNode != null && board[x][y].setAsStartNode()) {
            startNode.clear();
            startNode = board[x][y];
        }
        return false;
    }



}
