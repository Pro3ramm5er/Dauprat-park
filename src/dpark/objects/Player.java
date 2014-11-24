package dpark.objects;

import java.awt.event.KeyEvent;

import dpark.Game;
import dpark.GameObject;

import static dpark.DB.db;
//import dpark.objects.Coll.Phisyc;

public class Player extends GameObject {
	
    
	private int inertion = 0;
	public int direction = 0;
    public static int x1;
    public static int y1;
    public static int[] plxmas1 = {plx, plx-1, plx-2, plx-3, plx-4, plx-5, plx-6, plx-7,  plx-9,plx-10, plx, plx+1, plx+2, plx+3, plx+4, plx+5, plx+6, plx+7, plx+8, plx+9, plx+10};

    public static int[] plymas1 = {ply, ply-1, ply-2, ply-3, ply-4, ply-5, ply-6, ply-7,  ply-9, ply-10, ply, ply+1, ply+2, ply+3, ply+4, ply+5, ply+6, ply+7, ply+8, ply+9, ply+10};

	public Player(String name) {
		
		super(name);
		//CanMovie = false;
		
		

		sprite.addStep(Game.instance.getSprite("hero.png"));
		sprite.addStep(Game.instance.getSprite("hero.png"));
		sprite.addStep(Game.instance.getSprite("hero_front.png"));
		sprite.addStep(Game.instance.getSprite("hero_front.png"));

		plx1 = x;
		ply = y;
	}
	public static void Collision() {
        if (Checkr == 0) {
            PlayerCanMovie = 1;

            PlayerColSt = PlayerWalkst;
            Checkr = 1;
        }
	}

