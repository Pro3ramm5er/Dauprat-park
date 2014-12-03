package dpark.objects;

import dpark.Game;
import dpark.GameObject;

/**
 * Created by Nickita on 03.12.2014.
 */
public class Shlacoblock extends GameObject {
    public int[] myx = {1, 2, 3, 4 , 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    public int[] myy = {1, 2, 3, 4 , 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    public int xt;
    public int yt;
    public int OFF = 0;
    public int Timer = 50;



    int otchet = 0;
    int otchet2 = 0;
    int otchet3 = 0;
    int otchet4 = 0;
    int otchet5 = 0;
    int otchet6 = 0;
    int Col_del = 0;


    public Shlacoblock(String name)
    {
        super(name);
        sprite.addStep(Game.instance.getSprite("Shlakoblock.png"));
    }
    @Override
    public void update()
    {

        if (otchet == myx.length) {
            otchet = 0;

        }
        if (otchet3 == myx.length) {
            otchet3 = 0;

        }
        if (otchet5 == myx.length) {
            otchet5 = 0;

        }
        if (otchet2 == myy.length) {
            otchet2 = 0;

        }
        if (otchet4 == myy.length) {
            otchet4 = 0;

        }
        if (otchet6 == myy.length) {
            otchet6 = 0;

        }





        if (xt - myx[otchet] == plx1 || xt + myx[otchet] == plx1 || xt - myx[otchet5] == plx1 || xt + myx[otchet5] == plx1 || xt - myx[otchet3] == plx1 || xt + myx[otchet3] == plx1 || xt - myx[otchet] == plx2 || xt + myx[otchet] == plx2 || xt - myx[otchet5] == plx2 || xt + myx[otchet5] == plx2 || xt - myx[otchet3] == plx2 || xt + myx[otchet3] == plx2 || xt - myx[otchet] == plx3 || xt + myx[otchet] == plx3 || xt - myx[otchet5] == plx3 || xt + myx[otchet5] == plx3 || xt - myx[otchet3] == plx3 || xt + myx[otchet3] == plx3 || xt - myx[otchet] == plx4 || xt + myx[otchet] == plx4 || xt - myx[otchet5] == plx4 || xt + myx[otchet5] == plx4 || xt - myx[otchet3] == plx4 || xt + myx[otchet3] == plx4) {
            if (yt - myy[otchet2] == ply1 || yt + myy[otchet2] == ply1 || yt - myy[otchet6] == ply1 || yt + myy[otchet6] == ply1 ||  yt - myy[otchet4] == ply1 || yt + myy[otchet4] == ply1 || yt - myy[otchet6] == ply1 || yt + myy[otchet6] == ply1|| yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet6] == ply2 || yt + myy[otchet6] == ply2 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply2 ||  yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply2|| yt - myy[otchet2] == ply3 || yt + myy[otchet2] == ply3 || yt - myy[otchet6] == ply3 || yt + myy[otchet6] == ply3 || yt - myy[otchet4] == ply3 || yt + myy[otchet4] == ply3 || yt - myy[otchet2] == ply4 || yt + myy[otchet2] == ply4 || yt - myy[otchet4] == ply4 || yt + myy[otchet4] == ply4 || yt - myy[otchet6] == ply4 || yt + myy[otchet6] == ply4) {
                if (Game.Shlakoblock_magic == 0) {
                    Game.Shlakoblock_magic = 1;
                    OFF = 1;
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
