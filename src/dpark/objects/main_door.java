package dpark.objects;
import dpark.Game.*;
import dpark.Game;
import dpark.GameObject;
import dpark.DB;
import dpark.objects.KeyMessage;
import dpark.DB.*;

import static dpark.DB.db;

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
         int[] xdd = {xd, xd-1, xd+1, xd+2, xd-2, xd-3, xd+3};
         int[] ydd = {yd, yd-1, yd+1, yd+2, yd-2, yd-5, yd+5, yd-6, yd+6, yd-7, yd+7, yd+8, yd-8};
           public main_door(String name)
           {

             super(name);

               sprite.addStep(Game.instance.getSprite("Maindoor.png"));


           }

           public  void Checker_Opener()
           {

             if (Main_Key_is == 0)
             {

                 KeyMessage.GetReset = 100;





                 /*
                 if (KeyMessage.Created == 0) {

                     KeyMessage kms1 = new KeyMessage("Message");

                     kms1.x = 150;
                     kms1.y = 150;
                     kms1.z = 50;

                     //db.objects.put(kms1.name, kms1);
                     //Game.currentRoom.objectsIDs.add(kms1.name);
                     Player.Collision();

                 } else {
                     KeyMessage.AnimStep = 0;

                 }
                 */
             } else {
                 //db.objects.get("key_need").visible = true;

                   // WIIIIIIN!//

             }
           }
           @Override
           public void update()
           {
               super.update();

              
               if (xd == plx && yd-64 == ply)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx && yd+64 == ply)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx && yd-63 == ply)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx && yd+63 == ply)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx && yd-65 == ply)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx && yd+65 == ply)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }



               if (xd == plx && yd-68 == ply)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx && yd+68 == ply)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx && yd-67 == ply)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx && yd+67 == ply)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx && yd-66 == ply)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx && yd+66 == ply)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }


               //next



               if (xd == plx1 && yd-64 == ply1)
           {
               Checker_Opener();
               System.out.println("WHAT A FUCK?????");;
           }
               if (xd == plx1 && yd+64 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx1 && yd-63 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx1 && yd+63 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx1 && yd-65 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx1 && yd+65 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }


               if (xd == plx1 && yd-68 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx1 && yd+68 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx1 && yd-67 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx1 && yd+67 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx1 && yd-66 == ply1)
               {
                   Checker_Opener();
               }
               if (xd == plx1 && yd+66 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }



               if (xd == plx1 && yd-71 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx1 && yd+71 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx1 && yd-70 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx1 && yd+70 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx1 && yd-69 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx1 && yd+69 == ply1)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               //next

               if (xd == plx2 && yd-64 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd+64 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd-63 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd+63 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd-65 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd+65 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }



               if (xd == plx2 && yd-68 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd+68 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd-67 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd+67 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd-66 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd+66 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }



               if (xd == plx2 && yd-71 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd+71 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd-70 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd+70 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd-69 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               if (xd == plx2 && yd+69 == ply2)
               {
                   Checker_Opener();
                   System.out.println("WHAT A FUCK?????");
               }
               //next



               /*
               if (xd == plx3 && yd-68 == ply3)
               {
                   if (Main_Key_is == 0)
             {

                 KeyMessage kms1 = new KeyMessage("Message");
                 kms1.x = 150;
                 kms1.y = 150;
                 kms1.z = 5;
                 System.out.println("EERT");
                 db.objects.put(kms1.name, kms1);
                 Game.currentRoom.objectsIDs.add(kms1.name);
                 Player.Collision();

             } else {
                 //db.objects.get("key_need").visible = true;

                   // WIIIIIIN!//

             }
               }
               if (xd == plx3 && yd+68 == ply3)
               {
                   Checker_Opener();
               }
               if (xd == plx3 && yd-67 == ply3)
               {
                   Checker_Opener();
               }
               if (xd == plx3 && yd+67 == ply3)
               {
                   Checker_Opener();
               }
               if (xd == plx3 && yd-66 == ply3)
               {
                   Checker_Opener();
               }
               if (xd == plx3 && yd+66 == ply3)
               {
                   Checker_Opener();
               }



               if (xd == plx3 && yd-64 == ply3)
               {
                   Player.Collision();
               }
               if (xd == plx3 && yd+64 == ply3)
               {
                   Player.Collision();
               }
               if (xd == plx3 && yd-63 == ply3)
               {
                   Player.Collision();
               }
               if (xd == plx3 && yd+63 == ply3)
               {
                   Player.Collision();
               }
               if (xd == plx3 && yd-65 == ply3)
               {
                   Player.Collision();
               }
               if (xd == plx3 && yd+65 == ply3)
               {
                   Player.Collision();
               }
               //next


               if (xd == plx4 && yd-68 == ply4)
               {
                   Player.Collision();
               }
               if (xd == plx4 && yd+68 == ply4)
               {
                   Player.Collision();
               }
               if (xd == plx4 && yd-67 == ply4)
               {
                   Player.Collision();
               }
               if (xd == plx4 && yd+67 == ply4)
               {
                   Player.Collision();
               }
               if (xd == plx4 && yd-66 == ply4)
               {
                   Player.Collision();
               }
               if (xd == plx4 && yd+66 == ply4)
               {
                   Player.Collision();
               }



               if (xd == plx4 && yd-64 == ply4)
               {
                   Player.Collision();
               }
               if (xd == plx4 && yd+64 == ply4)
               {
                   Player.Collision();
               }
               if (xd == plx4 && yd-63 == ply4)
               {
                   Player.Collision();
               }
               if (xd == plx4 && yd+63 == ply4)
               {
                   Player.Collision();
               }
               if (xd == plx4 && yd-65 == ply4)
               {
                   Player.Collision();
               }
               if (xd == plx4 && yd+65 == ply4)
               {
                   Player.Collision();
               }
               //next

               */




           }


}
