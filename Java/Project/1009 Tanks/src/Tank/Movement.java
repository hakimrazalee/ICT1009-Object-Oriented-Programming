package Tank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;

public class Movement extends KeyAdapter{
	
	
	private final EntityController et;
	private final Sound shootSound = Gameplay.getShooting();
	private final Sound pauseSound = Gameplay.getClickSound();
	private final boolean[] keydown1 = new boolean[5];
	private final boolean[] keydown2 = new boolean[5];
	
	public Movement(EntityController et) {
		this.et = et;
		keydown1[0] = false;
		keydown1[1] = false;
		keydown1[2] = false;
		keydown1[3] = false;
		keydown1[4] = false;
		keydown2[0] = false;
		keydown2[1] = false;
		keydown2[2] = false;
		keydown2[3] = false;
		keydown2[4] = false;
	}



	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

			if(key == KeyEvent.VK_ESCAPE && Gameplay.getState() == Gameplay.STATE.GAME){
				pauseSound.play();
				Gameplay.setState(2);
			} else if (key == KeyEvent.VK_ESCAPE && Gameplay.getState() == Gameplay.STATE.PAUSED){
				pauseSound.play();
				Gameplay.setState(3);
			}

		if(Gameplay.getState() == Gameplay.STATE.GAME){
			for(int i = 0; i < et.entity.size(); i++) {
				Entity temp = et.entity.get(i);

				if(temp.getIndex() == 1) {
					//PLAYER 1
					if(key == KeyEvent.VK_W) {
						keydown1[0] = true;
						((Tank) temp).setOrientation("W");
						((Tank) temp).setTankImg(new ImageIcon("src/Images/p1TankW.png"));
						((Tank) temp).setySpeed(-((Tank) temp).getDefaultSpeed());
					}

					if(key == KeyEvent.VK_S) {
						keydown1[1] = true;
						((Tank) temp).setOrientation("S");
						((Tank) temp).setTankImg(new ImageIcon("src/Images/p1TankS.png"));
						((Tank) temp).setySpeed(((Tank) temp).getDefaultSpeed());
					}

					if(key == KeyEvent.VK_A) {
						keydown1[2] = true;
						((Tank) temp).setOrientation("A");
						((Tank) temp).setTankImg(new ImageIcon("src/Images/p1TankA.png"));
						((Tank) temp).setxSpeed(-((Tank) temp).getDefaultSpeed());
					}

					if(key == KeyEvent.VK_D) {
						keydown1[3] = true;
						((Tank) temp).setOrientation("D");
						((Tank) temp).setTankImg(new ImageIcon("src/Images/p1TankD.png"));
						((Tank) temp).setxSpeed(((Tank) temp).getDefaultSpeed());
					}

					//Player 1 Bullet
					if(key == KeyEvent.VK_SPACE && ((Tank) temp).getOrientation().equals("W") && !keydown1[4]){
						shootSound.play();
						keydown1[4] = true;
						et.addObject(new Bullet(new ImageIcon("src/Images/Bullets/bullet1.png"),
								3, temp.getX(),(temp.getY()-30), 1, "p1", et) );
					}

					if(key == KeyEvent.VK_SPACE && ((Tank) temp).getOrientation().equals("A") && !keydown1[4]){
						shootSound.play();
						keydown1[4] = true;
						et.addObject(new Bullet(new ImageIcon("src/Images/Bullets/bullet1d.png"),
								3, (temp.getX()-30),temp.getY(), 2, "p1", et));
					}

					if(key == KeyEvent.VK_SPACE && ((Tank) temp).getOrientation().equals("S") && !keydown1[4]){
						shootSound.play();
						keydown1[4] = true;
						et.addObject(new Bullet(new ImageIcon("src/Images/Bullets/bullet1c.png"),
								3, temp.getX(),(temp.getY()+30), 3, "p1", et));
					}

					if(key == KeyEvent.VK_SPACE && ((Tank) temp).getOrientation().equals("D") && !keydown1[4]){
						shootSound.play();
						keydown1[4] = true;
						et.addObject(new Bullet(new ImageIcon("src/Images/Bullets/bullet1b.png"),
								3, (temp.getX()+30),temp.getY(), 4, "p1", et));
					}
				}

				if(temp.getIndex() == 2) {
					//PLAYER 2
					if(key == KeyEvent.VK_UP) {
						keydown2[0] = true;
						((Tank) temp).setOrientation("W");
						((Tank) temp).setTankImg(new ImageIcon("src/Images/p2TankW.png"));
						((Tank) temp).setySpeed(-((Tank) temp).getDefaultSpeed());
					}
					if(key == KeyEvent.VK_DOWN) {
						keydown2[1] = true;
						((Tank) temp).setOrientation("S");
						((Tank) temp).setTankImg(new ImageIcon("src/Images/p2TankS.png"));
						((Tank) temp).setySpeed(((Tank) temp).getDefaultSpeed());
					}
					if(key == KeyEvent.VK_LEFT) {
						keydown2[2] = true;
						((Tank) temp).setOrientation("A");
						((Tank) temp).setTankImg(new ImageIcon("src/Images/p2TankA.png"));
						((Tank) temp).setxSpeed(-((Tank) temp).getDefaultSpeed());
					}
					if(key == KeyEvent.VK_RIGHT) {
						keydown2[3] = true;
						((Tank) temp).setOrientation("D");
						((Tank) temp).setTankImg(new ImageIcon("src/Images/p2TankD.png"));
						((Tank) temp).setxSpeed(((Tank) temp).getDefaultSpeed());
					}

					//Player 2 Bullet
					else if(key == KeyEvent.VK_ENTER && ((Tank) temp).getOrientation().equals("W") && !keydown2[4]){
						shootSound.play();
						keydown2[4] = true;
						et.addObject(new Bullet(new ImageIcon("src/Images/Bullets/bullet2.png"),
								3, temp.getX(),(temp.getY()-30), 1, "p2", et));
					} else if(key == KeyEvent.VK_ENTER && ((Tank) temp).getOrientation().equals("A")&& !keydown2[4]){
						shootSound.play();
						keydown2[4] = true;

						et.addObject(new Bullet(new ImageIcon("src/Images/Bullets/bullet2d.png"),
								3, (temp.getX()-30),temp.getY(), 2, "p2", et));
					} else if(key == KeyEvent.VK_ENTER && ((Tank) temp).getOrientation().equals("S")&& !keydown2[4]){
						shootSound.play();
						keydown2[4] = true;
						et.addObject(new Bullet(new ImageIcon("src/Images/Bullets/bullet2c.png"),
								3, temp.getX(),(temp.getY()+30), 3, "p2", et));
					} else if(key == KeyEvent.VK_ENTER && ((Tank) temp).getOrientation().equals("D")&& !keydown2[4]){
						shootSound.play();
						keydown2[4] = true;
						et.addObject(new Bullet(new ImageIcon("src/Images/Bullets/bullet2b.png"),
								3, (temp.getX()+30),temp.getY(), 4, "p2", et));
					}
				}
			}
		}

	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();

