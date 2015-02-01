package dpark.objects;

import dpark.Game;
import dpark.GameOtherVars;
import dpark.GameObject;
import dpark.GameStoryVars;

import static dpark.DB.db;

import java.awt.event.KeyEvent;
//import dpark.objects.Coll.Phisyc;

public class Player extends GameObject {


    private int inertion = 0;
    public int direction = 0;
    public static int x1;
    public static int y1;
    public static int Key_P = 0;
    public static int Key_K= 0;
    public static int ByhTimer = 40;
    public static int weedTimer = 40;
    public int reseter = 0;
    public int Tasktimer = 25;
    public int Tasktimer2 = 25;
    public int Tasktimer3 = 25;
    public int Tasknow = 12;
    public int Tasknow2 = 0;
    public int Tasknow3 = 0;
    public int Tabledel = 0;
    public int Phonetimer = 70;
    public int phonenow = 19;


    public Player(String name) {

        super(name);
        z = y;
        PlayerZ = z;
        PlayerSpeedBonus = 3;
        UseRoomInt = GameOtherVars.RoomNow;
        UseRoom = Game.currentRoom;
        //UseRoom = Game.currentRoom;
        sprite.addStep(Game.instance.getSprite("hero.png"));


        sprite.addStep(Game.instance.getSprite("hero_right.png"));

        sprite.addStep(Game.instance.getSprite("hero_up.png"));
        sprite.addStep(Game.instance.getSprite("hero_down.png"));
        sprite.addStep(Game.instance.getSprite("hero_down_sp_card_used.png"));


        sprite.addStep(Game.instance.getSprite("hero_bottle.png"));
        sprite.addStep(Game.instance.getSprite("hero_down_bottle.png"));
        sprite.addStep(Game.instance.getSprite("hero_right_bottle.png"));


        sprite.addStep(Game.instance.getSprite("hero_down_byhaet.png"));
        sprite.addStep(Game.instance.getSprite("hero_down_unef.png")); // 9

        sprite.addStep(Game.instance.getSprite("hero_down_weed.png")); //10

        sprite.addStep(Game.instance.getSprite("hero_down_weed_use.png")); //11


        // FOR ANIMATION
        // LIST
        sprite.addStep(Game.instance.getSprite("hero_right_task.png"));
        sprite.addStep(Game.instance.getSprite("hero_right_task2.png"));
        sprite.addStep(Game.instance.getSprite("hero_right_task3.png"));
        sprite.addStep(Game.instance.getSprite("hero_right_task4.png"));
        sprite.addStep(Game.instance.getSprite("hero_right_task5.png"));
        sprite.addStep(Game.instance.getSprite("hero_task6.png"));//17
        sprite.addStep(Game.instance.getSprite("hero_opa.png"));//18
        //PHONE
        sprite.addStep(Game.instance.getSprite("hero_right_ph1.png"));
        sprite.addStep(Game.instance.getSprite("hero_right_ph2.png"));
        sprite.addStep(Game.instance.getSprite("hero_right_ph3.png"));
        sprite.addStep(Game.instance.getSprite("hero_right_ph4.png"));
        sprite.addStep(Game.instance.getSprite("hero_right_ph5.png"));
        sprite.addStep(Game.instance.getSprite("hero_right_ph6.png"));//24


        //Backpack
        sprite.addStep(Game.instance.getSprite("s_p_1.png"));//25
        sprite.addStep(Game.instance.getSprite("s_p_2.png"));//26
        sprite.addStep(Game.instance.getSprite("s_p_3.png"));//27
        sprite.addStep(Game.instance.getSprite("s_p_4.png"));//28
        sprite.addStep(Game.instance.getSprite("s_p_5.png"));//29

        //Action 1
        sprite.addStep(Game.instance.getSprite("hero_up_action.png"));//30

        //PlayerSpeedBonus = 0;


        plx = x;
        ply = y;
    }

