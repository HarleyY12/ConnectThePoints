import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Points extends JPanel implements MouseListener {
    private int value;
    private int row;
    private int column;
    private boolean isConnected;
    private boolean isSelected;

    public Points(int value, int row, int column){
        this.value = value;
        this.row = row;
        this.column = column;
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
