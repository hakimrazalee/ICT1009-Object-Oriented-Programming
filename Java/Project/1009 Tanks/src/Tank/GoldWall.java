package Tank;

import javax.swing.*;
import java.awt.*;

public class GoldWall extends Wall{

	private boolean p1Armor = false;
	private boolean p2Armor = false;

	GoldWall(int index, int xCoord, int yCoord, ImageIcon wallImg, EntityController et) {
		super(index, xCoord, yCoord, wallImg, et);
	}

	public void tick() {collision(); setBuff();}

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
					super.getEt().removeObject(this);
				}
			}
		}
	}

	private void setBuff(){
		if(p1Armor){
			for(int i = 0; i < super.getEt().entity.size(); i++){
				Entity temp = super.getEt().entity.get(i);
				if(temp.getIndex() == 1){
					//Maximum 3 Armor Points
					if(((Tank) temp).getArmor() < 3){
						((Tank) temp).setArmor(((Tank) temp).getArmor() + 1);
						Gameplay.Armor1 += 1;
						p1Armor = false;
					}

				}
			}
		}
		if(p2Armor){
			for(int i = 0; i < super.getEt().entity.size(); i++){
				Entity temp = super.getEt().entity.get(i);
				if(temp.getIndex() == 2){
					//Maximum 3 Armor Points
					if(((Tank) temp).getArmor() < 3){
						((Tank) temp).setArmor(((Tank) temp).getArmor() + 1);
						Gameplay.Armor2 += 1;
						p2Armor = false;
					}

				}
			}
		}


	}

	public void render(Graphics g) {
		g.drawImage(super.getwallImg().getImage(), (int) super.getX(), (int) super.getY(), null);
	}
}
