import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard(4,6);
        board.generateBoard();

        System.out.println(Arrays.deepToString(board.getGameBoard()));
        board.generateBoard();
        System.out.println(Arrays.deepToString(board.getGameBoard()));
        System.out.println(Arrays.toString(board.test()));
        System.out.println(board.generateNumber());
        System.out.println(board.generateNumber());
        System.out.println(board.generateNumber());



    }
}