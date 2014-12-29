package dpark.objects;

import dpark.Game;
import dpark.GameObject;

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
        z = 1500;
    }
    @Override
    public void update()
    {
        if (Game.Health == 2)
        {
            sprite.currentStep = 0;
        }
        if (Game.Health == 1)
        {
            sprite.currentStep = 1;
        }
        if (Game.Health == 0)
        {
            sprite.currentStep = 3;
        }
    }

}
