package dpark.objects;

import dpark.Game;
import dpark.GameObject;

/**
 * Created by Nickita on 02.12.2014.
 */
public class DEC_Earth extends GameObject {


    public DEC_Earth(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("trava.png"));
        sprite.addStep(Game.instance.getSprite("trava1.png"));
        sprite.addStep(Game.instance.getSprite("trava2.png"));
        z = y;
        sprite.currentStep = 0 + (int) +(Math.random() * ((2 - 0) + 1));
    }


}
