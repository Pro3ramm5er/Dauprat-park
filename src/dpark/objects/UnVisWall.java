package dpark.objects;

import dpark.Game;
import dpark.GameObject;

/**
 * @author Nickita
 */
public class UnVisWall extends GameObject  {
    public int xt;
    public int yt;

    public int[] myx = {1, 2, 3, 4, 5, 6, 7,/* 8, 9 ,10, 11, 12, 13, 14, 15, 8, 9, 10, 11, 12, 13*/};
    public int[] myy = {-13, -12, -11, -10, -9,/* -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 8, 9, 10, 11, 12, 13*/};

    public int Timer = 0;
    public int otchet = 0;
    public int otchet2 = 0;
    public int otchet3 = 0;
    public int otchet4 = 0;
    public int otchet5 = 0;
    public int otchet6 = 0;
    public int otchet7 = 0; // x
    public int otchet8 = 0;  // y
    public int otchet9 = 0; // x
    public int otchet10 = 0; // y
    public int Col_del = 0;
    public int Type = 0;


    public UnVisWall(String name) {
        super(name);
        //z = yt+15;


        sprite.addStep(Game.instance.getSprite("unviswall.png"));
        sprite.addStep(Game.instance.getSprite("unviswall_1.png"));

        sprite.currentStep = Type;
    }

    @Override
    public void update() {
        super.update();
        sprite.currentStep = Type;
        if (Type == 0) {
            z = yt - 20;
        } else {
            z = yt-5;
        }


        //Collisions:
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();
        PlayerCollision();


    }
}
