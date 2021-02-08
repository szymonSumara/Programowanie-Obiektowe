package sumara.pathfindingVisualizer.Board;

import java.awt.*;

public enum BoardFieldContest {
    FREENODE("free field", Color.white),
    WALLNODE("wall node", Color.black),
    STARTNODE("start node", Color.GREEN),
    ENDNODE("end node ", Color.red),
    ONPATH("path node", Color.yellow),
    VISITED("visited node", Color.blue),
    ACTUALNODE("actual node", Color.CYAN);
    private final Color color;
    private final String stringRepresentation;

    BoardFieldContest(String stringRepresentation, Color color) {
        this.color = color;
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() {
        return this.stringRepresentation;
    }

    public Color getColor() {
        return this.color;
    }

}
