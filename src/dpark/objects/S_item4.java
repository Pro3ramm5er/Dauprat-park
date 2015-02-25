package dpark.objects;

import dpark.Game;
import dpark.GameObject;
import dpark.GameOtherVars;
import dpark.GameStoryVars;

/**
 * @author Nickita
 */
public class S_item4 extends GameObject {
    public int xt;
    public int yt;

    int UseRandom = 0;
    int UseTimer = 1;
    public int[] myx = {1, 2, 3, 4, 5, 6, 7 ,8, 9, 10, 11, 12, 13, 14 ,15 ,16, 17, 18, 19, 20, 21 ,22 ,23 ,24 ,25, 26, 27 ,28, 29, 30, 31 ,32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,43, 44, 45,46, 47, 48, 49 ,50, 51, 52,53, 54,55, 56,57,58,59,60};
    public int[] myy = {1, 2, 3, 4, 5, 6, 7 ,8, 9, 10, 11, 12, 13, 14 ,15 ,16, 17, 18, 19, 20, 21 ,22 ,23 ,24 ,25, 26, 27 ,28, 29, 30, 31 ,32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,43, 44, 45,46, 47, 48, 49 ,50, 51, 52,53, 54,55, 56,57,58,59,60};

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
    public int Taskdel = 0;
    public int TableTimer = 550;
    public int TAblenow = 0;
    public S_item4(String name)
    {
        super(name);
        sprite.addStep(Game.instance.getSprite("S_door.png"));
        sprite.addStep(Game.instance.getSprite("S_door_open.png"));
        sprite.addStep(Game.instance.getSprite("TNT_none.png"));
        //sprite.addStep(Game.instance.getSprite("Rock_2.png"));
        //sprite.currentStep = 0 + (int) (Math.random() * ((1 - 0) + 1));


        //z = y;
    }
    @Override
    public void update()
    {
        z = -1;
        collRunnable  = new Runnable() {
            @Override
            public void run() {


                    sprite.currentStep = 1;
                    GameOtherVars.Restart_type = 50;
                    GameOtherVars.AllDelete = 1;



            }
        };
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
        /*
        if (TAblenow == 1 && TableTimer <= 0)
        {
            GameStoryVars.S_table = 1;
            TAblenow = 0;
        } else {
            TableTimer--;
        }

        //if (GameStoryVars.S_task == 1)
        //{
        //    TAblenow = 1;

        //}

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
                if (GameStoryVars.S_43_key == 1) {

                    sprite.currentStep = 1;
                    GameOtherVars.Restart_type = 46;
                    GameOtherVars.AllDelete = 1;

                }
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
        */
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
    }
}