	@Override
	public void update() {
		
		super.update();
        /*
        CheckPlayer(plx, ply);
        CheckPlayer(plx+5, ply);
        CheckPlayer(plx-5, ply);
        CheckPlayer(plx, ply+5);
        CheckPlayer(plx, ply-5);
        CheckPlayer(plx+5, ply+5);
        CheckPlayer(plx-5, ply-5);
        CheckPlayer(plx+5, ply-5);
        CheckPlayer(plx-5, ply+5);
        */


		//if (PlayerCanMovie == 0)
		//{
		inertion--;
		if (inertion < 0)
			inertion = 0;
		if (direction == 0) {
			y -= inertion;
		} else if (direction == 90) {
			x += inertion;
		} else if (direction == 180) {
			y += inertion;
		} else if (direction == 270) {
			x -= inertion;
		}
        x1 = x;
        y1 = y;




		plx = x;
		ply = y;
		plx1 = x+1;
        ply1 = y+1;
        plx2 = x-1;
        ply2 = y-1;
        plx3 = x+2;
        ply3 = y+2;
        plx4 = x-2;
        ply4 = y-2;
        plx5 = x+3;
        ply5 = y+3;
        plx6 = x-3;
        ply6 = y-3;
        plx7 = x+4;
        ply7 = y+4;
        plx8 = x-4;
        ply8 = y-4;
        plx9 = x+5;
        ply9 = y+5;
        plx10 = x-5;
        ply10 = y-5;
        plx11 = x+6;
        ply11 = y+6;
        plx12 = x-6;
        ply12 = y-6;
        plx13 = x+7;
        ply13 = y+7;
        plx14 = x-7;
        ply14 = y-7;
        plx15 = x+8;
        ply15 = y+8;
        plx16 = x-8;
        ply16 = y-8;
        plx17 = x+9;
        ply17 = y+9;
        plx18 = x-9;
        ply18 = y-9;
        plx19 = x+10;
        ply19 = y+10;
        plx20 = x-10;
        ply20 = y-10;
        plx21 = x+11;
        ply21 = y+11;
        plx22 = x-11;
        ply22 = y-11;
        plx23 = x+12;
        ply23 = y+12;
        plx24 = x-12;
        ply24 = y-12;
        plx25 = x+13;
        ply25 = y+13;
        plx26 = x-13;
        ply26 = y-13;
        plx27 = x+14;
        ply27 = y+14;
        plx28 = x-14;
        ply28 = y-14;
        plx29 = x+15;
        ply29 = y+15;
        plx30 = x-15;
        ply30 = y-15;
        plx31 = x+16;
        ply31 = y+16;
        plx32 = x-16;
        ply32 = y-16;
        plx31 = x+16;
        ply31 = y+16;
        plx32 = x-16;
        ply32 = y-16;
        plx33 = x+17;
        ply33 = y+17;
        plx34 = x-17;
        ply34 = y-17;
        plx35 = x+18;
        ply35 = y+18;
        plx36 = x-18;
        ply36 = y-18;
        plx37 = x+19;
        ply37 = y+19;
        plx38 = x-19;
        ply38 = y-19;
        plx39 = x+20;
        ply39 = y+20;
        plx40 = x-20;
        ply40 = y-20;
        plx41 = x+21;
        ply41 = y+21;
        plx42 = x-21;
        ply42 = y-21;
        plx43 = x+22;
        ply43 = y+22;
        plx44 = x-22;
        ply44 = y-22;
        plx45 = x+23;
        ply45 = y+23;
        plx46 = x-23;
        ply46 = y-23;
        plx47 = x+24;
        ply47 = y+24;
        plx48 = x-24;
        ply48 = y-24;
        plx49 = x+25;
        ply49 = y+25;
        plx50 = x-25;
        ply50 = y-25;
        plx51 = x+26;
        ply51 = y+26;
        plx52 = x-26;
        ply52 = y-26;
        plx53 = x+27;
        ply53 = y+27;
        plx54 = x-27;
        ply54 = y-27;
        plx55 = x+29;
        ply55 = y+29;
        plx56 = x-29;
        ply56 = y-29;
        plx57 = x+31;
        ply57 = y+31;
        plx58 = x-31;
        ply58 = y-31;

	}
	
	
	@Override
	public void onKeyPress(int keycode) {
		
		super.onKeyPress(keycode);
		
	
		
		if (keycode == KeyEvent.VK_A) {

            if (PlayerColSt != 4) {
                Checkr = 0;
                PlayerWalkst = 4;
                PlayerColSt = 0;
                sprite.currentStep = 1;
                //if (PlayerCanMovie == 0)
                //{

                inertion += 2;
                direction = 270;
                //}
			}
			plx = x;
			ply = y;
		}
		if (keycode == KeyEvent.VK_D) {
            if (PlayerColSt != 2) {
                Checkr = 0;
                PlayerColSt = 0;
                PlayerWalkst = 2;
                sprite.currentStep = 1;
                //if (PlayerCanMovie == 0)
                //{

                inertion += 2;
                direction = 90;
               // }
			}
			plx = x;
			ply = y;
		}
		if (keycode == KeyEvent.VK_W) {
            if (PlayerColSt != 1) {
                Checkr = 0;
                PlayerColSt = 0;
                PlayerWalkst = 1;
                sprite.currentStep = 3;
                //if (PlayerCanMovie ==0)
                //{

                inertion += 2;
                direction = 0;
                //}
			}
			plx = x;
			ply = y;
		}
		if (keycode == KeyEvent.VK_S) {

			//if (PlayerCanMovie == 0)
			//{
            if (PlayerColSt != 3) {
                Checkr = 0;
                PlayerColSt = 0;
                PlayerWalkst = 3;
                sprite.currentStep = 3;
                //if (PlayerCanMovie ==0)
                //{

                    inertion += 2;
                    direction = 180;
                //}
            }
			//}
			plx = x;
			ply = y;
		}
		
		if (keycode == KeyEvent.VK_P) {
		 
			//x = x1;
			//y = y1;

		}
		if (keycode == KeyEvent.VK_J) {

           KeyMessage.GetReset = 100;




		}
        if (keycode == KeyEvent.VK_I) {

            x = 250;
            y = 250;
            plx = 250;
            ply = 250;

        }
        if (keycode == KeyEvent.VK_M) {

            Player.Collision();

        }
	
		if (inertion > 5)
		{	
			inertion = 5;
		}
	    
	}
}
