import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {
    // Declartion of instance variables
    private Breakout breakout;
    public int xPos, yPos, xa;
    private int width, height;
    public int speed;

    // constructor is first thing called when a new Paddle is created
    // the constructor is where any instance variables are given values
    // initializes instance variables
    public Paddle(int x, int y, Breakout out) {
        xPos = x;
        yPos = y;
        width = 100;
        height = 10;
        xa = 5;
        speed = 70;
        breakout = out;

    }

    public void paint(Graphics g) {
        g.fillRect(xPos, yPos, width, height);
    }

    /**
     * This method will check to see if the paddle can move If the paddle can move
     * it will move
     */
    public void movePaddle() {
        if (xPos + xa > 0 && xPos + xa < breakout.getWidth() - width) {
            xPos = xPos + xa;
        }
    }

    /* -------------------- How to use keyboard ---------------------- */
    /**
     * In order to use the keyboard, you need to be able to check for keyEvents. A
     * KeyEvent is when the key is released, pressed
     *
     * @param e is the KeyEvent that happens
     */
    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        // keyEvent.VK_RIGHT - right arrow
        // keyEvent.VK_LEFT - left arrow
        // keyEvent.VK_A - letter a 
        // KeyEvent.VK_D - letter d
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = 4;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            xa = 4;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -4;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            xa = -4;
        }
    }

    /* -------------------- How to check collision ---------------------- */
    /**
     * To have some type of collusion, the brick needs to have bounds In the class
     * Rectangle, there is a getBounds method
     *
     * @return rectangle's outer most values
     */
    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, width, height);
    }

    /**
     * This method will get the top of the bar, so it can interact with the ball
     * object
     *
     * @return the y value for the top of the paddle
     */
    public int getPaddleTop() {
        return yPos;
    }

    /* ------------------- Getters and Setters -------------------- */
}
