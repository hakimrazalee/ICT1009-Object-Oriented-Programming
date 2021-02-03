import javax.swing.*;
import java.awt.*;


public class BallTest extends JPanel {
    BallDisplay golfBall = new BallDisplay(10, 50, 20, Color.WHITE);
    BallDisplay basketBall = new BallDisplay(50, 80, 180, Color.RED);
    BallDisplay volleyBall = new BallDisplay(30, 200, 220, Color.getHSBColor(226, 220, 205));
    BackgroundBox bg = new BackgroundBox();

    BallTest() {
        this.setPreferredSize(new Dimension(bg.width, bg.height));
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Set up main window (using Swing's JFrame)
                JFrame frame = new JFrame("Draw Ball");
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new BallTest());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    // Paint background

        // Draw the box
        g.setColor(bg.color);
        g.fillRect(0, 0, bg.width, bg.height);

        // Draw the ball
        g.setColor(golfBall.color);
        // drawing the ball
        g.fillOval((int) (golfBall.ballCenterX - golfBall.radius), (int) (golfBall.ballCenterY - golfBall.radius),
                (int) (2 * golfBall.radius), (int) (2 * golfBall.radius));

        // Draw the ball
        g.setColor(basketBall.color);
        // drawing the ball
        g.fillOval((int) (basketBall.ballCenterX - basketBall.radius), (int) (basketBall.ballCenterY - basketBall.radius),
                (int) (2 * basketBall.radius), (int) (2 * basketBall.radius));

        // Draw the ball
        g.setColor(volleyBall.color);
        // drawing the ball
        g.fillOval((int) (volleyBall.ballCenterX - volleyBall.radius), (int) (volleyBall.ballCenterY - volleyBall.radius),
                (int) (2 * volleyBall.radius), (int) (2 * volleyBall.radius));


    }

}

class BackgroundBox {
    final int width;
    final int height;
    final int updateRate;
    Color color;

    public BackgroundBox() {
        this.width = 640;
        this.height = 480;
        this.color = Color.BLACK;
        this.updateRate = 30;
    }

}
class BallDisplay {
    float radius;
    float ballPositionX;
    float ballPositionY;
    float ballCenterX;
    float ballCenterY;
    Color color;

    BallDisplay() {
        this.radius = 20;
        this.ballPositionX = 50;
        this.ballPositionY = 20;
        this.color = Color.WHITE;
        ballCenterX = 0;
        ballCenterY = 0;
        CalculateBallCenter();
        getBallSize();
    }

    BallDisplay(float radius, float ballPositionX, float ballPositionY, Color color) {
        this.radius = radius;
        this.ballPositionX = ballPositionX;
        this.ballPositionY = ballPositionY;
        this.color = color;
        CalculateBallCenter();
        getBallSize();
    }

    public void CalculateBallCenter() {
        this.ballCenterX += this.ballPositionX;
        this.ballCenterY += this.ballPositionY;
    }

    public int getBallSize() {
        return this.radius;
    }
}

