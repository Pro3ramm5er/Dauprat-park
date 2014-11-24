package dpark.objects;

import dpark.Game;
import dpark.GameObject;

public class Crate extends GameObject {
	boolean STOP = true;
	public  int xt;
	public  int yt;
    public int xa2;
    public int ya2;
    public int xa3;
    public int ya3;
    public int xa4;
    public int ya4;
    public int xa5;
    public int ya5;
    public int[] myx = {1, 2, 3, 4 , 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,25 , 26,27, 28, 29, 30, 31,32};
    public int[] myy = {1, 2, 3, 4 , 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,25 , 26,27, 28, 29, 30, 31,32};

    public int g = 0;
	public int x_puse;
	public int y_puse;
	private int h = 1;
    public int playeris;
    public int[] u = { 15, 24, 52 };
    public int Timer = 0;
    public int otchet = 0;
    public int otchet2 = 0;
    public int otchet3 = 0;
    public int otchet4 = 0;
    public int otchet5 = 0;
    public int otchet6 = 0;
    public int Col_del = 0;

    int e = 2;
	public Crate(String name) {
		super(name);
		z = 0;
		



		
		
		
		sprite.addStep(Game.instance.getSprite("Blockstone.png"));
	    
	}
	@Override
	public void update() {
		super.update();



        //Collisions:
        if (Timer <= 0)
        {
            Col_del = 0;
            Timer = 0;
        } else {
            Timer--;
        }
        if (otchet == myx.length) {
            otchet = 0;
            System.out.println("OP....");
        }
        if (otchet3 == myx.length) {
            otchet3 = 0;
            System.out.println("OP....");
        }
        if (otchet5 == myx.length) {
            otchet5 = 0;
            System.out.println("OP....");
        }
        if (otchet2 == myy.length) {
            otchet2 = 0;
            System.out.println("OP2....");
        }
        if (otchet4 == myy.length) {
            otchet4 = 0;
            System.out.println("OP2....");
        }
        if (otchet6 == myy.length) {
            otchet6 = 0;
            System.out.println("OP2....");
        }





        if (xt - myx[otchet] == plx1 || xt + myx[otchet] == plx1 || xt - myx[otchet5] == plx1 || xt + myx[otchet5] == plx1 || xt - myx[otchet3] == plx1 || xt + myx[otchet3] == plx1 || xt - myx[otchet] == plx2 || xt + myx[otchet] == plx2 || xt - myx[otchet5] == plx2 || xt + myx[otchet5] == plx2 || xt - myx[otchet3] == plx2 || xt + myx[otchet3] == plx2 || xt - myx[otchet] == plx3 || xt + myx[otchet] == plx3 || xt - myx[otchet5] == plx3 || xt + myx[otchet5] == plx3 || xt - myx[otchet3] == plx3 || xt + myx[otchet3] == plx3 || xt - myx[otchet] == plx4 || xt + myx[otchet] == plx4 || xt - myx[otchet5] == plx4 || xt + myx[otchet5] == plx4 || xt - myx[otchet3] == plx4 || xt + myx[otchet3] == plx4) {
            if (yt - myy[otchet2] == ply1 || yt + myy[otchet2] == ply1 || yt - myy[otchet6] == ply1 || yt + myy[otchet6] == ply1 ||  yt - myy[otchet4] == ply1 || yt + myy[otchet4] == ply1 || yt - myy[otchet6] == ply1 || yt + myy[otchet6] == ply1|| yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet6] == ply2 || yt + myy[otchet6] == ply2 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply2 ||  yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply2|| yt - myy[otchet2] == ply3 || yt + myy[otchet2] == ply3 || yt - myy[otchet6] == ply3 || yt + myy[otchet6] == ply3 || yt - myy[otchet4] == ply3 || yt + myy[otchet4] == ply3 || yt - myy[otchet2] == ply4 || yt + myy[otchet2] == ply4 || yt - myy[otchet4] == ply4 || yt + myy[otchet4] == ply4 || yt - myy[otchet6] == ply4 || yt + myy[otchet6] == ply4) {
                if (Col_del == 0 & Timer == 0)
                {
                    Player.Collision();
                    Timer = 50;
                    Col_del = 1;
                    System.out.println(PlayerColSt + "::" + PlayerWalkst);
                }


            } else {
                //System.out.println("Yea.....");
                Col_del = 0;
                if (otchet == myx.length ) {
                    otchet = 0;
                } else {
                    otchet++;

                }
                if (otchet3 == myx.length ) {
                    otchet3 = 0;
                } else {
                    otchet3++;

                }
                if ( otchet2 == myy.length) {
                    otchet2 = 0;
                } else {
                    otchet2++;
                }
                if ( otchet4 == myy.length) {
                    otchet4 = 0;
                } else {
                    otchet4++;
                }
                if ( otchet6 == myy.length) {
                    otchet6 = 0;
                } else {
                    otchet6++;
                }
                if ( otchet5 == myx.length) {
                    otchet5 = 0;
                } else {
                    otchet5++;
                }
            }

        } else {

            Col_del = 0;
            if (otchet == myx.length ) {
                otchet = 0;
            } else {
                otchet++;

            }
            if (otchet3 == myx.length ) {
                otchet3 = 0;
            } else {
                otchet3++;

            }
            if ( otchet5 == myx.length) {
                otchet5 = 0;
            } else {
                otchet5++;
            }


        }



		}
	
	
	
}
