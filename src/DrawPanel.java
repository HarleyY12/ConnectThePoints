import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Font;
public class DrawPanel extends JPanel implements MouseListener{
    private Rectangle resetButton;
    private Rectangle resetPuzzleButton;
    private boolean gameOver;


    public DrawPanel(){
        resetButton = new Rectangle(100,200,100,50);
        resetPuzzleButton = new Rectangle(100,400,100,50);
        gameOver = false;

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