package Tank;


import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Tank implements Entity{

	Texture tex = Gameplay.getInstance();
	Sound diedSound = Gameplay.getDiedSound();
	Sound explodeSound = Gameplay.getExplosionSound();

	Animation explosionAnimation = new Animation(5,
									   tex.explosion[0],
									   tex.explosion[1],
									   tex.explosion[2],
									   tex.explosion[3],
									   tex.explosion[4],
									   tex.explosion[5],
									   tex.explosion[6],
									   tex.explosion[7],
									   tex.explosion[8],
									   tex.explosion[9],
									   tex.explosion[10],
									   tex.explosion[11],
									   tex.explosion[12],
									   tex.explosion[13],
									   tex.explosion[14],
									   tex.explosion[15]);
	private static Graphics l;
	private float xCoord, yCoord , xSpeed, ySpeed;
	private float defaultSpeed;
	private int index;	
	private int health;
	private int armor;
	private ImageIcon tankImg;
	private String orientation;
	private final EntityController et;
	private int lives;
	private int bulletX1, bulletX2, bulletY2, bulletY1;




	Tank(int index, float xCoord, float yCoord,ImageIcon tankImg, String orientation, EntityController et){

		this.xCoord = xCoord;
		this.yCoord = yCoord; 
		this.index = index;
		this.tankImg = tankImg;		
		this.orientation = orientation;
		this.et = et;
		defaultSpeed = 5;
		armor = 0;
		health = 180;
		lives = 3;
	}

	public float getDefaultSpeed() {
		return defaultSpeed;
	}
	
	public void setDefaultSpeed(float defaultSpeed) {
		this.defaultSpeed = defaultSpeed;
	}
	
	public void setOrientation(String orientation){ 
		this.orientation = orientation; 
	}
	
	public String getOrientation(){ 
		return orientation; 
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public float getX() {
		return xCoord;
	}
	
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	
	public float getY() {
		return yCoord;
	}
	
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	
	public ImageIcon getTankImg() {
		return tankImg;
	}
	
	public void setTankImg(ImageIcon tankImg) {
		this.tankImg = tankImg;
	}
	
	public float getxSpeed() {
		return xSpeed;
	}
	
	public void setxSpeed(float speed) {
		this.xSpeed = speed;
	}
	
	public float getySpeed() {
		return ySpeed;
	}
	
	public void setySpeed(float speed) {
		this.ySpeed = speed;
	}

	public int getArmor(){ return armor; }

	public void setArmor(int armor){this.armor = armor;}

	public void tick() {
		xCoord += xSpeed;
		yCoord += ySpeed;

		if(xCoord <= 0)
			xCoord = 0;
		if(xCoord >= 800)
			xCoord = 800;
		if (yCoord <=0)
			yCoord = 0;
		if(yCoord >= 570)
			yCoord = 570;


		collision();
		explosionAnimation.runAnimation();

	}
	
	public void collision() {
		for(int i = 0; i < et.entity.size(); i++) {
			Entity temp = et.entity.get(i);
			if(temp.getIndex() == 3) {
				if(getHitBox().intersects(temp.getHitBox())) {
					if(getIndex() == 1 && ((Bullet) temp).getSource().equals("p2")) {
						//Removes Bullet upon collision

						et.entity.remove(temp);
						bulletX1 = (int) temp.getX();
						bulletY1 = (int) temp.getY();
//						System.out.println("hit by t2");

						//If no armor, then deplete health
						if(getArmor() > 0){
							setArmor(getArmor() - 1);
							Gameplay.Armor1 -= 1;
						}else{
							Gameplay.HEALTH1 -= 30;
						}

						if(Gameplay.HEALTH1 <= 0) {
							diedSound.play();
							Gameplay.Lives1 -= 1;
							if(Gameplay.Lives1 <= 0){
								Gameplay.HEALTH1 = 0;
							} else {
								Gameplay.HEALTH1 = 180;
							}

						}
					}
				
					if(getIndex() == 2 && ((Bullet) temp).getSource().equals("p1")) {
						et.entity.remove(temp);
						bulletX2 = (int) temp.getX();
						bulletY2 = (int) temp.getY();
//						System.out.println("hit by t1");

						//If no armor, then deplete health
						if(getArmor() > 0){
							setArmor(getArmor() - 1);
							Gameplay.Armor2 -= 1;
						}else{
							Gameplay.HEALTH2 -= 30;
						}
						 if(Gameplay.HEALTH2 <= 0) {
							diedSound.play();
							Gameplay.Lives2 -= 1;
							 if(Gameplay.Lives2 <= 0){
								 Gameplay.HEALTH2 = 0;
							 } else {
								 Gameplay.HEALTH2 = 180;
							 }

					}
				}
			}
		}
			
			//Collision Checking with Walls
			if(temp.getIndex() == 4) {
				//Check for Horizontal Collision
				if(getHBox().intersects(temp.getHitBox())) {
					if(xSpeed > 0) {
						xSpeed = 0;
						xCoord = temp.getX() - 30/*tank hitbox*/;
					}
					else if(xSpeed < 0){
						xSpeed = 0;
						xCoord = temp.getX() + 40/*wall hitbox*/;
					}
				}
				//Check for Vertical Collision
				if(getVBox().intersects(temp.getHitBox())) {
					if(ySpeed > 0) {
						ySpeed = 0;
						yCoord = temp.getY() - 30/*tank hitbox*/;
					}
					else if(ySpeed < 0){
						ySpeed = 0;
						yCoord = temp.getY() + 40/*wall hitbox*/;
					}
				}			
			} 
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(tankImg.getImage(), (int) xCoord, (int) yCoord, null);
		if (bulletX1 >= 1 && bulletY1>= 1) {
			if(Gameplay.Lives1 <= 0){
				explosionAnimation.drawAnimation(g, bulletX1, bulletY1);
			} else {
				explodeSound.play();
				explosionAnimation.drawAnimation(g, bulletX1, bulletY1);
				bulletX1 = 0;
				bulletY1 = 0;


			}

		}
		if (bulletX2 >= 1 && bulletY2 >= 1) {

			if(Gameplay.Lives1 <= 0){
				explosionAnimation.drawAnimation(g, bulletX2, bulletY2);
			} else {
				explodeSound.play();
				explosionAnimation.drawAnimation(g, bulletX2, bulletY2);
				bulletX2 = 0;
				bulletY2 = 0;
			}
		}
		if(armor > 0){
			g.setColor(Color.yellow);
			g.drawRect((int) xCoord, (int) yCoord, 30, 30);
		}

	}

	
	public Rectangle getHitBox() {
		return new Rectangle((int) xCoord, (int) yCoord, 30, 30);
	}
	
	//Horizontal HitBox
	public Rectangle getHBox() {
		float bx = xCoord + xSpeed;
		float by = yCoord;
		float bw = 30 + xSpeed/2;
		float bh = 30;
		return new Rectangle((int) bx, (int) by, (int)bw, (int)bh);
	}
	
	//Vertical HitBox
	public Rectangle getVBox() {
		float bx = xCoord;
		float by = yCoord + ySpeed;
		float bw = 30;
		float bh = 30 + ySpeed/2;
		return new Rectangle((int) bx, (int) by, (int)bw, (int)bh);
	}
}