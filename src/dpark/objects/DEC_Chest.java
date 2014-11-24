package dpark.objects;
import dpark.Game;
import dpark.GameObject;
/**
 * Created by Nickita on 18.11.2014.
 */
public class DEC_Chest extends GameObject {
    public int[] myx = {1, 2, 3, 4 , 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    public int[] myy = {1, 2, 3, 4 , 5, 6, 7};
    public int Texture_number = 1 + (int)(Math.random() * ((2 - 1) + 1));
    int otchet = 0;
    int otchet2 = 0;
    int otchet3 = 0;
    int otchet4 = 0;
    public  int xt;
    public  int yt;
    int Col_del = 0;
    int Timer = 0;

    public DEC_Chest(String name)
    {
        super(name);
        z = 0;
        sprite.addStep(Game.instance.getSprite("Chest.png"));
        sprite.addStep(Game.instance.getSprite("Chest2.png"));
        if (Texture_number == 1)
        {
           sprite.currentStep = 0;

        }

        //if (Texture_number == 2)
        //{
        //    sprite.currentStep = 1;
        //}
    }
    @Override
    public void update()
    {
        /*
        if (Timer <= 0)
        {
            Col_del = 0;
            Timer = 0;
        } else {
            Timer--;
        }
        if (otchet == myx.length) {
            otchet = 0;
            System.out.println("OP....");
        }
        if (otchet2 == myy.length) {
            otchet2 = 0;
            System.out.println("OP2....");
        }



        if (otchet == myx.length ) {
            otchet = 0;
        }
        if ( otchet2 == myy.length) {
            otchet2 = 0;
        }

        if (xt - myx[otchet] == plx1 || xt + myx[otchet] == plx1 || xt - myx[otchet] == plx2 || xt + myx[otchet] == plx2 || xt - myx[otchet] == plx3 || xt + myx[otchet] == plx3 || xt - myx[otchet] == plx4 || xt + myx[otchet] == plx4) {
            if (yt - myy[otchet2] == ply1 || yt + myy[otchet2] == ply1 || yt - myy[otchet2] == ply1 || yt + myy[otchet2] == ply1 || yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet2] == ply3 || yt + myy[otchet2] == ply3 || yt - myy[otchet2] == ply4 || yt + myy[otchet2] == ply4) {
                if (Col_del == 0 & Timer == 0) {
                    System.out.println(PlayerColSt + "::" + PlayerWalkst);

                    Col_del = 1;
                    Timer = 50;
                    Player.Collision();
                    System.out.println(PlayerColSt + "::" + PlayerWalkst);



                }

            } else {
                //System.out.println("Yea.....");
                Col_del = 0;
                if (otchet == myx.length ) {
                    otchet = 0;
                } else {
                    otchet++;

                }
                if ( otchet2 == myy.length) {
                    otchet2 = 0;
                } else {
                    otchet2++;
                }
            }

        } else {

            Col_del = 0;
            if (otchet == myx.length ) {
                otchet = 0;
            } else {
                otchet++;

            }
            if ( otchet2 == myy.length) {
                otchet2 = 0;
            }


         */




        if (Timer <= 0)
        {
            Col_del = 0;
            Timer = 0;
        } else {
            Timer--;
        }
        if (otchet == myx.length) {
            otchet = 0;
            System.out.println("OP....");
        }
        if (otchet3 == myx.length) {
            otchet3 = 0;
            System.out.println("OP....");
        }
        if (otchet2 == myy.length) {
            otchet2 = 0;
            System.out.println("OP2....");
        }
        if (otchet4 == myy.length) {
            otchet4 = 0;
            System.out.println("OP2....");
        }





        if (xt - myx[otchet] == plx1 || xt + myx[otchet] == plx1 || xt - myx[otchet3] == plx1 || xt + myx[otchet3] == plx1 || xt - myx[otchet] == plx2 || xt + myx[otchet] == plx2 || xt - myx[otchet3] == plx2 || xt + myx[otchet3] == plx2 || xt - myx[otchet] == plx3 || xt + myx[otchet] == plx3 || xt - myx[otchet3] == plx3 || xt + myx[otchet3] == plx3 || xt - myx[otchet] == plx4 || xt + myx[otchet] == plx4 || xt - myx[otchet3] == plx4 || xt + myx[otchet3] == plx4) {
            if (yt - myy[otchet2] == ply1 || yt + myy[otchet2] == ply1 || yt - myy[otchet4] == ply1 || yt + myy[otchet4] == ply1 || yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply1 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply1 ||  yt - myy[otchet2] == ply2 || yt + myy[otchet2] == ply2 || yt - myy[otchet4] == ply2 || yt + myy[otchet4] == ply2|| yt - myy[otchet2] == ply3 || yt + myy[otchet2] == ply3 || yt - myy[otchet4] == ply3 || yt + myy[otchet4] == ply3 || yt - myy[otchet2] == ply4 || yt + myy[otchet2] == ply4 || yt - myy[otchet4] == ply4 || yt + myy[otchet4] == ply4) {
                if (Col_del == 0 & Timer == 0) {
                    System.out.println(PlayerColSt + "::" + PlayerWalkst);

                    Col_del = 1;
                    Timer = 50;
                    Player.Collision();
                    System.out.println(PlayerColSt + "::" + PlayerWalkst);



                }

            } else {
                //System.out.println("Yea.....");
                Col_del = 0;
                if (otchet == myx.length ) {
                    otchet = 0;
                } else {
                    otchet++;

                }
                if (otchet3 == myx.length ) {
                    otchet3 = 0;
                } else {
                    otchet3++;

                }
                if ( otchet2 == myy.length) {
                    otchet2 = 0;
                } else {
                    otchet2++;
                }
                if ( otchet4 == myy.length) {
                    otchet4 = 0;
                } else {
                    otchet4++;
                }
            }

        } else {

            Col_del = 0;
            if (otchet == myx.length ) {
                otchet = 0;
            } else {
                otchet++;

            }
            if (otchet3 == myx.length ) {
                otchet3 = 0;
            } else {
                otchet3++;

            }



        }


    }










    }



