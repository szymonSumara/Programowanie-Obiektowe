package agh.cs.lab1;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MapVisualizer extends JPanel {
    private final EvolutionMap map;
    private JLabel mapVisualisation[][];
    public MapVisualizer(EvolutionMap map) {
        this.map = map;
        Font f1  = new Font(Font.DIALOG_INPUT, Font.PLAIN,  5);
        setBorder(new EmptyBorder(0,0,0,0));
        Border blackline = BorderFactory.createLineBorder(Color.gray);
        this.mapVisualisation = new JLabel[map.getNorthEastCorner().x][map.getNorthEastCorner().y];
        for(int i=0;i<this.map.getNorthEastCorner().x;i++)
            for(int j=0;j<this.map.getNorthEastCorner().y;j++) {
                this.mapVisualisation[i][j] = new JLabel();
                //his.mapVisualisation[i][j].setSize(50,50);
                this.mapVisualisation[i][j].setBorder(blackline);
                this.mapVisualisation[i][j].setFont(f1);
                this.mapVisualisation[i][j].setText(" ");
                this.mapVisualisation[i][j].setOpaque(true);;
                add(this.mapVisualisation[i][j]);
            }
        setLayout(new GridLayout(this.map.getNorthEastCorner().x,this.map.getNorthEastCorner().y));
        for(int i=0;i<this.map.getNorthEastCorner().x;i++)
            for(int j=0;j<this.map.getNorthEastCorner().y;j++) {
               mapVisualisation[i][j].setBackground(Color.ORANGE);
            }
    }



    public void updateMap() {
        for(int i=0;i<this.map.getNorthEastCorner().x;i++)
            for(int j=0;j<this.map.getNorthEastCorner().y;j++) {
                if(this.map.getObjectAt(new Vector2d(i,j)) == null) {
                    this.mapVisualisation[i][j].setBackground(Color.LIGHT_GRAY);

                }
                else if(this.map.getObjectAt(new Vector2d(i,j)) instanceof Animal) {
                    this.mapVisualisation[i][j].setBackground(Color.BLACK);

                }else if(this.map.getObjectAt(new Vector2d(i,j)) instanceof Grass){

                    this.mapVisualisation[i][j].setBackground(Color.GREEN);
                }
            }

    }
}
