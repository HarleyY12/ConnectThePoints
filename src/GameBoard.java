
public class GameBoard {

    private int width;
    private int length;
    private int[][] gameBoard;
    private int[] numberList;
    private int[] availableNumbers;
    public GameBoard(int width, int length){
        this.length = length;
        this.width = width;
        gameBoard = new int[length][width];
        numberList = new int[]{1, 2, 3, 4};
        availableNumbers = new int[numberList.length * 2];
        int j = 0;
        for(int i = 0;i< availableNumbers.length;i=i+2){
            availableNumbers[i] = numberList[j];
            availableNumbers[i + 1] = numberList[j];
            j = j + 1;
        }
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

        for(int column = 0; column < width;column++){
            int returnedNumber = generateNumber();
            if(gameBoard[0][column]==0){
                gameBoard[0][column] = returnedNumber;
            }
        }
        for(int column = 0; column < width; column++){
            int returnedNumber = generateNumber();
            if(gameBoard[length-1][column]==0){
                gameBoard[length-1][column] = returnedNumber;
            }
        }
        for(int row = 0;row < length;row++){
            int returnedNumber = generateNumber();
            if(gameBoard[row][0] == 0){
                gameBoard[row][0] = returnedNumber;
            }
        }
        for(int row = 0; row < length;row++){
            int returnedNumber = generateNumber();
            if(gameBoard[row][width-1] == 0){
                gameBoard[row][width-1] = returnedNumber;
            }
        }
    }
    public int generateNumber(){

        for (int availableNumber : availableNumbers) {
            return availableNumber;
        }
        return 0;

    }
    public int[] test(){
        int[] availableNumbers = new int[numberList.length * 2];
        int j = 0;
        for(int i = 0;i< availableNumbers.length;i=i+2){
            availableNumbers[i] = numberList[j];
            availableNumbers[i + 1] = numberList[j];
            j = j + 1;
        }
        return availableNumbers;
    }



}
