package model;

import controller.GameController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.Serializable;

public class GridNumber implements Serializable{
    private final int X_COUNT;
    private final int Y_COUNT;

    private int[][] numbers;
    private boolean ifGameover = true;
    private int steps;

    public int getSteps() {
        return steps;
    }

    static Random random = new Random();

    public GridNumber(int xCount, int yCount) {
        this.X_COUNT = xCount;
        this.Y_COUNT = yCount;
        this.numbers = new int[this.X_COUNT][this.Y_COUNT];
        this.initialNumbers();
    }

    public void initialNumbers() {
        ifGameover = true;
        steps = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = 0;
            }
        }
        List<int[]> positions = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                positions.add(new int[]{i, j});
                //todo: update generate numbers method done.
            }
        }
        int[] pos1 = positions.remove(random.nextInt(positions.size()));
        int[] pos2 = positions.get(random.nextInt(positions.size()));
        // 在这两个位置随机赋值为2或4
        numbers[pos1[0]][pos1[1]] = random.nextInt(2) == 0 ? 2 : 4;
        numbers[pos2[0]][pos2[1]] = random.nextInt(2) == 0 ? 2 : 4;
    }
    //todo: finish the method of four direction moving.done.
    public void rearrange(int[] rowNumbers){
        //先重新排序每一行
        int nonZeroIndex = 0; // 记录非零数的顺序
        for (int i = 0; i < rowNumbers.length; i++) {
            if (rowNumbers[i] != 0) {
                rowNumbers[nonZeroIndex] = rowNumbers[i];
                nonZeroIndex++;
            }
        }
        // 补齐剩下的零
        for (int j = nonZeroIndex; j < rowNumbers.length; j++) {
            rowNumbers[j] = 0;
        }
    }
    public void integral(int[] nums){
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] == nums[j - 1] && nums[j-1] !=0){
                nums[j-1]*=2;
                nums[j]=0;
                rearrange(nums);
                break;
            }
        }
    }
    public void move(){
        for (int i = 0; i < numbers.length; i++) {
        rearrange(numbers[i]);
        integral(numbers[i]);
        rearrange(numbers[i]);
    }

    }
    public void moveLeft() {
        move();
        steps++;
        newRandom();
    }
    public void moveRight() {
        reverse();
        move();
        reverse();
        steps++;
        newRandom();
    }
    public void moveUp() {
        transpose();
        move();
        transpose();
        steps++;
        newRandom();
    }
    public void moveDown() {
        transpose();
        reverse();
        move();
        reverse();
        transpose();
        steps++;
        newRandom();
    }
    public int getNumber(int i, int j) {
        return numbers[i][j];
    }

    public void printNumber() {
        for (int[] line : numbers) {
            System.out.println(Arrays.toString(line));
        }
    }
    public void reverse(){
        for (int i = 0; i < numbers.length; i++) {
            int start = 0;
            int end = numbers.length - 1;
            while (start < end) {
                int temp = numbers[i][start];
                numbers[i][start] = numbers[i][end];
                numbers[i][end] = temp;
                start++;
                end--;
            }
        }
    }
    public void transpose(){
        int[][] transposed = new int[numbers[0].length][numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                transposed[j][i] = numbers[i][j];
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                numbers[i][j] = transposed[i][j];
            }
        }
    }
    public void newRandom(){
        List<int[]> positions = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if(numbers[i][j] == 0){
                    positions.add(new int[]{i, j});
                }

            }
        }
        if (positions.size()>0){
            int[] pos1 = positions.get(random.nextInt(positions.size()));
            numbers[pos1[0]][pos1[1]] = random.nextInt(2) == 0 ? 2 : 4;
        }else{
            System.out.println("The End");
//            this.ifGameover = false;
        }

    }
    public boolean getisIfGameover(){
        return ifGameover;
    }
}
