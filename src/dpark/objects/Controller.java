package dpark.objects;

import dpark.Game;
import dpark.GameObject;

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

              if (Game.GameUpdateType == 0) {
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
            if (Game.GameUpdateType == 1) {
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
                    Texture_number = 7;
                    Timer_to_change = 3;

                } else {
                    Timer_to_change--;
                }
                if (Texture_number == 7 && Timer_to_change <= 0) {
                    //System.out.println("Ready2");
                    db.rooms.get("main_menu_room").background = "main_menu_bg8";
                    //Timer_to_change = 5;
                    Texture_number = 8;
                    Timer_to_change = 3;

                } else {
                    Timer_to_change--;
                }
                if (Texture_number == 8 && Timer_to_change <= 0) {
                    //System.out.println("Ready2");
                    db.rooms.get("main_menu_room").background = "main_menu_bg9";
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
            if (Game.Reload_on == 1) {
                Game.instance.GetLevel_2();
                Game.Reload_on = 0;
            }
        }
        if (keycode == KeyEvent.VK_2) {
            System.exit(0);
        }
        if (keycode == KeyEvent.VK_3) {
            Game.AllDelete = 1;
        }
    }
}
