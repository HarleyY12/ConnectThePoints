import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard(4,6);

        int[] numbers = {1,2,3,4,5,6};
        System.out.println(board.generateNumber(numbers));
        System.out.println(board.generateNumber(numbers));
        System.out.println(board.generateNumber(numbers));


    }
}