    public static void Collision() {
        if (Checkr == 0) {
            PlayerCanMovie = 1;

            PlayerColSt = PlayerWalkst;
            Checkr = 1;
        }
    }

    @Override
    public void update() {
       // UseRoom = Game.currentRoom;
        z = ply+15;
        PlayerZ = ply+15;
        UseRoomInt = GameOtherVars.RoomNow;
        UseRoom = Game.currentRoom;


        if (GameOtherVars.Player_ac_t1 == 1)
        {
            sprite.currentStep = 30;
            GameOtherVars.Player_ac_t1 = 0;
        }
        if (GameOtherVars.BeforeMain == 1)
        {
            visible = true;
        }
        if (GameOtherVars.Level == 6 || GameOtherVars.Level == 7 || GameOtherVars.Level == 8 || GameOtherVars.Level == 9 || GameOtherVars.Level == 10 || GameOtherVars.Level == 11 || GameOtherVars.Level == 12 || GameOtherVars.Level == 13 || GameOtherVars.Level == 14 || GameOtherVars.Level == 15 || GameOtherVars.Level == 16 || GameOtherVars.Level == 17  || GameOtherVars.Level == 18  || GameOtherVars.Level == 19  || GameOtherVars.Level == 20    || GameOtherVars.Level == 21  || GameOtherVars.Level == 22  || GameOtherVars.Level == 23  || GameOtherVars.Level == 24  || GameOtherVars.Level == 25  || GameOtherVars.Level == 26 || GameOtherVars.Level == 27 || GameOtherVars.Level == 28 || GameOtherVars.Level == 29 || GameOtherVars.Level == 30 || GameOtherVars.Level == 31 || GameOtherVars.Level == 32 || GameOtherVars.Level == 33 || GameOtherVars.Level == 34 || GameOtherVars.Level == 35) {

            if (GameOtherVars.GEtdel == 0) {

                GameObject.plx = 373;
                GameObject.ply = 526;
                GameOtherVars.GEtdel = 1;
            }
        } else {
            if (GameOtherVars.GEtdel == 0) {
                GameObject.plx = 250;
                GameObject.ply = 250;
                GameOtherVars.GEtdel = 1;
            }

        }
        

        x = plx;
        y = ply;
        plx = x;
        ply = y;
        ply1 = y - 1;
        plx1 = x - 1;
        ply2 = y + 1;
        plx2 = x + 1;
        ply3 = y - 2;
        plx3 = x - 2;
        ply4 = y + 2;
        plx4 = x + 2;

        super.update();
        if (x >= 900 || x >= 900) {
            Collision();
        }
        if (x <= -10 || x <= -10) {
            Collision();
        }
        if (y >= 900 || y >= 900) {
            Collision();
        }
        if (y <= -10 || y <= -10) {
            Collision();
        }


        if (y < 0 && GameOtherVars.Level == 6)
        {
            GameOtherVars.Restart_type = 7;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 8)
        {
            GameOtherVars.Restart_type = 9;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 10)
        {
            GameOtherVars.Restart_type = 11;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 11)
        {
            GameOtherVars.Restart_type = 12;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 12)
        {
            GameOtherVars.Restart_type = 13;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 13)
        {
            GameOtherVars.Restart_type = 14;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 14)
        {
            GameOtherVars.Restart_type = 15;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 15)
        {
            GameOtherVars.Restart_type = 16;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 16)
        {
            GameOtherVars.Restart_type = 17;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 17)
        {
            GameOtherVars.Restart_type = 18;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 18)
        {
            GameOtherVars.Restart_type = 19;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 19)
        {
            GameOtherVars.Restart_type = 20;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 20)
        {
            GameOtherVars.Restart_type = 21;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 21)
        {
            GameOtherVars.Restart_type = 22;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 22)
        {
            GameOtherVars.Restart_type = 23;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 23)
        {
            GameOtherVars.Restart_type = 24;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 24)
        {
            GameOtherVars.Restart_type = 25;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 25)
        {
            GameOtherVars.Restart_type = 26;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 26)
        {
            GameOtherVars.Restart_type = 27;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 27)
        {
            GameOtherVars.Restart_type = 28;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 29)
        {
            GameOtherVars.Restart_type = 30;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 30)
        {
            GameOtherVars.Restart_type = 31;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 31)
        {
            GameOtherVars.Restart_type = 32;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 32)
        {
            GameOtherVars.Restart_type = 33;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 33)
        {
            GameOtherVars.Restart_type = 34;
            GameOtherVars.AllDelete = 1;
        }
        if (y < 0 && GameOtherVars.Level == 34)
        {
            GameOtherVars.Restart_type = 35;
            GameOtherVars.AllDelete = 1;
        }

        if (GameStoryVars.S_phone == 1)
        {
            sprite.currentStep = phonenow;
            if (Phonetimer <= 0 && phonenow < 25)
            {
                phonenow++;
                Phonetimer = 15;
            }
            if (!(Phonetimer <= 0))
            {
                Phonetimer--;
            }
            if (phonenow >= 25)
            {
                GameStoryVars.S_phone = 0;
                GameStoryVars.S_moment = 3;
                GameStoryVars.S_door = 1;
            }
        }
        if (GameStoryVars.S_task3 == 1)
        {
            if (Tasknow3 == 0)
            {
                sprite.currentStep = 25;
            }
            if (Tasknow3 == 1)
            {
                sprite.currentStep = 26;
            }
            if (Tasknow3 == 2)
            {
                sprite.currentStep = 27;
            }
            if (Tasknow3 == 3)
            {
                sprite.currentStep = 28;
            }
            if (Tasknow3 == 4)
            {
                sprite.currentStep = 29;
            }

            if (Tasktimer3 <= 0)
            {
                if (Tasknow3 < 4) {
                    Tasknow3++;
                    Tasktimer3 = 45;
                } else {

                    GameStoryVars.S_task3 = 0;
                }
            } else {
                Tasktimer3 --;
            }
        }
        if (GameStoryVars.S_task2 == 1)
        {
            if (Tasknow2 == 0)
            {
                sprite.currentStep = 12;
            }
            if (Tasknow2 == 1)
            {
                sprite.currentStep = 0;
            }
            if (Tasknow2 == 2)
            {
                sprite.currentStep = 1;
            }
            if (Tasknow2 == 3)
            {
                sprite.currentStep = 2;
            }
            if (Tasknow2 == 4)
            {
                sprite.currentStep = 3;
            }

            if (Tasktimer2 <= 0)
            {
                if (Tasknow2 < 4) {
                    Tasknow2++;
                    Tasktimer2 = 45;
                } else {
                    GameStoryVars.S_funnymeet = 1;
                    GameStoryVars.S_task2 = 0;
                }
            } else {
                Tasktimer2 --;
            }
        }
        if (GameStoryVars.S_task == 1)
        {
            sprite.currentStep = Tasknow;
            if (Tasktimer <= 0 && Tasknow < 17)
            {
                Tasknow++;
                Tasktimer = 15;
            }
            if (!(Tasktimer <= 0))
            {
                Tasktimer--;
            }
            if (!(Tasknow < 16))
            {
                GameStoryVars.S_task = 0;
                GameStoryVars.S_moment = 1;
            }
        }
        if (GameStoryVars.S_table == 1 && Tabledel == 0)
        {
            sprite.currentStep = 18;
            Tabledel = 1;
        }

        inertion--;
        if (inertion < 0)
            inertion = 0;
        if (direction == 0) {
            y -= inertion;
            PlayerZ += inertion;
            z += inertion;
        } else if (direction == 90) {
            x += inertion ;
        } else if (direction == 180) {
            y += inertion ;
            PlayerZ -= inertion ;
            z -= inertion ;
        } else if (direction == 270) {
            x -= inertion ;
        }
        x1 = x;
        y1 = y;


        plx = x;
        ply = y;
        ply1 = y - 1;
        plx1 = x - 1;
        ply2 = y + 1;
        plx2 = x + 1;
        ply3 = y - 2;
        plx3 = x - 2;
        ply4 = y + 2;
        plx4 = x + 2;


    }


