import javax.swing.JFrame;

public class MainFrame extends JFrame implements Runnable {

    private DrawPanel p;
    private Thread windowThread;

    public MainFrame(String display, GameBoard board) {
        super(display);
        int frameWidth = 550;
        int frameHeight = 620;
        p = new DrawPanel(board);
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(600, 100);
        this.setVisible(true);
        startThread();
    }

    public void startThread() {
        windowThread = new Thread(this);
        windowThread.start();
    }

    public void run() {
        while (true) {
            p.repaint();
        }
    }
}