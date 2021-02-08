package sumara.pathfindingVisualizer.UserInterface;

import sumara.pathfindingVisualizer.Board.BoardFieldContest;
import sumara.pathfindingVisualizer.Board.BoardLegend;
import sumara.pathfindingVisualizer.Board.BoardVisualisation;
import sumara.pathfindingVisualizer.Board.Vector2d;
import sumara.pathfindingVisualizer.Aplication.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ApplicationInterface extends JFrame implements ActionListener {

    private final Application relatedApplication;
    private BoardVisualisation relatedBoardVisualisation;


    private final SettingsWindow settingsWindow;
    private final BoardLegend boardLegend;
    private BoardFieldContest elementToInsert = null;


    public ApplicationInterface(Application application, BoardVisualisation boardVisualisation) {
        this.setResizable(false);
        this.setSize(1200, 1000);
        boardVisualisation.bindInterface(this);

        this.relatedBoardVisualisation = boardVisualisation;
        this.relatedApplication = application;
        this.settingsWindow = new SettingsWindow(this, relatedApplication.getBoardSize(), relatedApplication.getDelay(), relatedApplication.getInsertWallChange());

        JMenuBar menuBar = new JMenuBar();


        JMenu algorithmChose = new JMenu("Chose algorithm");
        algorithmChose.add(new MenuItem("BFS", "algorithmBFS", this));
        algorithmChose.add(new MenuItem("DFS", "algorithmDFS", this));
        algorithmChose.add(new MenuItem("algorithmGreedy", "algorithmGreedy", this));

        JMenu addElement = new JMenu("Add element");
        addElement.add(new MenuItem("start node", "addStartNode", this));
        addElement.add(new MenuItem("end node", "addEndNode", this));
        addElement.add(new MenuItem("wall node", "addWallNode", this));

        JMenu otherMenu = new JMenu("Others");
        otherMenu.add(new MenuItem("clear", "clear", this));
        otherMenu.add(new MenuItem("add random walls", "addRandomWalls", this));
        otherMenu.add(new MenuItem("clear walls", "clearWalls", this));
        otherMenu.addSeparator();
        otherMenu.add(new MenuItem("settings", "showSettings", this));

        JMenu actionMenu = new JMenu("Action");
        actionMenu.add(new MenuItem("start", "start", this));
        actionMenu.add(new MenuItem("stop", "stop", this));


        menuBar.add(addElement);
        menuBar.add(algorithmChose);
        menuBar.add(otherMenu);
        menuBar.add(actionMenu);

        this.setJMenuBar(menuBar);
        this.boardLegend = new BoardLegend();

        getContentPane().add(boardVisualisation);
        getContentPane().add(this.boardLegend);

        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }

    private class MenuItem extends JMenuItem {
        private MenuItem(String text, String actionCommand, ActionListener actionListener) {
            this.setText(text);
            this.setActionCommand(actionCommand);
            this.addActionListener(actionListener);
        }
    }

    public void changeBoardVisualisation(BoardVisualisation boardVisualisation) {
        this.getContentPane().remove(this.relatedBoardVisualisation);
        this.getContentPane().remove(this.boardLegend);

        this.relatedBoardVisualisation = boardVisualisation;

        this.getContentPane().add(this.relatedBoardVisualisation);
        this.getContentPane().add(this.boardLegend);

        this.relatedBoardVisualisation.bindInterface(this);
        validate();

    }

    public void readInsertedSettings() {
        this.relatedApplication.setBoardSize(this.settingsWindow.getBoardSize());
        this.relatedApplication.setDelay(this.settingsWindow.getDelay());
        this.relatedApplication.setInsertWallChange(this.settingsWindow.getChance());
    }

    public void clickOn(Vector2d boardFieldPosition) {
        this.relatedApplication.addElementAt(this.elementToInsert, boardFieldPosition);
    }


    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "addStartNode":
                this.elementToInsert = BoardFieldContest.STARTNODE;
                break;

            case "addEndNode":
                this.elementToInsert = BoardFieldContest.ENDNODE;
                break;

            case "addWallNode":
                this.elementToInsert = BoardFieldContest.WALLNODE;
                break;

            case "clearWalls":
                this.relatedApplication.clearWalls();
                break;

            case "clear":
                this.relatedApplication.clear();
                break;

            case "start":
                this.relatedApplication.runAlgorithm();
                break;

            case "stop":
                this.relatedApplication.stopPathFindingAlgorithm();
                break;

            case "algorithmBFS":
                this.relatedApplication.selectAlgorithm("algorithmBFS");
                break;

            case "algorithmDFS":
                this.relatedApplication.selectAlgorithm("algorithmDFS");
                break;

            case "algorithmGreedy":
                this.relatedApplication.selectAlgorithm("algorithmGreedy");
                break;

            case "addRandomWalls":
                this.relatedApplication.generateRandomWalls();
                break;

            case "showSettings":
                this.settingsWindow.setVisible(true);
                break;

            case "applyButton":
                this.readInsertedSettings();
                this.settingsWindow.setVisible(false);
                break;
        }

    }
}
