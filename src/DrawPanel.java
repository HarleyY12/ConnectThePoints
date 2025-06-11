import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {
    private Connector connector;
    private Rectangle resetButton;
    private Rectangle getNewPuzzle;
    private Rectangle pointsButton;
    private GameBoard board;
    private int cellSize;
    private int score;
    private int selectedValue;
    private boolean hasStartedSelection;
    private List<Point> selectedPoints;
    private List<Point> draggedPoints;

    private Color[] colorList = {
            Color.RED, Color.BLUE, Color.CYAN, Color.ORANGE, Color.PINK,
            Color.MAGENTA, Color.YELLOW, Color.GREEN };

    private Color getColor(int value){
        if(value <= 0 || value > colorList.length){
            return Color.GRAY;
        }
        return colorList[value - 1];
    }

    public DrawPanel(GameBoard board){
        this.board = board;
        connector = new Connector(board);
        resetButton = new Rectangle(200,0,70,30);
        getNewPuzzle = new Rectangle(450,0,127,30);
        pointsButton = new Rectangle(300,0,120,30);
        addMouseListener(this);
        addMouseMotionListener(this);
        cellSize = 60;
        score = 0;
        selectedValue = -1;
        hasStartedSelection = false;
        selectedPoints = new ArrayList<>();
        draggedPoints = new ArrayList<>();
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

                if(selectedPoints.contains(new Point(r,c))) {
                    g.setColor(getColor(selectedValue));
                    g.fillRect(x, y, cellSize, cellSize);
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(selectedValue), x + 25, y + 35);
                }else if(value != 0){
                    g.setColor(getColor(value));
                    g.fillRect(x,y,cellSize,cellSize);
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(value),x + 25,y + 35);
                }
            }
        }
        g.setFont(new Font("Courier New",Font.BOLD,20));
        g.setColor(Color.BLACK);
        g.drawString("Reset",205,23);
        g.drawRect(200,5,70,30);
        g.drawString("New Puzzle",455,23);
        g.drawRect(450,5,127,30);
        g.drawString("Score: " + score,305,23);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point clicked = e.getPoint();
        if(e.getButton() == 1){
            if(getNewPuzzle.contains(clicked)){
                board.generateBoard();
                selectedValue = -1;
                selectedPoints = new ArrayList<>();
                hasStartedSelection = false;
                score = 0;
                connector.resetConnection();
            }
            if(resetButton.contains(clicked)){
                selectedValue = -1;
                selectedPoints = new ArrayList<>();
                hasStartedSelection = false;
                board.resetToOriginal();
                score = 0;
                connector.resetConnection();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point clicked = e.getPoint();
        int row = (clicked.y - (int)(0.7 * cellSize))/cellSize;
        int column = (clicked.x - (int)(0.5 * cellSize))/cellSize;
        if(column <= board.getWidth() && column >= 0 && row <= board.getLength() && row >=0) {
            int [][] game = board.getGameBoard();
            int cell = game[row][column];
            if(cell > 0 && board.isOriginalPosition(row,column)){
                hasStartedSelection = true;
                selectedValue = cell;
                selectedPoints = new ArrayList<>();
                draggedPoints = new ArrayList<>();
                Point point = new Point(row,column);
                selectedPoints.add(point);
                draggedPoints.add(point);
                repaint();
            }
        }
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if(hasStartedSelection){
            Point clicked = e.getPoint();
            int row = (clicked.y - (int)(0.7 * cellSize))/cellSize;
            int column = (clicked.x - (int)(0.5 * cellSize))/cellSize;
            if(column <= board.getWidth() && column >= 0 && row <= board.getLength() && row >=0) {
                Point point = new Point(row,column);
                if(!draggedPoints.contains(point)){
                    int [][] game = board.getGameBoard();
                    int cell = game[row][column];
                    if(cell == 0 || cell == selectedValue && board.isOriginalPosition(row,column)) {
                        selectedPoints.add(point);
                        draggedPoints.add(point);
                        repaint();
                    }
                }
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if(!hasStartedSelection || selectedPoints.size() < 2){
            hasStartedSelection = false;
            selectedValue = -1;
            selectedPoints = new ArrayList<>();
            draggedPoints = new ArrayList<>();
        }
        int earnedPoints = connector.calculateScore(selectedValue,selectedPoints);
        if(earnedPoints > 0){
            score = score + earnedPoints;
            for(Point point : selectedPoints){
                if(!board.isOriginalPosition(point.x,point.y)){
                    board.getGameBoard()[point.x][point.y] = selectedValue;
                }
            }
        }
        hasStartedSelection = false;
        selectedValue = -1;
        selectedPoints = new ArrayList<>();
        draggedPoints = new ArrayList<>();
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
}

