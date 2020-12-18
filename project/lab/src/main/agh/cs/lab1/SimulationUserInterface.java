package agh.cs.lab1;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimulationUserInterface implements ActionListener{
    private final JFrame userInterfaceFrame;
    private final TextFieldWithLabel GrassPerDay;
    private final TextFieldWithLabel DailyEnergyCost;
    private final TextFieldWithLabel GrassEnergy;
    private final TextFieldWithLabel MinimalReproduceEnergy;

    private final SimulationApplication interfaceBelongTo;




    SimulationUserInterface(SimulationApplication simulationApplication){
        this.interfaceBelongTo = simulationApplication;
        this.userInterfaceFrame=new JFrame("Evolution simulation ");
        this.userInterfaceFrame.setSize(400,400);
        this.userInterfaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.userInterfaceFrame.setLocationRelativeTo(null);

        JLabel headerText = new JLabel("Enter start parameters");
        this.userInterfaceFrame.add(headerText);

        this.GrassPerDay = new TextFieldWithLabel("Grass Per Day" , 2);
        this.DailyEnergyCost = new TextFieldWithLabel("Daily Energy Cost ",10);
        this.GrassEnergy = new TextFieldWithLabel("Grass Energy ",200);
        this.MinimalReproduceEnergy = new TextFieldWithLabel("Minimal Reproduce Energy ",25);

        this.frame.add(this.GrassPerDay);
        this.frame.add(this.DailyEnergyCost);
        this.frame.add(this.GrassEnergy);
        this.frame.add(this.MinimalReproduceEnergy);

        JButton buttonStartSimulationOnOneBoard  = new JButton("Start Simulation On One Board");
        buttonStartSimulationOnOneBoard.setActionCommand("one");
        buttonStartSimulationOnOneBoard.addActionListener(this);

        JButton buttonStartSimulationOnTwoBoards = new JButton("Start Simulation On Two Boards");
        buttonStartSimulationOnTwoBoards.addActionListener(this);
        buttonStartSimulationOnTwoBoards.setActionCommand("two");

        this.userInterfaceFrame.add(buttonStartSimulationOnOneBoard);
        this.userInterfaceFrame.add(buttonStartSimulationOnTwoBoards);
        this.userInterfaceFrame.setLayout(new GridLayout(7,1));
        this.userInterfaceFrame.setSize(400,672);

        this.frame.setVisible(true);
    }

    public JFrame frame = new JFrame("HelloWorldSwing");
    public JTextArea textArea = new JTextArea(20, 30);


    public void showUserInterface(){
        this.userInterfaceFrame.setVisible(true);
    }

    public void hideUserInterface(){
        this.userInterfaceFrame.setVisible(false);
    }

    public Integer getGrassPerDayValue(){

        return this.GrassPerDay.getValue();
    }

    public int getGrassEnergy(){
        return this.GrassEnergy.getValue();
    }
    public int getDailyEnergyCost(){
        return this.DailyEnergyCost.getValue();
    }
    public int getMinimalReproduceEnergy(){
        return this.MinimalReproduceEnergy.getValue();
    }

    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if (command == "one" )
            this.interfaceBelongTo.oneSimulationStart();
        else if (command == "two")
            this.interfaceBelongTo.twoSimulationStart();
    }

    class TextFieldWithLabel extends JPanel{
        private final JLabel label;
        private final JTextField textField;

        public TextFieldWithLabel(String labelText, Integer textFieldDefoult){

            setBorder(BorderFactory.createLineBorder(Color.gray));


            this.label = new JLabel(labelText);
            this.textField = new JTextField();
            this.textField.setText(textFieldDefoult.toString());
            this.add(this.label);
            this.add(this.textField);

        }

        public int getValue(){
            return Integer.parseInt(this.textField.getText());
        }

    }


}
