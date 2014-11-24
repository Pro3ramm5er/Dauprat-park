package dpark.objects;
import dpark.Game;
import dpark.GameObject;
/**
 * Created by Nickita on 18.11.2014.
 */
public class DEC_Chest extends GameObject {
    public int[] myx = {1, 2, 3, 4 , 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    public int[] myy = {1, 1, 2, 2, 3, 3, 4 ,4, 5, 5, 6, 6,7, 7};
    public int Texture_number = 1 + (int)(Math.random() * ((2 - 1) + 1));
    int otchet = 0;
    int otchet2 = 0;
    public static int xt;
    public static int yt;
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
        /*
        if (xt - myx[otchet] == plx | xt + myx[otchet] == plx) {
            if (yt - myy[otchet2] == ply | yt + myy[otchet2] == ply | yt - myy[otchet2] == ply | yt + myy[otchet2] == ply) {
                System.out.println(PlayerColSt + "::" + PlayerWalkst);
                if (Col_del == 0 & Timer == 0) {
                    System.out.println(PlayerColSt + "::" + PlayerWalkst);
                    System.out.println("Yea!");
                    Col_del = 1;
                    Timer = 5000;
                    Player.Collision();



                }

            } else {
                System.out.println("Yea....");

                if (otchet != myx.length ) {


                    otchet++;
                    System.out.println("Otchet++" + otchet);

                }
                if (otchet2 == myy.length) {
                    otchet2 = 0;
                    System.out.println("OP2....");
                } else {
                    otchet2++;
                    System.out.println("Otchet2++" + otchet2);
                }
            }

        } else {


            if (otchet == myx.length ) {
                otchet = 0;
                System.out.println("OP....");
            } else {
                otchet++;

            }
            if ( otchet2 == myy.length) {
                otchet2 = 0;
                System.out.println("OP2....");
            }


        }

         */


        if (otchet == myx.length ) {
            otchet = 0;
        }
        if ( otchet2 == myy.length) {
            otchet2 = 0;
        }

        if (xt - myx[otchet] == plx1 | xt + myx[otchet] == plx1 | xt - myx[otchet] == plx2 | xt + myx[otchet] == plx2 | xt - myx[otchet] == plx3 | xt + myx[otchet] == plx3 | xt - myx[otchet] == plx4 | xt + myx[otchet] == plx4) {
            if (yt - myy[otchet2] == ply1 | yt + myy[otchet2] == ply1 | yt - myy[otchet2] == ply1 | yt + myy[otchet2] == ply1 | yt - myy[otchet2] == ply2 | yt + myy[otchet2] == ply2 | yt - myy[otchet2] == ply3 | yt + myy[otchet2] == ply3 | yt - myy[otchet2] == ply4 | yt + myy[otchet2] == ply4) {
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


        }


        /*
        if (otchet == myx.length ) {
            otchet = 0;
        }
        if ( otchet2 == myy.length) {
            otchet2 = 0;
        }

        if (xt - myx[otchet] == plx2 | xt + myx[otchet] == plx2) {
            if (yt - myy[otchet2] == ply2 | yt + myy[otchet2] == ply2 | yt - myy[otchet2] == ply2 | yt + myy[otchet2] == ply2) {
                if (Col_del == 0) {
                    System.out.println("Yea!");
                    Player.Collision();
                    Col_del = 1;
                }

            } else {
                System.out.println("Yea....");
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


        }





        if (otchet == myx.length ) {
            otchet = 0;
        }
        if ( otchet2 == myy.length) {
            otchet2 = 0;
        }

        if (xt - myx[otchet] == plx3 | xt + myx[otchet] == plx3) {
            if (yt - myy[otchet2] == ply3 | yt + myy[otchet2] == ply3 | yt - myy[otchet2] == ply3 | yt + myy[otchet2] == ply3) {
                if (Col_del == 0) {
                    System.out.println("Yea!");
                    Player.Collision();
                    Col_del = 1;
                }

            } else {
                System.out.println("Yea.....");
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


        }






        if (otchet == myx.length ) {
            otchet = 0;
        }
        if ( otchet2 == myy.length) {
            otchet2 = 0;
        }

        if (xt - myx[otchet] == plx4 | xt + myx[otchet] == plx4) {
            if (yt - myy[otchet2] == ply4 | yt + myy[otchet2] == ply4 | yt - myy[otchet2] == ply4 | yt + myy[otchet2] == ply4) {
                if (Col_del == 0) {
                    System.out.println("Yea!");
                    Player.Collision();
                    Col_del = 1;
                }

            } else {
                System.out.println("Yea...");
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


        }






        if (otchet == myx.length ) {
            otchet = 0;
        }
        if ( otchet2 == myy.length) {
            otchet2 = 0;
        }

        if (xt - myx[otchet] == plx5 | xt + myx[otchet] == plx5) {
            if (yt - myy[otchet2] == ply5 | yt + myy[otchet2] == ply5 | yt - myy[otchet2] == ply5 | yt + myy[otchet2] == ply5) {
                if (Col_del == 0) {
                    System.out.println("Yea!");
                    Player.Collision();
                    Col_del = 1;
                }

            } else {
                System.out.println("Yea...");
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


        }
        */

    }


}
