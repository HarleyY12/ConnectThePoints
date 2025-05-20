import java.util.Arrays;

public class GameBoard {

    private int width;
    private int length;
    private int[][] gameBoard;
    private int[] numberList;
    private int[] availableNumbers;
    public GameBoard(){
        length = 8;
        width = 8;
        gameBoard = new int[length][width];
        numberList = new int[]{1, 2, 3, 4, 5, 6};
        availableNumbers = new int[numberList.length * 2];
        int j = 0;
        for(int i = 0; i < availableNumbers.length; i = i + 2){
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

    public void getGameBoard(){
        for(int[] array : gameBoard){
            System.out.println(Arrays.toString(array));
        }
    }

    public void generateBoard(){
        for(int i = 0; i< availableNumbers.length; i++){
            int column = (int) (Math.random() * width);
            int row = (int) (Math.random() * length);
            while(gameBoard[row][column] != 0){
                column = (int) (Math.random() * width);
                row = (int) (Math.random() * length);
            }
            //check if each successive point can be connected
            int[] collectedNumbers = new int[availableNumbers.length];
            collectedNumbers[i] = availableNumbers[i];
            int test = 5;
            if(i % 2 == 1 && i < 2){
                test= 6;
            }else{
                test = 7;
            }
            if(gameBoard[row][column] == 0) {
                gameBoard[row][column] = availableNumbers[i];
            }
        }
    }
//    public int generateNumber(){
//        return 0;
//    }
//    public void generateBoard1(){
//
//        for(int column = 0; column < width;column++){
//            int returnedNumber = generateNumber();
//            if(gameBoard[0][column]==0){
//                gameBoard[0][column] = returnedNumber;
//            }
//        }
//        for(int column = 0; column < width; column++){
//            int returnedNumber = generateNumber();
//            if(gameBoard[length-1][column]==0){
//                gameBoard[length-1][column] = returnedNumber;
//            }
//        }
//        for(int row = 0;row < length;row++){
//            int returnedNumber = generateNumber();
//            if(gameBoard[row][0] == 0){
//                gameBoard[row][0] = returnedNumber;
//            }
//        }
//        for(int row = 0; row < length;row++){
//            int returnedNumber = generateNumber();
//            if(gameBoard[row][width-1] == 0){
//                gameBoard[row][width-1] = returnedNumber;
//            }
//        }
//    }
}
