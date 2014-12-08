package dpark.objects;
import dpark.GameObject;
import dpark.Game;

import javax.jws.soap.SOAPBinding;

/**
 * @author Nickita
 */
public class Spruce extends GameObject {
    public int Timer = 0;
    int UseRandom = 0;
    int UseTimer = 1;

    public Spruce(String name)
    {
        super(name);
        sprite.addStep(Game.instance.getSprite("Tree.png"));


        z = 15;
    }
    @Override
    public void update()
    {
        if (Timer <= 0 && UseTimer == 1)
        {
            UseRandom = 1 + (int) (Math.random() * ((4 - 1) + 1));
            if (UseRandom == 1)
            {
                Game.SantaX = x;
                Game.SantaY = y;
                Game.NWY_Present_create = 0;
                UseTimer = 0;
                //Timer = 40;
            }
        } else {
            Timer--;
        }
    }



}
