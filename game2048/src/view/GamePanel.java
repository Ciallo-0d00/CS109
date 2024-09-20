package view;

import model.GridNumber;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends ListenerPanel {
    private final int COUNT = 4;
    private GridComponent[][] grids;

    private GridNumber model;
    private JLabel stepLabel;//标签
    private int steps;//总步数
    private final int GRID_SIZE;
    private boolean ifGameover = true;
    public void setModel(GridNumber model) {
        this.model = model;
        this.steps = model.getSteps();
    }
    public GamePanel(int size) {
        this.setVisible(true);
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.DARK_GRAY);//方格线条的颜色
        this.setSize(size, size);
        this.GRID_SIZE = size / COUNT;
        this.grids = new GridComponent[COUNT][COUNT];
        this.model = new GridNumber(COUNT, COUNT);
        initialGame();
    }

    public GridNumber getModel() {
        return model;
    }

    public void initialGame() {
        ifGameover = true;
        this.steps = 0;
        if (stepLabel != null) {
            stepLabel.setText(String.format("Start")); // 更新步数标签
        }
        for (GridComponent[] gridRow : grids) {
            for (GridComponent grid : gridRow) {
                if (grid != null) {
                    this.remove(grid); // 从面板中移除组件
                }
            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                grids[i][j] = new GridComponent(i, j, model.getNumber(i, j), this.GRID_SIZE);
                grids[i][j].setLocation(j * GRID_SIZE, i * GRID_SIZE);
                this.add(grids[i][j]);
            }
        }
        model.printNumber();//check the 4*4 numbers in game
        this.repaint();
    }

    public void updateGridsNumber() {
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                grids[i][j].setNumber(model.getNumber(i, j));
            }
        }
        model.printNumber();
        repaint();
    }


    /**
     * Implement the abstract method declared in ListenerPanel.
     * Do move right.
     */
    private void check(){
        ifGameover = model.getisIfGameover();
    }
    @Override
    public void doMoveRight() {
        check();
        if(ifGameover){
            System.out.println("Click VK_RIGHT");
            this.model.moveRight();
            this.afterMove();
            this.updateGridsNumber();
        }
    }
    public void doMoveLeft() {
        check();
        if(ifGameover){
            System.out.println("Click VK_LEFT");
            this.model.moveLeft();
            this.afterMove();
            this.updateGridsNumber();
        }
    }
    public void doMoveUp() {
        check();
        if(ifGameover){
            System.out.println("Click VK_UP");
            this.model.moveUp();
            this.afterMove();
            this.updateGridsNumber();
        }

    }
    public void doMoveDown() {
        check();
        if(ifGameover){
            System.out.println("Click VK_DOWN");
            this.model.moveDown();
            this.afterMove();
            this.updateGridsNumber();
        }

    }


    public void afterMove() {
        this.steps++;
        this.stepLabel.setText(String.format("Step: %d", this.steps));
    }

    public void setStepLabel(JLabel stepLabel) {
        this.stepLabel = stepLabel;
    }
}
