import java.awt.*;
import javax.swing.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.CYAN;

class BackgroundBox{
    final int width;
    final int height;
    Color color;
    final int updateRate;

    BackgroundBox() {
        width = 640;
        height = 480;
        color = BLACK;
        updateRate = 30;

    }
}

class Ball{
    float radius;
    float ballPositionX;
    float ballPositionY;
    float ballCenterX;
    float ballCenterY;
    Color color;

    Ball(){
        radius = 20;
        ballPositionX = 50;
        ballPositionY = 20;
        ballCenterX = 0;
        ballCenterY = 0;
        color = CYAN;
        calculateBallCenters(ballPositionX,ballPositionY);
        getBallSize(radius);

    };

    Ball(float r, float bX, float bY, float bXX, float bYY, Color color){
        this.radius = r;
        this.ballPositionX = bX;
        this.ballPositionY = bY;
        this.ballCenterX = bXX;
        this.ballCenterY = bYY;
        this.color = color;
    }

    void calculateBallCenters(float x, float y){
        this.ballCenterX = x;
        this.ballCenterY = y;
        ballCenterX += 50;
        ballCenterY += 20;
    }
    int getBallSize(float radius){
        this.radius = radius;
        float result = (radius * radius * radius * 4)/3;
        return (int) (result * Math.PI);

    }



}
public class BallTest extends JPanel{

//    // Container box's width and height
//    final int BOX_WIDTH = 640;
//    final int BOX_HEIGHT = 480;
//
//    static float ballRadius = 20; // Ball's radius
//    float ballX = ballRadius + 50; // Ball's center (x, y)
//    float ballY = ballRadius + 20;
//    static float ballSpeedX = 3;   // Ball's speed for x and y
//    float ballSpeedY = 2;
//
//    static Color ballColor = Color.RED;
//
//    final int UPDATE_RATE = 30; // Number of refresh per second

    //create new objects using the classes and constructors that we made
    Ball ball = new Ball();
    BackgroundBox bg = new BackgroundBox();

    /** Constructor to create the UI components and init game objects. */
    public BallTest() {
        this.setPreferredSize(new Dimension(bg.width, bg.height));
    }

    /** Custom rendering codes for drawing the JPanel */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    // Paint background

        // Draw the box
        g.setColor(bg.color);
        System.out.print("\nThe background colour is:" + bg.color);
        g.fillRect(0, 0, bg.width, bg.height);

        // Draw the ball
        System.out.print("\nThe ball colour is:" + ball.color);
        g.setColor(ball.color);
        // drawing the ball
        g.fillOval((int) (ball.ballCenterX - ball.radius), (int) (ball.ballCenterY - ball.radius),
                (int)(2 * ball.radius), (int)(2 * ball.radius));


    }

    /** main program (entry point) */
    public static void main(String[] args) {


        // change ball color xyz speed
        //take input from user
//        ballColor = Color.GREEN;
//        ballRadius= 100;
//        System.out.print("The color of the ball:" + ballColor);
//        System.out.print("\nThe radius of the ball:" + ballRadius);
        // Run GUI in the Event Dispatcher Thread (EDT) instead of main thread.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Set up main window (using Swing's Jframe)
                JFrame frame = new JFrame("Draw Ball");
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new BallTest());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
