package dpark.objects;

import dpark.Game;
import dpark.GameObject;
import dpark.GameOtherVars;

/**
 * @author Nickita
 */
public class AN_alarm extends GameObject {

    public int xt;
    public int yt;


    public int TimerToCT = 1;
    public int TX = 0;
    public AN_alarm(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("TNT_none.png"));
        sprite.addStep(Game.instance.getSprite("alarm.png"));
        sprite.addStep(Game.instance.getSprite("alarm.png"));
        sprite.addStep(Game.instance.getSprite("alarm.png"));
        sprite.addStep(Game.instance.getSprite("alarm.png"));
        sprite.addStep(Game.instance.getSprite("alarm.png"));
        sprite.addStep(Game.instance.getSprite("alarm.png"));
        sprite.addStep(Game.instance.getSprite("alarm.png"));
        sprite.addStep(Game.instance.getSprite("alarm.png"));
        sprite.addStep(Game.instance.getSprite("alarm.png"));
        sprite.addStep(Game.instance.getSprite("TNT_none.png"));




    }


    @Override
    public void update() {
        // STEPS
        xt = x;
        yt = y;
        z = 1000;
        sprite.currentStep = TX;
        if (GameOtherVars.PlAlarmOn == 1) {
            if (TimerToCT <= 0) {
                if (TX < 10) {
                    TX++;
                    TimerToCT = 15;
                }
            } else {

                TimerToCT--;

            }
        }
    }

}
