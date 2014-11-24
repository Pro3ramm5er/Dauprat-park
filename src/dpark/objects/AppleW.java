package dpark.objects;

import dpark.Game;
import dpark.GameObject;

/**
 * Created by Nickita on 24.11.2014.
 */
public class AppleW extends GameObject {

    public int xt;
    public int yt;
    public int MST = 1; // 1 - up, 2 - right, 3 - down, 4 - left

    public AppleW(String name)
    {
        super(name);
        sprite.addStep(Game.instance.getSprite("AppleW_1.png"));
    }
    @Override
    public void update()
    {
        if (ог)
    }




}
