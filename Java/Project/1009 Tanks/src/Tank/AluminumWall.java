package Tank;

import javax.swing.ImageIcon;
import java.awt.*;

public class AluminumWall extends Wall{

    private boolean p1Speed = false;
    private boolean p2Speed = false;

    AluminumWall(int index, int xCoord, int yCoord, ImageIcon wallImg, EntityController et) {
        super(index, xCoord, yCoord, wallImg, et);
    }

    @Override
    public void tick() {
        collision();
        setBuff();
    }

    public void collision() {
        for(int i = 0; i < super.getEt().entity.size(); i++){
            Entity tempBullet = super.getEt().entity.get(i);
            if(tempBullet.getIndex() == 3) {
                if(getHitBox().intersects(tempBullet.getHitBox())) {
                    if(((Bullet) tempBullet).getSource() == "p1"){
                        p1Speed = true;
                    }
                    if(((Bullet) tempBullet).getSource() == "p2"){
                        p2Speed = true;
                    }
                    super.getEt().removeObject(tempBullet);
                    super.getEt().removeObject(this);
                }
            }
        }
    }

    private void setBuff(){
        if(p1Speed){
            for(int i = 0; i < super.getEt().entity.size(); i++){
                Entity temp = super.getEt().entity.get(i);
                if(temp.getIndex() == 1){
                    ((Tank) temp).setDefaultSpeed(8);
                    p1Speed = false;
                }
            }
        }
        if(p2Speed){
            for(int i = 0; i < super.getEt().entity.size(); i++){
                Entity temp = super.getEt().entity.get(i);
                if(temp.getIndex() == 2){
                    ((Tank) temp).setDefaultSpeed(8);
                    p2Speed = false;
                }
            }
        }


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(super.getwallImg().getImage(), (int) super.getX(), (int) super.getY(), null);
    }
}
