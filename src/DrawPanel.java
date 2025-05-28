import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements MouseListener{
    private Rectangle resetButton;
    private Rectangle getNewPuzzle;
    private Rectangle pointsButton;
    private boolean gameOver;
    private GameBoard board;
    private Points point;
    private int cellSize;
    private int score;


    public DrawPanel(GameBoard board){
        this.board = board;
        point = new Points(1,1,11);
        resetButton = new Rectangle(70,550,70,30);
        getNewPuzzle = new Rectangle(265,550,127,30);
        pointsButton = new Rectangle(165,0,120,30);
        gameOver = false;
        addMouseListener(this);
        cellSize = 60;
        score = 0;

    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int rows = board.getLength();
        int columns = board.getWidth();
        int [][] newBoard = board.getGameBoard();
        g.setFont(new Font("Courier New",Font.BOLD,20));
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                int y = (int) ((r+0.7) * cellSize);
                int x = (int) ((c+0.5) * cellSize);
                g.drawRect(x,y,cellSize,cellSize);

                int value = newBoard[r][c];
                if(value != 0){
                    g.setColor(Color.BLUE);
                    g.fillRect(x,y,cellSize,cellSize);
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(value),x + 25,y + 35);
                }
            }
        }

        g.setFont(new Font("Courier New",Font.BOLD,20));
        g.setColor(Color.BLACK);
        g.drawString("Reset",75,570);
        g.drawRect(70,550,70,30);
        g.drawString("New Puzzle",270,570);
        g.drawRect(265,550,127,30);
        g.drawString("Points: " + score,170,20);
        g.drawRect(165,0,150,30);

    }



    @Override
    public void mouseClicked(MouseEvent e) {
        Point clicked = e.getPoint();
        if(e.getButton() == 1){
            if(getNewPuzzle.contains(clicked)){
                board.generateBoard();
            }
            if(resetButton.contains(clicked)){
                score = score + 1;
            }
        }
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