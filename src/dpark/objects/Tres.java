package dpark.objects;

import dpark.Game;
import dpark.GameObject;
import dpark.GameOtherVars;

/**
 * Created by Nickita on 25.11.2014.
 */
public class Tres extends GameObject {
    public int[] myx = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38};
    public int[] myy = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38};
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
    public int SnowTimer = 10;

    public Tres(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("Tres_left.png"));
        sprite.addStep(Game.instance.getSprite("Tres_up.png"));
        sprite.addStep(Game.instance.getSprite("Tres_rigth.png"));
        sprite.addStep(Game.instance.getSprite("Tres_down.png"));

    }


    @Override
    public void update() {
        // STEPS
        xt = x;
        yt = y;
        z = yt+16;
        GameOtherVars.Snow_MST = MST;
        GameOtherVars.Snow_x = x;
        GameOtherVars.Snow_y = y + 15;
        if (SnowTimer <= 0)
        {
            int a =  1 + (int) (Math.random() * ((3 - 1) + 1));
            if (a == 1) {
                GameOtherVars.Snow_create = 0;
            }
            SnowTimer = 10;
        } else {
            SnowTimer--;
        }
        if (xt >= 500 || x >= 500) {
            MST = 4;
        }
        if (xt <= 90 || x <= 90) {
            MST = 2;
        }
        if (yt >= 500 || y >= 500) {
            MST = 1;
        }
        if (yt <= 90 || y <= 90) {
            MST = 3;
        }

        for (int i = 0; i < 120; i++) {
            if (plx == xt && ply == yt - i) {
                MST = 1;
            } else {
                if (plx == xt && ply == yt + i) {
                    MST = 3;
                } else {
                    if (ply == yt && plx == xt - i) {
                        MST = 4;
                    } else {
                        if (ply == yt && plx == xt + i) {
                            MST = 2;
                        }
                    }
                }
            }

        }

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


        // STEPS END

        if (Timer <= 0) {
            MST = 0 + (int) (Math.random() * ((4 - 0) + 1));
            Timer_set_del = 0;
        } else {
            Timer--;
        }
        if (MST == 0) {
            if (Timer_set_del == 0) {
                Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                Timer_set_del = 1;
            }
            //y-=3;
            //yt-=3;
            //sprite.currentStep = 0;
        }
        if (MST == 1) {
            if (Timer_set_del == 0) {
                Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                Timer_set_del = 1;
            }

            //yt-=3;
            y -= 1;
            z += 1;
            sprite.currentStep = 1;
        }
        if (MST == 2) {
            if (Timer_set_del == 0) {
                Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                Timer_set_del = 1;
            }

            //xt+=3;
            x += 1;
            sprite.currentStep = 2;
        }
        if (MST == 3) {
            if (Timer_set_del == 0) {
                Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                Timer_set_del = 1;
            }

            // yt+=3;
            y +=1;
            z -= 1;
            sprite.currentStep = 3;
        }
        if (MST == 4) {
            if (Timer_set_del == 0) {
                Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                Timer_set_del = 1;
            }

            //xt-=3;
            x -= 1;
            sprite.currentStep = 0;
        }


        // Collision :

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
                    Atack = 1;
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


    }


}

