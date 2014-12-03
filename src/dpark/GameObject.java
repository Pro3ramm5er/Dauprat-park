package dpark;

import java.awt.Graphics;
import java.util.Comparator;
import static dpark.DB.db;
import dpark.Game.*;
import dpark.Game;

public class GameObject {
	
	public static int plx;
	public static int ply;
    public static int plx1;
    public static int ply1;
    public static int plx2;
    public static int ply2;
    public static int plx3;
    public static int ply3;
    public static int plx4;
    public static int ply4;






        public static int PlayerColSt = 0; // 1 - up; 2 - right; 3 - down; 4 - left
        public static int PlayerWalkst = 0;

	    public static int PlayerCanMovie = 0;
        public static int Checkr = 0;



	
	
	
	
	
	
	
	
	
	
	
	
	public int StMovie;
	public Animation sprite;
	public String name = "";
	public int z = 0;
	public boolean visible = true;
	public int x = 0;
	public int y = 0;

	public GameObject(String name) {
		this.name = name;
		this.sprite = new Animation(name + "_synth_anm");
		sprite.currentStep = 0;
		sprite.isPlaying = false;
		StMovie = 1;
	}

	public void update() {
		sprite.update();
	}

	public void render(Graphics g) {
		if (visible) {
			Animation.Step step = sprite.getStep();
			if (step.sprite != null) {
				step.sprite.draw(g, x, y);
			}
		}
	}



	/**
	 * When key is NOW pressed
	 * 
	 * @param keycode
	 */
	public void onKeyPress(int keycode) {

	}
	
	

	/**
	 * When key was pressed and released.
	 * 
	 * @param keycode
	 */
	public void onKey(int keycode) {

	}

	public void onMouseClick() {
		System.out.println("Clicked object " + name);
	}

	public void onGlobalMouseClick(final double x, final double y) {
		if (visible) {
			if ((x >= this.x) && (y >= this.y)) {
				final Animation.Step st = sprite.getStep();
				if (st != null) {
					final Sprite spr = st.sprite;
					if (spr != null) {
						if ((this.x + spr.getWidth() > x)
								&& (this.y + spr.getHeight() > y)) {
							onMouseClick();
						}
					}
				}
			}
		}
	}

	public static final Comparator<GameObject> compareByDepth = new Comparator<GameObject>() {
		@Override
		public int compare(GameObject o1, GameObject o2) {
			return Integer.compare(o1.z, o2.z);
		}
	};
	public void Mouse_any_pressed(int mcode) {
		// TODO Auto-generated method stub
		
	}
}
