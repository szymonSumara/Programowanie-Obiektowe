package sumara.pathfindingVisualizer.UserInterface;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {

    private final SettingsWindowItem settingsWindowItemSize;
    private final SettingsWindowItem settingsWindowItemChance;
    private final SettingsWindowItem settingsWindowItemDelay;


    public SettingsWindow(ApplicationInterface applicationInterface, int actualBoardSize, int actualDelay, int actualInsertWallChance) {
        this.setResizable(false);
        this.setSize(200, 300);

        settingsWindowItemSize = new SettingsWindowItem("Size", 10, 150, actualBoardSize);
        add(settingsWindowItemSize);
        System.out.println(actualDelay);
        settingsWindowItemDelay = new SettingsWindowItem("Delay", 0, 300, actualDelay);
        add(settingsWindowItemDelay);

        settingsWindowItemChance = new SettingsWindowItem("Insert wall chance", 10, 90, actualInsertWallChance);
        add(settingsWindowItemChance);

        JButton applyButton = new JButton("Apply");
        applyButton.addActionListener(applicationInterface);
        applyButton.setActionCommand("applyButton");
        add(applyButton);
        setLayout(new GridLayout(4, 1));
    }

    private static class SettingsWindowItem extends JPanel {

        private final JSlider slider;

        private SettingsWindowItem(String labelValue, int minValue, int maxValue, int actualValue) {

            this.slider = new JSlider(JSlider.HORIZONTAL, minValue, maxValue, actualValue);

            add(new JLabel(labelValue));
            add(slider);
            setLayout(new GridLayout(1, 2));
        }

        private int getValue() {
            return slider.getValue();
        }

    }

    public int getDelay() {
        return settingsWindowItemDelay.getValue();
    }

    public int getBoardSize() {
        return settingsWindowItemSize.getValue();
    }

    public int getChance() {
        return settingsWindowItemChance.getValue();
    }


}
