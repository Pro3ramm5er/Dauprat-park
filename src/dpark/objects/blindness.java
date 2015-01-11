package dpark.objects;
import dpark.GameObject;
import dpark.Game;
import dpark.GameOtherVars;

import javax.jws.soap.SOAPBinding;

/**
 * @author Nickita
 */
public class blindness extends GameObject {
    public int Timer = 35;
    public blindness(String name)
    {
        super(name);
        sprite.addStep(Game.instance.getSprite("blindness.png"));
        sprite.addStep(Game.instance.getSprite("blindness_off.png"));


        //z = y;
    }
    @Override
    public void update()
    {
        if (GameOtherVars.blindness_on == 1)
        {
            sprite.currentStep = 0;
            if (Timer <= 0)
            {
                GameOtherVars.blindness_on = 0;
                Timer = 35;
            } else {
                Timer--;
            }
        } else {
            sprite.currentStep = 1;
        }
    }
}
