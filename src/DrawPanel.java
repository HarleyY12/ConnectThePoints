import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;


public class DrawPanel extends JPanel implements MouseListener{
    private Rectangle resetButton;
    private Rectangle getNewPuzzle;
    private Rectangle pointsButton;
    private boolean gameOver;
    private GameBoard board;
    private Nodes point;
    private int cellSize;
    private int score;

    private int selectedRow;
    private int selectedColumn;

    private boolean hasStartedSelection;
    private int selectedValue;
    private List<Point> selectedPoints;


    public DrawPanel(GameBoard board){
        this.board = board;
        point = new Nodes(1,1,11);
        resetButton = new Rectangle(200,810,70,30);
        getNewPuzzle = new Rectangle(400,810,127,30);
        pointsButton = new Rectangle(300,0,120,30);
        gameOver = false;
        addMouseListener(this);
        cellSize = 60;
        score = 0;
        hasStartedSelection = false;
        selectedValue = -1;
        selectedPoints = new ArrayList<>();

        selectedRow = -1;
        selectedColumn = -1;
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
                int value = newBoard[r][c];
                g.drawRect(x,y,cellSize,cellSize);

                if(value != 0 ){
                    g.setColor(Color.BLUE);
                    g.fillRect(x,y,cellSize,cellSize);
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(value),x + 25,y + 35);
                }
                if(r == selectedRow && c == selectedColumn){
                    g.setColor(Color.ORANGE);
                    g.fillRect(x,y,cellSize,cellSize);
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(value),x + 25,y + 35);
                }
                if(value != 0 && !board.isOriginalPosition(r,c)){
                    selectedPoints.add(new Point(r,c));
                }


            }
        }




        g.setFont(new Font("Courier New",Font.BOLD,20));
        g.setColor(Color.BLACK);
        g.drawString("Reset",205,830);
        g.drawRect(200,810,70,30);
        g.drawString("New Puzzle",405,830);
        g.drawRect(400,810,127,30);
        g.drawString("Score: " + score,305,20);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point clicked = e.getPoint();
        int row = (clicked.y - (int)(0.7 * cellSize))/cellSize;
        int column = (clicked.x - (int)(0.5 * cellSize))/cellSize;

        if(e.getButton() == 1){
            if(getNewPuzzle.contains(clicked)){
                board.generateBoard();
                selectedRow = -1;
                selectedColumn = -1;
                selectedValue = -1;
                selectedPoints = new ArrayList<>();
            }
            if(resetButton.contains(clicked)){
                score = score + 1;
                selectedRow = -1;
                selectedColumn = -1;
                selectedValue = -1;
                selectedPoints = new ArrayList<>();
            }
            if(column <= board.getWidth() && column >= 0 && row <= board.getLength() && row >=0
                    && board.isOriginalPosition(row,column)){
                selectedRow = row;
                selectedColumn = column;
                selectedPoints.add(new Point(column,row));
                hasStartedSelection = true;
                System.out.println("row: " + selectedRow + " col: " + selectedColumn);

                repaint();
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

