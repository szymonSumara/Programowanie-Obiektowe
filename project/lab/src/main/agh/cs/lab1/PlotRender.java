package agh.cs.lab1;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PlotRender extends JPanel {
    private final Statistic statistic;

    private Plot plot;
    private StatisticLabels statisticLabels;

    public PlotRender(Statistic statistic){

        this.statistic = statistic;
        this.plot = new Plot(this.statistic);
        this.statisticLabels = new StatisticLabels();
        add(this.plot);
        add(this.statisticLabels);

    }

    public void updateLabels(){
        this.statisticLabels.updateLabels();
    }

    @Override
    public void paintComponent(Graphics g){
        Vector2d panelSize = new Vector2d(getSize().width, getSize().height);
        g.setColor(Color.RED);
        g.clearRect(0,0,panelSize.x,panelSize.y);
        this.plot.paintComponent(g);
    }


    class StatisticLabels extends JPanel{
        private JLabel actualAnimalsCount;
        private JLabel actualAnimalsGrass;
        private JLabel animalEnergySum;
        private JLabel averageLiveDays;
        private JLabel averageChildrenForLivingAnimals;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600,300);
        }

        StatisticLabels() {

            setBorder(new EmptyBorder(20, 60, 10, 10));


            this.actualAnimalsCount = new JLabel();
            this.actualAnimalsGrass = new JLabel();
            this.animalEnergySum = new JLabel();
            this.averageLiveDays = new JLabel();
            this.averageChildrenForLivingAnimals = new JLabel();
            setSize(new Dimension(300,600));

            Font font = new Font(Font.SERIF, Font.PLAIN,  20);
            this.actualAnimalsCount.setFont(font);
            this.actualAnimalsGrass.setFont(font);
            this.animalEnergySum.setFont(font);
            this.averageLiveDays.setFont(font);
            this.averageChildrenForLivingAnimals.setFont(font);

            add(actualAnimalsCount);
            add(actualAnimalsGrass);
            add(animalEnergySum);
            add(averageLiveDays);
            add(averageChildrenForLivingAnimals);
            setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));


        }


        public void updateLabels(){
            this.actualAnimalsCount.setText( "Actual Animals Count                                    " + statistic.getAnimalsNumber());
            this.actualAnimalsGrass.setText( "Actual Animals Grass                                    " + statistic.getGrasCounter());
            this.animalEnergySum.setText(    "Average Animals Energy                               " + statistic.getAverageAnimalsEnergy());
            this.averageLiveDays.setText(    "Average Child Number For Living Animals  " + statistic.getAverageChildNumberForLivingAnimals());
            this.averageChildrenForLivingAnimals.setText(
                                            "Average Life Time                                         " + statistic.getAverageLifeTime());
        }


    }

    class Plot extends JPanel{
        private final Statistic statistic;


        public Plot(Statistic statistic){
            this.statistic = statistic;


        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 700);
        }

        public void paintComponent(Graphics g) {
            Vector2d panelSize = new Vector2d(getSize().width, getSize().height);
            g.setColor(Color.RED);
            g.clearRect(0,0,panelSize.x,panelSize.y);
            //System.out.println(statistic.animalsDataToPlot);
            setMinimumSize(new Dimension(500, 500));
            setBackground(Color.cyan);
            Border blackline = BorderFactory.createLineBorder(Color.gray);
            setBorder(blackline);
            float max = -1;
            for(Integer animalNum :statistic.animalsDataToPlot)
                max = Math.max(max,animalNum);

            for(Integer grassNum :statistic.grassDataToPlot)
                max = Math.max(max,grassNum);

            System.out.println(max);
            for(int i=0;i<this.statistic.animalsDataToPlot.size()-1;i++) {
                g.setColor(Color.black);
                g.drawLine(500/statistic.animalsDataToPlot.size() * i,
                        (int)(500 - 450.0/max * statistic.animalsDataToPlot.get(i)),
                        500/statistic.animalsDataToPlot.size() * (i+1),
                        (int)(500 - 450.0/max * statistic.animalsDataToPlot.get(i + 1)));
            }
            for(int i=0;i<this.statistic.grassDataToPlot.size()-1;i++) {
                g.setColor(Color.green);
                g.drawLine(500/statistic.grassDataToPlot.size() * i,
                        (int)(500 - 450.0/max * statistic.grassDataToPlot.get(i)),
                        500/statistic.grassDataToPlot.size() * (i+1),
                        (int)(500 - 450.0/max * statistic.grassDataToPlot.get(i + 1)));
            }
        }
    }
}
