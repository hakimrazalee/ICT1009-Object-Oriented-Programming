import java.awt.*;
import java.util.Formatter;
import javax.swing.*;

public class BallTest extends JPanel{

    // Container box's width and height
    final int BOX_WIDTH = 640;
    final int BOX_HEIGHT = 480;

    static float ballRadius = 20; // Ball's radius
    float ballX = ballRadius + 50; // Ball's center (x, y)
    float ballY = ballRadius + 20;
    static float ballSpeedX = 3;   // Ball's speed for x and y
    float ballSpeedY = 2;

    static Color ballColor = Color.RED;

    final int UPDATE_RATE = 30; // Number of refresh per second

    /** Constructor to create the UI components and init game objects. */
    public BallTest() {
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
    }

    /** Custom rendering codes for drawing the JPanel */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    // Paint background

        // Draw the box
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

        // Draw the ball
        g.setColor(ballColor);
        // drawing the ball
        g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
                (int)(2 * ballRadius), (int)(2 * ballRadius));


    }

    /** main program (entry point) */
    public static void main(String[] args) {


        // change ball color xyz speed
        //take input from user
        ballColor = Color.GREEN;
        ballRadius= 100;

        System.out.print("The color of the ball:" + ballColor);
        System.out.print("\nThe radius of the ball:" + ballRadius);
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
