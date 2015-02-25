package dpark;

import java.awt.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import dpark.Game;
import dpark.Game.*;
import dpark.objects.Player;
import static dpark.DB.db;

public class GameObject {
    private  int[] myx = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38};
    private int[] myy = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38};
    public static int plx;
    public static int ply;
    public static int plx1;
    public static int ply1;
    public static int plx2;
    public static int ply2;
    public static int plx3;
    public static int ply3;
    public static int plx4;
    public static int ply4;
    public static int PlayerZ;
    public static int PlayerSpeedBonus = 3;
    public int[] sd = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38};
    public Room UseRoom;
    public int UseRoomInt;
     int MinusTimer = 15;
     int Minus = 0;
     int Timer_sec = 0;
     int Atack = 0;
     int Timer_3 = 15;
    public static int PlayerColSt = 0; // 1 - up; 2 - right; 3 - down; 4 - left
    public static int PlayerWalkst = 0;

    public static int PlayerCanMovie = 0;
    public static int Checkr = 0;

    public int ObjectType = 0;
    public int StMovie;
    public Animation sprite;
    public String name = "";
    public int z = 0;
    public boolean visible = true;
    public int x = 0;
    public int y = 0;
    public Runnable collRunnable = null;
    public GameObject(String name) {
        this.name = name;
        this.sprite = new Animation(name + "_synth_anm");
        sprite.currentStep = 0;
        sprite.isPlaying = false;
        StMovie = 1;
    }

    public void update() {
        sprite.update();
    }

    public void render(Graphics g) {
        if (visible) {
            Animation.Step step = sprite.getStep();
            if (step.sprite != null) {
                step.sprite.draw(g, x, y);
            }
        }
    }
    public void PlayerCollisionRunnable(int[] u, int[] u1) {
        if (x-Game.instance.GetRandom(u[0], u[u.length-1]) == plx && y-Game.instance.GetRandom(u1[0], u1[u1.length-1]) == ply || x+Game.instance.GetRandom(u[0], u[u.length-1]) == plx && y+Game.instance.GetRandom(u1[0], u1[u1.length-1]) == ply || Game.instance.GetRandom(u[0], u[u.length-1]) == plx2 && Game.instance.GetRandom(u1[0], u1[u1.length-1]) == ply2 || Game.instance.GetRandom(u[0], u[u.length-1]) == plx3 && Game.instance.GetRandom(u1[0], u1[u1.length-1]) == ply3 || Game.instance.GetRandom(u[0], u[u.length-1]) == plx3 && Game.instance.GetRandom(u1[0], u1[u1.length-1]) == ply3 || Game.instance.GetRandom(u[0],u[u.length-1]) == plx4 && Game.instance.GetRandom(u1[0], u1[u1.length-1]) == ply4)
        {

            collRunnable.run();


        }

    }
    public void PlayerCollision() {
        if (x-Game.instance.GetRandom(myx[0], myx[myx.length-1]) == plx && y-Game.instance.GetRandom(myy[0], myy[myy.length-1]) == ply || x+Game.instance.GetRandom(myx[0], myx[myx.length-1]) == plx && y+Game.instance.GetRandom(myy[0], myy[myy.length-1]) == ply || Game.instance.GetRandom(myx[0], myx[myx.length-1]) == plx2 && Game.instance.GetRandom(myy[0], myy[myy.length-1]) == ply2 || Game.instance.GetRandom(myx[0], myx[myx.length-1]) == plx3 && Game.instance.GetRandom(myy[0], myy[myy.length-1]) == ply3 || Game.instance.GetRandom(myx[0], myx[myx.length-1]) == plx3 && Game.instance.GetRandom(myy[0], myy[myy.length-1]) == ply3 || Game.instance.GetRandom(myx[0],myx[myx.length-1]) == plx4 && Game.instance.GetRandom(myy[0], myy[myy.length-1]) == ply4)
        {

           Player.Collision();


        }

    }
    public void ObjCollision() {
        if (x-Game.instance.GetRandom(myx[0], myx[myx.length-1]) == plx && y-Game.instance.GetRandom(myy[0], myy[myy.length-1]) == ply || x+Game.instance.GetRandom(myx[0], myx[myx.length-1]) == plx && y+Game.instance.GetRandom(myy[0], myy[myy.length-1]) == ply || Game.instance.GetRandom(myx[0], myx[myx.length-1]) == plx2 && Game.instance.GetRandom(myy[0], myy[myy.length-1]) == ply2 || Game.instance.GetRandom(myx[0], myx[myx.length-1]) == plx3 && Game.instance.GetRandom(myy[0], myy[myy.length-1]) == ply3 || Game.instance.GetRandom(myx[0], myx[myx.length-1]) == plx3 && Game.instance.GetRandom(myy[0], myy[myy.length-1]) == ply3 || Game.instance.GetRandom(myx[0],myx[myx.length-1]) == plx4 && Game.instance.GetRandom(myy[0], myy[myy.length-1]) == ply4)
        {

                    Atack = 1;


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
    }
    public void ObjCollisionDie() {
        for (GameObject o : db.objects.values()) {

                        if (x - Game.instance.GetRandom(myx[0], myx[myx.length - 1]) == o.x && y - Game.instance.GetRandom(myy[0], myy[myy.length - 1]) == o.y || x + Game.instance.GetRandom(myx[0], myx[myx.length - 1]) == o.x && y + Game.instance.GetRandom(myy[0], myy[myy.length - 1]) == o.y || Game.instance.GetRandom(myx[0], myx[myx.length - 1]) == o.x) {
                            if (o.ObjectType == 0 && Game.instance.GetRandom(0, 3) == 3) {



                                            UseRoom = null;



                            }
                        }

        }
    }


    /**
     * When key is NOW pressed
     *
     * @param keycode
     */
    public void onKeyPress(int keycode) {

    }


    /**
     * When key was pressed and released.
     *
     * @param keycode
     */
    public void onKey(int keycode) {

    }

    public void onMouseClick() {
        System.out.println("Clicked object " + name);
    }

    public void onGlobalMouseClick(final double x, final double y) {
        if (visible) {
            if ((x >= this.x) && (y >= this.y)) {
                final Animation.Step st = sprite.getStep();
                if (st != null) {
                    final Sprite spr = st.sprite;
                    if (spr != null) {
                        if ((this.x + spr.getWidth() > x)
                                && (this.y + spr.getHeight() > y)) {
                            onMouseClick();
                        }
                    }
                }
            }
        }
    }

    public static final Comparator<GameObject> compareByDepth = new Comparator<GameObject>() {
        @Override
        public int compare(GameObject o1, GameObject o2) {
            return Integer.compare(o1.z, o2.z);
        }
    };

    public void Mouse_any_pressed(int mcode) {
        // TODO Auto-generated method stub

    }
}
