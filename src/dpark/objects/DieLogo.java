package dpark.objects;

import dpark.Game;
import dpark.GameObject;

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
        if (Game.VisibleDieLogo == 0) {
            sprite.currentStep = 1;
        }
        if (Game.VisibleDieLogo == 1) {
            sprite.currentStep = 0;
        }
    }


}
