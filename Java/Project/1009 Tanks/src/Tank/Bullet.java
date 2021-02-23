package Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Bullet implements Entity{
	
	ImageIcon bulletImage;
    BufferedImage image;
    private float x;
    private float y;
    private final int index;
    private final int otation;
    private final String source;
    private final EntityController et;

    public Bullet(ImageIcon img, int index, float x, float y, int otation, String source, EntityController et) {
        this.x = x;
        this.y = y;
        this.index = index;
        this.bulletImage = img;
        this.otation = otation;
        this.source = source;
        this.et = et;

    }


	public void tick(){
       if (otation == 1){
           y -= 10;
       } else if (otation == 2){
           x -= 10;
       } else if (otation == 3) {
    	   y += 10;
       } else if (otation == 4) {
           x += 10;
       }
       
       collision();
    }
	
	private void collision() {
		for(int i = 0; i < et.entity.size(); i++){
            Entity TempBullet = et.entity.get(i);
            if(TempBullet.getIndex() == 3) {
            	if(TempBullet.getY() < 0 || TempBullet.getX() < 0 || TempBullet.getX() > 800 || TempBullet.getY() > 570 ){
            		et.removeObject(TempBullet);
            	}
            }        
        }
	}

    public void render(Graphics g) {
        g.drawImage(bulletImage.getImage(), (int) x, (int) y, null);
    }
    
    public Rectangle getHitBox() {
    		return new Rectangle((int) x, (int) y, 30, 30);
    }
    
    public String getSource() {
		return source;
	}
    
    public float getY(){
        return y;
    }

    public float getX(){
        return x;
    }

	public int getIndex() {
		return index;
	}
}
