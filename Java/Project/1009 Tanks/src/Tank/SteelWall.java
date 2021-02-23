package Tank;

import javax.swing.*;
import java.awt.*;

public class SteelWall extends Wall{

    SteelWall(int index, int xCoord, int yCoord, ImageIcon wallImg, EntityController et) {
        super(index, xCoord, yCoord, wallImg, et);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(super.getwallImg().getImage(), (int) super.getX(), (int) super.getY(), null);
    }

    @Override
    public void tick() {
        collision();
    }
}
