import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameBoard board1 = new GameBoard(4,6);
        System.out.println(board1.getLength());
        board1.generateBoard();
        System.out.println(Arrays.deepToString(board1.getGameBoard()));
        System.out.println("start game");
    }
}