package dpark.objects;

import dpark.Game;
import dpark.GameObject;
import dpark.GameOtherVars;

/**
 * @author Nickita
 */
public class NWY_DedMoroz extends GameObject {
    public int[] myx = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35/*, 36, 37, 38, 39,40, 41, 42, 43, 44, 45, 46, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60*/};
    public int[] myy = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35/*, 36, 37, 38, 39,40, 41, 42, 43, 44, 45, 46, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60*/};
    public int xt;
    public int yt;
    public int MST = 1; // 1 - up, 2 - right, 3 - down, 4 - left
    public int Timer = 50;
    public int Timer_2;
    public int Timer_set_del = 0;
    public int Timer_sec = 0;
    public int Atack = 0;
    int otchet = 0;
    int otchet2 = 0;
    int otchet3 = 0;
    int otchet4 = 0;
    int otchet5 = 0;
    int otchet6 = 0;
    int Col_del = 0;
    public int Timer_3 = 15;
    public int Santa_Timer = 25;
    //НЕ КОПИРУЙ КОД ОТСУДА! ЭТО ИНДИВИДУАЛЬНЫЙ НПС!!!!!

    public NWY_DedMoroz(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("DedMoroz_left.png"));
        sprite.addStep(Game.instance.getSprite("DedMoroz_up.png"));
        sprite.addStep(Game.instance.getSprite("DedMoroz_right.png"));
        sprite.addStep(Game.instance.getSprite("DedMoroz_down.png"));

    }


    @Override
    public void update() {
        // STEPS
        GameOtherVars.SantaX = xt;
        GameOtherVars.SantaY = yt;
        xt = x;
        yt = y;

        if (xt >= 1200 || x >= 1200) {
            MST = 4;
        }
        if (xt <= -100 || x <= -100) {
            MST = 2;
        }
        if (yt >= 1200 || y >= 1200) {
            MST = 1;
        }
        if (yt <= -100 || y <= -100) {
            MST = 3;
        }


        for (int i = 0; i < 80; i++) {
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
        if (Santa_Timer <= 0)
        {
            GameOtherVars.NWY_Present_create = 0;
            Santa_Timer = 25;
        } else {
            Santa_Timer--;
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
            y -= 10;
            sprite.currentStep = 1;
        }
        if (MST == 2) {
            if (Timer_set_del == 0) {
                Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                Timer_set_del = 1;
            }

            //xt+=3;
            x += 10;
            sprite.currentStep = 2;
        }
        if (MST == 3) {
            if (Timer_set_del == 0) {
                Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                Timer_set_del = 1;
            }

            // yt+=3;
            y += 10;
            sprite.currentStep = 3;
        }
        if (MST == 4) {
            if (Timer_set_del == 0) {
                Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                Timer_set_del = 1;
            }

            //xt-=3;
            x -= 10;
            sprite.currentStep = 0;
        }


        // Collision :


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
                if (GameOtherVars.Shlakoblock_magic == 0) {
                    Atack = 1;
                } else {
                    GameOtherVars.NWY_Present_create = 0;
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


    }
}
