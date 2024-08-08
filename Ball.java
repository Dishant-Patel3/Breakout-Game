import java.awt.Graphics;
import java.awt.Font;
import java.awt.Rectangle;

public class Ball {
    // Declartion of instance variables/objects
    // 3 instance, one for xPos, one for yPos, diameter
    public int xPos, yPos, diameter;
    public int xa;
    public int ya;
    private Breakout breakout;

    // constructor is first thing called when a new Paddle is created
    // the constructor is where any instance variables are given values
    // initializes instance variables
    public Ball(int x, int y, Breakout out) { // declare int x, int y 
        // intialize your instance variables
        xPos = x;
        yPos = y;
        diameter = 10;
        breakout = out; // ties the two objects togther
        xa = breakout.getSpeed();
        ya = breakout.getSpeed();
    }

    /**
     * 
     * @param g
     */
    public void paint(Graphics g) {
        // in the Graphics class there is a method called fillOval()
        // java api graphics
        g.fillOval(xPos, yPos, diameter, diameter);
        if (yPos > 470) {
            g.setFont(new Font("TimesRoman", Font.BOLD, 21));
            g.drawString("Game Over, You LOST!", 85, 280);
            xa = 0;
            ya = 0;
            breakout.speed = 0;
        } 
    }

    // method when called will have the code that will move the ball
    public void moveBall() {
        if (xPos + xa < 0) {
            xa = breakout.getSpeed();
        } else if (xPos + xa > breakout.getWidth() - diameter) {
            xa = -breakout.getSpeed();
        } else if (yPos + ya < 0) {
            ya = breakout.getSpeed();
        } else if (yPos + ya > breakout.getHeight() - diameter) {
            ya = -breakout.getSpeed();
        } else if (collision()) {
            ya = -breakout.getSpeed();
        }
        xPos = xPos + xa;
        yPos = yPos + ya;
    }

    /* -------------------- How to check collision ---------------------- */
    /**
     * To have some type of collusion, the brick needs to have bounds In the class
     * Rectangle, there is a getBounds method
     *
     * @return rectangle's outer most values
     */
    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, diameter, diameter);
    }

    /**
     * There also needs to be collision between the brick and the ball the following
     * method will take care of the collision
     * 
     * @return true if the ball intersects the brick
     */
    public boolean collision() {
        return breakout.getPaddle().getBounds().intersects(getBounds());
    }
    /* ------------------- Getters and Setters -------------------- */

    public void setYA(int newValue) {
        ya = newValue;
    }
}


