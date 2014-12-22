package dpark.objects;

import dpark.Game;
import dpark.GameObject;


/**
 * Created by Nickita on 24.11.2014.
 */
public class AppleW extends GameObject {
    public int[] myx = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 /*, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70*/};
    public int[] myy = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 /*, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70*/};
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
    int Col_del = 0;
    public int Timer_3 = 15;
    public int NPC_Type = 0; // 0 - easy, 1 - Patrul
    // FOR NPC_TYPE == 1


    public int Type_st = 0;
    public int Type_st_Del = 0;


    //
    public AppleW(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("AppleW_1.png"));
        sprite.addStep(Game.instance.getSprite("AppleW_2.png"));
        sprite.addStep(Game.instance.getSprite("AppleW_3.png"));
        sprite.addStep(Game.instance.getSprite("AppleW_4.png"));
        x = xt;
        y = yt;
    }

    @Override
    public void update() {
        // STEPS
        xt = x;
        yt = y;
        z = y;
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

        if (Atack == 1) {
            Timer_sec = 1;
            Game.VisibleDieLogo = 1;


            if (Timer_sec == 1) {

                if (Timer_3 <= 0) {
                    Atack = 0;
                    Timer_sec = 0;
                    Timer_3 = 5;
                    Game.VisibleDieLogo = 0;
                    Game.Get_Die();
                } else {
                    Timer_3--;
                }
            }
        }


        // STEPS END
        if (Timer <= 0) {

            if (NPC_Type == 0) {
                MST = 0 + (int) (Math.random() * ((4 - 0) + 1));
                Timer_set_del = 0;
            }


            if (NPC_Type == 1) {


                if (Type_st == 1) {
                    MST = 1;

                    //System.out.println("YOY");
                    //Timer = 50;
                    Timer_set_del = 0;


                }
                if (Type_st == 2) {
                    MST = 2;

                    //System.out.println("YOY");
                    //Timer = 50;
                    Timer_set_del = 0;


                }
                if (Type_st == 3) {
                    MST = 3;

                    //System.out.println("YOY");
                    //Timer = 50;
                    Timer_set_del = 0;


                }
                if (Type_st == 4) {
                    MST = 4;

                    //System.out.println("YOY");
                    //Timer = 50;
                    Timer_set_del = 0;


                }
                if (Type_st_Del == 0) {
                    Type_st++;
                    Type_st_Del = 1;
                }
                if (Type_st > 4) {
                    Type_st = 1;
                }
            }





                  /*
                  if (Type_st == 0) {
                      MST = 1 + (int) (Math.random() * ((4 - 0) + 1));
                      if (Timer_set_del == 0)
                      {
                          Timer = 50+ (int) (Math.random() * ((1000 - 50) + 1));
                          Timer_set_del = 1;
                      }
                      Type_st++;
                  }
                  */
        } else {
            Timer--;
        }


        if (NPC_Type == 0) {
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
                sprite.currentStep = 3;
            }
            if (MST == 2) {
                if (Timer_set_del == 0) {
                    Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                    Timer_set_del = 1;
                }

                //xt+=3;
                x += 1;
                sprite.currentStep = 1;
            }
            if (MST == 3) {
                if (Timer_set_del == 0) {
                    Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                    Timer_set_del = 1;
                }

                // yt+=3;
                y +=1;
                z -= 1;
                sprite.currentStep = 0;
            }
            if (MST == 4) {
                if (Timer_set_del == 0) {
                    Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                    Timer_set_del = 1;
                }

                //xt-=3;
                x -= 1;
                sprite.currentStep = 2;
            }

        }


        if (NPC_Type == 1) {
            if (MST == 0) {
                if (Timer_set_del == 0) {
                    Timer = 15;
                    Timer_set_del = 1;
                    Type_st_Del = 0;
                }
                //y--;
                //yt--;
                //sprite.currentStep = 3;
            }
            if (MST == 1) {
                if (Timer_set_del == 0) {
                    Timer = 15;
                    Timer_set_del = 1;
                    Type_st_Del = 0;
                }
                y--;
                yt--;
                z += 1*2;
                sprite.currentStep = 3;
            }
            if (MST == 2) {
                if (Timer_set_del == 0) {
                    Timer = 15;
                    Timer_set_del = 1;
                    Type_st_Del = 0;
                }
                x++;
                xt++;
                sprite.currentStep = 1;
            }
            if (MST == 3) {
                if (Timer_set_del == 0) {
                    Timer = 15;
                    Timer_set_del = 1;
                    Type_st_Del = 0;
                }
                y++;
                yt++;
                z -= 1*2;
                sprite.currentStep = 0;
            }
            if (MST == 4) {
                if (Timer_set_del == 0) {
                    Timer = 15;
                    Timer_set_del = 1;
                    Type_st_Del = 0;
                }
                x--;
                xt--;
                sprite.currentStep = 2;
            }

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
        if (otchet7 == myx.length) {
            otchet7 = 0;

        }
        if (otchet8 == myy.length) {
            otchet8 = 0;

        }


        if (xt - myx[otchet] == plx1 || xt + myx[otchet] == plx1 || xt - myx[otchet5] == plx1 || xt + myx[otchet5] == plx1 || xt - myx[otchet3] == plx1 || xt + myx[otchet7] == plx1 || xt - myx[otchet7] == plx1 || xt + myx[otchet3] == plx1 || xt - myx[otchet] == plx2 || xt + myx[otchet] == plx2 || xt - myx[otchet7] == plx2 || xt + myx[otchet7] == plx2 || xt - myx[otchet5] == plx2 || xt + myx[otchet5] == plx2 || xt - myx[otchet3] == plx2 || xt + myx[otchet3] == plx2 || xt - myx[otchet] == plx3 || xt + myx[otchet] == plx3 || xt - myx[otchet7] == plx3 || xt + myx[otchet7] == plx3 || xt - myx[otchet5] == plx3 || xt + myx[otchet5] == plx3 || xt - myx[otchet3] == plx3 || xt + myx[otchet3] == plx3 || xt - myx[otchet] == plx4 || xt + myx[otchet] == plx4 || xt - myx[otchet7] == plx4 || xt + myx[otchet7] == plx4 || xt - myx[otchet5] == plx4 || xt + myx[otchet5] == plx4 || xt - myx[otchet3] == plx4 || xt + myx[otchet3] == plx4) {
            if (yt - myy[otchet2] == ply1 || yt + myy[otchet2] == ply1 || yt - myy[otchet7] == ply1 || yt + myy[otchet7] == ply1 || yt - myy[otchet6] == ply1 || yt + myy[otchet6] == ply1 || yt - myy[otchet4] == ply1 || yt + myy[otchet4] == ply1 || yt - myy[otchet6] == ply1 || yt + myy[otchet6] == ply1 || yt - myy[otchet7] == ply2 || yt + myy[otchet7] == ply1 || yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet6] == ply2 || yt + myy[otchet6] == ply2 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply2 || yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply2 || yt - myy[otchet2] == ply3 || yt + myy[otchet2] == ply3 || yt - myy[otchet7] == ply3 || yt + myy[otchet7] == ply3 || yt - myy[otchet6] == ply3 || yt + myy[otchet6] == ply3 || yt - myy[otchet4] == ply3 || yt + myy[otchet4] == ply3 || yt - myy[otchet2] == ply4 || yt + myy[otchet2] == ply4 || yt - myy[otchet4] == ply4 || yt + myy[otchet4] == ply4 || yt - myy[otchet6] == ply4 || yt + myy[otchet6] == ply4 || yt - myy[otchet7] == ply4 || yt + myy[otchet7] == ply4) {

                //System.out.println("KOL");
                Atack = 1;


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
