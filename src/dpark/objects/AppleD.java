package dpark.objects;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import dpark.GameObject;
import dpark.Game;
import dpark.DB;

import static dpark.DB.db;

/**
 * Created by Nickita on 08.11.2014.
 */
public class AppleD extends GameObject {

         public int Texture_number = 1 + (int)(Math.random() * ((2 - 1) + 1));
         public int[] myx = {0, 1 ,2 ,3 ,4 ,5, 6, 7, 8, 9, 10, 11 ,12, 13, 14, 15,16, 17, 18, 19, 20};
         public int[] myy = {0, 1 ,2 ,3 ,4, 5, 6, 7, 8, 9, 10, 11 ,12, 13, 14, 15,16, 17, 18, 19, 20};

         public  int xt;
         public  int yt;
         int otchet = 0;
         int otchet2 = 0;
         public int dead = 0;
         int Timer = 100;
         int OneDo = 0;
         int Timer_sec = 0;
         int created = 0;

         public AppleD(String name)
         {
           super(name);





             if (Texture_number == 1) {
                 sprite.addStep(Game.instance.getSprite("Apple.png"));

             }
             if (Texture_number == 2) {
                 sprite.addStep(Game.instance.getSprite("Apple_2.png"));

             }
             sprite.addStep(Game.instance.getSprite("Apple_dead.png"));
             sprite.currentStep = 0;
         }

         @Override
         public void update()
         {
             super.update();

             if (dead == 0) {
                 if (otchet == myx.length || otchet == myy.length) {
                     otchet = 0;
                 }
                 if (otchet2 == myx.length || otchet2 == myy.length) {
                     otchet2 = 0;
                 }

                 if (xt - myx[otchet] == plx || xt + myx[otchet] == plx) {
                     if (yt - myy[otchet] == ply || yt + myy[otchet] == ply || yt - myy[otchet2] == ply || yt + myy[otchet2] == ply) {
                         sprite.currentStep = 1;
                         dead = 1;

                     } else {
                         if (otchet == myx.length || otchet == myy.length) {
                             otchet = 0;
                         } else {
                             otchet++;

                         }
                         if (otchet2 == myx.length || otchet2 == myy.length) {
                             otchet2 = 0;
                         } else {
                             otchet2++;
                         }
                     }

                 } else {

                     if (otchet == myx.length || otchet == myy.length) {
                         otchet = 0;
                     } else {
                         otchet++;

                     }
                     if (otchet2 == myx.length || otchet2 == myy.length) {
                         otchet2 = 0;
                     }


                 }




                 if (otchet == myx.length || otchet == myy.length) {
                     otchet = 0;
                 }
                 if (otchet2 == myx.length || otchet2 == myy.length) {
                     otchet2 = 0;
                 }

                 if (xt - myx[otchet] == plx1 || xt + myx[otchet] == plx1) {
                     if (yt - myy[otchet] == ply1 || yt + myy[otchet] == ply1 || yt - myy[otchet2] == ply1 || yt + myy[otchet2] == ply1) {
                         sprite.currentStep = 1;
                         dead = 1;

                     } else {
                         if (otchet == myx.length || otchet == myy.length) {
                             otchet = 0;
                         } else {
                             otchet++;

                         }
                         if (otchet2 == myx.length || otchet2 == myy.length) {
                             otchet2 = 0;
                         } else {
                             otchet2++;
                         }
                     }

                 } else {

                     if (otchet == myx.length || otchet == myy.length) {
                         otchet = 0;
                     } else {
                         otchet++;

                     }
                     if (otchet2 == myx.length || otchet2 == myy.length) {
                         otchet2 = 0;
                     }


                 }





             }


             if (otchet == myx.length || otchet == myy.length)
             {
                 otchet = 0;
             }
             if (otchet2 == myx.length || otchet2 == myy.length)
             {
                 otchet2 = 0;
             }
             if (dead == 1 && Timer_sec == 0)
             {
                 Player.PlayerCanMovie = 1;
                 sprite.currentStep = 1;
                 if (Timer <= 0) {
                     OnAI();
                     Timer_sec = 1;
                     Timer = 50;
                 } else {
                     Timer--;
                 }

             }
             if (Timer_sec == 1)
             {
                 if (Timer <= 0)
                 {
                    //System.out.println("Suns ready");
                    Game.VisibleDieLogo = 1;
                    Timer_sec = 2;
                    Timer = 100;
                 } else {
                     Timer --;
                 }
             }
             if (Timer_sec == 2)
             {
                 if (Timer <= 0)
                 {
                     //System.out.println("Suns ready2");
                     dead = 0;
                     Timer_sec = 0;
                     Timer = 5;
                     Game.VisibleDieLogo = 0;
                     Game.Get_Die();


                 } else {
                     Timer --;
                 }
             }



         }
    public void AppleCreate_rn(int rt, int rt1) {
        {
             AppleD fr = new AppleD("apple");
            fr.x = rt;
            fr.y = rt1;
            fr.z = -5;
            fr.xt = rt;
            fr.yt = rt1;

            //System.out.println("Game/Objects/AppleD created" + ":" + rt + ":" + rt1);


        }
        //Wxx.put(Wxx_now, xa);
        //Wyy.put(Wyy_now, ya);
        //Wxx_now++;
        //Wyy_now++;

    }
         public  void OnAI()
         {

             if (OneDo == 0) {
                 Game.instance.AppleCalipse();

                 OneDo = 1;
             }

         }











}
