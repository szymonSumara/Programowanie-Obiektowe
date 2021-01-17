package sumara.pathfindingVisualizer.Algoritms;

public class BoardField {

    private  BoardFieldContest boardFieldContest = BoardFieldContest.FREE;

    public boolean placeWall(){
        if(this.boardFieldContest == BoardFieldContest.FREE){
            this.boardFieldContest = BoardFieldContest.WALL;
            return true;
        }
        if(this.boardFieldContest == BoardFieldContest.WALL){
            this.boardFieldContest = BoardFieldContest.FREE;
            return true;
        }

        return false;
    }

    public boolean clear(){
        this.boardFieldContest = BoardFieldContest.FREE;
        return false;
    }

    public boolean setAsStartNode(){
        if(this.boardFieldContest != BoardFieldContest.ENDNODE
            && this.boardFieldContest != BoardFieldContest.STARTNODE)
            this.boardFieldContest = BoardFieldContest.STARTNODE;

    }

    public void setAsEndNode(){
        this.boardFieldContest = BoardFieldContest.ENDNODE;
    }
}
