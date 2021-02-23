package Tank;

import javax.swing.*;
import java.awt.*;

public class MoissaniteWall extends Wall{

	private boolean p1Armor = false;
	private boolean p2Armor = false;

	MoissaniteWall(int index, int xCoord, int yCoord, ImageIcon wallImg, EntityController et) {
		super(index, xCoord, yCoord, wallImg, et);
	}

	public void tick() {collision(); setDebuff();}

	public void collision() {
		for(int i = 0; i < super.getEt().entity.size(); i++){
			Entity tempBullet = super.getEt().entity.get(i);
			if(tempBullet.getIndex() == 3) {
				if(getHitBox().intersects(tempBullet.getHitBox())) {
					if(((Bullet) tempBullet).getSource() == "p1"){
						p1Armor = true;
					}
					if(((Bullet) tempBullet).getSource() == "p2"){
						p2Armor= true;
					}
					super.getEt().removeObject(tempBullet);
				}
			}
		}
	}

	private void setDebuff(){
		if(p1Armor){
			for(int i = 0; i < super.getEt().entity.size(); i++){
				Entity temp = super.getEt().entity.get(i);
				if(temp.getIndex() == 1){
					//Minimum 0 Armor Points
					if(((Tank) temp).getArmor() > 0){
						((Tank) temp).setArmor(((Tank) temp).getArmor() - 1);
						Gameplay.Armor1 -= 1;
					}
					p1Armor = false;
				}
			}
		}
		if(p2Armor){
			for(int i = 0; i < super.getEt().entity.size(); i++){
				Entity temp = super.getEt().entity.get(i);
				if(temp.getIndex() == 2){
					//Minimum 0 Armor Points
					if(((Tank) temp).getArmor() > 0){
						((Tank) temp).setArmor(((Tank) temp).getArmor() - 1);
						Gameplay.Armor2 -= 1;
					}
					p2Armor = false;
				}
			}
		}


	}

	public void render(Graphics g) {
		g.drawImage(super.getwallImg().getImage(), (int) super.getX(), (int) super.getY(), null);
	}
}
