import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Points extends JPanel implements MouseListener {
    private int value;
    private int row;
    private int column;
    private int score;
    private boolean isConnected;
    private boolean isSelected;

    public Points(int value, int row, int column, int score){
        this.value = value;
        this.row = row;
        this.column = column;
        this.score = score;
        isConnected = false;
        isSelected = true;
    }
    public void setConnected(){
         isConnected = true;
    }
    public void setSelected(){
        isSelected = true;
    }
    public int getValue(){
        return value;
    }
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
    public int getScore(){
        return score;
    }
    //temp test
    public void increaseScore(){
        score = score + 1;
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
