package dpark.objects;

import dpark.Game;
import dpark.GameObject;
import dpark.GameOtherVars;
import dpark.GameStoryVars;

/**
 * @author Nickita
 */
public class Door_forr2 extends GameObject {
    public int xt;
    public int yt;

    int UseRandom = 0;
    int UseTimer = 1;
    public int[] myx = {1, 2 ,3 ,4 ,5 ,6 ,7 ,8 ,9, 10, 11 ,12 ,13 ,14 ,15};
    public int[] myy = {1, 2 ,3 ,4 ,5 ,6 ,7 ,8 ,9, 10, 11 ,12 ,13 ,14 ,15};

    public int Timer = 0;
    public int otchet = 0;
    public int otchet2 = 0;
    public int otchet3 = 0;
    public int otchet4 = 0;
    public int otchet5 = 0;
    public int otchet6 = 0;
    public int otchet7 = 0; // x
    public int otchet8 = 0;  // y
    public int Col_del = 0;
    public int PlusOnce = 0;

    public Door_forr2(String name)
    {
        super(name);

        sprite.addStep(Game.instance.getSprite("door_visible.png"));
        //sprite.currentStep = 0 + (int) (Math.random() * ((1 - 0) + 1));


        //z = y;
    }
    @Override
    public void update()
    {
        z = yt;

        /*
        if (Timer <= 0 && UseTimer == 1)
        {
            UseRandom = 1 + (int) (Math.random() * ((4 - 1) + 1));
            if (UseRandom == 1)
            {
                Game.SantaX = x;
                Game.SantaY = y;
                Game.NWY_Present_create = 0;
                UseTimer = 0;
                //Timer = 40;
            }

        } else {
            Timer--;
        }
        */



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


        if (xt - myx[otchet] == plx1 || xt + myx[otchet] == plx1 || xt - myx[otchet5] == plx1 || xt + myx[otchet5] == plx1 || xt - myx[otchet3] == plx1 || xt + myx[otchet7] == plx1 || xt - myx[otchet7] == plx1 || xt + myx[otchet3] == plx1 || xt - myx[otchet] == plx2 || xt + myx[otchet] == plx2 || xt - myx[otchet7] == plx2 || xt + myx[otchet7] == plx2 || xt - myx[otchet5] == plx2 || xt + myx[otchet5] == plx2 || xt - myx[otchet3] == plx2 || xt + myx[otchet3] == plx2 || xt - myx[otchet] == plx3 || xt + myx[otchet] == plx3 || xt - myx[otchet7] == plx3 || xt + myx[otchet7] == plx3 || xt - myx[otchet5] == plx3 || xt + myx[otchet5] == plx3 || xt - myx[otchet3] == plx3 || xt + myx[otchet3] == plx3 || xt - myx[otchet] == plx4 || xt + myx[otchet] == plx4 || xt - myx[otchet7] == plx4 || xt + myx[otchet7] == plx4 || xt - myx[otchet5] == plx4 || xt + myx[otchet5] == plx4 || xt - myx[otchet3] == plx4 || xt + myx[otchet3] == plx4) {
            if (yt - myy[otchet2] == ply1 || yt + myy[otchet2] == ply1 || yt - myy[otchet7] == ply1 || yt + myy[otchet7] == ply1 || yt - myy[otchet6] == ply1 || yt + myy[otchet6] == ply1 || yt - myy[otchet4] == ply1 || yt + myy[otchet4] == ply1 || yt - myy[otchet6] == ply1 || yt + myy[otchet6] == ply1 || yt - myy[otchet7] == ply2 || yt + myy[otchet7] == ply1 || yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet6] == ply2 || yt + myy[otchet6] == ply2 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply2 || yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply2 || yt - myy[otchet2] == ply3 || yt + myy[otchet2] == ply3 || yt - myy[otchet7] == ply3 || yt + myy[otchet7] == ply3 || yt - myy[otchet6] == ply3 || yt + myy[otchet6] == ply3 || yt - myy[otchet4] == ply3 || yt + myy[otchet4] == ply3 || yt - myy[otchet2] == ply4 || yt + myy[otchet2] == ply4 || yt - myy[otchet4] == ply4 || yt + myy[otchet4] == ply4 || yt - myy[otchet6] == ply4 || yt + myy[otchet6] == ply4 || yt - myy[otchet7] == ply4 || yt + myy[otchet7] == ply4) {


                GameStoryVars.S_moment = 5;
                GameOtherVars.Restart_type = 8;
                GameOtherVars.AllDelete = 1;


                if (Col_del == 0 && Timer <= 0) {
                    //System.out.println("KOL");
                    if (PlayerZ == z || z < PlayerZ) {



                        if (PlusOnce == 0) {
                            PlayerZ++;
                            PlusOnce = 1;
                        }
                        //Player.Collision();
                    }

                }
                if (! (PlayerZ == z)) {
                    //Player.Collision();
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
            }

        } else {
            PlusOnce = 0;
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


        }
    }



}

