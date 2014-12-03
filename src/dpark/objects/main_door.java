package dpark.objects;

import dpark.Game;
import dpark.GameObject;

/**
 * Created by Nickita on 28.10.2014.
 */
public class main_door extends GameObject {
    public static int Main_Key_is = 0;
    public int xd;
    public int yd;
    public int xch = 0;
    public int ych = 0;
    int i = 0;
    int i1 = 0;
    int[] xdd = {xd, xd - 1, xd + 1, xd + 2, xd - 2, xd - 3, xd + 3};
    int[] ydd = {yd, yd - 1, yd + 1, yd + 2, yd - 2, yd - 5, yd + 5, yd - 6, yd + 6, yd - 7, yd + 7, yd + 8, yd - 8};

    public main_door(String name) {

        super(name);

        sprite.addStep(Game.instance.getSprite("Maindoor.png"));


    }

    public void Checker_Opener() {

        if (Main_Key_is == 0) {

            KeyMessage.GetReset = 100;


        } else {


        }
    }

    @Override
    public void update() {
        super.update();


        if (xd == plx && yd - 64 == ply) {
            Checker_Opener();

        }
        if (xd == plx && yd + 64 == ply) {
            Checker_Opener();

        }
        if (xd == plx && yd - 63 == ply) {
            Checker_Opener();

        }
        if (xd == plx && yd + 63 == ply) {
            Checker_Opener();

        }
        if (xd == plx && yd - 65 == ply) {
            Checker_Opener();

        }
        if (xd == plx && yd + 65 == ply) {
            Checker_Opener();

        }


        if (xd == plx && yd - 68 == ply) {
            Checker_Opener();

        }
        if (xd == plx && yd + 68 == ply) {
            Checker_Opener();

        }
        if (xd == plx && yd - 67 == ply) {
            Checker_Opener();

        }
        if (xd == plx && yd + 67 == ply) {
            Checker_Opener();

        }
        if (xd == plx && yd - 66 == ply) {
            Checker_Opener();

        }
        if (xd == plx && yd + 66 == ply) {
            Checker_Opener();

        }


        //next


        if (xd == plx1 && yd - 64 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd + 64 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd - 63 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd + 63 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd - 65 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd + 65 == ply1) {
            Checker_Opener();

        }


        if (xd == plx1 && yd - 68 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd + 68 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd - 67 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd + 67 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd - 66 == ply1) {
            Checker_Opener();
        }
        if (xd == plx1 && yd + 66 == ply1) {
            Checker_Opener();

        }


        if (xd == plx1 && yd - 71 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd + 71 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd - 70 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd + 70 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd - 69 == ply1) {
            Checker_Opener();

        }
        if (xd == plx1 && yd + 69 == ply1) {
            Checker_Opener();

        }
        //next

        if (xd == plx2 && yd - 64 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd + 64 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd - 63 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd + 63 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd - 65 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd + 65 == ply2) {
            Checker_Opener();

        }


        if (xd == plx2 && yd - 68 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd + 68 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd - 67 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd + 67 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd - 66 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd + 66 == ply2) {
            Checker_Opener();

        }


        if (xd == plx2 && yd - 71 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd + 71 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd - 70 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd + 70 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd - 69 == ply2) {
            Checker_Opener();

        }
        if (xd == plx2 && yd + 69 == ply2) {
            Checker_Opener();

        }
        //next


    }


}
