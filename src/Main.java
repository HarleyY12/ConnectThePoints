
public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        board.generateBoard();
        MainFrame main = new MainFrame("Connections", board);
    }
}