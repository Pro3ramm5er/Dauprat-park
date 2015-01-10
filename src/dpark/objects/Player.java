package dpark.objects;

import dpark.Game;
import dpark.Game;
import dpark.GameObject;
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
    public int Tasknow = 12;
    public int Tabledel = 0;
    public int Phonetimer = 70;
    public int phonenow = 19;


    public Player(String name) {

        super(name);
        z = y;
        PlayerZ = z;
        PlayerSpeedBonus = 3;
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
        z = ply+15;
        PlayerZ = ply+15;


        

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


        if (y < 0 && Game.Level == 6)
        {
             Game.Restart_type = 7;
             Game.AllDelete = 1;
        }
        if (y < 0 && Game.Level == 8)
        {
            Game.Restart_type = 9;
            Game.AllDelete = 1;
        }

        if (Game.S_phone == 1)
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
                Game.S_phone = 0;
                Game.S_moment = 3;
                Game.S_door = 1;
            }
        }
        if (Game.S_task == 1)
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
                Game.S_task = 0;
                Game.S_moment = 1;
            }
        }
        if (Game.S_table == 1 && Tabledel == 0)
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


        if (keycode == KeyEvent.VK_A && Game.S_task == 0) {

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
                if (Game.Player_bottle == 1)
                {
                    sprite.currentStep = 5;
                }
                if (Game.Shlakoblock_magic == 1) {
                    sprite.currentStep = 0;
                }
                if (Game.Shlakoblock_magic == 0 && Game.Player_bottle == 0) {
                    sprite.currentStep = 0;
                }




            }

        }
        if (keycode == KeyEvent.VK_D) {
            if (PlayerColSt != 2 && Game.S_task == 0) {
                //if (PlayerSpeedBonus == 0) {
                inertion += 1;
                //} else {
                //    inertion += PlayerSpeedBonus+1;
                //}
                direction = 90;
                Checkr = 0;
                PlayerColSt = 0;
                PlayerWalkst = 2;
                if (Game.Player_bottle == 1)
                {
                    sprite.currentStep = 7;
                }
                if (Game.Shlakoblock_magic == 1) {
                    sprite.currentStep = 1;
                }
                if (Game.Shlakoblock_magic == 0 && Game.Player_bottle == 0) {
                    sprite.currentStep = 1;
                }





            }

        }
        if (keycode == KeyEvent.VK_W && Game.S_task == 0) {
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
                if (Game.Player_bottle == 1)
                {
                    sprite.currentStep = 2;
                }
                if (Game.Shlakoblock_magic == 1) {
                    sprite.currentStep = 2;
                }
                if (Game.Shlakoblock_magic == 0 && Game.Player_bottle == 0) {
                    sprite.currentStep = 2;
                }




            }

        }
        if (keycode == KeyEvent.VK_S && Game.S_task == 0) {


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
                if (Game.UnderEffecr == 1)
                {
                    sprite.currentStep = 9;
                }
                if (Game.Player_weed == 1)
                {
                    sprite.currentStep = 10;
                }
                if (Game.Player_bottle == 1)
                {
                    sprite.currentStep = 6;
                }
                if (Game.Shlakoblock_magic == 1) {
                    sprite.currentStep = 4;
                }
                if (Game.Shlakoblock_magic == 0 && Game.Player_bottle == 0 && Game.UnderEffecr == 0 && Game.Player_weed == 0) {
                    sprite.currentStep = 3;
                }




            }

        }
        if (keycode == KeyEvent.VK_E) {

            if (Game.Player_bottle == 1) {
                sprite.currentStep = 8;
                reseter = 0;
                if (ByhTimer <= 0) {

                    Game.Player_bottle = 0;
                    Game.UnderEffecr = 1;
                    sprite.currentStep = 9;
                    ByhTimer = 180;
                    Game.Health ++;
                } else {

                    ByhTimer--;

                }

            }
            if (Game.Player_weed == 1) {
                sprite.currentStep = 11;
                reseter = 0;
                if (weedTimer <= 0) {

                    Game.Player_weed = 0;
                    Game.UnderEffecr = 1;
                    sprite.currentStep = 9;
                    weedTimer = 180;
                    Game.Health += 2;
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
            Game.Shlakoblock_create = 0;
            Game.Shlakoblock_create = 0;
            Game.Shlakoblock_create = 0;
            Game.Shlakoblock_create = 0;
            Game.Shlakoblock_create = 0;
        }
        if (keycode == KeyEvent.VK_L && Key_P == 1)
        {
              Game.Get_win_1();
        }
        if (keycode == KeyEvent.VK_O && Key_K == 1)
        {
            Game.DedMoroz_create = 0;
            Game.DedMoroz_create = 0;
            Game.DedMoroz_create = 0;
            Game.DedMoroz_create = 0;
            Game.DedMoroz_create = 0;
            Game.DedMoroz_create = 0;
        }
        if (keycode == KeyEvent.VK_U && Key_K == 1)
        {
            Game.MainKey = 1;
        }
        if (keycode == KeyEvent.VK_Y && Key_K == 1)
        {
            Game.CardCreate = 0;
        }
        if (keycode == KeyEvent.VK_T && Key_K == 1)
        {
            Game.Fullimmortality = 1;
        }

        if (keycode == KeyEvent.VK_R && Key_K == 1)
        {
            Game.Restart_type = 3;
            Game.AllDelete = 1;
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
