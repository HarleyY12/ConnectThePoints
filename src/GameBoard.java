
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
    public int[][] getGameBoard(){
        return gameBoard;
    }
    public void generateBoard(){
        int[][] board = new int[length][width];
        int[] numbers = {1,2,3};
        for(int column = 0; column < width;column++){

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
    public int generateNumber(int[] numbers){
        int[] numberCounter = new int [numbers.length] ;
        for(int i = 0; i < numbers.length;i++){
            numberCounter[i] = 0;
        }
        for(int i = 0; i < numberCounter.length;i++){

            while(numberCounter[i] < 2){
                numberCounter[i] = numberCounter[i] + 1;

                return numberCounter[i];

            }
        }
        return 0;
    }



}
