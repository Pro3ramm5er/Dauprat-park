package dpark.objects;

import dpark.*;

import static dpark.DB.db;
import  dpark.DB.*;
import dpark.objects.Controller;
import dpark.objects.KeyMessage;
import dpark.objects.Player;
import dpark.objects.main_door;
import dpark.rooms.MainMenuRoom;
import dpark.rooms.Map1;
import dpark.rooms.Map2;
import dpark.rooms.Map3;
import dpark.rooms.Map4;
import dpark.rooms.Storymap1;
import dpark.rooms.NewGameSplashScreenRoom;

import java.util.HashMap;
import java.util.Map;


import java.awt.event.KeyEvent;

import static dpark.DB.db;

public class Controller extends GameObject {
    public int Timer_to_change = 5;
    public int Texture_number = 0;


    public Controller(String name) {
        super(name);
        visible = false;
        //sprite.addStep(Game.instance.getSprite("logo1.png"));
        //sprite.addStep(Game.instance.getSprite("logo2.png"));
        //sprite.addStep(Game.instance.getSprite("logo3.png"));
    }

    @Override
    public void update() {


        if (Game.currentRoom == db.rooms.get("main_menu_room")) {

              if (GameOtherVars.GameUpdateType == 0) {
                  if (Texture_number == 0 && Timer_to_change <= 0) {
                      //System.out.println("Ready1");
                      db.rooms.get("main_menu_room").background = "main_menu_bg";
                      //Timer_to_change = 5;
                      Texture_number = 1;
                      Timer_to_change = 1;

                  } else {
                      Timer_to_change--;
                  }
                  if (Texture_number == 1 && Timer_to_change <= 0) {
                      //System.out.println("Ready2");
                      db.rooms.get("main_menu_room").background = "main_menu_bg2";
                      //Timer_to_change = 5;
                      Texture_number = 0;
                      Timer_to_change = 1;

                  } else {
                      Timer_to_change--;
                  }
              }
            if (GameOtherVars.GameUpdateType == 1) {
                if (Texture_number == 0 && Timer_to_change <= 0) {
                    //System.out.println("Ready1");
                    db.rooms.get("main_menu_room").background = "main_menu_bg";
                    //Timer_to_change = 5;
                    int userandom = 0;
                    userandom = 1 + (int) (Math.random() * ((4 - 1) + 1));
                    if (userandom == 1) {
                        Texture_number = 1;
                    }
                    Timer_to_change = 190;

                } else {
                    Timer_to_change--;
                }
                if (Texture_number == 1 && Timer_to_change <= 0) {
                    //System.out.println("Ready2");
                    db.rooms.get("main_menu_room").background = "main_menu_bg2";
                    //Timer_to_change = 5;
                    Texture_number = 2;
                    Timer_to_change = 3;

                } else {
                    Timer_to_change--;
                }
                if (Texture_number == 2 && Timer_to_change <= 0) {
                    //System.out.println("Ready2");
                    db.rooms.get("main_menu_room").background = "main_menu_bg3";
                    //Timer_to_change = 5;
                    Texture_number = 3;
                    Timer_to_change = 3;

                } else {
                    Timer_to_change--;
                }
                if (Texture_number == 3 && Timer_to_change <= 0) {
                    //System.out.println("Ready2");
                    db.rooms.get("main_menu_room").background = "main_menu_bg4";
                    //Timer_to_change = 5;
                    Texture_number = 4;
                    Timer_to_change = 3;

                } else {
                    Timer_to_change--;
                }
                if (Texture_number == 4 && Timer_to_change <= 0) {
                    //System.out.println("Ready2");
                    db.rooms.get("main_menu_room").background = "main_menu_bg5";
                    //Timer_to_change = 5;
                    Texture_number = 5;
                    Timer_to_change = 3;

                } else {
                    Timer_to_change--;
                }
                if (Texture_number == 5 && Timer_to_change <= 0) {
                    //System.out.println("Ready2");
                    db.rooms.get("main_menu_room").background = "main_menu_bg6";
                    //Timer_to_change = 5;
                    Texture_number = 6;
                    Timer_to_change = 3;

                } else {
                    Timer_to_change--;
                }
                if (Texture_number == 6 && Timer_to_change <= 0) {
                    //System.out.println("Ready2");
                    db.rooms.get("main_menu_room").background = "main_menu_bg7";
                    //Timer_to_change = 5;
                    Texture_number = 0;
                    Timer_to_change = 40;

                } else {
                    Timer_to_change--;
                }

            }





        }
    }

    @Override
    public void onKey(int keycode) {
        super.onKey(keycode);
        if (keycode == KeyEvent.VK_1) {
            if (GameOtherVars.Reload_on == 1) {
                //Sound.playSound("Deep_Purple-Burn.wav").stop();
                Game.instance.GetLevel_2();
                GameOtherVars.Reload_on = 0;
            }
        }
        if (keycode == KeyEvent.VK_2) {
            System.exit(0);
        }
        if (keycode == KeyEvent.VK_3) {
            //if (Game.Story == 0) {

            GameOtherVars.Restart_type = 1;
            GameOtherVars.AllDelete = 1;


            //}
        } if (keycode == KeyEvent.VK_4) {
            if (GameOtherVars.Reload_on == 1) {

                GameOtherVars.Restart_type = 5;
                GameOtherVars.AllDelete = 1;
            }
        }
        if (keycode == KeyEvent.VK_9) {
            GameOtherVars.Restart_type = 62;
            GameOtherVars.AllDelete = 1;
        }
    }
}
