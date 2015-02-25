package dpark.objects;

import dpark.Game;
import dpark.GameObject;
import dpark.GameOtherVars;

/**
 * @author Nickita
 */
public class OBJ_bullet extends GameObject {
    public int[] myx = {1, 2, 3 ,4, 5, 6 ,7 ,8 ,9};
    public int[] myy = {1, 2, 3 ,4, 5, 6 ,7 ,8 ,9};
    public int xt;
    public int yt;
    public int MST = 1; // 1 - up, 2 - right, 3 - down, 4 - left
    public int Timer = 50;
    public int Timer_2;
    public int Timer_set_del = 0;
    public int Timer_sec = 0;
    public int Atack = 0;

    public int otchet = 0;
    public int otchet2 = 0;
    public int otchet3 = 0;
    public int otchet4 = 0;
    public int otchet5 = 0;
    public int otchet6 = 0;
    public int otchet7 = 0; // x
    public int otchet8 = 0;  // y
    public int Timer_3 = 15;
    public int PlusOnce = 0;
    public int MinusTimer = 15;
    public int Minus = 0;
    public int i = 0;
    public int i2 = 0;

    public OBJ_bullet(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("Bullet.png"));
        MST = 3;

    }


    @Override
    public void update() {
        // STEPS
        xt = x;
        yt = y;
        z = yt + 40;
        collRunnable  = new Runnable() {
            @Override
            public void run() {
                Game.Get_Die();


            }
        };
        ObjCollisionDie();






        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);
        PlayerCollisionRunnable(myx, myy);

        /*
        if (Atack == 1) {

            Timer_sec = 1;
            GameOtherVars.VisibleDieLogo = 1;


            if (Timer_sec == 1) {

                if (Timer_3 <= 0) {
                    Atack = 0;
                    Timer_sec = 0;
                    Timer_3 = 5;
                    GameOtherVars.VisibleDieLogo = 0;
                    Game.Get_Die();


                } else {
                    Timer_3--;
                }
            }
        }
        */

        // STEPS END





            // yt+=3;
            y += 6;
            z -= 6;





        // Collision :
        /*

        if (Timer_2 <= 0) {
            Col_del = 0;
            Timer_2 = 0;
        } else {
            Timer_2--;
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


        if (xt - myx[otchet] == plx1 || xt + myx[otchet] == plx1 || xt - myx[otchet5] == plx1 || xt + myx[otchet5] == plx1 || xt - myx[otchet3] == plx1 || xt + myx[otchet3] == plx1 || xt - myx[otchet] == plx2 || xt + myx[otchet] == plx2 || xt - myx[otchet5] == plx2 || xt + myx[otchet5] == plx2 || xt - myx[otchet3] == plx2 || xt + myx[otchet3] == plx2 || xt - myx[otchet] == plx3 || xt + myx[otchet] == plx3 || xt - myx[otchet5] == plx3 || xt + myx[otchet5] == plx3 || xt - myx[otchet3] == plx3 || xt + myx[otchet3] == plx3 || xt - myx[otchet] == plx4 || xt + myx[otchet] == plx4 || xt - myx[otchet5] == plx4 || xt + myx[otchet5] == plx4 || xt - myx[otchet3] == plx4 || xt + myx[otchet3] == plx4) {
            if (yt - myy[otchet2] == ply1 || yt + myy[otchet2] == ply1 || yt - myy[otchet6] == ply1 || yt + myy[otchet6] == ply1 || yt - myy[otchet4] == ply1 || yt + myy[otchet4] == ply1 || yt - myy[otchet6] == ply1 || yt + myy[otchet6] == ply1 || yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet6] == ply2 || yt + myy[otchet6] == ply2 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply2 || yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply2 || yt - myy[otchet2] == ply3 || yt + myy[otchet2] == ply3 || yt - myy[otchet6] == ply3 || yt + myy[otchet6] == ply3 || yt - myy[otchet4] == ply3 || yt + myy[otchet4] == ply3 || yt - myy[otchet2] == ply4 || yt + myy[otchet2] == ply4 || yt - myy[otchet4] == ply4 || yt + myy[otchet4] == ply4 || yt - myy[otchet6] == ply4 || yt + myy[otchet6] == ply4) {
                if (Game.Shlakoblock_magic == 0) {
                    Atack = 1;
                }
                //System.out.println("KOL");


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



        }
        */




        /*
        if (Timer_2 <= 0) {

            Timer_2 = 0;
        } else {
            Timer_2--;
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


        if (xt - myx[otchet] == plx1 || xt + myx[otchet] == plx1 || xt - myx[otchet5] == plx1 || xt + myx[otchet5] == plx1 || xt - myx[otchet3] == plx1 || xt + myx[otchet7] == plx1 || xt - myx[otchet7] == plx1 || xt + myx[otchet3] == plx1 || xt - myx[otchet] == plx2 || xt + myx[otchet] == plx2 || xt - myx[otchet7] == plx2 || xt + myx[otchet7] == plx2 || xt - myx[otchet5] == plx2 || xt + myx[otchet5] == plx2 || xt - myx[otchet3] == plx2 || xt + myx[otchet3] == plx2 || xt - myx[otchet] == plx3 || xt + myx[otchet] == plx3 || xt - myx[otchet7] == plx3 || xt + myx[otchet7] == plx3 || xt - myx[otchet5] == plx3 || xt + myx[otchet5] == plx3 || xt - myx[otchet3] == plx3 || xt + myx[otchet3] == plx3 || xt - myx[otchet] == plx4 || xt + myx[otchet] == plx4 || xt - myx[otchet7] == plx4 || xt + myx[otchet7] == plx4 || xt - myx[otchet5] == plx4 || xt + myx[otchet5] == plx4 || xt - myx[otchet3] == plx4 || xt + myx[otchet3] == plx4) {
            if (yt - myy[otchet2] == ply1 || yt + myy[otchet2] == ply1 || yt - myy[otchet7] == ply1 || yt + myy[otchet7] == ply1 || yt - myy[otchet6] == ply1 || yt + myy[otchet6] == ply1 || yt - myy[otchet4] == ply1 || yt + myy[otchet4] == ply1 || yt - myy[otchet6] == ply1 || yt + myy[otchet6] == ply1 || yt - myy[otchet7] == ply2 || yt + myy[otchet7] == ply1 || yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet6] == ply2 || yt + myy[otchet6] == ply2 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply2 || yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply2 || yt - myy[otchet2] == ply3 || yt + myy[otchet2] == ply3 || yt - myy[otchet7] == ply3 || yt + myy[otchet7] == ply3 || yt - myy[otchet6] == ply3 || yt + myy[otchet6] == ply3 || yt - myy[otchet4] == ply3 || yt + myy[otchet4] == ply3 || yt - myy[otchet2] == ply4 || yt + myy[otchet2] == ply4 || yt - myy[otchet4] == ply4 || yt + myy[otchet4] == ply4 || yt - myy[otchet6] == ply4 || yt + myy[otchet6] == ply4 || yt - myy[otchet7] == ply4 || yt + myy[otchet7] == ply4) {

                //System.out.println("KOL");
                if (GameOtherVars.Fullimmortality == 0) {
                    Minus = 1;
                }
                if (PlusOnce == 0) {
                    PlayerZ++;
                    PlusOnce = 1;
                }


                //System.out.println("nowfaleKOL");

            } else {
                //System.out.println("Yea.....");

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
    }


}
