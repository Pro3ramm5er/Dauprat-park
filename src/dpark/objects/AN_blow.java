package dpark.objects;

import dpark.Game;
import dpark.GameObject;
import dpark.GameOtherVars;

/**
 * @author Nickita
 */
public class AN_blow extends GameObject {

    public int xt;
    public int yt;


    public int TimerToCT = 3;
    public int TX = 0;
    public AN_blow(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("Ban1.png"));
        sprite.addStep(Game.instance.getSprite("Ban2.png"));
        sprite.addStep(Game.instance.getSprite("Ban3.png"));
        sprite.addStep(Game.instance.getSprite("Ban4.png"));
        sprite.addStep(Game.instance.getSprite("TNT_none.png"));

    }


    @Override
    public void update() {
        // STEPS
        xt = x;
        yt = y;
        z = yt + 48;
        sprite.currentStep = TX;
        if (TimerToCT <= 0) {
          if (TX < 4)
          {
              TX++;
              TimerToCT = 3;
          }
        } else {
            TimerToCT--;
        }
    }

}

