package dpark.objects;

import dpark.Game;
import dpark.GameObject;

/**
 * Created by Nickita on 28.11.2014.
 */
public class Portal extends GameObject {


    public int Timer = 100;
    public int Shans_sozdania = 0;
    public int Type = 1; //+ (int)(Math.random() * ((2 - 1) + 1));
    public int TimeChangeTExture = 5;
    public int Texture_number = 0;


    public Portal(String name)
    {
        super(name);
        sprite.addStep(Game.instance.getSprite("ApplePortal_1.png"));
        sprite.addStep(Game.instance.getSprite("ApplePortal_2.png"));
        sprite.addStep(Game.instance.getSprite("ApplePortal_3.png"));
    }
    public void DO()
    {
        Shans_sozdania = 1 + (int) (Math.random() * ((2 - 1) + 1));
        if (Shans_sozdania == 2) {
            Game.StopUpdate = 1;

            Game.instance.NPC_AppleW_create(0);

            Game.StopUpdate = 1;
            System.out.println("2");
            Game.StopUpdate = 0;
            //Timer = 50;
        }
    }

    public void DO_2()
    {
        Shans_sozdania = 1 + (int) (Math.random() * ((2 - 1) + 1));
        if (Shans_sozdania == 2) {
            Game.StopUpdate = 1;

            Game.instance.NPC_Deamon_create();


            Timer = 50;
            Game.StopUpdate = 0;
        }
    }
    @Override
    public void update()
    {
        if (TimeChangeTExture <= 0)
        {
            if (Texture_number < 2)
            {
                sprite.currentStep = Texture_number;
                TimeChangeTExture = 5;
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
        if (Type == 2) {
            if (Timer <= 0) {
                DO_2();
            } else {
                Timer--;
            }
        }
    }


}
