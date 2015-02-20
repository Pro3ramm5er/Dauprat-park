package dpark.objects;

import dpark.Game;
import dpark.GameObject;
import dpark.GameOtherVars;

/**
 * Created by Nickita on 25.11.2014.
 */
public class Alpinos extends GameObject {
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

    public Alpinos(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("Alpinos_left.png"));
        sprite.addStep(Game.instance.getSprite("Alpinos_up.png"));
        sprite.addStep(Game.instance.getSprite("Alpinos_right.png"));
        sprite.addStep(Game.instance.getSprite("Alpinos_down.png"));

    }


    @Override
    public void update() {
        // STEPS
        xt = x;
        yt = y;
        z = yt + 47;
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
            y += 1;
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

        ObjCollision();
    }


}
