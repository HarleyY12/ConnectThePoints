import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class GameBoard extends JPanel implements MouseListener {

    private int width;
    private int length;
    private int[][] gameBoard;
    private int[][] replicatedBoard;
    private int[] numberList;
    private int[] availableNumbers;

    public GameBoard(){
        length = 7;
        width = 7;
        gameBoard = new int[length][width];
        replicatedBoard = new int[length][width];
        numberList = new int[]{1, 2, 3, 4, 5, 6};
        availableNumbers = new int[numberList.length * 2];
        int j = 0;
        for(int i = 0; i < availableNumbers.length; i = i + 2){
            availableNumbers[i] = numberList[j];
            availableNumbers[i + 1] = numberList[j];
            j = j + 1;
        }
    }
    public int getWidth(){
        return width;
    }
    public int getLength(){
        return length;
    }

    public void getGameBoard(){
        for(int[] array : gameBoard){
            System.out.println(Arrays.toString(array));
        }
    }

    public void generateBoard(){
        for(int i = 0; i< availableNumbers.length; i++){
            int column = 0;
            int row = 0;
            //add extra condition to check if position is viable

            while(gameBoard[row][column] != 0) {
                column = (int) (Math.random() * width);
                row = (int) (Math.random() * length);
            }
            if(i % 2 == 1){
                while(isViablePosition(row, column, availableNumbers[i])){
                    column = (int) (Math.random() * width);
                    row = (int) (Math.random() * length);
                }
            }
            if(gameBoard[row][column] == 0) {
                gameBoard[row][column] = availableNumbers[i];
            }
        }
    }

    public boolean isViablePosition(int row, int column, int number){
        replicatedBoard[row][column] = number;




        return false;
    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
