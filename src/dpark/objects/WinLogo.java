package dpark.objects;

import dpark.Game;
import dpark.GameObject;

/**
 * Created by Nickita on 17.11.2014.
 */
public class WinLogo extends GameObject {

    public int Timer = 10;
    public int Timer_sec = 0;
    public WinLogo(String name) {

        super(name);
        sprite.addStep(Game.instance.getSprite("Final.png"));
        sprite.addStep(Game.instance.getSprite("Needakey4.png"));
        sprite.addStep(Game.instance.getSprite("Final_2.png"));
        sprite.addStep(Game.instance.getSprite("Final_3.png"));
        sprite.addStep(Game.instance.getSprite("Final_4.png"));
        sprite.addStep(Game.instance.getSprite("Final_5.png"));
        sprite.addStep(Game.instance.getSprite("Final_6.png"));
        sprite.addStep(Game.instance.getSprite("Final_7.png"));


        z = 500;
    }

    @Override
    public void update() {
        if (Game.WinVisible == 0) {

            sprite.currentStep = 1;
        }
        if (Game.WinVisible == 1) {
            if (Timer <= 0 && Timer_sec <= 6)
            {
                Timer_sec++;
                Timer = 1;
            } else {

                Timer--;

            }
            if (Timer_sec == 0) {
                sprite.currentStep = 0;
            }
            if (Timer_sec == 1) {
                sprite.currentStep = 2;
            }
            if (Timer_sec == 2) {
                sprite.currentStep = 3;
            }
            if (Timer_sec == 3) {
                sprite.currentStep = 4;
            }
            if (Timer_sec == 4) {
                sprite.currentStep = 5;
            }
            if (Timer_sec == 5) {
                sprite.currentStep = 6;
            }
            if (Timer_sec == 6) {
                sprite.currentStep = 7;
            }
        }
    }


}
