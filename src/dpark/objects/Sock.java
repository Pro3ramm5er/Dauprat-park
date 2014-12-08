package dpark.objects;
import dpark.GameObject;
import dpark.Game;
/**
 * @author Nickita
 */
public class Sock extends GameObject {

    public int YO;
    public Sock(String name)
    {
        super(name);
        sprite.addStep(Game.instance.getSprite("sock.png"));

        sprite.addStep(Game.instance.getSprite("sock_right.png"));
        YO = 0 + (int) (Math.random() * ((1 - 0) + 1));
        sprite.currentStep = YO;
        z = -5;
    }



}
