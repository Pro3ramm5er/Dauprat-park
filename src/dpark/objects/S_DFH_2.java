package dpark.objects;

import dpark.Game;
import dpark.GameObject;
import dpark.GameOtherVars;

/**
 * @author Nickita
 */
public class S_DFH_2 extends GameObject {
    //ИНДИВИДУАЛЬНЫЙ НПС
    public int[] myx = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};
    public int[] myy = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};
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
    public int TimerBeforeFire = 110;
    public int TimeChangeTExture = 5;
    public int Texture_number = 0;
    public int TimerBeforeAtack = 0;
    public int Health = 130;
    public int Comeback = 0;
    public int ComebackChangerTimer = 50;

    public S_DFH_2(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("DFH_W.png"));
        sprite.addStep(Game.instance.getSprite("DFH_W.png"));
        sprite.addStep(Game.instance.getSprite("DFH_1_W.png"));
        sprite.addStep(Game.instance.getSprite("DFH_1_W.png"));
        ObjectType = 1;


        // When Fire
        sprite.addStep(Game.instance.getSprite("DFH_W_fire.png"));
        MST = 2;

    }


    @Override
    public void update() {
        // STEPS
        xt = x;
        yt = y;
        z = yt + 45;

        ObjectType = 1;
        if (Comeback == 1 && ComebackChangerTimer <= 0) {
            ComebackChangerTimer = 35;
            Comeback = 2;
        } else {
            ComebackChangerTimer--;
        }
        if (Comeback == 2 && ComebackChangerTimer <= 0) {
            ComebackChangerTimer = 35;
            Comeback = 3;
        } else {
            ComebackChangerTimer--;
        }
        if (Comeback == 3 && ComebackChangerTimer <= 0) {
            ComebackChangerTimer = 35;
            Comeback = 4;
        } else {
            ComebackChangerTimer--;
        }
        if (Comeback == 1) {
            MST = 1;
        }
        if (Comeback == 2) {
            MST = 1;
        }
        if (Comeback == 3) {
            MST = 4;
        }
        if (Health <= 0) {
            GameOtherVars.Restart_type = 44;
            GameOtherVars.AllDelete = 1;
        }
        GameOtherVars.Bullet_createedx = x;
        GameOtherVars.Bullet_createedy = y;
        if (TimerBeforeFire <= 0) {
            if (Game.instance.GetRandom(0, 1) == 1) {
                GameOtherVars.Bullet_create = 1;
                GameOtherVars.Bullet_create = 1;
                GameOtherVars.Bullet_create = 1;
                GameOtherVars.Bullet_create = 1;
                GameOtherVars.Bullet_create = 1;
                GameOtherVars.Bullet_create = 1;
                GameOtherVars.Bullet_create = 1;
                GameOtherVars.Bullet_create = 1;
                GameOtherVars.Bullet_create = 1;
                sprite.currentStep = 4;
                TimerBeforeFire = 1;
            }
            {
                TimerBeforeFire = 1;
            }
        } else {
            TimerBeforeFire--;
        }
        if (TimeChangeTExture <= 0) {
            if (Texture_number < 3) {
                sprite.currentStep = Texture_number;
                TimeChangeTExture = 1;
                Texture_number++;
            } else {
                Texture_number = 0;
            }

        } else {
            TimeChangeTExture--;
        }
        if (TimerBeforeAtack <= 0) {


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


            // STEPS END


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


            if (x - Game.instance.GetRandom(myx[0], myx[myx.length - 1]) == plx || y - Game.instance.GetRandom(myy[0], myy[myy.length - 1]) == ply || x + Game.instance.GetRandom(myx[0], myx[myx.length - 1]) == plx || y + Game.instance.GetRandom(myy[0], myy[myy.length - 1]) == ply || Game.instance.GetRandom(myx[0], myx[myx.length - 1]) == plx2 && Game.instance.GetRandom(myy[0], myy[myy.length - 1]) == ply2 || Game.instance.GetRandom(myx[0], myx[myx.length - 1]) == plx3 && Game.instance.GetRandom(myy[0], myy[myy.length - 1]) == ply3 || Game.instance.GetRandom(myx[0], myx[myx.length - 1]) == plx3 && Game.instance.GetRandom(myy[0], myy[myy.length - 1]) == ply3 || Game.instance.GetRandom(myx[0], myx[myx.length - 1]) == plx4 && Game.instance.GetRandom(myy[0], myy[myy.length - 1]) == ply4) {
                //System.out.println("KOL");
                if (Comeback == 0) {
                    Comeback = 1;
                }
                if (GameOtherVars.PlayerIsFighting == 1) {
                    Health -= 30;
                    GameOtherVars.PlayerIsFighting = 0;
                }
                if (PlusOnce == 0) {
                    PlayerZ++;
                    PlusOnce = 1;
                }


                //System.out.println("nowfaleKOL");

            }


        }


    }
}

