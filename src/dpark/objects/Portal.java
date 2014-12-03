package dpark.objects;

import dpark.Game;
import dpark.GameObject;

/**
 * Created by Nickita on 28.11.2014.
 */
public class Portal extends GameObject {


    public int Timer = 700;
    public int Shans_sozdania = 0;
    public int Type = 1; //+ (int)(Math.random() * ((2 - 1) + 1));
    public int TimeChangeTExture = 5;
    public int Texture_number = 0;


    public Portal(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("ApplePortal_1.png"));
        sprite.addStep(Game.instance.getSprite("ApplePortal_2.png"));
        sprite.addStep(Game.instance.getSprite("ApplePortal_3.png"));
    }

    public void DO() {
        Game.AppleCreate = 0;
        Timer = 700;
    }


    @Override
    public void update() {
        if (TimeChangeTExture <= 0) {
            if (Texture_number < 2) {
                sprite.currentStep = Texture_number;
                TimeChangeTExture = 5;
                Texture_number++;
            } else {
                Texture_number = 0;
            }

        } else {
            TimeChangeTExture--;
        }
        if (Type == 1) {
            if (Timer <= 0) {
                DO();
            } else {
                Timer--;
            }
        }

    }


}
