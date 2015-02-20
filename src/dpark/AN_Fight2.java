package dpark;

/**
 * @author Nickita
 */
public class AN_Fight2 extends GameObject {

    public int xt;
    public int yt;


    public int TimerToCT = 1;
    public int TX = 0;
    public AN_Fight2(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("AN_fight1.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight2.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight3.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight4.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight5.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight6.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight7.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight8.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight9.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight10.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight11.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight11.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight11.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight11.png"));
        sprite.addStep(Game.instance.getSprite("AN_fight11.png"));
        sprite.addStep(Game.instance.getSprite("TNT_none.png"));




    }


    @Override
    public void update() {
        // STEPS
        xt = x;
        yt = y;
        z = 1000;
        sprite.currentStep = TX;
        if (TimerToCT <= 0) {
            if (TX < 15)
            {
                TX++;
                TimerToCT = 1;
            }
        } else {

                TimerToCT--;

        }
    }

}

