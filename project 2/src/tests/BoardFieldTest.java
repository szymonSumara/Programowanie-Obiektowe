import org.junit.jupiter.api.Test;
import sumara.pathfindingVisualizer.Board.Board;
import sumara.pathfindingVisualizer.Board.BoardField;
import sumara.pathfindingVisualizer.Board.BoardFieldContest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardFieldTest {
    /*
    @Test
    public void placeWallTest(){
        BoardField boardField = new BoardField(1,1,new Board(1,1));

        boardField.placeWall();
        assertEquals(BoardFieldContest.WALL,boardField.getState());

        boardField.placeWall();
        assertEquals(BoardFieldContest.FREE,boardField.getState());
    }

    @Test
    public void clearTest(){
        BoardField boardField = new BoardField(1,1,new Board(1,1));

        boardField.placeWall();
        boardField.clear();
        assertEquals(BoardFieldContest.FREE,boardField.getState());

        boardField.setAsEndNode();
        boardField.clear();
        assertEquals(BoardFieldContest.FREE,boardField.getState());

        boardField.setAsStartNode();
        boardField.clear();
        assertEquals(BoardFieldContest.FREE,boardField.getState());
    }

    @Test
    public void setAsStartNodeTest(){
        BoardField boardField = new BoardField(1,1,new Board(1,1));
        boardField.placeWall();
        boardField.setAsStartNode();
        assertEquals(BoardFieldContest.STARTNODE,boardField.getState());

        boardField.clear();
        boardField.setAsStartNode();
        assertEquals(BoardFieldContest.STARTNODE,boardField.getState());
    }

    @Test
    public void setAsSEndNodeTest(){
        BoardField boardField = new BoardField(1,1,new Board(1,1));
        boardField.placeWall();
        boardField.setAsEndNode();
        assertEquals(BoardFieldContest.ENDNODE,boardField.getState());

        boardField.clear();
        boardField.setAsEndNode();
        assertEquals(BoardFieldContest.ENDNODE,boardField.getState());

    }

    @Test
    public void overallTest(){
        BoardField boardField = new BoardField(1,1,new Board(1,1));
        boardField.placeWall();
        boardField.setAsEndNode();
        assertEquals(BoardFieldContest.ENDNODE,boardField.getState());


        boardField.setAsStartNode();
        assertEquals(BoardFieldContest.ENDNODE,boardField.getState());

        boardField.placeWall();
        assertEquals(BoardFieldContest.ENDNODE,boardField.getState());

        boardField.clear();
        boardField.placeWall();
        boardField.setAsStartNode();
        assertEquals(BoardFieldContest.STARTNODE,boardField.getState());

        boardField.setAsEndNode();
        assertEquals(BoardFieldContest.STARTNODE,boardField.getState());
    }
    */
}
