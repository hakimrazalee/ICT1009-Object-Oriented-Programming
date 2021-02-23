package Tank;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Wall implements Entity{
	private int index;
	private float xCoord, yCoord;
	private ImageIcon wallImg;
	private EntityController et;

	
	Wall(int index, int xCoord, int yCoord, ImageIcon wallImg, EntityController et){
		this.index = index;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.wallImg = wallImg;
		this.et = et;
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

	public float getY() {
		return yCoord;
	}
	
	public void setX(int xCoord) {
		this.xCoord = xCoord;
	}
	
	public void setY(int yCoord) {
		this.yCoord = yCoord;
	}
	
	public ImageIcon getwallImg() {
		return wallImg;
	}

	public EntityController getEt(){ return et;}

	public void setwallImg(ImageIcon wallImg) {
		this.wallImg = wallImg;
	}
	
	public void removeWallImg() {
		this.wallImg = null;
	}

	public void collision() {
		for(int i = 0; i < et.entity.size(); i++){
            Entity tempWall = et.entity.get(i);
            if(tempWall.getIndex() == 3) {
            	if(getHitBox().intersects(tempWall.getHitBox())) {
            		et.removeObject(tempWall);   
            	}        		
            }        
        }
	}
	
	abstract public void render(Graphics g);

	abstract public void tick();

	public Rectangle getHitBox() {
		return new Rectangle((int) xCoord, (int) yCoord, 40, 40 );
	}

}