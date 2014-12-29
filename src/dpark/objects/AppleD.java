package dpark.objects;

import dpark.Game;
import dpark.GameObject;

/**
 * Created by Nickita on 08.11.2014.
 */
public class AppleD extends GameObject {

    public int Texture_number = 1 + (int) (Math.random() * ((2 - 1) + 1));
    public int[] myx = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    public int[] myy = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public int xt;
    public int yt;
    public int otchet = 0;
    public int otchet2 = 0;
    public int otchet3 = 0;
    public int otchet4 = 0;
    public int otchet5 = 0;
    public int otchet6 = 0;
    public int otchet7 = 0; // x
    public int otchet8 = 0;  // y
    public int dead = 0;
    int Timer = 100;
    int OneDo = 0;
    int Timer_sec = 0;
    int created = 0;

    public AppleD(String name) {
        super(name);


        if (Texture_number == 1) {
            sprite.addStep(Game.instance.getSprite("Apple.png"));

        }
        if (Texture_number == 2) {
            sprite.addStep(Game.instance.getSprite("Apple_2.png"));

        }
        sprite.addStep(Game.instance.getSprite("Apple_dead.png"));
        sprite.currentStep = 0;
        z = yt+5;
    }

    @Override
    public void update() {
        super.update();
        z = xt+10;
        if (dead == 0) {
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
                    sprite.currentStep = 1;
                    dead = 1;

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


            if (otchet == myx.length || otchet == myy.length) {
                otchet = 0;
            }
            if (otchet2 == myx.length || otchet2 == myy.length) {
                otchet2 = 0;
            }

            if (xt - myx[otchet] == plx1 || xt + myx[otchet] == plx1) {
                if (yt - myy[otchet] == ply1 || yt + myy[otchet] == ply1 || yt - myy[otchet2] == ply1 || yt + myy[otchet2] == ply1) {
                    sprite.currentStep = 1;
                    dead = 1;

                } else {
                    if (otchet == myx.length || otchet == myy.length) {
                        otchet = 0;
                    } else {
                        otchet++;

                    }
                    if (otchet2 == myx.length || otchet2 == myy.length) {
                        otchet2 = 0;
                    } else {
                        otchet2++;
                    }
                }

            } else {

                if (otchet == myx.length || otchet == myy.length) {
                    otchet = 0;
                } else {
                    otchet++;

                }
                if (otchet2 == myx.length || otchet2 == myy.length) {
                    otchet2 = 0;
                }


            }


        }


        if (otchet == myx.length || otchet == myy.length) {
            otchet = 0;
        }
        if (otchet2 == myx.length || otchet2 == myy.length) {
            otchet2 = 0;
        }
        if (dead == 1 && Timer_sec == 0) {
            Player.PlayerCanMovie = 1;
            sprite.currentStep = 1;
            if (Timer <= 0) {
                OnAI();
                Timer_sec = 1;
                Timer = 50;
            } else {
                Timer--;
            }

        }
        if (Timer_sec == 1) {
            if (Timer <= 0) {
                //System.out.println("Suns ready");
                Game.VisibleDieLogo = 1;
                Timer_sec = 2;
                Timer = 100;
            } else {
                Timer--;
            }
        }
        if (Timer_sec == 2) {
            if (Timer <= 0) {
                //System.out.println("Suns ready2");
                dead = 0;
                Timer_sec = 0;
                Timer = 5;
                Game.VisibleDieLogo = 0;
                Game.Get_Die();


            } else {
                Timer--;
            }
        }


    }

    public void AppleCreate_rn(int rt, int rt1) {
        {
            AppleD fr = new AppleD("apple");
            fr.x = rt;
            fr.y = rt1;
            fr.z = -5;
            fr.xt = rt;
            fr.yt = rt1;

            //System.out.println("Game/Objects/AppleD created" + ":" + rt + ":" + rt1);


        }
        //Wxx.put(Wxx_now, xa);
        //Wyy.put(Wyy_now, ya);
        //Wxx_now++;
        //Wyy_now++;

    }

    public void OnAI() {

        if (OneDo == 0) {
            Game.instance.AppleCalipse();

            OneDo = 1;
        }

    }


}
