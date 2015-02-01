package dpark.objects;

import dpark.Game;
import dpark.GameObject;
import dpark.GameOtherVars;

/**
 * @author Nickita
 */
public class S_deamon3 extends GameObject {
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
    public int MinusTimer = 15;
    public int Minus = 0;
    public int i = 0;
    public int i2 = 0;
    public int Timer_To_change = 1;
    public int TimerTexture = 0;
    public int TimeChangeTExture = 5;
    public int Texture_number = 0;
    public S_deamon3(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("Frost_d1.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d1.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d2.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d2.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d3.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d3.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d4.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d4.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d5.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d5.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d6.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d6.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d7.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d7.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d8.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d8.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d9.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d9.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d10.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d10.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d11.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d11.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d12.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d12.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d13.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d13.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d14.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d14.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d15.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d15.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d16.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d16.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d17.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d17.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d18.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d18.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d19.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d19.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d20.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d20.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d21.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d21.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d22.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d22.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d23.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d23.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d24.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d24.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d25.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d25.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d26.png"));
        sprite.addStep(Game.instance.getSprite("Frost_d26.png"));

    }


    @Override
    public void update() {
        // STEPS
        xt = x;
        yt = y;
        z = yt + 18;

        if (TimeChangeTExture <= 0) {
            if (Texture_number < 52) {
                sprite.currentStep = Texture_number;
                TimeChangeTExture = 1;
                Texture_number++;
            } else {
                Texture_number = 0;
            }

        } else {
            TimeChangeTExture--;
        }

        if (MinusTimer <= 0 && Minus == 1) {
            if (GameOtherVars.Health == 1) {
                Atack = 1;
            } else {
                GameOtherVars.Health--;
                MinusTimer = 30;
                Minus = 0;
            }

        } else {
            MinusTimer--;
        }
        if (xt >= 700 || x >= 700) {
            MST = 4;
        }
        if (xt <= 90 || x <= 90) {
            MST = 2;
        }
        if (yt >= 700 || y >= 700) {
            MST = 1;
        }
        if (yt <= 90 || y <= 90) {
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
            y -= 5;
            z += 5;
            //sprite.currentStep = 1;
        }
        if (MST == 2) {
            if (Timer_set_del == 0) {
                Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                Timer_set_del = 1;
            }

            //xt+=3;
            x += 5;
            //sprite.currentStep = 2;
        }
        if (MST == 3) {
            if (Timer_set_del == 0) {
                Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                Timer_set_del = 1;
            }

            // yt+=3;
            y += 5;
            z -= 5;
            //sprite.currentStep = 3;
        }
        if (MST == 4) {
            if (Timer_set_del == 0) {
                Timer = 20 + (int) (Math.random() * ((80 - 20) + 1));
                Timer_set_del = 1;
            }

            //xt-=3;
            x -= 5;
            //sprite.currentStep = 0;
        }


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


    }


}