    @Override
    public void onKeyPress(int keycode) {

        super.onKeyPress(keycode);


        if (keycode == KeyEvent.VK_A && GameStoryVars.S_task == 0 && GameStoryVars.S_task2 == 0) {

            if (PlayerColSt != 4) {
                //if (PlayerSpeedBonus == 0) {
                inertion += 1;
                //} else {
                //    inertion += PlayerSpeedBonus;
                //}
                direction = 270;
                Checkr = 0;
                PlayerWalkst = 4;
                PlayerColSt = 0;
                if (GameOtherVars.Player_bottle == 1)
                {
                    sprite.currentStep = 5;
                }
                if (GameOtherVars.Shlakoblock_magic == 1) {
                    sprite.currentStep = 0;
                }
                if (GameOtherVars.Shlakoblock_magic == 0 && GameOtherVars.Player_bottle == 0) {
                    sprite.currentStep = 0;
                }




            }

        }
        if (keycode == KeyEvent.VK_D) {
            if (PlayerColSt != 2 && GameStoryVars.S_task == 0 && GameStoryVars.S_task2 == 0) {
                //if (PlayerSpeedBonus == 0) {
                inertion += 1;
                //} else {
                //    inertion += PlayerSpeedBonus+1;
                //}
                direction = 90;
                Checkr = 0;
                PlayerColSt = 0;
                PlayerWalkst = 2;
                if (GameOtherVars.Player_bottle == 1)
                {
                    sprite.currentStep = 7;
                }
                if (GameOtherVars.Shlakoblock_magic == 1) {
                    sprite.currentStep = 1;
                }
                if (GameOtherVars.Shlakoblock_magic == 0 && GameOtherVars.Player_bottle == 0) {
                    sprite.currentStep = 1;
                }





            }

        }
        if (keycode == KeyEvent.VK_W && GameStoryVars.S_task == 0 && GameStoryVars.S_task2 == 0) {
            if (PlayerColSt != 1) {
                //if (PlayerSpeedBonus == 0) {
                inertion += 1;
                //} else {
                 //   inertion += PlayerSpeedBonus+1;
                //}
                direction = 0;
                //z--;
                Checkr = 0;
                PlayerColSt = 0;
                PlayerWalkst = 1;
                if (GameOtherVars.Player_bottle == 1)
                {
                    sprite.currentStep = 2;
                }
                if (GameOtherVars.Shlakoblock_magic == 1) {
                    sprite.currentStep = 2;
                }
                if (GameOtherVars.Shlakoblock_magic == 0 && GameOtherVars.Player_bottle == 0) {
                    sprite.currentStep = 2;
                }




            }

        }
        if (keycode == KeyEvent.VK_S && GameStoryVars.S_task == 0 && GameStoryVars.S_task2 == 0) {


            if (PlayerColSt != 3) {

                //if (PlayerSpeedBonus == 0) {
                inertion += 1;
                //} else {
                 //   inertion += PlayerSpeedBonus+1;
                //}
                direction = 180;
                //z++;
                Checkr = 0;
                PlayerColSt = 0;
                PlayerWalkst = 3;
                if (GameOtherVars.UnderEffecr == 1)
                {
                    sprite.currentStep = 9;
                }
                if (GameOtherVars.Player_weed == 1)
                {
                    sprite.currentStep = 10;
                }
                if (GameOtherVars.Player_bottle == 1)
                {
                    sprite.currentStep = 6;
                }
                if (GameOtherVars.Shlakoblock_magic == 1) {
                    sprite.currentStep = 4;
                }
                if (GameOtherVars.Shlakoblock_magic == 0 && GameOtherVars.Player_bottle == 0 && GameOtherVars.UnderEffecr == 0 && GameOtherVars.Player_weed == 0) {
                    sprite.currentStep = 3;
                }




            }

        }
        if (keycode == KeyEvent.VK_E) {

            if (GameOtherVars.Player_bottle == 1) {
                sprite.currentStep = 8;
                reseter = 0;
                if (ByhTimer <= 0) {

                    GameOtherVars.Player_bottle = 0;
                    GameOtherVars.UnderEffecr = 1;
                    sprite.currentStep = 9;
                    ByhTimer = 180;
                    GameOtherVars.Health ++;
                } else {

                    ByhTimer--;

                }

            }
            if (GameOtherVars.Player_weed == 1) {
                sprite.currentStep = 11;
                reseter = 0;
                if (weedTimer <= 0) {

                    GameOtherVars.Player_weed = 0;
                    GameOtherVars.UnderEffecr = 1;
                    sprite.currentStep = 9;
                    weedTimer = 180;
                    GameOtherVars.Health += 2;
                } else {

                    weedTimer--;

                }

            }

        }
        if (keycode == KeyEvent.VK_K) {


            Key_K = 1;

        } else {
            if  (! (keycode == KeyEvent.VK_O ||  keycode == KeyEvent.VK_R || keycode == KeyEvent.VK_U || keycode == KeyEvent.VK_Y || keycode == KeyEvent.VK_T)  ) {
                Key_K = 0;
            }
        }
        if (keycode == KeyEvent.VK_P) {


            Key_P = 1;


        } else {
            if  (! (keycode == KeyEvent.VK_O || keycode == KeyEvent.VK_L)) {
                Key_P = 0;
            }
        }
        if (keycode == KeyEvent.VK_P) {


            Key_P = 1;


        } else {
            if  (! (keycode == KeyEvent.VK_O || keycode == KeyEvent.VK_L)) {
                Key_P = 0;
            }
        }
        if (keycode == KeyEvent.VK_O && Key_P == 1)
        {
            GameOtherVars.Shlakoblock_create = 0;
            GameOtherVars.Shlakoblock_create = 0;
            GameOtherVars.Shlakoblock_create = 0;
            GameOtherVars.Shlakoblock_create = 0;
            GameOtherVars.Shlakoblock_create = 0;
        }
        if (keycode == KeyEvent.VK_L && Key_P == 1)
        {
            Game.Get_win_1();
        }
        if (keycode == KeyEvent.VK_O && Key_K == 1)
        {
            GameOtherVars.DedMoroz_create = 0;
            GameOtherVars.DedMoroz_create = 0;
            GameOtherVars.DedMoroz_create = 0;
            GameOtherVars.DedMoroz_create = 0;
            GameOtherVars.DedMoroz_create = 0;
            GameOtherVars.DedMoroz_create = 0;
        }
        if (keycode == KeyEvent.VK_U && Key_K == 1)
        {
            GameOtherVars.MainKey = 1;
        }
        if (keycode == KeyEvent.VK_Y && Key_K == 1)
        {
            GameOtherVars.CardCreate = 0;
        }
        if (keycode == KeyEvent.VK_T && Key_K == 1)
        {
            GameOtherVars.Fullimmortality = 1;
        }

        if (keycode == KeyEvent.VK_R && Key_K == 1)
        {
            GameOtherVars.Restart_type = 3;
            GameOtherVars.AllDelete = 1;
        }
        //if (PlayerSpeedBonus == 0) {
       //     if (inertion > 3) {
        //        inertion = 3;
        //    }
       // } else {
            if (inertion > PlayerSpeedBonus)
            {
                inertion = PlayerSpeedBonus;
            }
        //}

    }
}
