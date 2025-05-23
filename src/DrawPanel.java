import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements MouseListener{
    private Rectangle resetButton;
    private Rectangle resetPuzzleButton;
    private boolean gameOver;
    private GameBoard board;
    private int cellSize;


    public DrawPanel(GameBoard board){
        this.board = board;
        resetButton = new Rectangle();
        resetPuzzleButton = new Rectangle();
//        resetButton = new Rectangle(100,200,100,50);
//        resetPuzzleButton = new Rectangle(100,400,100,50);
        gameOver = false;
        addMouseListener(this);
        cellSize = 60;

    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int rows = board.getLength();
        int columns = board.getWidth();
        int [][] board1 = board.getGameBoard1();
        g.setFont(new Font("Courier New",Font.BOLD,20));
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                int y = (int) ((r+0.5) * cellSize);
                int x = (int) ((c+0.5) * cellSize);
                g.drawRect(x,y,cellSize,cellSize);

                int value = board1[r][c];
                if(value != 0){
                    g.setColor(Color.BLUE);
                    g.fillRect(x,y,cellSize,cellSize);
                    g.setColor(Color.ORANGE);
                    g.drawString(String.valueOf(value),x + 25,y + 35);
                }
            }
        }

        g.setFont(new Font("Courier New",Font.BOLD,20));
        g.setColor(Color.BLACK);
        g.drawString("Reset",75,550);
        g.drawRect(70,530,70,30);
        g.drawString("New Puzzle",270,550);
        g.drawRect(265,530,127,30);

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