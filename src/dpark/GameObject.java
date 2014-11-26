package dpark;

import java.awt.Graphics;
import java.util.Comparator;
import static dpark.DB.db;
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
    public static int plx5;
    public static int ply5;
    public static int plx6;
    public static int ply6;
    public static int plx7;
    public static int ply7;
    public static int plx8;
    public static int ply8;
    public static int plx9;
    public static int ply9;
    public static int plx10;
    public static int ply10;
    public static int plx11;
    public static int ply11;
    public static int plx12;
    public static int ply12;
    public static int plx13;
    public static int ply13;
    public static int plx14;
    public static int ply14;
    public static int plx15;
    public static int ply15;
    public static int plx16;
    public static int ply16;
    public static int plx17;
    public static int ply17;
    public static int plx18;
    public static int ply18;
    public static int plx19;
    public static int ply19;
    public static int plx20;
    public static int ply20;
    public static int plx21;
    public static int ply21;
    public static int plx22;
    public static int ply22;
    public static int plx23;
    public static int ply23;
    public static int plx24;
    public static int ply24;
    public static int plx25;
    public static int ply25;
    public static int plx26;
    public static int ply26;
    public static int plx27;
    public static int ply27;
    public static int plx28;
    public static int ply28;
    public static int plx29;
    public static int ply29;
    public static int plx30;
    public static int ply30;
    public static int plx31;
    public static int ply31;
    public static int plx32;
    public static int ply32;
    public static int plx33;
    public static int ply33;
    public static int plx34;
    public static int ply34;
    public static int plx35;
    public static int ply35;
    public static int plx36;
    public static int ply36;
    public static int plx37;
    public static int ply37;
    public static int plx38;
    public static int ply38;
    public static int plx39;
    public static int ply39;
    public static int plx40;
    public static int ply40;
    public static int plx41;
    public static int ply41;
    public static int plx42;
    public static int ply42;
    public static int plx43;
    public static int ply43;
    public static int plx44;
    public static int ply44;
    public static int plx45;
    public static int ply45;
    public static int plx46;
    public static int ply46;
    public static int plx47;
    public static int ply47;
    public static int plx48;
    public static int ply48;
    public static int plx49;
    public static int ply49;
    public static int plx50;
    public static int ply50;
    public static int plx51;
    public static int ply51;
    public static int plx52;
    public static int ply52;
    public static int plx53;
    public static int ply53;
    public static int plx54;
    public static int ply54;
    public static int plx55;
    public static int ply55;
    public static int plx56;
    public static int ply56;
    public static int plx57;
    public static int ply57;
    public static int plx58;
    public static int ply58;


    //public class Coll {


        public static int PlayerColSt = 0; // 1 - up; 2 - right; 3 - down; 4 - left
        public static int PlayerWalkst = 0;
	    public int CanMovie = 0;
	    public static int PlayerCanMovie = 0;
        public static int Checkr = 0;

	//}
	public void CheckSuf(int x, int y, int xcheck, int ycheck, int iscontrol)
    {
        /*
        int g = x+y;
        int u = xcheck+ycheck;
        if (g == u)
        {
            iscontrol = 1;
        }
        */
        if (x == xcheck && y == ycheck)
        {
            iscontrol = 1;
        } else {

            iscontrol = 0;
        }
        /*
        if (x == xcheck)
        {
            iscontrol = 1;
        }
        if (y == ycheck)
        {
            iscontrol = 1;
        }
        */
    }
	
	
	
	
	
	
	
	
	
	
	
	
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
    public void Remove(String RMN)
    {
       db.objects.remove(RMN);


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
