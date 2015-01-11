package dpark.objects;

import dpark.Game;
import dpark.GameObject;
import dpark.GameOtherVars;

/**
 * Created by Nickita on 17.11.2014.
 */
public class DieLogo extends GameObject {


    public DieLogo(String name) {

        super(name);
        sprite.addStep(Game.instance.getSprite("Gameover.png"));
        sprite.addStep(Game.instance.getSprite("Needakey4.png"));
        z = 1900;
    }

    @Override
    public void update() {
        if (GameOtherVars.VisibleDieLogo == 0) {
            sprite.currentStep = 1;
        }
        if (GameOtherVars.VisibleDieLogo == 1) {
            sprite.currentStep = 0;
        }
    }


}
