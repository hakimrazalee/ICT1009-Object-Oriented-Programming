package Tank;
import java.awt.Graphics;
import java.util.LinkedList;

public class EntityController {
	
	LinkedList<Entity> entity = new LinkedList<Entity>();
	
	public void tick(){
		for(int i = 0; i < entity.size(); i++) {
			Entity temp = entity.get(i);
			temp.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < entity.size(); i++) {
			Entity temp = entity.get(i);
			temp.render(g);
		}
	}
	
	public void addObject(Entity entity) {
		this.entity.add(entity);
	}
	
	public void removeObject(Entity entity) {
		this.entity.remove(entity);
	}
	
	public void clear() {
		this.entity.clear();
	}
}
