package dpark;

import dpark.objects.Controller;
import dpark.objects.KeyMessage;
import dpark.objects.Player;
import dpark.objects.main_door;
import dpark.rooms.MainMenuRoom;
import dpark.rooms.Map1;
import dpark.rooms.Map2;
import dpark.rooms.Map3;
import dpark.rooms.NewGameSplashScreenRoom;

import java.util.HashMap;
import java.util.Map;

public class DB {
    public Map<String, Animation> animations = new HashMap<String, Animation>();
    public Map<String, GameObject> objects = new HashMap<String, GameObject>();
    public Map<String, Background> backgrounds = new HashMap<String, Background>();
    public Map<String, Room> rooms = new HashMap<String, Room>();
    public static final DB db;

    static {
        db = new DB();
    }

    public void onGameLoaded(final Game game) {
        if (Game.GameUpdateType == 0) {
            {
                final Background b = new Background("main_menu_bg", game.getSprite("logo.png"));
                backgrounds.put(b.name, b);
            }

            {
                final Background b = new Background("main_menu_bg2", game.getSprite("logo2.png"));
                backgrounds.put(b.name, b);
            }
        }
        if (Game.GameUpdateType == 1) {
            {
                final Background b = new Background("main_menu_bg", game.getSprite("Newyaer_logo.png"));
                backgrounds.put(b.name, b);
            }

            {
                final Background b = new Background("main_menu_bg2", game.getSprite("Newyaer_logo_1.png"));
                backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg3", game.getSprite("Newyaer_logo_2.png"));
                backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg4", game.getSprite("Newyaer_logo_3.png"));
                backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg5", game.getSprite("Newyaer_logo_4.png"));
                backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg6", game.getSprite("Newyaer_logo_5.png"));
                backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg7", game.getSprite("Newyaer_logo_6.png"));
                backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg8", game.getSprite("Newyaer_logo_7.png"));
                backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg9", game.getSprite("Newyaer_logo_8.png"));
                backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg10", game.getSprite("Newyaer_logo_9.png"));
                backgrounds.put(b.name, b);
            }
        }
        {
            final Animation a = new Animation("new_game_splash_screen_anm");
            a.isPlaying = false;

            a.addStep(game.getSprite("stop_22.png"));
            a.addStep(game.getSprite("video.png"));
            a.addStep(game.getSprite("video_2.png"));
            a.addStep(game.getSprite("video_3.png"));
            a.addStep(game.getSprite("video_4.png"));
            a.addStep(game.getSprite("video_5.png"));
            a.addStep(game.getSprite("video_6.png"));
            a.addStep(game.getSprite("video_7.png"));
            a.addStep(game.getSprite("video_8.png"));
            a.addStep(game.getSprite("video_9.png"));
            a.addStep(game.getSprite("video_10.png"));
            //Game.BeforeMain = 1;
            a.runAfterEnd = new Runnable() {
                @Override
                public void run() {
                    game.Get_Start();
                    Game.BeforeMain = 1;

                }
            };
            animations.put(a.name, a);
        }
        {
            final Animation a = new Animation("win_anm");
            a.isPlaying = false;

            a.addStep(game.getSprite("stop_22.png"));
            a.addStep(game.getSprite("Victory_1.png"));
            a.addStep(game.getSprite("Victory_2.png"));
            a.addStep(game.getSprite("Victory_3.png"));
            a.addStep(game.getSprite("Victory_4.png"));
            a.addStep(game.getSprite("Victory_5.png"));
            a.addStep(game.getSprite("Victory_6.png"));
            a.addStep(game.getSprite("Victory_7.png"));
            a.addStep(game.getSprite("Victory_8.png"));
            a.addStep(game.getSprite("Victory_9.png"));
            a.addStep(game.getSprite("Victory_10.png"));
            a.addStep(game.getSprite("Victory_11.png"));
            a.addStep(game.getSprite("Victory_12.png"));
            a.addStep(game.getSprite("Victory_13.png"));
            a.addStep(game.getSprite("Victory_14.png"));
            a.addStep(game.getSprite("Victory_15.png"));
            a.addStep(game.getSprite("Victory_16.png"));
            a.addStep(game.getSprite("Victory_17.png"));
            a.addStep(game.getSprite("Victory_18.png"));
            a.addStep(game.getSprite("Victory_19.png"));
            a.addStep(game.getSprite("Victory_20.png"));
            a.addStep(game.getSprite("Victory_21.png"));
            //Game.BeforeMain = 1;
            a.runAfterEnd = new Runnable() {
                @Override
                public void run() {
                    Game.Get_win_2();

                }
            };
            animations.put(a.name, a);
        }
        {
            {

                final Animation KeyMessagea = new Animation("KeyMessageAnimation");
                KeyMessagea.isPlaying = false;
                KeyMessagea.addStep(game.getSprite("Needakey.png"));
                KeyMessagea.addStep(game.getSprite("Needakey.png"));
                KeyMessagea.addStep(game.getSprite("Needakey.png"));
                KeyMessagea.addStep(game.getSprite("Needakey.png"));
                KeyMessagea.addStep(game.getSprite("Needakey.png"));
                KeyMessagea.addStep(game.getSprite("Needakey.png"));
                KeyMessagea.addStep(game.getSprite("Needakey.png"));
                KeyMessagea.addStep(game.getSprite("Needakey1.png"));
                KeyMessagea.addStep(game.getSprite("Needakey2.png"));
                KeyMessagea.addStep(game.getSprite("Needakey3.png"));
                KeyMessagea.addStep(game.getSprite("Needakey4.png"));
                KeyMessagea.runAfterEnd = new Runnable() {
                    @Override
                    public void run() {
                        KeyMessage.AnimStep = 1;
                        KeyMessage.Created = 1;
                    }
                };
                animations.put(KeyMessagea.name, KeyMessagea);
            }
        }
        {
            final Background b = new Background("new_game_splash_screen_bg", null);
            b.sprite = animations.get("new_game_splash_screen_anm");
            backgrounds.put(b.name, b);
        }
        {
            if (Game.Biome_type == 1) {
                final Background b = new Background("map1_bg", game.getSprite("map1.png"));
                backgrounds.put(b.name, b);
            }
            if (Game.Biome_type == 2) {
                final Background b = new Background("map1_bg", game.getSprite("Newyaermap1.png"));
                backgrounds.put(b.name, b);
            }
            if (Game.Biome_type == 3) {
                final Background b = new Background("map1_bg", game.getSprite("map2.png"));
                backgrounds.put(b.name, b);
            }
            if (Game.Biome_type == 4) {
                final Background b = new Background("map1_bg", game.getSprite("map3.png"));
                backgrounds.put(b.name, b);
            }
        }
        {
            final Controller c = new Controller("controller");
            c.x = 0;
            c.y = 0;
            objects.put(c.name, c);
        }
        {
            final Player p = new Player("player");
            GameObject.PlayerCanMovie = 0;
            p.x = 250;
            p.y = 250;
            p.z = 5;
            p.visible = false;
            objects.put(p.name, p);
        }
        {
            final main_door d = new main_door("main_door");
            objects.put(d.name, d);
        }
        {
            final KeyMessage kms = new KeyMessage("key_need");
            //kms.x = 150;
            //kms.y = 150;
            //kms.z = 50;
            //kms.visible = true;
            objects.put(kms.name, kms);
        }
        {
            final MainMenuRoom r = new MainMenuRoom("main_menu_room");
            r.background = "main_menu_bg";
            r.objectsIDs.add("controller");
            rooms.put(r.name, r);
        }
        {
            final NewGameSplashScreenRoom r = new NewGameSplashScreenRoom("new_game_splash_screen_room");
            r.background = "new_game_splash_screen_bg";
            r.objectsIDs.add("controller");
            rooms.put(r.name, r);
        }
        {
            final Map1 r = new Map1("map1_room");
            r.background = "map1_bg";
            r.objectsIDs.add("controller");
            r.objectsIDs.add("player");
            rooms.put(r.name, r);

        }
        {
            final Map2 r = new Map2("map2_room");
            r.background = "map1_bg";
            r.objectsIDs.add("controller");
            r.objectsIDs.add("player");
            rooms.put(r.name, r);

        }

        {
            final Map3 r = new Map3("map3_room");
            r.background = "map1_bg";
            r.objectsIDs.add("controller");
            r.objectsIDs.add("player");
            rooms.put(r.name, r);

        }
    }
}
