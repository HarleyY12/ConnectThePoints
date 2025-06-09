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
       int minPoints = 0;
       if(points.size() <= 2){
           return minPoints;
       }
       if(!connectedValues[value] && points.getFirst() != points.getLast()){
           return minPoints;
       }

       connectedValues[value] = true;
       int addedPoints = Math.min(maxPoints,maxPoints-(points.size()-2));
       return addedPoints;
    }
}

