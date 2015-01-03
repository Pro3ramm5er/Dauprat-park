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
    public static int ByhTimer = 180;
    public int reseter = 0;


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
        sprite.addStep(Game.instance.getSprite("hero_down_unef.png"));

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


        if (keycode == KeyEvent.VK_A) {

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
            if (PlayerColSt != 2) {
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
        if (keycode == KeyEvent.VK_W) {
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
        if (keycode == KeyEvent.VK_S) {


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
                if (Game.Player_bottle == 1)
                {
                    sprite.currentStep = 6;
                }
                if (Game.Shlakoblock_magic == 1) {
                    sprite.currentStep = 4;
                }
                if (Game.Shlakoblock_magic == 0 && Game.Player_bottle == 0 && Game.UnderEffecr == 0) {
                    sprite.currentStep = 3;
                }




            }

        }
        if (keycode == KeyEvent.VK_SPACE) {

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