		for(int i = 0; i < et.entity.size(); i++) {
			Entity temp = et.entity.get(i);
			
			if(temp.getIndex() == 1) {
				//PLAYER 1
				if(key == KeyEvent.VK_W) keydown1[0]=false;

				if(key == KeyEvent.VK_S) keydown1[1]=false;
				
				if(key == KeyEvent.VK_A) keydown1[2]=false;
				
				if(key == KeyEvent.VK_D) keydown1[3]=false;
				
				if (key == KeyEvent.VK_SPACE){
					keydown1[4] = false;
				}
				
				if(!keydown1[0] && !keydown1[1])((Tank) temp).setySpeed(0);
				if(!keydown1[2] && !keydown1[3])((Tank) temp).setxSpeed(0);
			}
			
			if(temp.getIndex() == 2) {
				//PLAYER 2
				if(key == KeyEvent.VK_UP) keydown2[0]=false;

				if(key == KeyEvent.VK_DOWN) keydown2[1]=false;
				
				if(key == KeyEvent.VK_LEFT) keydown2[2]=false;
				
				if(key == KeyEvent.VK_RIGHT) keydown2[3]=false;
				
				if (key == KeyEvent.VK_ENTER){
					keydown2[4] = false;
				}
				
				if(!keydown2[0] && !keydown2[1])((Tank) temp).setySpeed(0);
				if(!keydown2[2] && !keydown2[3])((Tank) temp).setxSpeed(0);
			}
		}
	}
}