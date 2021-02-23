package Tank;

import javax.swing.*;
import java.awt.*;

public class DiamondWall extends Wall{

	private boolean p1Health = false;
	private boolean p2Health = false;

	DiamondWall(int index, int xCoord, int yCoord, ImageIcon wallImg, EntityController et) {
		super(index, xCoord, yCoord, wallImg, et);
	}

	public void tick() {collision(); setDebuff();}

	public void collision() {
		for(int i = 0; i < super.getEt().entity.size(); i++){
			Entity tempBullet = super.getEt().entity.get(i);
			if(tempBullet.getIndex() == 3) {
				if(getHitBox().intersects(tempBullet.getHitBox())) {
					if(((Bullet) tempBullet).getSource() == "p1"){
						p1Health = true;
					}
					if(((Bullet) tempBullet).getSource() == "p2"){
						p2Health= true;
					}
					super.getEt().removeObject(tempBullet);
				}
			}
		}
	}

	private void setDebuff(){
		if(p1Health){
			for(int i = 0; i < super.getEt().entity.size(); i++){
				Entity temp = super.getEt().entity.get(i);
				if(temp.getIndex() == 1){
						Gameplay.HEALTH1 -= 50;
						if(Gameplay.HEALTH1 <= 0) {
							Gameplay.Lives1 -= 1;
							Gameplay.HEALTH1 = 180;
						}
					p1Health = false;
				}
			}
		}
		if(p2Health){
			for(int i = 0; i < super.getEt().entity.size(); i++){
				Entity temp = super.getEt().entity.get(i);
				if(temp.getIndex() == 2){
						Gameplay.HEALTH2 -= 50;
						if(Gameplay.HEALTH2 <= 0) {
							Gameplay.Lives2 -= 1;
							Gameplay.HEALTH2 = 180;
					}
					p2Health = false;
				}
			}
		}


	}

	public void render(Graphics g) {
		g.drawImage(super.getwallImg().getImage(), (int) super.getX(), (int) super.getY(), null);
	}
}
