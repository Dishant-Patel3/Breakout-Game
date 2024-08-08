import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame {
    // Declartion of instance variables/objects
    private int width, height;
    private static String title;

    // constructor is first thing called when a new Paddle is created
    // the constructor is where any instance variables are given values
    // initializes instance variables
    public GameWindow(String t, int w, int h) throws InterruptedException {
        // initialize instance variables
        title = t;
        width = w; 
        height = h;

        // methods to make a JFrame/window
        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        Breakout out = new Breakout(401,500);
        ScoreWindow output = new ScoreWindow(out);
        add(output);
        add(out);
        setVisible(true);
        // this while loop will be the game loop that will run
        while (true) {
            out.move();
            out.repaint();
            output.repaint();
            Thread.sleep(10);
        }
    }
}
