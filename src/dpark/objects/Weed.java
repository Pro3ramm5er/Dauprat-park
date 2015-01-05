package dpark.objects;

import dpark.Game;
import dpark.GameObject;
/**
 * @author Nickita
 */
public class Weed extends GameObject {

    public int xt;
    public int yt;

    public int[] myx = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
    public int[] myy = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};

    public int Timer = 0;
    public int otchet = 0;
    public int otchet2 = 0;
    public int otchet3 = 0;
    public int otchet4 = 0;
    public int otchet5 = 0;
    public int otchet6 = 0;
    public int otchet7 = 0; // x
    public int otchet8 = 0;  // y
    public int otchet9 = 0; // x
    public int otchet10 = 0; // y
    public int Col_del = 0;
    public int Get = 0;
    public Weed(String name)
    {
        super(name);
        sprite.addStep(Game.instance.getSprite("Weeeeeeed.png"));
        sprite.addStep(Game.instance.getSprite("TNT_none.png"));
    }
    @Override
    public void update() {
        super.update();


        //Collisions:
        if (Timer <= 0) {
            Col_del = 0;
            Timer = 0;
        } else {
            Timer--;
        }
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
        if (otchet7 == myx.length) {
            otchet7 = 0;

        }
        if (otchet8 == myy.length) {
            otchet8 = 0;

        }
        if (otchet9 == myx.length) {
            otchet9 = 0;

        }
        if (otchet10 == myy.length) {
            otchet10 = 0;

        }


        if (x - myx[otchet] == plx1 || x + myx[otchet] == plx1 || x - myx[otchet9] == plx1 || x + myx[otchet9] == plx1 || x - myx[otchet5] == plx1 || x + myx[otchet5] == plx1 || x - myx[otchet3] == plx1 || x + myx[otchet7] == plx1 || x - myx[otchet7] == plx1 || x + myx[otchet3] == plx1 || x - myx[otchet] == plx2 || x + myx[otchet] == plx2 || x - myx[otchet9] == plx2 || x + myx[otchet9] == plx2 || x - myx[otchet7] == plx2 || x + myx[otchet7] == plx2 || x - myx[otchet5] == plx2 || x + myx[otchet5] == plx2 || x - myx[otchet3] == plx2 || x + myx[otchet3] == plx2 || x - myx[otchet] == plx3 || x + myx[otchet] == plx3 || x - myx[otchet9] == plx3 || x + myx[otchet9] == plx3 || x - myx[otchet] == plx3 || x + myx[otchet] == plx3 || x - myx[otchet7] == plx3 || x + myx[otchet7] == plx3 || x - myx[otchet5] == plx3 || x + myx[otchet5] == plx3 || x - myx[otchet3] == plx3 || x + myx[otchet3] == plx3 || x - myx[otchet] == plx4 || x + myx[otchet] == plx4 || x - myx[otchet9] == plx4 || x + myx[otchet9] == plx4 || x - myx[otchet7] == plx4 || x + myx[otchet7] == plx4 || x - myx[otchet5] == plx4 || x + myx[otchet5] == plx4 || x - myx[otchet3] == plx4 || x + myx[otchet3] == plx4) {
            if (y - myy[otchet2] == ply1 || y + myy[otchet2] == ply1 || y - myy[otchet10] == ply1 || y + myy[otchet10] == ply1 || y - myy[otchet7] == ply1 || y + myy[otchet7] == ply1 || y - myy[otchet6] == ply1 || y + myy[otchet6] == ply1 || y - myy[otchet4] == ply1 || y + myy[otchet4] == ply1 || y - myy[otchet6] == ply1 || y + myy[otchet6] == ply1 || y - myy[otchet7] == ply2 || y + myy[otchet7] == ply2 ||  y - myy[otchet10] == ply2 || y + myy[otchet10] == ply2  || y - myy[otchet2] == ply2 || y + myy[otchet2] == ply2 || y - myy[otchet6] == ply2 || y + myy[otchet6] == ply2 || y - myy[otchet4] == ply2 || y + myy[otchet4] == ply2 || y - myy[otchet2] == ply2 || y + myy[otchet2] == ply2 || y - myy[otchet4] == ply2 || y + myy[otchet4] == ply2 || y - myy[otchet2] == ply3 || y + myy[otchet2] == ply3 || y - myy[otchet7] == ply3 || y + myy[otchet7] == ply3 || y - myy[otchet10] == ply3 || y + myy[otchet10] == ply3 || y - myy[otchet6] == ply3 || y + myy[otchet6] == ply3 || y - myy[otchet4] == ply3 || y + myy[otchet4] == ply3 || y - myy[otchet2] == ply4 || y + myy[otchet2] == ply4 || y - myy[otchet4] == ply4 || y + myy[otchet4] == ply4 || y - myy[otchet6] == ply4 || y + myy[otchet6] == ply4 || y - myy[otchet7] == ply4 || y + myy[otchet7] == ply4 || y - myy[otchet10] == ply4 || y + myy[otchet10] == ply4) {
                if (Get == 0) {
                    //System.out.println("KOL");
                    Game.Player_weed = 1;
                    sprite.currentStep = 1;
                    Get = 1;

                }
                //System.out.println("nowfaleKOL");

            } else {
                //System.out.println("Yea.....");
                Col_del = 0;
                if (otchet == myx.length) {
                    otchet = 0;
                } else {
                    otchet++;

                }
                if (otchet3 == myx.length) {
                    otchet3 = 0;
                } else {
                    otchet3++;

                }
                if (otchet2 == myy.length) {
                    otchet2 = 0;
                } else {
                    otchet2++;
                }
                if (otchet4 == myy.length) {
                    otchet4 = 0;
                } else {
                    otchet4++;
                }
                if (otchet6 == myy.length) {
                    otchet6 = 0;
                } else {
                    otchet6++;
                }
                if (otchet5 == myx.length) {
                    otchet5 = 0;
                } else {
                    otchet5++;
                }
                if (otchet7 == myx.length) {
                    otchet7 = 0;

                }
                if (otchet8 == myy.length) {
                    otchet8 = 0;

                }
                if (otchet10 == myy.length) {
                    otchet10 = 0;

                }
            }

        } else {

            Col_del = 0;
            if (otchet == myx.length) {
                otchet = 0;
            } else {
                otchet++;

            }
            if (otchet3 == myx.length) {
                otchet3 = 0;
            } else {
                otchet3++;

            }
            if (otchet5 == myx.length) {
                otchet5 = 0;
            } else {
                otchet5++;
            }
            if (otchet7 == myx.length) {
                otchet7 = 0;

            }
            if (otchet9 == myx.length) {
                otchet9 = 0;

            }


        }


    }

}
