package agh.cs.lab1;

import javax.swing.*;
import java.awt.*;

public class SimulationWindow {

    private JFrame frame ;
    private JTextArea textArea = new JTextArea(20, 30);
    private MapVisualizer mapVisualisation;
    private PlotRender plotRender;

    public SimulationWindow(MapVisualizer mapVisualisation,PlotRender plotRender){
        this.frame= new JFrame("Evolution Simulator");
        this.plotRender = plotRender;

        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new GridLayout(1,2));
        this.mapVisualisation = mapVisualisation;
        this.frame.add(mapVisualisation);
        this.frame.add(plotRender);



        Font f1  = new Font(Font.DIALOG_INPUT, Font.PLAIN,  15);
        textArea.setFont(f1);



        frame.setVisible(true);

    }

    public void updateContent(){
        mapVisualisation.updateMap();
        mapVisualisation.repaint();
        plotRender.repaint();
    }
}
