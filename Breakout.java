import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Breakout extends JPanel {
    // instance variable
    private int width, height;
    public int speed;
    public int score;
    private Ball ball;
    private Paddle paddle;

    private ArrayList<Brick> bricks;
    // constructor takes in two parameters for the size of the JPanel
    // uses the methods from the JPanel class to create a visible
    // panel for the other objects of the game to appear on
    public Breakout(int w, int h) {
        width = w;
        height = h;
        speed = 1;

        setSize(width, height);
        setLocation(200, 100);
        setBackground(Color.CYAN);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    
        ball = new Ball(150, 150, this); // makes an instance of the class
        paddle = new Paddle(50, 460, this);
        // brick = new Brick(0, 0 ,this);
        // brick2 = new Brick(40, 0, this);

        // listen for the key pressing
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
                paddle.keyPressed(e);
            }
            public void keyReleased(KeyEvent e) {
                paddle.keyReleased(e);
            }
        });

        // must hav to make sure breakout is focused
        setFocusable(true);
        createGrid();
    }
    /**
     * Displays graphics on the JPanel
     *
     * @param g is the declaration of the Graphics class, where all the methods
     *          needed to get graphics onto the JPanel
     */

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        paddle.paint(g);
        ball.paint(g);
        for (int x = bricks.size() - 1; x >= 0; x--) {
            bricks.get(x).paint(g);
            if (bricks.get(x).collision()) {
                ball.setYA(speed);
                bricks.remove(x);
                score += 10;
                if (score == 50) {
                    speed = 2;
                } else if (score == 200) {
                    speed = 3;
                } else if (score == 200) {
                    speed = 3;
                } else if (score == 300) {
                    speed = 4;
                } else if (score == 400) {
                    speed = 5;
                } 
            }
    
        }
        if (score == 500) {
            g.setFont(new Font("TimesRoman", Font.BOLD, 21));
            g.drawString("Game Over, You WON!", 85, 280);
            speed = 0;
            ball.xa = 0;
            ball.ya = 0;
            paddle.speed = 0;
        } 
    }

    /**
     * This method will get movement in the game
     */
    public void move() {
        paddle.movePaddle();
        ball.moveBall();
    }

    /* -------------------- The Brick Grid -------------------- */
    public ArrayList<Brick> createGrid() {
        bricks = new ArrayList<Brick>();
        for (int row = 0; row < 5; row++) {
            Color color = new Color(255, 255, 255);
            if (row == 0) {
                color = new Color(25, 255, 25);
            } else if (row == 1) {
                color = new Color(255, 102, 0);
            } else if (row == 2) {
                color = new Color(255, 255, 0);
            } else if (row == 3) {
                color = new Color(255, 0, 0);
            } else if (row == 4) {
                color = new Color(184, 100, 249);
            }
            for (int col = 0; col < 10; col++) {
                bricks.add(new Brick((col * 40), (row * 25), this, color));
            }
    }
    return bricks;
}
    /* ------------------- Getters and Setters -------------------- */

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int newValue) {
        speed = newValue;
    }

    public Ball getBall() {
        return ball;
    }

    public Paddle getPaddle() {
        return paddle;
    }
}
