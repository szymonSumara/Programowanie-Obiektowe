package sumara.pathfindingVisualizer.Board;

import java.util.Random;

public class RandomWallGenerator {
    private static final Random random = new Random();

    public static void generateWall(double wallPutProbability, Board board) {
        for (int i = 0; i < board.getBoardSize().x; i++)
            for (int j = 0; j < board.getBoardSize().y; j++)
                if (random.nextFloat() <= wallPutProbability)
                    board.addWallNode(new Vector2d(i, j));
    }

}
