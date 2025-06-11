import java.awt.*;
import java.util.List;

public class Connector {
    private GameBoard board;
    private int maxValue;
    private boolean [] connectedValues;

    public Connector (GameBoard board){
        this.board = board;
        maxValue = 6;
        connectedValues = new boolean[maxValue + 1];
    }

    public int calculateScore(int value, List<Point> points){
        int maxPoints = 100;
        int minPoints = 1;
        int [][] game = board.getGameBoard();
        if(points.size() < 2){
            return 0;
        }
        if(value > maxValue || connectedValues[value]){
            return 0;
        }
        Point start = points.get(0);
        Point end = points.get(points.size()-1);

        if(!board.isOriginalPosition(start.x,start.y) ||
                !board.isOriginalPosition(end.x,end.y)){
            return 0;
        }
        if(game[start.x][start.y] != value ||
                game[end.x][end.y] != value) {
            return 0;
        }
        for(int i = 1; i < points.size()-1;i++){
            Point p = points.get(i);
            int cellValue = game[p.x][p.y];
            if(cellValue != 0 && cellValue != value){
                return 0;
            }
        }

        connectedValues[value] = true;
        int addedPoints = Math.max(minPoints,maxPoints-(points.size()-2));
        return addedPoints;
    }
    public void resetConnection(){
        for(int i = 1;i <= maxValue; i++){
            connectedValues[i] = false;
        }
    }

}


