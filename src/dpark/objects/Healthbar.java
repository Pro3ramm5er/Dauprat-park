package dpark.objects;

import dpark.Game;
import dpark.GameObject;
import dpark.GameOtherVars;

/**
 * @author Nickita
 */
public class Healthbar extends GameObject {
    public Healthbar(String name)
    {
        super(name);
        sprite.addStep(Game.instance.getSprite("Health_100.png"));
        sprite.addStep(Game.instance.getSprite("Health_50.png"));
        sprite.addStep(Game.instance.getSprite("Health_0.png"));
        sprite.addStep(Game.instance.getSprite("Health_150.png"));
        sprite.addStep(Game.instance.getSprite("Health_200.png"));
        z = 1500;
    }
    @Override
    public void update()
    {
        if (GameOtherVars.Health == 4)
        {
            sprite.currentStep = 4;
        }
        if (GameOtherVars.Health == 3)
        {
            sprite.currentStep = 3;
        }
        if (GameOtherVars.Health == 2)
        {
            sprite.currentStep = 0;
        }
        if (GameOtherVars.Health == 1)
        {
            sprite.currentStep = 1;
        }
        if (GameOtherVars.Health == 0)
        {
            sprite.currentStep = 2;
        }
    }

}
