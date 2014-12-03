package dpark.objects;

import dpark.Game;
import dpark.GameObject;

/**
 * Created by Nickita on 03.11.2014.
 */
public class KeyMessage extends GameObject {
    public static int Created = 0;
    public static int AnimStep = 0;
    public static int GetReset = 0;

    public KeyMessage(String name) {
        super(name);


        sprite.addStep(Game.instance.getSprite("Needakey.png"));

        sprite.addStep(Game.instance.getSprite("Needakey.png"));
        sprite.addStep(Game.instance.getSprite("Needakey.png"));
        sprite.addStep(Game.instance.getSprite("Needakey.png"));
        sprite.addStep(Game.instance.getSprite("Needakey.png"));
        sprite.addStep(Game.instance.getSprite("Needakey.png"));
        sprite.addStep(Game.instance.getSprite("Needakey.png"));
        sprite.addStep(Game.instance.getSprite("Needakey.png"));
        sprite.addStep(Game.instance.getSprite("Needakey.png"));
        sprite.addStep(Game.instance.getSprite("Needakey.png"));
        sprite.addStep(Game.instance.getSprite("Needakey.png"));

        sprite.addStep(Game.instance.getSprite("Needakey1.png"));
        sprite.addStep(Game.instance.getSprite("Needakey2.png"));
        sprite.addStep(Game.instance.getSprite("Needakey3.png"));
        sprite.addStep(Game.instance.getSprite("Needakey4.png"));

        sprite.currentStep = 0;


        //Created = 1;

    }

    @Override
    public void update() {
        super.update();


        //if (AnimStep == 0)
        //{
        //visible = true;
        if (GetReset != 0) {
            sprite.currentStep = 0;
            GetReset -= 1;
        }
        if (sprite.currentStep == 14) {

            //AnimStep = 1;

        }
        if (sprite.currentStep != 14) {
            sprite.currentStep++;

        }
        //}
    }

}
