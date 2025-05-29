public class GameBoard {

    private int width;
    private int length;
    private int[][] gameBoard;
    private int[][] replicatedBoard;
    private int[] numberList;
    private int[] availableNumbers;

    public GameBoard(){
        length = 12;
        width = 12;
        gameBoard = new int[length][width];
        replicatedBoard = new int[length][width];
        numberList = new int[]{1, 2, 3, 4, 5};
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
    public int[][] getGameBoard(){
        return gameBoard;
    }

    public void generateBoard(){
        gameBoard = new int[length][width];
        for(int i = 0; i< availableNumbers.length; i++){

            int column = (int) (Math.random() * width);
            int row = (int) (Math.random() * length);

            while(gameBoard[row][column] != 0) {
                column = (int) (Math.random() * width);
                row = (int) (Math.random() * length);
            }

//            //add extra condition to check if position is viable
//            if(i % 2 == 1){
//                while(isViablePosition(row, column, availableNumbers[i])){
//                    column = (int) (Math.random() * width);
//                    row = (int) (Math.random() * length);
//                }
//            }
            if(gameBoard[row][column] == 0) {
                gameBoard[row][column] = availableNumbers[i];
            }
        }
    }

//    public boolean isViablePosition(int row, int column, int number){
//        replicatedBoard = gameBoard;
//        int count = 0;
//        for(int r = 0; r < length; r++) {
//            for (int c = 0; c < width; c++) {
//                if(gameBoard[r][c] == number){
//                    count = count + 1;
//                }
//            }
//        }
//        if(count == 2){
//
//        }
//
//
//
//        return false;
//    }


}
