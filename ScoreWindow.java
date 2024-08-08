import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ScoreWindow extends JPanel {
    private int width, height;
    private Breakout breakout;


    public ScoreWindow(Breakout out) {
        width = 401;
        height = 50;
        setSize(width, height);
        setLocation(200, 50);
        setBackground(Color.PINK);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(null);
        breakout = out;
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("TimesRoman", Font.BOLD, 21));
        g.drawString("Score: " + breakout.score, 15, 33);
    }
}
