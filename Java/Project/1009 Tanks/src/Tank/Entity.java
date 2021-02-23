package Tank;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Entity {
	
	void tick();
	void render(Graphics g);

	float getX();
	float getY();
	//Tank 1 = 1, Tank 2 = 2, Bullet = 3, Wall = 4...
    int getIndex();
	Rectangle getHitBox();
}
