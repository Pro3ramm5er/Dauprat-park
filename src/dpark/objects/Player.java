package dpark.objects;

import dpark.Game;
import dpark.GameObject;

import java.awt.event.KeyEvent;
//import dpark.objects.Coll.Phisyc;

public class Player extends GameObject {


    private int inertion = 0;
    public int direction = 0;
    public static int x1;
    public static int y1;


    public Player(String name) {

        super(name);


        sprite.addStep(Game.instance.getSprite("hero.png"));


        sprite.addStep(Game.instance.getSprite("hero_front.png"));

        sprite.addStep(Game.instance.getSprite("hero_front_sh_magic.png"));
        sprite.addStep(Game.instance.getSprite("hero_sh_magic.png"));


        plx = x;
        ply = y;
    }

    public static void Collision() {
        if (Checkr == 0) {
            PlayerCanMovie = 1;

            PlayerColSt = PlayerWalkst;
            Checkr = 1;
        }
    }

    @Override
    public void update() {
        plx = x;
        ply = y;
        ply1 = y - 1;
        plx1 = x - 1;
        ply2 = y + 1;
        plx2 = x + 1;
        ply3 = y - 2;
        plx3 = x - 2;
        ply4 = y + 2;
        plx4 = x + 2;

        super.update();


        inertion--;
        if (inertion < 0)
            inertion = 0;
        if (direction == 0) {
            y -= inertion;
        } else if (direction == 90) {
            x += inertion;
        } else if (direction == 180) {
            y += inertion;
        } else if (direction == 270) {
            x -= inertion;
        }
        x1 = x;
        y1 = y;


        plx = x;
        ply = y;
        ply1 = y - 1;
        plx1 = x - 1;
        ply2 = y + 1;
        plx2 = x + 1;
        ply3 = y - 2;
        plx3 = x - 2;
        ply4 = y + 2;
        plx4 = x + 2;


    }


    @Override
    public void onKeyPress(int keycode) {

        super.onKeyPress(keycode);


        if (keycode == KeyEvent.VK_A) {

            if (PlayerColSt != 4) {
                Checkr = 0;
                PlayerWalkst = 4;
                PlayerColSt = 0;

                if (Game.Shlakoblock_magic == 1) {
                    sprite.currentStep = 3;
                } else {

                    sprite.currentStep = 0;

                }


                inertion += 1;
                direction = 270;

            }

        }
        if (keycode == KeyEvent.VK_D) {
            if (PlayerColSt != 2) {
                Checkr = 0;
                PlayerColSt = 0;
                PlayerWalkst = 2;

                if (Game.Shlakoblock_magic == 1) {
                    sprite.currentStep = 3;
                } else {

                    sprite.currentStep = 0;

                }

                inertion += 1;
                direction = 90;

            }

        }
        if (keycode == KeyEvent.VK_W) {
            if (PlayerColSt != 1) {
                Checkr = 0;
                PlayerColSt = 0;
                PlayerWalkst = 1;
                if (Game.Shlakoblock_magic == 1) {
                    sprite.currentStep = 2;
                } else {

                    sprite.currentStep = 1;

                }


                inertion += 1;
                direction = 0;

            }

        }
        if (keycode == KeyEvent.VK_S) {


            if (PlayerColSt != 3) {
                Checkr = 0;
                PlayerColSt = 0;
                PlayerWalkst = 3;
                if (Game.Shlakoblock_magic == 1) {
                    sprite.currentStep = 2;
                } else {

                    sprite.currentStep = 1;

                }


                inertion += 1;
                direction = 180;

            }

        }


        if (inertion > 3) {
            inertion = 3;
        }

    }
}
