package dpark.objects;

import dpark.Game;
import dpark.GameObject;

/**
 * Created by Nickita on 10.11.2014.
 */
public class AppleS extends GameObject {

    private int Texture_number = 0 + (int) (Math.random() * ((3 - 1) + 1));
    public int retplx;
    public int retply;
    public int xplus;
    public int yplus;


    public AppleS(String name) {
        super(name);
        z = -5;
        sprite.addStep(Game.instance.getSprite("AppleMutant.png"));
        sprite.addStep(Game.instance.getSprite("AppleMutant_2.png"));
        sprite.addStep(Game.instance.getSprite("AppleMutant_3.png"));
        sprite.addStep(Game.instance.getSprite("Needakey4"));

        //System.out.println("apples!");


        sprite.currentStep = 0;
    }

    @Override
    public void update() {

        //System.out.println("applees!");
        if (Game.Applecalipses == 1) {
            //visible = true;
            sprite.currentStep = Texture_number;
        }
        if (Game.Applecalipses == 0) {
            //visible = false;
            //System.out.println(x + "::" + y + "::");
            sprite.currentStep = 3;
            if (xplus == 1) {
                x = plx + retplx;
            }
            if (xplus == 0) {
                x = plx - retplx;
            }
            if (yplus == 1) {
                y = ply + retply;
            }
            if (yplus == 0) {
                y = ply - retply;
            }
        }
    }


}
