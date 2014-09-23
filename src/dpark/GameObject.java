package dpark;

import java.awt.Graphics;
import java.util.Comparator;

public class GameObject {
	public Animation sprite = new Animation();
	public int depth = 0;
	public boolean visible = true;
	public int x = 0;
	public int y = 0;

	public void init() {

	}

	public void update(long delta) {
		sprite.update(delta);
	}

	public void render(Graphics g) {
		if (visible) {
			Animation.Step step = sprite.getStep();
			if (step.sprite != null) {
				step.sprite.draw(g, x, y);
			}
		}
	}

	public static final Comparator<GameObject> compareByDepth = new Comparator<GameObject>() {
		@Override
		public int compare(GameObject o1, GameObject o2) {
			return Integer.compare(o1.depth, o2.depth);
		}
	};
}
