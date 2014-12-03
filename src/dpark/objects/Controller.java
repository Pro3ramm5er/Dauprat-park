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
    }

    @Override
    public void onKey(int keycode) {
        super.onKey(keycode);
        if (keycode == KeyEvent.VK_1) {
            Game.instance.GetLevel_2();
        }
        if (keycode == KeyEvent.VK_2) {
            System.exit(0);
        }
        if (keycode == KeyEvent.VK_3) {
            Game.AllDelete = 1;
        }
    }
}
