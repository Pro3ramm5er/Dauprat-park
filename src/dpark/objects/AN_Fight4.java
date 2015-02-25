package dpark.objects;

import dpark.Game;
import dpark.GameObject;

/**
 * @author Nickita
 */
public class AN_Fight4  extends GameObject {

    public int xt;
    public int yt;


    public int TimerToCT = 15;
    public int TX = 0;
    public AN_Fight4(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("AN_fight2_1.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight2_2.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight2_3.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight2_4.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight2_5.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight2_6.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight2_7.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight2_8.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight2_9.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight2_10.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight2_11.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight2_12.png"));

        sprite.addStep(Game.instance.getSprite("TNT_none.png"));




    }


    @Override
    public void update() {
        // STEPS
        xt = x;
        yt = y;
        z = 1000;
        sprite.currentStep = TX;
        if (TimerToCT <= 0) {
            if (TX < 12)
            {
                TX++;
                TimerToCT = 25;
            }
        } else {

            TimerToCT--;

        }
    }

}


