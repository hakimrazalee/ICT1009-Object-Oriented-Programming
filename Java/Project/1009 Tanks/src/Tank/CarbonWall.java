package Tank;

import javax.swing.*;
import java.awt.*;

public class CarbonWall extends Wall{

	private boolean p1Speed = false;
	private boolean p2Speed = false;

	CarbonWall(int index, int xCoord, int yCoord, ImageIcon wallImg, EntityController et) {
		super(index, xCoord, yCoord, wallImg, et);
	}

	public void tick() {collision(); setDebuff();}

	public void collision() {
		for(int i = 0; i < super.getEt().entity.size(); i++){
			Entity tempBullet = super.getEt().entity.get(i);
			if(tempBullet.getIndex() == 3) {
				if(getHitBox().intersects(tempBullet.getHitBox())) {
					if(((Bullet) tempBullet).getSource() == "p1"){
						p1Speed = true;
					}
					if(((Bullet) tempBullet).getSource() == "p2"){
						p2Speed= true;
					}
					super.getEt().removeObject(tempBullet);
				}
			}
		}
	}

	private void setDebuff(){
		if(p1Speed){
			for(int i = 0; i < super.getEt().entity.size(); i++){
				Entity temp = super.getEt().entity.get(i);
				if(temp.getIndex() == 1){
					//Minimum Movement Speed has to be 1
					if(((Tank) temp).getDefaultSpeed() > 1){
						((Tank) temp).setDefaultSpeed(((Tank) temp).getDefaultSpeed() - 1);
						p1Speed = false;
					}
				}
			}
		}
		if(p2Speed){
			for(int i = 0; i < super.getEt().entity.size(); i++){
				Entity temp = super.getEt().entity.get(i);
				if(temp.getIndex() == 2){
					//Minimum Movement Speed has to be 1
					if(((Tank) temp).getDefaultSpeed() > 1){
						((Tank) temp).setDefaultSpeed(((Tank) temp).getDefaultSpeed() - 1);
						p2Speed = false;
					}
				}
			}
		}


	}

	public void render(Graphics g) {
		g.drawImage(super.getwallImg().getImage(), (int) super.getX(), (int) super.getY(), null);
	}
}
