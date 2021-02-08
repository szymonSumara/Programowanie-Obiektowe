package sumara.pathfindingVisualizer.Board;

import sumara.pathfindingVisualizer.UserInterface.ApplicationInterface;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardVisualisation extends JPanel {
    private final JLabel[][] mapVisualisation;
    private ApplicationInterface relatedApplicationInterface;
    private final Board relatedBoard;


    public BoardVisualisation(Board board){
        this.setPreferredSize(new Dimension(900, 900));
        this.relatedBoard = board;
        int x = board.getBoardSize().x;
        int y = board.getBoardSize().y;

        mapVisualisation = new JLabel[x][y];
        Border blackLine = BorderFactory.createLineBorder(Color.gray);
        for(int i=0;i<x;i++)
            for(int j=0;j<y;j++){
                this.mapVisualisation[i][j] = new JLabel();
                this.mapVisualisation[i][j].setBorder(blackLine);
                this.mapVisualisation[i][j].setText( " " );
                this.mapVisualisation[i][j].setOpaque(true);
                this.mapVisualisation[i][j].setBackground(Color.white);
                final int  tmpX = i;
                final int  tmpY = j;
                this.mapVisualisation[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        relatedApplicationInterface.clickOn(board.getFieldAt(new Vector2d(tmpX,tmpY)).getPosition());
                    }
                });
                add(this.mapVisualisation[i][j]);
            }

        setLayout(new GridLayout(x,y));
        setVisible(true);
    }

    public void bindInterface(ApplicationInterface relatedApplicationInterface){
        this.relatedApplicationInterface = relatedApplicationInterface;
    }


    public void updateField(Vector2d fieldPosition){
        this.mapVisualisation[fieldPosition.x][fieldPosition.y].setBackground(this.relatedBoard.getFieldAt(fieldPosition).getColor());
    }


}
