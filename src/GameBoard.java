
public class GameBoard {

    private int width;
    private int length;
    private int[][] gameBoard;

    public GameBoard(int width, int length){
        this.length = length;
        this.width = width;
        gameBoard = new int[length][width];



    }
    public int getWidth(){
        return width;
    }
    public int getLength(){
        return length;
    }
    public void generateBoard(){
        boolean[][] alreadyGenerated = new boolean[length][width];


        for(int i = 1; i < 5; i++){
            int generate = (int) (Math.random() * 4);
            gameBoard[1][1] = 5;


        }
        //length = 5 (row), width = 3(column)
        //generate numbers on left & right
        //(0,0), (1,0), (2,0), (3,0), (4,0)
        //(0, 2), (1, 2), (2,2), (3,2), (4,2)
        //generate numbers on top & bottom
        //(0,0), (0,1), (0,2)
        //(4,0), (4,1), (4,2)
        // if length - 1 >= 0 & width = 0;



    }
    public int[][] getGameBoard(){
        return gameBoard;
    }



}
