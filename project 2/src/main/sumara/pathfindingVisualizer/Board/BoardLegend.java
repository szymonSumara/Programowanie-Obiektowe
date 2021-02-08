package sumara.pathfindingVisualizer.Board;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BoardLegend extends JPanel {

    public BoardLegend() {
        setPreferredSize(new Dimension(150, 900));
        add(new JLabel("Legend"));

        for (BoardFieldContest boardFieldContest : BoardFieldContest.values())
            add(new LegendItem(boardFieldContest.getColor(), boardFieldContest.getStringRepresentation()));

        setLayout(new FlowLayout());
    }

    private class LegendItem extends JPanel {

        private LegendItem(Color color, String label) {

            JLabel field = new JLabel();
            setPreferredSize(new Dimension(150, 40));
            Border blackLine = BorderFactory.createLineBorder(Color.gray);
            field.setBorder(blackLine);
            field.setPreferredSize(new Dimension(25, 25));
            field.setOpaque(true);
            field.setBackground(color);

            add(field);
            add(new JLabel(label));
            setLayout(new FlowLayout());
        }

    }
}
