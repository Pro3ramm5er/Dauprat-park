package dpark;

import dpark.objects.*;
import dpark.objects.Player;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.lang.Object;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;


import static dpark.DB.db;

import dpark.objects.Window;
import dpark.rooms.AN_Fight;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


/**
 * @author Pro3ramm5er, STALKER_2010
 */
public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = -5445130295019858065L;
    public BufferStrategy bss;
    public Graphics gl;
    private boolean running = false;
    public static Game instance;
    public Map<Integer, Integer> Wxx = new HashMap<Integer, Integer>();
    public Map<Integer, Integer> Wyy = new HashMap<Integer, Integer>();

    public static int Applecalipses = 0;
    public static Room currentRoom;
    public MusicPlayer MainTheme;
    public MusicPlayer ms = new MusicPlayer("sounds/Queen - Bicycle Race.wma");

    public SoundEngine soundengine;
    public AudioSystem e;


    public Game() {
        instance = this;
    }


    public void start() {
        running = true;

        new Thread(this).start();
    }

    public static final int FPS = 35;
    private static final int FrameDuration = 750 / FPS;
    private static final int MaxFrameSkip = 3;
    private long nextFrameTime = System.currentTimeMillis();

    public void run() {
        int loops;
        init();
        addKeyListener(new Keyboard());
        addMouseListener(mouseListener);
        while (running) {
            loops = 0;

            while (System.currentTimeMillis() > nextFrameTime
                    && loops < MaxFrameSkip) {

                update();
                //db.objects.get("player").update();
                if (currentRoom == db.rooms.get("main_menu_room")) {
                    GameOtherVars.StartAnimation();
                }
                if (GameOtherVars.Debag_1 == 0) {
                    System.out.print(" IN");
                    GameOtherVars.Debag_1 = 1;
                }
                if (GameOtherVars.Debag_4 == 0) {
                    System.out.print(" MY");
                    GameOtherVars.Debag_4 = 1;
                }
                if (GameOtherVars.Debag_5 == 0) {
                    System.out.print(" HEARTH");
                    GameOtherVars.Debag_5 = 1;
                }
                if (GameOtherVars.Debag_6 == 0) {
                    System.out.print(" , AND");
                    GameOtherVars.Debag_6 = 1;
                }
                if (GameOtherVars.Debag_7 == 0) {
                    System.out.print(" MY");
                    GameOtherVars.Debag_7 = 1;
                }
                if (GameOtherVars.Debag_8 == 0) {
                    System.out.print(" CODE");
                    GameOtherVars.Debag_8 = 1;
                }
                if (GameOtherVars.Debag_9 == 0) {
                    System.out.print(" TOO");
                    GameOtherVars.Debag_9 = 1;
                }
                if (GameOtherVars.Debag_10 == 0) {
                    System.out.print(". HELLO");
                    GameOtherVars.Debag_10 = 1;
                }
                if (GameOtherVars.Debag_11 == 0) {
                    System.out.print(" ANDREW");
                    GameOtherVars.Debag_11 = 1;
                }
                if (GameOtherVars.Debag_12 == 0) {
                    System.out.print(",  HOW");
                    GameOtherVars.Debag_12 = 1;
                }
                if (GameOtherVars.Debag_13 == 0) {
                    System.out.print("  ARE");
                    GameOtherVars.Debag_13 = 1;
                }
                if (GameOtherVars.Debag_14 == 0) {
                    System.out.print("  YOU?");
                    GameOtherVars.Debag_14 = 1;
                }

                if (GameOtherVars.BeforeMain == 1) {
                    if (GameOtherVars.Level == 1) {
                        Get_Start();

                    }
                    if (GameOtherVars.Level == 2) {
                        Get_start_location_2();

                    }
                    if (GameOtherVars.Level == 3) {
                        Get_start_location_3();

                    }
                    if (GameOtherVars.Level == 4) {
                        Get_4_level();

                    }
                    if (GameOtherVars.Level == 5) {
                        GetStartStory();

                    }
                    if (GameOtherVars.Level == 6) {
                        GetStartS2();

                    }
                    if (GameOtherVars.Level == 7) {
                        GetStartS3();

                    }
                    if (GameOtherVars.Level == 8) {
                        GetStartS4();

                    }
                    if (GameOtherVars.Level == 9) {
                        GetStartS5();

                    }
                    if (GameOtherVars.Level == 10) {
                        GetStartS6();

                    }
                    if (GameOtherVars.Level == 11) {
                        GetStartS7();

                    }
                    if (GameOtherVars.Level == 12) {
                        GetStartS8();

                    }
                    if (GameOtherVars.Level == 13) {
                        GetStartS9();

                    }
                    if (GameOtherVars.Level == 14) {
                        GetStartS10();

                    }
                    if (GameOtherVars.Level == 15) {
                        GetStartS11();

                    }
                    if (GameOtherVars.Level == 16) {
                        GetStartS12();

                    }
                    if (GameOtherVars.Level == 17) {
                        GetStartS13();

                    }
                    if (GameOtherVars.Level == 18) {
                        GetStartS14();

                    }
                    if (GameOtherVars.Level == 19) {
                        GetStartS15();

                    }
                    if (GameOtherVars.Level == 20) {
                        GetStartS16();

                    }
                    if (GameOtherVars.Level == 21) {
                        GetStartS17();

                    }
                    if (GameOtherVars.Level == 22) {
                        GetStartS18();

                    }
                    if (GameOtherVars.Level == 23) {
                        GetStartS19();

                    }
                    if (GameOtherVars.Level == 24) {
                        GetStartS20();

                    }
                    if (GameOtherVars.Level == 25) {
                        GetStartS21();

                    }
                    if (GameOtherVars.Level == 26) {
                        GetStartS22();

                    }
                    if (GameOtherVars.Level == 27) {
                        GetStartS23();

                    }
                    if (GameOtherVars.Level == 28) {
                        GetStartS24();

                    }
                    if (GameOtherVars.Level == 29) {
                        GetStartS25();

                    }
                    if (GameOtherVars.Level == 30) {
                        GetStartS26();

                    }
                    if (GameOtherVars.Level == 31) {
                        GetStartS27();

                    }
                    if (GameOtherVars.Level == 33) {
                        GetStartS29();

                    }
                    if (GameOtherVars.Level == 34) {
                        GetStartS30();

                    }
                    if (GameOtherVars.Level == 35) {
                        GetStartS31();

                    }
                    if (GameOtherVars.Level == 36) {
                        GetStartS32();

                    }
                    if (GameOtherVars.Level == 37) {
                        GetStartS33();

                    }
                    if (GameOtherVars.Level == 38) {
                        GetStartS34();

                    }
                    if (GameOtherVars.Level == 39) {
                        GetStartS35();

                    }

                    if (GameOtherVars.Level == 40) {
                        GetStartS36();

                    }
                    if (GameOtherVars.Level == 41) {
                        GetStartS37();

                    }
                    if (GameOtherVars.Level == 42) {
                        GetStartS38();

                    }
                    if (GameOtherVars.Level == 43) {
                        GetStartS39();

                    }
                    if (GameOtherVars.Level == 44) {
                        GetStartS40();

                    }
                    if (GameOtherVars.Level == 45) {
                        GetStartS41();

                    }
                    if (GameOtherVars.Level == 46) {
                        GetStartS42();

                    }
                    if (GameOtherVars.Level == 47) {
                        GetStartS43();

                    }
                    if (GameOtherVars.Level == 48) {
                        GetStartS44();

                    }
                    if (GameOtherVars.Level == 49) {
                        GetStartS45();

                    }
                    if (GameOtherVars.Level == 50) {
                        GetStartS46();

                    }
                    if (GameOtherVars.Level == 51) {
                        GetStartS47();

                    }
                    if (GameOtherVars.Level == 52) {
                        GetStartS48();

                    }
                    if (GameOtherVars.Level == 53) {
                        GetStartS49();

                    }
                    if (GameOtherVars.Level == 54) {
                        GetStartS50();

                    }
                    if (GameOtherVars.Level == 55) {
                        GetStartS51();

                    }
                    if (GameOtherVars.Level == 56) {
                        GetStartS52();

                    }
                    if (GameOtherVars.Level == 57) {
                        GetStartS53();

                    }
                    if (GameOtherVars.Level == 58) {
                        GetStartS54();

                    }
                    if (GameOtherVars.Level == 59) {
                        GetStartS55();

                    }
                    if (GameOtherVars.Level == 60) {
                        GetStartS56();

                    }
                    if (GameOtherVars.Level == 61) {
                        GetStartS57();

                    }
                    if (GameOtherVars.Level == 62) {
                        GetStartS58();

                    }
                    if (GameOtherVars.Level == 63) {
                        GetStartS59();

                    }
                }
                currentRoom.update();


                if (GameOtherVars.AllDelete == 0 && GameOtherVars.StopUpdate == 0) {

                    for (GameObject o : db.objects.values()) {

                            if (GameOtherVars.AllDelete == 0 && GameOtherVars.StopUpdate == 0) {
                                if (o.UseRoom == currentRoom) {
                                    if (o.UseRoomInt == GameOtherVars.RoomNow) {
                                        o.update();
                                    }
                                }
                            }

                    }
                    db.objects.get("player").UseRoomInt = GameOtherVars.RoomNow;
                    //db.objects.get("player").update();
                    db.objects.get("player").UseRoom = Game.currentRoom;


                }

                if (GameOtherVars.AllDelete == 1) {


                    currentRoom.objectsIDs.clear();
                    currentRoom.objectsIDs.add("player");
                    GameOtherVars.RoomNow ++;

                    //db.objects.clear();
                    //db.onGameLoaded(this);
                    GameOtherVars.WinVisible = 0;
                    GameOtherVars.VisibleDieLogo = 0;
                    GameOtherVars.AllDelete = 0; // If 1 - SelfRemove for all objects.
                    GameOtherVars.StopUpdate = 0;
                    GameOtherVars.IsCreated = 0;
                    GameOtherVars.AppleCreate = 1;

                    GameOtherVars.BluemanCreated = 0;
                    GameOtherVars.RatCreated = 0;
                    GameOtherVars.xo = 0;
                    GameOtherVars.yo = 0;
                    GameOtherVars.MainKey = 0;
                    GameOtherVars.Shlakoblock_magic = 0;
                    GameOtherVars.BeforeMain = 0;
                    GameOtherVars.Reload_on = 1;
                    GameOtherVars.Health = 2;
                    GameOtherVars.Biome_type = 1 + (int) (Math.random() * ((6 - 1) + 1));
                    GameOtherVars.Player_bottle = 0;
                    GameOtherVars.UnderEffecr = 0;
                    GameOtherVars.Fullimmortality = 0;
                    GameOtherVars.GEtdel = 0;
                    GameOtherVars.Magic_1 = 0;
                    GameOtherVars.PlAlarmOn = 0;

                    Back_init();
                    if (GameOtherVars.Restart_type == 1) {
                        init();
                    }
                    if (GameOtherVars.Restart_type == 2) {
                        //init_location_2();
                        Get_start_location_2();
                    }
                    if (GameOtherVars.Restart_type == 3) {
                        Get_start_location_3();
                    }
                    if (GameOtherVars.Restart_type == 4) {
                        Get_4_level();
                    }
                    if (GameOtherVars.Restart_type == 5) {
                        GetStartStory();
                    }
                    if (GameOtherVars.Restart_type == 6) {
                        GetStartS2();
                    }
                    if (GameOtherVars.Restart_type == 7) {
                        GetStartS3();
                    }
                    if (GameOtherVars.Restart_type == 8) {
                        GetStartS4();
                    }
                    if (GameOtherVars.Restart_type == 9) {
                        GetStartS5();
                    }
                    if (GameOtherVars.Restart_type == 10) {
                        GetStartS6();

                    }
                    if (GameOtherVars.Restart_type == 11) {
                        GetStartS7();

                    }
                    if (GameOtherVars.Restart_type == 12) {
                        GetStartS8();

                    }
                    if (GameOtherVars.Restart_type == 13) {
                        GetStartS9();

                    }
                    if (GameOtherVars.Restart_type == 14) {
                        GetStartS10();

                    }
                    if (GameOtherVars.Restart_type == 15) {
                        GetStartS11();

                    }
                    if (GameOtherVars.Restart_type == 16) {
                        GetStartS12();

                    }
                    if (GameOtherVars.Restart_type == 17) {
                        GetStartS13();

                    }
                    if (GameOtherVars.Restart_type == 18) {
                        GetStartS14();

                    }
                    if (GameOtherVars.Restart_type == 19) {
                        GetStartS15();

                    }
                    if (GameOtherVars.Restart_type == 20) {
                        GetStartS16();

                    }
                    if (GameOtherVars.Restart_type == 21) {
                        GetStartS17();

                    }
                    if (GameOtherVars.Restart_type == 22) {
                        GetStartS18();

                    }
                    if (GameOtherVars.Restart_type == 23) {
                        GetStartS19();

                    }
                    if (GameOtherVars.Restart_type == 24) {
                        GetStartS20();

                    }
                    if (GameOtherVars.Restart_type == 25) {
                        GetStartS21();

                    }
                    if (GameOtherVars.Restart_type == 26) {
                        GetStartS22();

                    }
                    if (GameOtherVars.Restart_type == 27) {
                        //GameOtherVars.Level = 27;
                        GetStartS23();

                    }
                    if (GameOtherVars.Restart_type == 28) {
                        //GameOtherVars.Level = 27;
                        GetStartS24();

                    }
                    if (GameOtherVars.Restart_type == 29) {
                        //GameOtherVars.Level = 27;
                        GetStartS25();

                    }
                    if (GameOtherVars.Restart_type == 30) {
                        //GameOtherVars.Level = 27;
                        GetStartS26();

                    }
                    if (GameOtherVars.Restart_type == 31) {
                        //GameOtherVars.Level = 27;
                        GetStartS27();

                    }
                    if (GameOtherVars.Restart_type == 32) {
                        //GameOtherVars.Level = 27;
                        GetStartS28();

                    }
                    if (GameOtherVars.Restart_type == 33) {
                        //GameOtherVars.Level = 27;
                        GetStartS29();

                    }
                    if (GameOtherVars.Restart_type == 34) {
                        //GameOtherVars.Level = 27;
                        GetStartS30();

                    }
                    if (GameOtherVars.Restart_type == 35) {
                        //GameOtherVars.Level = 27;
                        GetStartS31();

                    }
                    if (GameOtherVars.Restart_type == 36) {
                        //GameOtherVars.Level = 27;
                        GetStartS32();

                    }
                    if (GameOtherVars.Restart_type == 37) {
                        //GameOtherVars.Level = 27;
                        GetStartS33();

                    }
                    if (GameOtherVars.Restart_type == 38) {
                        //GameOtherVars.Level = 27;
                        GetStartS34();

                    }
                    if (GameOtherVars.Restart_type == 39) {
                        //GameOtherVars.Level = 27;
                        GetStartS35();

                    }
                    if (GameOtherVars.Restart_type == 40) {
                        //GameOtherVars.Level = 27;
                        GetStartS36();

                    }
                    if (GameOtherVars.Restart_type == 41) {
                        //GameOtherVars.Level = 27;
                        GetStartS37();

                    }
                    if (GameOtherVars.Restart_type == 42) {
                        //GameOtherVars.Level = 27;
                        GetStartS38();

                    }
                    if (GameOtherVars.Restart_type == 43) {
                        //GameOtherVars.Level = 27;
                        GetStartS39();

                    }
                    if (GameOtherVars.Restart_type == 44) {
                        //GameOtherVars.Level = 27;
                        GetStartS40();

                    }
                    if (GameOtherVars.Restart_type == 45) {
                        //GameOtherVars.Level = 27;
                        GetStartS41();

                    }
                    if (GameOtherVars.Restart_type == 46) {
                        //GameOtherVars.Level = 27;
                        GetStartS42();

                    }
                    if (GameOtherVars.Restart_type == 47) {
                        //GameOtherVars.Level = 27;
                        GetStartS43();

                    }
                    if (GameOtherVars.Restart_type == 48) {
                        //GameOtherVars.Level = 27;
                        GetStartS44();

                    }
                    if (GameOtherVars.Restart_type == 49) {
                        //GameOtherVars.Level = 27;
                        GetStartS45();

                    }
                    if (GameOtherVars.Restart_type == 50) {
                        //GameOtherVars.Level = 27;
                        GetStartS46();

                    }
                    if (GameOtherVars.Restart_type == 51) {
                        //GameOtherVars.Level = 27;
                        GetStartS47();

                    }
                    if (GameOtherVars.Restart_type == 52) {
                        //GameOtherVars.Level = 27;
                        GetStartS48();

                    }
                    if (GameOtherVars.Restart_type == 53) {
                        //GameOtherVars.Level = 27;
                        GetStartS49();

                    }
                    if (GameOtherVars.Restart_type == 54) {
                        //GameOtherVars.Level = 27;
                        GetStartS50();

                    }
                    if (GameOtherVars.Restart_type == 55) {
                        //GameOtherVars.Level = 27;
                        GetStartS51();

                    }
                    if (GameOtherVars.Restart_type == 56) {
                        //GameOtherVars.Level = 27;
                        GetStartS52();

                    }
                    if (GameOtherVars.Restart_type == 57) {
                        //GameOtherVars.Level = 27;
                        GetStartS53();

                    }
                    if (GameOtherVars.Restart_type == 58) {
                        //GameOtherVars.Level = 27;
                        GetStartS54();

                    }
                    if (GameOtherVars.Restart_type == 59) {
                        //GameOtherVars.Level = 27;
                        GetStartS55();

                    }

                    if (GameOtherVars.Restart_type == 60) {
                        //GameOtherVars.Level = 27;
                        GetStartS56();

                    }

                    if (GameOtherVars.Restart_type == 61) {
                        //GameOtherVars.Level = 27;
                        GetStartS57();

                    }
                    if (GameOtherVars.Restart_type == 62) {
                        //GameOtherVars.Level = 27;
                        GetStartS58();

                    }
                    if (GameOtherVars.Restart_type == 63) {
                        //GameOtherVars.Level = 27;
                        GetStartS59();

                    }
                    /*
                    if (GameOtherVars.Restart_type == 62) {
                        //GameOtherVars.Level = 27;
                        GetStartS58();

                    }
                    if (GameOtherVars.Restart_type == 63) {
                        //GameOtherVars.Level = 27;
                        GetStartS59();

                    }
                    */
                    GameOtherVars.AllDelete = 0;

                }
                for (Animation a : db.animations.values()) {
                    a.update();
                }


                nextFrameTime += FrameDuration;

                loops++;

            }
            render(currentRoom);
        }
    }

    public void init() {


        if (GameOtherVars.InitOn == 0) {
            addKeyListener(new Keyboard());
            addMouseListener(mouseListener);

            //GameOtherVars.instance.Back_init();
            //soundengine.load("assets/sounds/Deep_Purple_Burn.aif");

            db.onGameLoaded(this);
            Back_init();
            GameOtherVars.InitOn = 1;
            //ms.play();


        }

        //Sound.playSound("sounds/Deep_Purple-Burn.wav").join();



        currentRoom = db.rooms.get("main_menu_room");
    }

    public void Back_init()
    {

        {

            final Player p = new Player("player");
            p.UseRoom = Game.currentRoom;
            GameObject.PlayerCanMovie = 0;

            p.x = 250;
            p.y = 250;


            //p.z = 5;
            p.UseRoomInt = GameOtherVars.RoomNow;
            p.visible = false;
            db.objects.put(p.name, p);
        }
        //if (GameOtherVars.GameUpdateType == 0) {
            if (GameOtherVars.Biome_type == 1) {
                final Background b = new Background("map1_bg", Game.instance.getSprite("map1.png"));
                DB.db.backgrounds.put(b.name, b);
            }
            if (GameOtherVars.Biome_type == 2) {
                final Background b = new Background("map1_bg", Game.instance.getSprite("Newyaermap1.png"));
                DB.db.backgrounds.put(b.name, b);
            }
            if (GameOtherVars.Biome_type == 3) {
                final Background b = new Background("map1_bg", Game.instance.getSprite("map2.png"));
                DB.db.backgrounds.put(b.name, b);
            }
            if (GameOtherVars.Biome_type == 4) {
                final Background b = new Background("map1_bg", Game.instance.getSprite("map3.png"));
                DB.db.backgrounds.put(b.name, b);
            }
            if (GameOtherVars.Biome_type == 5) {
                final Background b = new Background("map1_bg", Game.instance.getSprite("map4.png"));
                DB.db.backgrounds.put(b.name, b);
            }
            if (GameOtherVars.Biome_type == 6) {
                final Background b = new Background("map1_bg", Game.instance.getSprite("map5.png"));
                DB.db.backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg", Game.instance.getSprite("logo.png"));
                DB.db.backgrounds.put(b.name, b);
            }

            {
                final Background b = new Background("main_menu_bg2", Game.instance.getSprite("logo2.png"));
                DB.db.backgrounds.put(b.name, b);
            }

        //}
        if (GameOtherVars.GameUpdateType == 1) {
            {
                final Background b = new Background("main_menu_bg", Game.instance.getSprite("Newyaer_logo.png"));
                DB.db.backgrounds.put(b.name, b);
            }

            {
                final Background b = new Background("main_menu_bg2", Game.instance.getSprite("Newyaer_logo_1.png"));
                DB.db.backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg3", Game.instance.getSprite("Newyaer_logo_2.png"));
                DB.db.backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg4", Game.instance.getSprite("Newyaer_logo_3.png"));
                DB.db.backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg5", Game.instance.getSprite("Newyaer_logo_4.png"));
                DB.db.backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg6", Game.instance.getSprite("Newyaer_logo_3.png"));
                DB.db.backgrounds.put(b.name, b);
            }
            {
                final Background b = new Background("main_menu_bg7", Game.instance.getSprite("Newyaer_logo_2.png"));
                DB.db.backgrounds.put(b.name, b);
            }

            {
                final Background b = new Background("main_menu_bg8", Game.instance.getSprite("Newyaer_logo_1.png"));
                DB.db.backgrounds.put(b.name, b);
            }


        }
        if (GameOtherVars.Debag_3 == 0) {
            System.out.print(" FOREVER");
            GameOtherVars.Debag_3 = 1;
        }
    }
    public void render(Room room) {
        bss = getBufferStrategy();
        if (bss == null) {
            createBufferStrategy(2);
            requestFocus();

            return;
        }
        gl =  bss.getDrawGraphics();

        gl.setColor(Color.black);
        gl.fillRect(0, 0 , 5000, 5000);




        db.backgrounds.get(currentRoom.background).sprite.getStep().sprite.draw(gl, 0,
                0);
        List<GameObject> objs = new ArrayList<GameObject>(db.objects.values());
        Collections.sort(objs, GameObject.compareByDepth);
        for (GameObject o : objs /*db.objects.values()*/) {
            if (room.objectsIDs.contains(o.name)/*currentRoom.objectsIDs.contains(o.name)*/) {
                if (o.UseRoom == currentRoom ) {
                    if (o.UseRoomInt == GameOtherVars.RoomNow) {
                        o.render(gl);

                    }
                }
            }

        }

        bss.show();
        gl.dispose();
    }

    public void update() {

    }

    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public static String NAME = "Dauprat park";

    public static Game launch(final Game game) {
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        JFrame frame = new JFrame(Game.NAME);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        game.start();

        return game;
    }





    public static void Get_win_1()
    {
        GameOtherVars.WinVisible = 1;

    }
    public static void Get_win_2()
    {
        GameOtherVars.AllDelete = 1;
        GameOtherVars.VisibleDieLogo = 0;
    }
    public static void Get_Die() {

        GameOtherVars.AllDelete = 1;
        GameOtherVars.VisibleDieLogo = 0;


    }
    public void GetStartS59() {


        GameOtherVars.Level = 63;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 63;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);





            S_dec_tr_create(55, 125);
            S_dec_tr_create(745, 125);

            AN_alarm_Create(0, 0);

            //S_trashhouse_create(515, 310);

            Roomback19_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS58() {


        GameOtherVars.Level = 62;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 62;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);
            S_coconat_create(95, 45);




            S_dec_tr_create(55, 125);
            S_dec_tr_create(745, 125);
            AN_Fight4_create(0, 0);
            AN_alarm_Create(0, 0);

            //S_trashhouse_create(515, 310);

            Roomback19_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void S_coconat_create(int w, int e) {

        final S_coconat chest = new S_coconat(getFreeName("S_coconat"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void AN_Fight4_create(int w, int e) {

        final AN_Fight4 chest = new AN_Fight4(getFreeName("AN_Fight4"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS57() {


        GameOtherVars.Level = 61;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 61;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);





            S_dec_tr_create(55, 125);
            S_dec_tr_create(745, 125);
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));

            Security_deamon_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            Security_deamon_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            Security_deamon_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            Security_deamon_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            Security_deamon_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            Security_deamon_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            NPC_rebbit_sec_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            AN_alarm_Create(0, 0);

            //S_trashhouse_create(515, 310);

            Roomback19_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void NPC_rebbit_sec_create(int w, int e) {

        final S_rabbit_security chest = new S_rabbit_security(getFreeName("S_rabbit_security"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS56() {


        GameOtherVars.Level = 60;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 60;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);





            S_dec_tr_create(55, 125);
            S_dec_tr_create(745, 125);
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));

            Security_deamon_create(400, 0);
            Security_deamon_create(400, 0);
            Security_deamon_create(400, 0);
            Security_deamon_create(400, 0);
            Security_deamon_create(400, 0);
            Security_deamon_create(400, 0);
            AN_alarm_Create(0, 0);

            //S_trashhouse_create(515, 310);

            Roomback19_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS55() {


        GameOtherVars.Level = 59;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 59;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);





            S_dec_tr_create(55, 125);
            S_dec_tr_create(745, 125);
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));

            Security_deamon_create(400, 0);
            Security_deamon_create(400, 0);
            Security_deamon_create(400, 0);

            AN_alarm_Create(0, 0);

            //S_trashhouse_create(515, 310);

            Roomback19_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS54() {


        GameOtherVars.Level = 58;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 58;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);





            S_dec_tr_create(55, 125);
            S_dec_tr_create(745, 125);
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));

            Security_deamon_create(400, 0);
            Security_deamon_create(400, 0);
            Security_deamon_create(400, 0);

            AN_alarm_Create(0, 0);

            //S_trashhouse_create(515, 310);

            Roomback19_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS53() {


        GameOtherVars.Level = 57;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 57;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);





            S_dec_tr_create(55, 125);
            S_dec_tr_create(745, 125);
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));
            S_dec_crate_create(Game.instance.GetRandom(51, 600), Game.instance.GetRandom(0, 600));

            Security_deamon_create(400, 0);

            AN_alarm_Create(0, 0);

            //S_trashhouse_create(515, 310);

            Roomback19_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void S_dec_crate_create(int w, int e) {

        final S_dec_crate chest = new S_dec_crate(getFreeName("S_dec_crate"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS52() {


        GameOtherVars.Level = 56;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 56;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            S_dec_table_create(379, 255);
            S_dec_table_create(429, 255);
            S_dec_table_create(320, 255);

            S_dec_table_create(379, 155);
            S_dec_table_create(429, 155);
            S_dec_table_create(320, 155);

            S_dec_table_create(379, 355);
            S_dec_table_create(429, 355);
            S_dec_table_create(320, 355);



            S_dec_tr_create(55, 125);
            S_dec_tr_create(745, 125);



            S_dec_table_create(179, 255);
            S_dec_table_create(229, 255);
            S_dec_table_create(120, 255);

            S_dec_table_create(179, 155);
            S_dec_table_create(229, 155);
            S_dec_table_create(120, 155);

            S_dec_table_create(179, 355);
            S_dec_table_create(229, 355);
            S_dec_table_create(120, 355);


            S_dec_table_create(579, 255);
            S_dec_table_create(629, 255);
            S_dec_table_create(520, 255);

            S_dec_table_create(579, 155);
            S_dec_table_create(629, 155);
            S_dec_table_create(520, 155);

            S_dec_table_create(579, 355);
            S_dec_table_create(629, 355);
            S_dec_table_create(520, 355);

            AN_alarm_Create(0, 0);

            //S_trashhouse_create(515, 310);

            Roomback19_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void S_dec_table_create(int w, int e) {

        final S_dec_table chest = new S_dec_table(getFreeName("S_dec_table"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS51() {


        GameOtherVars.Level = 55;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 55;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);


            S_dec_tr_create(55, 425);
            S_dec_tr_create(745, 425);
            S_dec_tr_create(55, 340);
            S_dec_tr_create(745, 340);
            S_dec_tr_create(55, 255);
            S_dec_tr_create(745, 255);
            AN_alarm_Create(0, 0);

            //S_trashhouse_create(515, 310);

            Roomback19_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void S_dec_tr_create(int w, int e) {

        final S_dec_tr chest = new S_dec_tr(getFreeName("S_dec_tr"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void Roomback19_create(int w, int e) {

        final Roomback_19 chest = new Roomback_19(getFreeName("Roomback_19"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS50() {


        GameOtherVars.Level = 54;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 54;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);
            //Security_deamon_create(75, 0);
            //Security_deamon_create(175, 0);
            //Security_deamon_create(275, 0);
            //Security_deamon_create(375, 0);
            xcr = 47;
            icr = 108;
            i = 0;
            zex = 0;
            for (i = 0; i <= 21; i++) {


                DEC_unviswall_create(xcr, icr, 0);

                xcr += 32;
            }
            DEC_unviswall_create(739, 108, 0);
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);
            S_decwall3_create(47, -39);
            S_door3_create(409, 45);
            AN_alarm_Create(0, 0);

            //S_trashhouse_create(515, 310);
            DEC_camen_create(GetRandom(55, 700), GetRandom(200, 700));
            Roomback17_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
            xcr = 47;
            icr = 108;
            i = 0;
            zex = 0;
            for (i = 0; i <= 21; i++) {


                DEC_unviswall_create(xcr, icr, 0);

                xcr += 32;
            }
            DEC_unviswall_create(739, 108, 0);
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void S_decwall3_create(int w, int e) {

        final S_decwall3 chest = new S_decwall3(getFreeName("S_decwall3"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void S_door3_create(int w, int e) {

        final S_item5 chest = new S_item5(getFreeName("S_item5"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS49() {


        GameOtherVars.Level = 53;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 53;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);


            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);

            AN_alarm_Create(0, 0);
            for (int e = 0; e < 65; e++)
            {
                DEC_tree3_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 1));
            }
            //S_trashhouse_create(515, 310);
            DEC_camen_create(GetRandom(55, 700), GetRandom(55, 700));
            Roomback17_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS48() {


        GameOtherVars.Level = 52;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 52;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);


            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);

            AN_alarm_Create(0, 0);
            for (int e = 0; e < 65; e++)
            {
                DEC_tree3_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 1));
            }
            //S_trashhouse_create(515, 310);
            DEC_camen_create(GetRandom(55, 700), GetRandom(55, 700));
            Roomback17_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS47() {


        GameOtherVars.Level = 51;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 51;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);


            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);
            Security_deamon_create(675, 0);

            AN_alarm_Create(0, 0);
            for (int e = 0; e < 65; e++)
            {
                DEC_tree3_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 1));
            }
            //S_trashhouse_create(515, 310);
            DEC_camen_create(GetRandom(55, 700), GetRandom(55, 700));
            Roomback17_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS46() {


        GameOtherVars.Level = 50;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 50;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);


            Security_deamon_create(375, 0);
            Security_deamon_create(675, 0);

            AN_alarm_Create(0, 0);
            for (int e = 0; e < 65; e++)
            {
                DEC_tree3_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 1));
            }
            //S_trashhouse_create(515, 310);
            DEC_camen_create(GetRandom(55, 700), GetRandom(55, 700));
            Roomback17_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS45() {


        GameOtherVars.Level = 49;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 49;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);
            //Security_deamon_create(75, 0);
            //Security_deamon_create(175, 0);
            //Security_deamon_create(275, 0);
            //Security_deamon_create(375, 0);
            xcr = 47;
            icr = 108;
            i = 0;
            zex = 0;
            for (i = 0; i <= 21; i++) {


                DEC_unviswall_create(xcr, icr, 0);

                xcr += 32;
            }
            DEC_unviswall_create(739, 108, 0);
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);
            S_decwall2_create(47, -39);
            S_door2_create(309, 45);
            AN_alarm_Create(0, 0);

            //S_trashhouse_create(515, 310);
            DEC_camen_create(GetRandom(55, 700), GetRandom(200, 700));
            Roomback17_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
            xcr = 47;
            icr = 108;
            i = 0;
            zex = 0;
            for (i = 0; i <= 21; i++) {


                DEC_unviswall_create(xcr, icr, 0);

                xcr += 32;
            }
            DEC_unviswall_create(739, 108, 0);
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void S_door2_create(int w, int e) {

        final S_item4 chest = new S_item4(getFreeName("S_item4"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void S_decwall2_create(int w, int e) {

        final S_decwall2 chest = new S_decwall2(getFreeName("S_decwall2"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS44() {


        GameOtherVars.Level = 48;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 48;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);
            Security_deamon_create(75, 0);
            Security_deamon_create(175, 0);
            Security_deamon_create(275, 0);
            Security_deamon_create(375, 0);

            AN_alarm_Create(0, 0);
            for (int e = 0; e < 15; e++)
            {
                DEC_tree3_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 1));
            }
            //S_trashhouse_create(515, 310);
            DEC_camen_create(GetRandom(55, 700), GetRandom(55, 700));
            Roomback17_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void AN_alarm_Create(int w, int e) {

        final AN_alarm chest = new AN_alarm(getFreeName("AN_alarm"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void Security_deamon_create(int w, int e) {

        final S_security chest = new S_security(getFreeName("S_security"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS43() {


        GameOtherVars.Level = 47;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 47;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);




            //S_trashhouse_create(515, 310);
            DEC_camen_create(GetRandom(55, 700), GetRandom(55, 700));
            Roomback17_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS42() {


        GameOtherVars.Level = 46;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 46;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }


            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);




            //S_trashhouse_create(515, 310);

            Roomback18_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void Roomback18_create(int w, int e) {

        final Roomback_18 chest = new Roomback_18(getFreeName("Roomback_18"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS41() {


        GameOtherVars.Level = 45;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 45;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            xcr = 47;
            icr = 108;
            i = 0;
            zex = 0;
            for (i = 0; i <= 21; i++) {


                DEC_unviswall_create(xcr, icr, 0);

                xcr += 32;
            }
            DEC_unviswall_create(739, 108, 0);
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);
            DEC_decwall(47, -39);
            DEC_s_keytodoor(340, 340);
            DEC_s_walldoor(309, 45);
            for (int e = 0; e < 15; e++)
            {
                DEC_tree3_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 1));
            }
            //S_trashhouse_create(515, 310);

            Roomback17_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void DEC_s_keytodoor(int w, int e) {

        final S_item3 chest = new S_item3(getFreeName("S_item3"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_s_walldoor(int w, int e) {

        final S_item2 chest = new S_item2(getFreeName("S_item2"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_decwall(int w, int e) {

        final S_decwall chest = new S_decwall(getFreeName("S_decwall"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS40() {


        GameOtherVars.Level = 44;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 44;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);


            for (int e = 0; e < 15; e++)
            {
                DEC_tree3_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 1));
            }
            //S_trashhouse_create(515, 310);
            DEC_camen_create(GetRandom(55, 700), GetRandom(55, 700));
            Roomback17_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void DEC_camen_create(int w, int e) {

        final S_dec_camen chest = new S_dec_camen(getFreeName("S_dec_camen"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS39() {


        GameOtherVars.Level = 43;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 43;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);


            for (int e = 0; e < 15; e++)
            {
                DEC_tree3_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 1));
            }
            //S_trashhouse_create(515, 310);
            DFH_2_create( 35, 150);
            Roomback17_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx+45, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        if (GameOtherVars.Bullet_create == 1)
        {
            Bullet_create(GameOtherVars.Bullet_createedx+45, GameOtherVars.Bullet_createedy+50);
            //System.out.println("go");
            GameOtherVars.Bullet_create = 0;
        }
        //System.out.println("go1");
    }
    public void DFH_2_create(int w, int e) {

        final S_DFH_2 chest = new S_DFH_2(getFreeName("S_DFH_2"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void Bullet_create(int w, int e) {

        final OBJ_bullet chest = new OBJ_bullet(getFreeName("OBJ_bullet"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS38() {


        GameOtherVars.Level = 42;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 42;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);


            for (int e = 0; e < 65; e++)
            {
                DEC_tree3_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 1));
            }
            //S_trashhouse_create(515, 310);

            Roomback17_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS37() {


        GameOtherVars.Level = 41;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 41;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);


            for (int e = 0; e < 65; e++)
            {
                DEC_tree3_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 1));
            }
            //S_trashhouse_create(515, 310);

            Roomback17_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void DEC_tree3_create(int w, int e, int g) {

        final DEC_lava_tree chest = new DEC_lava_tree(getFreeName("DEC_lava_tree"));
        chest.TypeTex = g;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void Roomback17_create(int w, int e) {

        final Roomback_17 chest = new Roomback_17(getFreeName("Roomback_17"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS36() {


        GameOtherVars.Level = 40;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 40;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);
            S_PortalTH(300, 92);

            for (int e = 0; e < 65; e++)
            {
                S_tree_biome2_create(GetRandom(55, 700), GetRandom(55, 700));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback15_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void S_PortalTH(int w, int e) {

        final S_portaltohell chest = new S_portaltohell(getFreeName("S_portaltohell"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS35() {


        GameOtherVars.Level = 39;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 39;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);
            S_DFH_Create(300, 0);
            S_animationDFH(0, 0);
            for (int e = 0; e < 65; e++)
            {
                S_tree_biome2_create(GetRandom(55, 700), GetRandom(55, 700));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback15_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void S_animationDFH(int w, int e) {

        final AN_Fight_3 chest = new AN_Fight_3(getFreeName("AN_Fight_3"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void S_DFH_Create(int w, int e) {

        final S_DFH chest = new S_DFH(getFreeName("S_DFH"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS34() {


        GameOtherVars.Level = 38;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 38;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            //S_CHBOSS_create(400, 0);
            //AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                S_tree_biome2_create(GetRandom(55, 700), GetRandom(55, 700));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback15_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS33() {


        GameOtherVars.Level = 37;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 37;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            S_CHBOSS_create(400, 0);
            AN_fight2_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                S_tree_biome2_create(GetRandom(55, 700), GetRandom(55, 700));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback15_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void AN_fight2_create(int w, int e) {

        final AN_Fight2 chest = new AN_Fight2(getFreeName("AN_Fight2"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS32() {


        GameOtherVars.Level = 36;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 36;
            GameOtherVars.BeforeMain =1;
            GameOtherVars.FightAnimation = 1;
            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            S_CHBOSS_create(400, 0);
            AN_fight_create(0, 0);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                S_tree_biome2_create(GetRandom(55, 700), GetRandom(55, 700));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback15_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void S_CHBOSS_create(int w, int e) {

        final S_CHAIR chest = new S_CHAIR(getFreeName("S_CHAIR"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void AN_fight_create(int w, int e) {

        final AN_Fight chest = new AN_Fight(getFreeName("AN_Fight"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS31() {


        GameOtherVars.Level = 35;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 35;
            GameOtherVars.BeforeMain =1;

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);

            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                S_tree_biome2_create(GetRandom(55, 700), GetRandom(55, 700));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback15_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS30() {


        GameOtherVars.Level = 34;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 34;
            GameOtherVars.BeforeMain =1;

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            S_boss_create(344, 8);
            S_boss_create(344, 8);
            S_demon_create(344, 8);
            S_demon_create(344, 8);
            S_demon2_create(344, 8);
            S_demon2_create(344, 8);
            S_demon3_create(344, 8);
            S_demon3_create(344, 8);
            S_demon3_create(344, 8);
            S_demon3_create(344, 8);
            AN_blow_create(344, 8);
            AN_blow_create(364, 8);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                S_tree_biome2_create(GetRandom(55, 700), GetRandom(55, 700));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback15_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS29() {


        GameOtherVars.Level = 33;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 33;
            GameOtherVars.BeforeMain =1;

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            S_boss_create(344, 8);
            S_boss_create(344, 8);
            S_demon_create(344, 8);
            S_demon_create(344, 8);
            S_demon2_create(344, 8);
            S_demon2_create(344, 8);
            S_demon3_create(344, 8);
            S_demon3_create(344, 8);
            AN_blow_create(344, 8);
            AN_blow_create(364, 8);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                S_tree_biome2_create(GetRandom(55, 700), GetRandom(55, 700));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback15_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS28() {


        GameOtherVars.Level = 32;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 32;
            GameOtherVars.BeforeMain =1;

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            S_boss_create(344, 8);
            S_boss_create(344, 8);
            S_demon_create(344, 8);
            S_demon_create(344, 8);
            S_demon2_create(344, 8);
            S_demon2_create(344, 8);
            AN_blow_create(344, 8);
            AN_blow_create(364, 8);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                S_tree_biome2_create(GetRandom(55, 700), GetRandom(55, 700));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback15_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS27() {


        GameOtherVars.Level = 31;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 31;
            GameOtherVars.BeforeMain =1;

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            S_boss_create(344, 8);
            S_boss_create(344, 8);
            S_demon_create(344, 8);
            S_demon_create(344, 8);
            AN_blow_create(344, 8);
            AN_blow_create(364, 8);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                S_tree_biome2_create(GetRandom(55, 700), GetRandom(55, 700));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback15_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS26() {


        GameOtherVars.Level = 30;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 30;
            GameOtherVars.BeforeMain =1;

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            S_boss_create(344, 8);
            S_boss_create(344, 8);
            AN_blow_create(344, 8);
            AN_blow_create(364, 8);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                S_tree_biome2_create(GetRandom(55, 700), GetRandom(55, 700));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback15_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS25() {


        GameOtherVars.Level = 29;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 29;
            GameOtherVars.BeforeMain =1;

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                S_tree_biome2_create(GetRandom(55, 700), GetRandom(55, 700));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback15_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void DEC_roomback15_create(int w, int e) {

        final Roomback_16 chest = new Roomback_16(getFreeName("Roomback_16"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void AN_blow_create(int w, int e) {

        final AN_blow chest = new AN_blow(getFreeName("AN_blow"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void S_tree_biome2_create(int w, int e) {

        final DEC_Tree_rad chest = new DEC_Tree_rad(getFreeName("DEC_Tree_rad"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS24() {


        GameOtherVars.Level = 28;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 28;
            GameOtherVars.BeforeMain =1;

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
           // S_portal_create(GetRandom(15, 600), GetRandom(15, 600));

            //S_boss_create(344, 8);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void GetStartS23() {


        GameOtherVars.Level = 27;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.Level = 27;
            GameOtherVars.BeforeMain =1;

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            S_portal_create(GetRandom(45, 600), GetRandom(45, 600));

            S_boss_create(344, 8);
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }
        if (GameOtherVars.Deamon_create == 1)
        {
            S_demon_create(GameOtherVars.Bossx, GameOtherVars.Bossy-50);
            //System.out.println("go");
            GameOtherVars.Deamon_create = 0;
        }
        //System.out.println("go1");
    }
    public void S_portal_create(int w, int e) {

        final S_portal chest = new S_portal(getFreeName("S_portal"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void S_boss_create(int w, int e) {

        final S_TheBoss chest = new S_TheBoss(getFreeName("S_TheBoss.png"));

        chest.x = w;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS22() {


        GameOtherVars.Level = 26;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }



            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void GetStartS21() {


        GameOtherVars.Level = 25;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }



            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }
            //S_trashhouse_create(515, 310);

            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void GetStartS20() {


        GameOtherVars.Level = 24;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }



            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }
            //S_trashhouse_create(515, 310);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon2_create(45, 45);
            S_demon2_create(45, 45);
            S_demon2_create(45, 45);
            S_demon2_create(45, 45);
            S_demon3_create(45, 45);
            S_demon3_create(45, 45);
            S_demon3_create(45, 45);
            S_demon3_create(45, 45);
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_deamon4_create(45, 45);
            S_deamon4_create(45, 45);
            S_deamon4_create(45, 45);
            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void GetStartS19() {


        GameOtherVars.Level = 23;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }



            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }
            //S_trashhouse_create(515, 310);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon2_create(45, 45);
            S_demon2_create(45, 45);
            S_demon2_create(45, 45);
            S_demon2_create(45, 45);
            S_demon3_create(45, 45);
            S_demon3_create(45, 45);
            S_demon3_create(45, 45);
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_deamon4_create(45, 45);
            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void S_deamon4_create(int w, int e) {

            final S_deamon4 chest = new S_deamon4(getFreeName("S_deamon4.png"));

            chest.x = w;
            chest.y = e;
            chest.xt = w;
            chest.yt = e;
            chest.UseRoom = currentRoom;
            //chest.z = 5;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS18() {


        GameOtherVars.Level = 22;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }



            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }
            //S_trashhouse_create(515, 310);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon2_create(45, 45);
            S_demon3_create(45, 45);
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            S_egg_create();
            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void S_egg_create() {
        if (GetRandom(0, 1) == 1) {
            final Egg chest = new Egg(getFreeName("Egg.png"));

            chest.x = GetRandom(100, 600);
            chest.y = GetRandom(100, 600);
            chest.xt = GetRandom(100, 600);
            chest.yt = GetRandom(100, 600);
            chest.UseRoom = currentRoom;
            //chest.z = 5;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
        }


    }
    public void GetStartS17() {


        GameOtherVars.Level = 21;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }



            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }
            //S_trashhouse_create(515, 310);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon2_create(45, 45);
            S_demon3_create(45, 45);
            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void S_demon3_create(int w, int e) {

        final S_deamon3 chest = new S_deamon3(getFreeName("S_deamon3.png"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS16() {


        GameOtherVars.Level = 20;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }



            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }
            //S_trashhouse_create(515, 310);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon2_create(45, 45);
            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void S_demon2_create(int w, int e) {

        final S_deamon2 chest = new S_deamon2(getFreeName("S_deamon2.png"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS15() {


        GameOtherVars.Level = 19;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }



            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }
            //S_trashhouse_create(515, 310);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void GetStartS14() {


        GameOtherVars.Level = 18;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }



            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }
            //S_trashhouse_create(515, 310);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void GetStartS13() {


        GameOtherVars.Level = 17;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }



            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }
            //S_trashhouse_create(515, 310);
            S_demon_create(45, 45);
            S_demon_create(45, 45);
            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void GetStartS12() {


        GameOtherVars.Level = 16;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }



            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }
            S_trashhouse_create(515, 310);
            S_demon_create(45, 45);
            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
            GameOtherVars.Player_ac_t1 = 1;
        }


    }
    public void S_demon_create(int w, int e) {

        final S_deamon chest = new S_deamon(getFreeName("S_deamon.png"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void S_trashhouse_create(int w, int e) {

        final DEC_trash_house chest = new DEC_trash_house(getFreeName("DEC_trash_house.png"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS11() {


        GameOtherVars.Level = 15;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }



            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            for (int e = 0; e < 65; e++)
            {
                DEC_tree_create(GetRandom(55, 700), GetRandom(55, 700), GetRandom(0, 2));
            }

            DEC_roomback14_create(47, 0);
            //sS_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void GetStartS10() {


        GameOtherVars.Level = 14;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }



            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);

            DEC_roomback14_create(47, 0);
            S_task3_create(633, 444);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void S_task3_create(int w, int e) {

        final s_item chest = new s_item(getFreeName("s_item.png"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS9() {


        GameOtherVars.Level = 13;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            xcr = 50;
            icr = 97;
            i = 0;
            zex = 0;

            for (i = 0; i <= 10; i++) {


                DEC_unviswall_create(xcr, icr, 0);

                xcr += 32;
            }
            DEC_unviswall_create(399, 66, 1);
            xcr = 399;
            icr = 66;
            i = 0;
            zex = 0;

            for (i = 0; i <= 11; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }

            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);
            Roomback_15_create(50, 0);
            DEC_roomback14_create(47, 0);
            DEC_tree_create(495, 282, 1);
            DEC_tree_create(518, 3, 0);
            DEC_tree_create(87, 134, 2);
            DEC_door_prop2_create(142, 64);
            DEC_trash_create(613, 55, 0);
            DEC_trash_create(600, 23, 1);
            DEC_write_create(327, 13, 0);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void DEC_write_create(int w, int e, int ty) {

        final DEC_write chest = new DEC_write(getFreeName("DEC_write.png"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.type = ty;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_trash_create(int w, int e, int ty) {

        final DEC_trash_prop chest = new DEC_trash_prop(getFreeName("DEC_trash_prop"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.type = ty;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_door_prop2_create(int w, int e) {

        final DEC_door_prop2 chest = new DEC_door_prop2(getFreeName("DEC_door_prop2"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void Roomback_15_create(int w, int e) {

        final Roomback_15 chest = new Roomback_15(getFreeName("Roomback_15"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS8() {


        GameOtherVars.Level = 12;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);
            S_task2_create(433, 239);
            DEC_roomback14_create(47, 0);
            S_screamer_create(250, 150);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void S_screamer_create(int w, int e) {

        final S_friend chest = new S_friend(getFreeName("s_task2"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void S_task2_create(int w, int e) {

        final s_task2 chest = new s_task2(getFreeName("s_task2"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS7() {


        GameOtherVars.Level = 11;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {

            currentRoom = db.rooms.get("Storyroom7");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 26; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 25; i++) {


                DEC_unviswall_create(xcr, icr, 1);

                icr -= 32;
            }
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);
            DEC_monumet_create(101, 187);
            DEC_monumet_create(131, 187);
            DEC_monumet_create(161, 187);
            DEC_monumet_create(191, 187);
            DEC_monumet_create(221, 187);
            DEC_monumet_create(281, 187);
            DEC_monumet_create(311, 187);
            DEC_roomback14_create(47, 0);
            DEC_tree_create(372, 159, 1);
            DEC_tree_create(572, 543, 1);
            DEC_tree_create(432, 275, 1);
            DEC_tree_create(356, 341, 1);
            DEC_tree_create(234, 532, 1);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void DEC_monumet_create(int w, int e) {

        final Monument chest = new Monument(getFreeName("Monument"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS6() {


        GameOtherVars.Level = 10;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            //db.onGameLoaded(this);
            currentRoom = db.rooms.get("Storyroom6");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 25; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 25; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }
            DEC_unviswall_create(773, -9, 1);
            DEC_unviswall_create(47, -9, 1);
            DEC_roomback14_create(47, 0);
            DEC_tree_create(544, 178, 0);
            DEC_tree_create(658, 398, 1);
            DEC_tree_create(131, 460, 2);
            DEC_tree_create(589, 242, 1);
            DEC_tree_create(645, 310, 2);
            DEC_tree_create(695, 365, 0);
            DEC_tree_create(723, 215, 1);
            DEC_tree_create(695, 250, 2);
            DEC_tree_create(575, 195, 1);
            DEC_tree_create(652, 178, 0);
            DEC_tree_create(581, 122, 2);
            DEC_tree_create(730, 126, 0);
            DEC_tree_create(655,  54, 1);
            DEC_tree_create(545, 59, 2);
            DEC_tree_create(723, 40, 1);
            DEC_tree_create(619, 54, 0);
            DEC_tree_create(172, 729, 2);
            DEC_tree_create(83, 276, 2);
            DEC_rock_create(98, 349);
            DEC_plate_create(405, 466);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void DEC_plate_create(int w, int e) {

        final Plate chest = new Plate(getFreeName("Plate"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_rock_create(int w, int e) {

        final DEC_rock chest = new DEC_rock(getFreeName("DEC_rock"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_tree_create(int w, int e, int g) {

        final DEC_Tree chest = new DEC_Tree(getFreeName("DEC_Tree"));
        chest.TypeTex = g;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        //chest.z = 5;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_cartina_create(int w, int e) {

        final DEC_cartina chest = new DEC_cartina(getFreeName("DEC_cartina"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback14_create(int w, int e) {

        final Roomback_14 chest = new Roomback_14(getFreeName("Roomback_14"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS5() {


        GameOtherVars.Level = 9;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            //db.onGameLoaded(this);
            currentRoom = db.rooms.get("Storyroom5");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 25; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 25; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }
            DEC_roomback11_create(50, 185);
            xcr = 50;
            icr = 182;
            i = 0;
            zex = 0;

            for (i = 0; i <= 21; i++) {


                DEC_unviswall_create(xcr, icr, 0);
                xcr += 32;
            }
            DEC_unviswall_create(742, 182, 0);
            //DEC_unviswall_create(678, 182, 0);
            DEC_roomback12_create(50, 81);
            DEC_roomback13_create(50, 0);
            DEC_door_forr3_create(367, 121);
            S_dec_sing_create(723, 178);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void S_dec_sing_create(int w, int e) {

        final S_dec_sing chest = new S_dec_sing(getFreeName("S_dec_sing"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_door_forr3_create(int w, int e) {

        final Door_forr3 chest = new Door_forr3(getFreeName("Door_forr3"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback13_create(int w, int e) {

        final Roomback_13 chest = new Roomback_13(getFreeName("Roomback_13"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback12_create(int w, int e) {

        final Roomback_12 chest = new Roomback_12(getFreeName("Roomback_12"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback11_create(int w, int e) {

        final Roomback_11 chest = new Roomback_11(getFreeName("Roomback_11"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS4() {


        GameOtherVars.Level = 8;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            //db.onGameLoaded(this);
            currentRoom = db.rooms.get("Storyroom4");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 47;
            int icr = 600;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 25; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            xcr = 773;
            icr = 600;
            i = 0;
            zex = 0;

            for (i = 0; i <= 25; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr -= 32;
            }

            DEC_roomback8_create(50, 389);
            DEC_roomback9_create(50, 211);
            DEC_roomback10_create(50, 0);


            GameOtherVars.IsCreated = 1;
        }


    }
    public void DEC_roomback10_create(int w, int e) {

        final Roomback_10 chest = new Roomback_10(getFreeName("Roomback_10"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback9_create(int w, int e) {

        final Roomback_9 chest = new Roomback_9(getFreeName("Roomback_9"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback8_create(int w, int e) {

        final Roomback_8 chest = new Roomback_8(getFreeName("Roomback_8"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback7_create(int w, int e) {

        final Roomback_7 chest = new Roomback_7(getFreeName("Roomback_7"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_scriptdoor_create(int w, int e) {

        final Door_forr2 chest = new Door_forr2(getFreeName("Door_forr2"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS3() {

        GameOtherVars.Level = 7;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            //db.onGameLoaded(this);

            currentRoom = db.rooms.get("Storymap3");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 269;
            int icr = 0;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 25; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr += 32;
            }
            xcr = 501;
            icr = 0;
            i = 0;
            zex = 0;

            for (i = 0; i <= 25; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr += 32;
            }
            xcr = 272;
            icr = 596;
            i = 0;
            zex = 0;

            for (i = 0; i <= 5; i++) {


                DEC_unviswall_create(xcr, icr, 0);
                xcr += 32;
            }


            xcr = 269;
            icr = 46;
            i = 0;
            zex = 0;

            for (i = 0; i <= 6; i++) {


                DEC_unviswall_create(xcr, icr, 0);
                xcr += 32;
            }
            DEC_unviswall_create(469,46,0);



            DEC_unviswall_create(464, 596, 0);
            DEC_unviswall_create(469, 596, 0);
            DEC_roomback6_create(272, 49);
            DEC_scriptdoor_create(292, 14);
            DEC_roomback7_create(272, 0);
            DEC_crate_create(272, 80);
            DEC_crate_create(475, 35);

            GameOtherVars.IsCreated = 1;
        }


    }
    public void DEC_crate_create(int w, int e) {

        final DEC_crate chest = new DEC_crate(getFreeName("DEC_crate"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS2() {

        GameOtherVars.Level = 6;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            //db.onGameLoaded(this);
            currentRoom = db.rooms.get("Storymap2");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            int xcr = 269;
            int icr = 0;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 25; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr += 32;
            }
            xcr = 501;
            icr = 0;
            i = 0;
            zex = 0;

            for (i = 0; i <= 25; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr += 32;
            }
            xcr = 272;
            icr = 596;
            i = 0;
            zex = 0;

            for (i = 0; i <= 5; i++) {


                DEC_unviswall_create(xcr, icr, 0);
                xcr += 32;
            }
            DEC_unviswall_create(464, 596, 0);
            DEC_unviswall_create(469, 596, 0);
            DEC_roomback6_create(271, 0);
            DEC_door_prop_create(382, 563);
            DEC_cartina_create(291, 287);
            DEC_crate_create(432, 509);
            DEC_crate_create(412, 413);
            DEC_crate_create(425, 351);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void DEC_door_prop_create(int w, int e) {

        final Door_prop chest = new Door_prop(getFreeName("Door_prop"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback6_create(int w, int e) {

        final Roomback_6 chest = new Roomback_6(getFreeName("Roomback_6"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartStory() {

        GameOtherVars.Level = 5;
        GameStoryVars.Story = 1;

        if (GameOtherVars.IsCreated == 0) {
            //db.onGameLoaded(this);
            currentRoom = db.rooms.get("Storymap1");
            db.objects.get("player").visible = true;
            GameOtherVars.AllDelete = 0;

            GameObject.PlayerCanMovie = 0;

            int xcr = 32;
            int icr = 0;
            int i = 0;
            int zex = 0;

            for (i = 0; i <= 12; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr += 32;
            }
            DEC_unviswall_create(32, 386, 1);


            i = 0;
            xcr = 32;
            icr = 768;
            for (i = 0; i <= 24; i++) {


                DEC_unviswall_create(xcr, icr, 0);
                xcr += 32;

            }


            i = 0;
            xcr = 32;
            icr = 128;
            for (i = 0; i <= 22; i++) {


                DEC_unviswall_create(xcr, icr, 0);
                xcr += 32;

            }


            i = 0;
            xcr = 768;
            icr = 0;
            for (i = 0; i <= 12; i++) {


                DEC_unviswall_create(xcr, icr, 1);
                icr += 32;
            }
            DEC_unviswall_create(768, 386, 1);
            DEC_bed_create(742, 190);
            DEC_cupboard_create(724, 75); //433, 131
            DEC_unviswall_create(739, 332, 0);
            DEC_unviswall_create(712, 332, 0);
            DEC_unviswall_create(680, 332, 0);
            DEC_unviswall_create(648, 332, 0);
            DEC_unviswall_create(616, 332, 0);
            DEC_unviswall_create(614, 300, 1);

            DEC_unviswall_create(614, 268, 1);
            DEC_unviswall_create(614, 130, 1);
            //DEC_unviswall_create(614, 204, 1);
            //DEC_unviswall_create(614, 172, 1);
            DEC_unviswall_create(614, 140, 1);
            //DEC_unviswall_create(614, 108, 1);
            //DEC_unviswall_create(614, 76, 1);


            DEC_window_create(465, 61);
            DEC_window_create(570, 61);
            DEC_unviswall_create(433, 131, 1);
            DEC_unviswall_create(433, 163, 1);
            DEC_unviswall_create(433, 195, 1);
            DEC_unviswall_create(433, 227, 1);
            DEC_unviswall_create(433, 259, 1);
            DEC_unviswall_create(433, 387, 1);
            //DEC_unviswall_create(433, 419, 1);



            DEC_unviswall_create(433, 419, 0);
            DEC_unviswall_create(465, 419, 0);
            DEC_unviswall_create(497, 419, 0);
            DEC_unviswall_create(529, 419, 0);
            DEC_unviswall_create(561, 419, 0);
            DEC_window_create(67, 61);
            DEC_window_create(167, 61);
            DEC_window_create(267, 61);
            DEC_window_create(367, 61);

            int xpp = 32;
            for (int u = 0; u<=4; u++)
            {
                DEC_unviswall_create(561+xpp, 419, 0);
                xpp+=32;
            }
            DEC_unviswall_create(739, 419, 0);



            DEC_carpet_create(631, 227);
            DEC_roomback_create(617, 131);
            DEC_roomback_2_create(436, 131);
            DEC_roomback_3_create(616, 335);
            DEC_computer_create(617, 289);
            DEC_board_create(436, 131);
            DEC_dirt_create(629, 79);
            DEC_roomback_4_create(35, 131);
            DEC_roomback_5_create(35, 0);
            DEC_table_create(35, 131);
            DEC_s_task_create(75, 238);
            DEC_door_create(479, 387);
            DEC_cartina2_create(215, 75);
            DEC_crate_create(290, 154);
            DEC_crate_create(240, 169);
            DEC_crate_create(150, 169);
            DEC_crate_create(383, 210);
            DEC_crate_create(253, 212);

            xpp = 32;
            for (int u = 0; u<=15; u++)
            {
                DEC_unviswall_create(561-xpp, 419, 0);
                xpp+=32;
            }
            DEC_unviswall_create(29, 419, 0);
            GameOtherVars.IsCreated = 1;
        }


    }
    public void DEC_cartina2_create(int w, int e) {

        final DEC_cartina2 chest = new DEC_cartina2(getFreeName("DEC_cartina2"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_door_create(int w, int e) {

        final Door chest = new Door(getFreeName("Door"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_s_task_create(int w, int e) {

        final s_task chest = new s_task(getFreeName("Table"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_table_create(int w, int e) {

        final Table chest = new Table(getFreeName("Table"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback_5_create(int w, int e) {

        final Roomback_5 chest = new Roomback_5(getFreeName("Roomback_5"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback_4_create(int w, int e) {

        final Roomback_4 chest = new Roomback_4(getFreeName("Roomback_4"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_dirt_create(int w, int e) {

        final Dirt chest = new Dirt(getFreeName("Dirt"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_board_create(int w, int e) {

        final Board chest = new Board(getFreeName("Board"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_computer_create(int w, int e) {

        final Computer chest = new Computer(getFreeName("Computer"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback_3_create(int w, int e) {

        final Roomback_3 chest = new Roomback_3(getFreeName("Roomback_3"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback_2_create(int w, int e) {

        final Roomback_2 chest = new Roomback_2(getFreeName("Roomback_2"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback_create(int w, int e) {

        final Roomback_1 chest = new Roomback_1(getFreeName("Roomback_1"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_carpet_create(int w, int e) {

        final Carpet chest = new Carpet(getFreeName("Carpet"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_window_create(int w, int e) {

        final Window chest = new Window(getFreeName("Window"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_cupboard_create(int w, int e) {

        final Cupboard chest = new Cupboard(getFreeName("Cupboard"));
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_unviswall_create(int w, int e, int t) {

        final UnVisWall chest = new UnVisWall(getFreeName("UnVisWall"));
        chest.Type = t;
        int wardenx = w;
        int wardeny = e;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.x = wardenx;
        chest.y = wardeny;
        chest.xt = wardenx;
        chest.yt = wardeny;
        chest.UseRoom = currentRoom;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_bed_create(int w, int e) {

        final Bed chest = new Bed(getFreeName("Bed"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }



    public void Get_4_level() {

        GameOtherVars.Level = 4;
        if (GameObject.plx >= 900 || GameObject.plx >= 900) {
            GameOtherVars.Restart_type = 4;
            GameOtherVars.AllDelete  =1;
        }
        if (GameObject.plx <= -10 || GameObject.plx <= -10) {
            GameOtherVars.Restart_type = 4;
            GameOtherVars.AllDelete  =1;
        }
        if (GameObject.ply >= 900 || GameObject.ply >= 900) {
            GameOtherVars.Restart_type = 4;
            GameOtherVars.AllDelete  =1;
        }
        if (GameObject.ply <= -10 || GameObject.ply <= -10) {
            GameOtherVars.Restart_type = 4;
            GameOtherVars.AllDelete  =1;
        }
        if (GameOtherVars.IsCreated == 0) {
            GameOtherVars.AllDelete = 0;
            //db.onGameLoaded(this);
            GameObject.PlayerCanMovie = 0;

            currentRoom = db.rooms.get("map4_room");
            db.objects.get("player").visible = true;

            GameOtherVars.IsCreated = 1;




            if (KeyMessage.Created == 0) {
                KeyMessage.AnimStep = 0;
                MessageAkey_create();
                KeyMessage.Created = 1;

            }


            AppleCreate(50, 50);


            AppleGet(1, 1, 65, 65);
            AppleGet(0, 1, 65, 65);
            AppleGet(1, 0, 65, 65);
            AppleGet(0, 0, 65, 65);

            AppleGet(1, 1, 95, 95);
            AppleGet(0, 1, 95, 95);
            AppleGet(1, 0, 95, 95);
            AppleGet(0, 0, 95, 95);

            AppleGet(1, 1, 143, 145);
            AppleGet(0, 1, 123, 23);
            AppleGet(1, 0, 345, 124);
            AppleGet(1, 1, 213, 53);

            DieLogoCreate();
            WinLogoCreate();


            NPC_AppleW_create(1);
            NPC_AppleW_create(0);
            NPC_AppleW_create(1);

            NPC_Deamon_create();
            NPC_Deamon_create();
            NPC_Deamon_create();

            NPC_Lavaman_create();
            OBJ_APL_Portal_create();

            NPC_Ant_create();
            NPC_Ant_create();
            NPC_Healthbar_create();
            NPC_Blueman_create();

            Maslo_create();
            Maslo_create();
            Maslo_create();
            NPC_MegaBear_create();
            NPC_ChinaMAN_create();
            NPC_Bandit_create();
            NPC_MoMo_create();
            NPC_Bananar_create();
            if (GameOtherVars.Biome_type == 1) {
                Tree_create();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
            } if (GameOtherVars.Biome_type == 2) {
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();

                DEC_spruce_create();

                NPC_Present_create();
                NPC_Present_create();

                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_GoblinMaster_create();
                NPC_GoblinMaster_create();
                Snowbug_create();
                Snowbug_create();
                Snowbug_create();
            }
            if (GameOtherVars.Biome_type == 3)
            {
                Cactus_create();
                Rock_create();
                Pesokman_create();
                MonsterCactus_create();

            }
            if (GameOtherVars.Biome_type == 4)
            {
                Ship_create();

                Inoplanetanin_create();
                Tarakan_create();
                Sphuyna_create();

            }
            if (GameOtherVars.Biome_type == 5)
            {
                rad_dec_create();
                Zombie_create();


            }
            if (GameOtherVars.Biome_type == 6)
            {
                Soul_create();
                Mag_create();


            }


            NPC_Shlakoblock_create();
            Card_create();
            Card_create();
            Card_create();
            eff_bil_create();
            NPC_Bananas_create();
            NPC_HoMonster_create();
            NPC_Shlakoblock_create();
            NPC_EvilWorm_create();
            NPC_EvilWorm_create();
            NPC_EvilWorm_create();
            NPC_HoMonster_create();
            NPC_IRT_create();
            NPC_IRT_create();

            NPC_Slim_create();
            NPC_Alpinos_create();
            NPC_Tres_create();
            NPC_Healthbar_create();
            NPC_SantaDemon_create();
            NPC_Bananas_create();
            NPC_BrainWater_create();



            NPC_Present_create();
            NPC_Present_create();
            Bottle_create();
            Hacker_create();
            Mandarinka_create();
            Weed_create();
        }

        if (GameOtherVars.WinVisible == 1) {
            if (GameOtherVars.WinTimer <= 0) {
                GameOtherVars.AllDelete = 1;
                GameOtherVars.WinTimer = 15;
            } else {
                GameOtherVars.WinTimer--;
            }
        }
        if (GameOtherVars.AppleCreate == 0) {
            NPC_Deamon_create();
            GameOtherVars.AppleCreate = 1;
        }
        if (GameOtherVars.BluemanCreated == 0) {
            NPC_Blueman_create();
            GameOtherVars.BluemanCreated = 1;
        }
        if (GameOtherVars.RatCreated == 0) {

            GameOtherVars.RatCreated = 1;
        }
        if (GameOtherVars.NWY_Present_create == 0)
        {
            NPC_Present_create(GameOtherVars.SantaX, GameOtherVars.SantaY);
            GameOtherVars.NWY_Present_create = 1;
        }
        if (GameOtherVars.Shlakoblock_create  == 0)
        {
            NPC_Shlakoblock_create();
            GameOtherVars.Shlakoblock_create = 1;
        }
        if (GameOtherVars.DedMoroz_create  == 0)
        {
            NPC_NWY_Ded_Moroz_create();
            GameOtherVars.DedMoroz_create = 1;
        }
        if (GameOtherVars.Maslo_Create  == 0)
        {

            GameOtherVars.Maslo_Create = 0;
        }
        if (GameOtherVars.CardCreate  == 0)
        {
            Card_create();
            GameOtherVars.CardCreate = 1;
        }
        if (GameOtherVars.Bananar_bad > 0)
        {
            GameOtherVars.Bananar_bad--;
            NPC_Bananar_create();
        }

    }
    public void Get_start_location_3() {
        GameOtherVars.Level = 3;
        if (GameOtherVars.IsCreated == 0) {
            //db.onGameLoaded(this);
            GameOtherVars.AllDelete = 0;
            GameOtherVars.BeforeMain = 1;

            GameObject.PlayerCanMovie = 0;

            currentRoom = db.rooms.get("map3_room");
            db.objects.get("player").visible = true;
            GameOtherVars.IsCreated = 1;
            int xcr = 0;
            int icr = 0;
            int i = 0;
            int zex = 0;
            for (i = 0; i < 5; i++) {
                Crate_create(xcr, icr, zex);
                xcr += 32;

            }
            Mdoor_create(160,icr, 2);
            xcr = xcr + 128;
            icr = 0;
            i = 0;
            zex = 0;
            for (i = 0; i < 20; i++) {
                Crate_create(xcr, icr, zex);
                xcr += 32;

            }
            i = 0;
            xcr = 0;
            icr = 0;

            for (i = 0; i <= 25; i++) {

                icr += 32;
                zex+= 32;
                Crate_create(xcr, icr, zex);
            }
            i = 0;
            xcr = 32;
            icr = 580;
            zex = 0;
            for ( i = 0; i <= 25; i++) {


                xcr+=32;

                Crate_create(xcr, icr, zex);
            }


            i = 0;
            xcr = 0;

            for (i = 0; i <= 23; i++) {

                xcr += 32;
                Crate_create(xcr, icr, zex);
                zex += 32;
            }


            i = 0;
            xcr = 768;
            icr = 0;

            for (i = 0; i <= 25; i++) {


                Crate_create(xcr, icr, zex);
                icr += 32;
                zex += 32;
            }




            i = 0;
            xcr = 0;
            //icr = 0;
            for (i = 0; i <= 25; i++) {

                xcr += 32;
                Crate_create(xcr, icr, zex);
            }


            i = 0;
            xcr = 32;
            icr = 768;
            for (i = 0; i <= 24; i++) {


                Crate_create(xcr, icr, zex);
                xcr += 32;
            }



            if (KeyMessage.Created == 0) {
                KeyMessage.AnimStep = 0;
                MessageAkey_create();
                KeyMessage.Created = 1;

            }


            AppleCreate(50, 50);


            AppleGet(1, 1, 65, 65);
            AppleGet(0, 1, 65, 65);
            AppleGet(1, 0, 65, 65);
            AppleGet(0, 0, 65, 65);

            AppleGet(1, 1, 95, 95);
            AppleGet(0, 1, 95, 95);
            AppleGet(1, 0, 95, 95);
            AppleGet(0, 0, 95, 95);

            AppleGet(1, 1, 143, 145);
            AppleGet(0, 1, 123, 23);
            AppleGet(1, 0, 345, 124);
            AppleGet(1, 1, 213, 53);

            DieLogoCreate();
            WinLogoCreate();

            NPC_Ant_create();
            NPC_Ant_create();

            Maslo_create();
            Maslo_create();
            Maslo_create();
            if (GameOtherVars.Biome_type == 1) {
                Tree_create();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
            } if (GameOtherVars.Biome_type == 2) {
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();

                DEC_spruce_create();

                Snowbug_create();
                Snowbug_create();
                Snowbug_create();

            }
            if (GameOtherVars.Biome_type == 3)
            {
                Cactus_create();
                Rock_create();
                Pesokman_create();
                MonsterCactus_create();

            }
            if (GameOtherVars.Biome_type == 4)
            {
                Ship_create();
                Inoplanetanin_create();
                Tarakan_create();
                Sphuyna_create();
                //Rock_create();

            }
            if (GameOtherVars.Biome_type == 5)
            {
                rad_dec_create();
                Zombie_create();
                //Rock_create();
                //Inoplanetanin_create();

            }
            if (GameOtherVars.Biome_type == 6)
            {
                Soul_create();
                Mag_create();


            }
            NPC_GoblinMaster_create();
            NPC_GoblinMaster_create();
            NPC_HoMonster_create();
            NPC_Shlakoblock_create();
            NPC_EvilWorm_create();
            NPC_EvilWorm_create();
            NPC_EvilWorm_create();
            NPC_HoMonster_create();
            NPC_IRT_create();
            NPC_IRT_create();

            NPC_Slim_create();
            NPC_Alpinos_create();
            NPC_Tres_create();
            NPC_Healthbar_create();
            NPC_SantaDemon_create();
            NPC_Bananas_create();
            Bottle_create();
            Hacker_create();
            Mandarinka_create();
            Weed_create();

        }

        if (GameOtherVars.WinVisible == 1) {
            if (GameOtherVars.WinTimer <= 0) {
                GameOtherVars.AllDelete = 1;
                GameOtherVars.WinTimer = 15;
            } else {
                GameOtherVars.WinTimer--;
            }
        }
        if (GameOtherVars.AppleCreate == 0) {
            NPC_Deamon_create();
            GameOtherVars.AppleCreate = 1;
        }
        if (GameOtherVars.BluemanCreated == 0) {
            NPC_Blueman_create();
            GameOtherVars.BluemanCreated = 1;
        }
        if (GameOtherVars.RatCreated == 0) {

            GameOtherVars.RatCreated = 1;
        }

        if (GameOtherVars.NWY_Present_create == 0)
        {
            NPC_Present_create(GameOtherVars.SantaX, GameOtherVars.SantaY);
            GameOtherVars.NWY_Present_create = 1;
        }
        if (GameOtherVars.Shlakoblock_create  == 0)
        {
            NPC_Shlakoblock_create();
            GameOtherVars.Shlakoblock_create = 1;
        }
        if (GameOtherVars.DedMoroz_create  == 0)
        {
            NPC_NWY_Ded_Moroz_create();
            GameOtherVars.DedMoroz_create = 1;
        }
        if (GameOtherVars.Maslo_Create  == 0)
        {

            GameOtherVars.Maslo_Create = 0;
        }
        if (GameOtherVars.CardCreate  == 0) {
            Card_create();
            GameOtherVars.CardCreate = 1;
        }
        if (GameOtherVars.Snow_create  == 0)
        {
            NPC_Snow_create();
            GameOtherVars.Snow_create = 1;
        }
    }
    public void NPC_SantaDemon_create() {
        int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        if (ui == 1) {
            final SantaDemon chest = new SantaDemon(getFreeName("SantaDemon"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            chest.UseRoom = currentRoom;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            NPC_SantaDemon_create();

        }
    }
    public void NPC_Healthbar_create() {

        final Healthbar chest = new Healthbar(getFreeName("Healthbar"));

        chest.x = 32;
        chest.y = 32;

        chest.UseRoom = currentRoom;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);

    }
    public void NPC_Snow_create() {

        final Gun chest = new Gun(getFreeName("Gun"));

        chest.x = GameOtherVars.Snow_x;
        chest.y = GameOtherVars.Snow_y;
        chest.xt = GameOtherVars.Snow_x;
        chest.yt = GameOtherVars.Snow_y;
        chest.MST = GameOtherVars.Snow_MST;
        chest.UseRoom = currentRoom;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void NPC_Tres_create() {
        int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        if (ui == 1) {
            final Tres chest = new Tres(getFreeName("Tres"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            chest.UseRoom = currentRoom;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            NPC_Tres_create();

        }
    }
    public void NPC_Alpinos_create() {
        int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        if (ui == 1) {
            final Alpinos chest = new Alpinos(getFreeName("Alpinos"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            chest.UseRoom = currentRoom;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            NPC_Alpinos_create();

        }
    }
    public void NPC_Slim_create() {
        int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        if (ui == 1) {
            final Slim chest = new Slim(getFreeName("Slim"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            chest.UseRoom = currentRoom;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            NPC_Slim_create();

        }
    }









    public void Get_start_location_2() {
        GameOtherVars.Level = 2;
        if (GameOtherVars.IsCreated == 0) {

            GameOtherVars.AllDelete = 0;
            GameOtherVars.BeforeMain = 1;
            //db.onGameLoaded(this);
            GameObject.PlayerCanMovie = 0;
            currentRoom = db.rooms.get("map2_room");
            db.objects.get("player").visible = true;
            GameOtherVars.IsCreated = 1;
            int xcr = 0;
            int icr = 0;
            int i = 0;
            int zex = 0;
            for (i = 0; i < 25; i++) {
                Crate_create(xcr, icr, zex);
                xcr += 32;

            }


            i = 0;
            xcr = 0;
            icr = 0;

            for (i = 0; i <= 10; i++) {

                icr += 32;
                Crate_create(xcr, icr, zex);
            }


            i = 0;
            xcr = 0;
            icr = icr + 128;
            for (i = 0; i <= 2; i++) {

                icr += 32;
                Crate_create(xcr, icr, zex);
            }

            i = 0;
            xcr = 0;

            for (i = 0; i <= 23; i++) {

                xcr += 32;
                Crate_create(xcr, icr, zex);
                zex += 32;
            }


            i = 0;
            xcr = 768;
            icr = 0;
            for (i = 0; i <= 22; i++) {

                icr += 32;
                Crate_create(xcr, icr, zex);
            }

            Mdoor_create(0, 384, 1);
            if (KeyMessage.Created == 0) {
                KeyMessage.AnimStep = 0;
                MessageAkey_create();
                KeyMessage.Created = 1;

            }


            AppleCreate(50, 50);


            AppleGet(1, 1, 65, 65);
            AppleGet(0, 1, 65, 65);
            AppleGet(1, 0, 65, 65);
            AppleGet(0, 0, 65, 65);

            AppleGet(1, 1, 95, 95);
            AppleGet(0, 1, 95, 95);
            AppleGet(1, 0, 95, 95);
            AppleGet(0, 0, 95, 95);

            AppleGet(1, 1, 143, 145);
            AppleGet(0, 1, 123, 23);
            AppleGet(1, 0, 345, 124);
            AppleGet(1, 1, 213, 53);

            DieLogoCreate();
            WinLogoCreate();


            NPC_Ant_create();
            NPC_Ant_create();

            Maslo_create();
            Maslo_create();
            Maslo_create();
            if (GameOtherVars.Biome_type == 1) {
                Tree_create();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
            } if (GameOtherVars.Biome_type == 2) {
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();

                DEC_spruce_create();

                Snowbug_create();
                Snowbug_create();
                Snowbug_create();
                Hacker_create();

            }
            if (GameOtherVars.Biome_type == 3)
            {
                Cactus_create();
                Rock_create();
                Pesokman_create();
                MonsterCactus_create();

            }
            if (GameOtherVars.Biome_type == 4)
            {
                Ship_create();
                Inoplanetanin_create();
                Sphuyna_create();
                Tarakan_create();
                //Rock_create();

            }
            if (GameOtherVars.Biome_type == 5)
            {
                rad_dec_create();
                Zombie_create();


            }
            if (GameOtherVars.Biome_type == 6)
            {
                Soul_create();
                Mag_create();


            }
            NPC_GoblinMaster_create();
            NPC_GoblinMaster_create();
            NPC_HoMonster_create();
            NPC_Shlakoblock_create();
            NPC_EvilWorm_create();
            NPC_EvilWorm_create();
            NPC_EvilWorm_create();
            NPC_HoMonster_create();
            NPC_IRT_create();
            NPC_IRT_create();

            NPC_BrainWater_create();
            Card_create();
            Card_create();
            Card_create();
            eff_bil_create();
            NPC_TNT_create();
            NPC_Healthbar_create();
            NPC_InfectGoblin_create();
            NPC_Bananas_create();
            Bottle_create();
            Mandarinka_create();
            Weed_create();

        }

        if (GameOtherVars.WinVisible == 1) {
            if (GameOtherVars.WinTimer <= 0) {
                GameOtherVars.AllDelete = 1;
                GameOtherVars.WinTimer = 15;
            } else {
                GameOtherVars.WinTimer--;
            }
        }
        if (GameOtherVars.AppleCreate == 0) {
            NPC_Deamon_create();
            GameOtherVars.AppleCreate = 1;
        }
        if (GameOtherVars.BluemanCreated == 0) {
            NPC_Blueman_create();
            GameOtherVars.BluemanCreated = 1;
        }
        if (GameOtherVars.RatCreated == 0) {

            GameOtherVars.RatCreated = 1;
        }

        if (GameOtherVars.Shlakoblock_create  == 0)
        {
            NPC_Shlakoblock_create();
            GameOtherVars.Shlakoblock_create = 1;
        }
        if (GameOtherVars.DedMoroz_create  == 0)
        {
            NPC_NWY_Ded_Moroz_create();
            GameOtherVars.DedMoroz_create = 1;
        }
        if (GameOtherVars.Maslo_Create  == 0)
        {

            GameOtherVars.Maslo_Create = 0;
        }

    }
    public void NPC_InfectGoblin_create() {
        int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        if (ui == 1) {
            final InfectGoblin chest = new InfectGoblin(getFreeName("InfectGoblin"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            chest.UseRoom = currentRoom;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            NPC_InfectGoblin_create();

        }
    }
    public void NPC_TNT_create() {


        final TNT chest = new TNT(getFreeName("TNT"));
        int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
        int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));

        chest.x = wardenx;
        chest.y = wardeny;
        chest.xt = wardenx;
        chest.yt = wardeny;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);

    }
    public void NPC_BrainWater_create() {
        int ui = 1 + (int) +(Math.random() * ((5 - 1) + 1));
        if (ui == 1) {
            final BrainWater chest = new BrainWater(getFreeName("BrainWater"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            chest.UseRoom = currentRoom;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
        if (ui == 1) {
            ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
            if (ui == 1) {
                final BrainWater chest = new BrainWater(getFreeName("BrainWater"));
                int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
                int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
                chest.x = wardenx;
                chest.y = wardeny;
                chest.xt = wardenx;
                chest.yt = wardeny;
                chest.UseRoomInt = GameOtherVars.RoomNow;
                chest.UseRoom = currentRoom;
                db.objects.put(chest.name, chest);
                currentRoom.objectsIDs.add(chest.name);


            }
        }
        if (ui == 1) {
            ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
            if (ui == 1) {
                final BrainWater chest = new BrainWater(getFreeName("BrainWater"));
                int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
                int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
                chest.x = wardenx;
                chest.y = wardeny;
                chest.xt = wardenx;
                chest.yt = wardeny;
                chest.UseRoomInt = GameOtherVars.RoomNow;
                chest.UseRoom = currentRoom;
                db.objects.put(chest.name, chest);
                currentRoom.objectsIDs.add(chest.name);


            }
        }
        if (ui == 1) {
            ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
            if (ui == 1) {
                final BrainWater chest = new BrainWater(getFreeName("BrainWater"));
                int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
                int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
                chest.x = wardenx;
                chest.y = wardeny;
                chest.xt = wardenx;
                chest.yt = wardeny;
                chest.UseRoomInt = GameOtherVars.RoomNow;
                chest.UseRoom = currentRoom;
                db.objects.put(chest.name, chest);
                currentRoom.objectsIDs.add(chest.name);


            }
        }
    }
    public void OBJ_APL_Snow_create() {
        //int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        //if (ui == 2) {
        final Snow chest = new Snow(getFreeName("Snow"));
        int wardenx = 0;
        int wardeny = 0;
        chest.x = wardenx;
        chest.y = wardeny;
        chest.UseRoom = currentRoom;
        chest.z = 400;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);
        //}
    }
    public void NPC_IRT_create() {
        int ui = 1 + (int) +(Math.random() * ((4 - 1) + 1));
        if (ui == 1) {
            final IRT chest = new IRT(getFreeName("IRT"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 5;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }
    public void NPC_EvilWorm_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final EvilWorm chest = new EvilWorm(getFreeName("Worm"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 5;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }
    public void NPC_HoMonster_create() {
        int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        if (ui == 1) {
            final HoMonster chest = new HoMonster(getFreeName("HoMonster"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 5;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }
    public void Get_Start() {

        GameOtherVars.Level = 1;

        if (GameOtherVars.IsCreated == 0) {
            //MainTheme.Load("C:\\Users\\Nickita\\DownloadsDeep_Purple-Burn.wav");
            //MainTheme.
            //MainTheme.play();
            GameOtherVars.AllDelete = 0;
            //db.onGameLoaded(this);
            GameObject.PlayerCanMovie = 0;
            currentRoom = db.rooms.get("map1_room");
            db.objects.get("player").visible = true;
            GameOtherVars.IsCreated = 1;
            int xcr = 0;
            int icr = 0;
            int i = 0;
            int zex = 0;
            for (i = 0; i < 25; i++) {
                Crate_create(xcr, icr, zex);
                xcr += 32;
                zex += 32;
            }


            i = 0;
            xcr = 0;
            icr = 0;

            for (i = 0; i <= 10; i++) {

                icr += 32;
                Crate_create(xcr, icr, zex);
            }


            i = 0;
            xcr = 0;
            icr = icr + 128;
            for (i = 0; i <= 2; i++) {

                icr += 32;
                Crate_create(xcr, icr, zex);
            }

            i = 0;
            xcr = 0;

            for (i = 0; i <= 23; i++) {

                xcr += 32;
                Crate_create(xcr, icr, zex);
                zex += 32;
            }


            i = 0;
            xcr = 768;
            icr = 0;
            for (i = 0; i <= 22; i++) {

                icr += 32;
                Crate_create(xcr, icr, zex);
            }

            Mdoor_create(0, 384, 1);
            if (KeyMessage.Created == 0) {
                KeyMessage.AnimStep = 0;
                MessageAkey_create();
                KeyMessage.Created = 1;

            }


            AppleCreate(50, 50);


            AppleGet(1, 1, 65, 65);
            AppleGet(0, 1, 65, 65);
            AppleGet(1, 0, 65, 65);
            AppleGet(0, 0, 65, 65);

            AppleGet(1, 1, 95, 95);
            AppleGet(0, 1, 95, 95);
            AppleGet(1, 0, 95, 95);
            AppleGet(0, 0, 95, 95);

            AppleGet(1, 1, 143, 145);
            AppleGet(0, 1, 123, 23);
            AppleGet(1, 0, 345, 124);
            AppleGet(1, 1, 213, 53);

            DieLogoCreate();
            WinLogoCreate();


            NPC_AppleW_create(1);
            NPC_AppleW_create(0);
            NPC_AppleW_create(1);

            NPC_Deamon_create();
            NPC_Deamon_create();
            NPC_Deamon_create();

            NPC_Lavaman_create();
            OBJ_APL_Portal_create();

            NPC_Ant_create();
            NPC_Ant_create();
            NPC_Healthbar_create();
            NPC_Blueman_create();

            Maslo_create();
            Maslo_create();
            Maslo_create();
            NPC_MegaBear_create();
            NPC_ChinaMAN_create();
            NPC_Bandit_create();
            NPC_MoMo_create();
            NPC_Bananar_create();
            if (GameOtherVars.Biome_type == 1) {
                Tree_create();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
                DEC_EarthCreate();
            } if (GameOtherVars.Biome_type == 2) {
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();

                DEC_spruce_create();

                NPC_Present_create();
                NPC_Present_create();

                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_Goblin_create();
                NPC_GoblinMaster_create();
                NPC_GoblinMaster_create();
                Snowbug_create();
                Snowbug_create();
                Snowbug_create();
            }
            if (GameOtherVars.Biome_type == 3)
            {
                Cactus_create();
                Rock_create();
                Pesokman_create();
                MonsterCactus_create();

            }
            if (GameOtherVars.Biome_type == 4)
            {
                Ship_create();

                Inoplanetanin_create();
                Tarakan_create();
                Sphuyna_create();

            }
            if (GameOtherVars.Biome_type == 5)
            {
                rad_dec_create();
                Zombie_create();


            }
            if (GameOtherVars.Biome_type == 6)
            {
                Soul_create();
                Mag_create();


            }

            NPC_Shlakoblock_create();
            Card_create();
            Card_create();
            Card_create();
            eff_bil_create();
            NPC_Bananas_create();


            NPC_Present_create();
            NPC_Present_create();
            Bottle_create();
            Hacker_create();
            Mandarinka_create();
            Weed_create();
        }

        if (GameOtherVars.WinVisible == 1) {
            if (GameOtherVars.WinTimer <= 0) {
                GameOtherVars.AllDelete = 1;
                GameOtherVars.WinTimer = 15;
            } else {
                GameOtherVars.WinTimer--;
            }
        }
        if (GameOtherVars.AppleCreate == 0) {
            NPC_Deamon_create();
            GameOtherVars.AppleCreate = 1;
        }
        if (GameOtherVars.BluemanCreated == 0) {
            NPC_Blueman_create();
            GameOtherVars.BluemanCreated = 1;
        }
        if (GameOtherVars.RatCreated == 0) {

            GameOtherVars.RatCreated = 1;
        }
        if (GameOtherVars.NWY_Present_create == 0)
        {
            NPC_Present_create(GameOtherVars.SantaX, GameOtherVars.SantaY);
            GameOtherVars.NWY_Present_create = 1;
        }
        if (GameOtherVars.Shlakoblock_create  == 0)
        {
            NPC_Shlakoblock_create();
            GameOtherVars.Shlakoblock_create = 1;
        }
        if (GameOtherVars.DedMoroz_create  == 0)
        {
            NPC_NWY_Ded_Moroz_create();
            GameOtherVars.DedMoroz_create = 1;
        }
        if (GameOtherVars.Maslo_Create  == 0)
        {

            GameOtherVars.Maslo_Create = 0;
        }
        if (GameOtherVars.CardCreate  == 0)
        {
            Card_create();
            GameOtherVars.CardCreate = 1;
        }
        if (GameOtherVars.Bananar_bad > 0)
        {
            GameOtherVars.Bananar_bad--;
            NPC_Bananar_create();
        }

    }
    public void Weed_create() {
        int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        if (ui == 1) {
            final Weed chest = new Weed(getFreeName("Weed"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = chest.yt+18;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Weed_create();

        }
    }
    public void Mandarinka_create() {
        int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        if (ui == 1) {
            final Mandarinka chest = new Mandarinka(getFreeName("Mandarinka"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Mandarinka_create();

        }
    }
    public void Hacker_create() {
        int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        if (ui == 1) {
            final Hacker chest = new Hacker(getFreeName("Hacker"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            chest.UseRoom = currentRoom;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Hacker_create();

        }
    }
    public void Bottle_create() {
        int ui = 1 + (int) +(Math.random() * ((4 - 1) + 1));
        if (ui == 1) {
            final Bottle chest = new Bottle(getFreeName("Bottle"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = chest.yt+1;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Bottle_create();

        }
    }
    public void Soul_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Soul chest = new Soul(getFreeName("Soul"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = chest.yt+17;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Soul_create();

        }
    }
    public void Snowbug_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Snowbug chest = new Snowbug(getFreeName("Snowbug"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = chest.yt+5;
            chest.UseRoom = currentRoom;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Snowbug_create();

        }
    }
    public void Zombie_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Radiation_zombie chest = new Radiation_zombie(getFreeName("Radiation_zombie"));

            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            chest.UseRoom = currentRoom;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Zombie_create();

        }
    }
    public void Tarakan_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Tarakan chest = new Tarakan(getFreeName("Tarakan"));

            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Tarakan_create();

        }
    }
    public void rad_dec_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Radiation chest = new Radiation(getFreeName("Radiation"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = chest.yt+15;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            rad_dec_create();

        }
    }
    public void MonsterCactus_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final MonsterCactus chest = new MonsterCactus(getFreeName("MonsterCactus"));

            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            MonsterCactus_create();

        }
    }
    public void Pesokman_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Pesokman chest = new Pesokman(getFreeName("Pesokman"));

            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            //chest.z = chest.yt+60;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Pesokman_create();

        }
    }
    public void Inoplanetanin_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Inoplanetanin chest = new Inoplanetanin(getFreeName("Inoplanetanin"));

            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Inoplanetanin_create();

        }
    }
    public void Ship_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final SpaceShip chest = new SpaceShip(getFreeName("Ship"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = chest.yt+26;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Ship_create();

        }
    }
    public void NPC_Bananas_create_nrdm() {

        final Bananas chest = new Bananas(getFreeName("Bananas"));
        int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
        int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
        chest.x = wardenx;
        chest.y = wardeny;
        chest.xt = wardenx;
        chest.yt = wardeny;
        chest.UseRoom = currentRoom;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void NPC_Bananas_create() {
        int ui = 1 + (int) +(Math.random() * ((15 - 1) + 1));
        if (ui == 1) {
            final Bananas chest = new Bananas(getFreeName("Bananas"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);

            NPC_Bananas_create_nrdm();
            NPC_Bananas_create_nrdm();
            NPC_Bananas_create();
        }
    }
    public void Sphuyna_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Sphuyna chest = new Sphuyna(getFreeName("Sphuyna"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = chest.yt+110;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Sphuyna_create();

        }
    }
    public void Mag_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Magilla chest = new Magilla(getFreeName("Magilla"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = chest.yt+15;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Mag_create();

        }
    }
    public void Rock_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Rock chest = new Rock(getFreeName("Rock"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = chest.yt+4;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Rock_create();

        }
    }
    public void Cactus_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Cactus chest = new Cactus(getFreeName("Cactus"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = chest.yt+30;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Cactus_create();

        }
    }
    public void Tree_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Tree chest = new Tree(getFreeName("Tree"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = chest.yt+105;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            Tree_create();

        }
    }
    public void eff_bil_create() {

        final blindness chest = new blindness(getFreeName("blindness"));
        int wardenx =0;
        int wardeny =0;
        chest.x = 0;
        chest.y = 0;
        chest.UseRoom = currentRoom;
        chest.z = 15000000;
        chest.UseRoom = currentRoom;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void Card_create() {
        int ui = 1 + (int) +(Math.random() * ((5 - 1) + 1));
        if (ui == 1) {
            final Card chest = new Card(getFreeName("Card"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }
    public void NPC_Bananar_create() {
        int ui = 1 + (int) +(Math.random() * ((7 - 1) + 1));
        if (ui == 1) {
            final Bananar chest = new Bananar(getFreeName("Bananar"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
        if (ui == 1) {
            ui = 1 + (int) +(Math.random() * ((4 - 1) + 1));
            if (ui == 1) {
                final Bananar chest = new Bananar(getFreeName("Bananar"));
                int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
                int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
                chest.x = wardenx;
                chest.y = wardeny;
                chest.xt = wardenx;
                chest.yt = wardeny;
                chest.UseRoom = currentRoom;
                chest.UseRoomInt = GameOtherVars.RoomNow;
                db.objects.put(chest.name, chest);
                currentRoom.objectsIDs.add(chest.name);


            }
        }
        if (ui == 1) {
            ui = 1 + (int) +(Math.random() * ((4 - 1) + 1));
            if (ui == 1) {
                final Bananar chest = new Bananar(getFreeName("Bananar"));
                int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
                int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
                chest.x = wardenx;
                chest.y = wardeny;
                chest.xt = wardenx;
                chest.yt = wardeny;
                //chest.z = 5;
                chest.UseRoom = currentRoom;
                chest.UseRoomInt = GameOtherVars.RoomNow;
                db.objects.put(chest.name, chest);
                currentRoom.objectsIDs.add(chest.name);


            }
        }
    }
    public void NPC_MoMo_create() {
        int ui = 1 + (int) +(Math.random() * ((6 - 1) + 1));
        if (ui == 1) {
            final MoMo chest = new MoMo(getFreeName("MoMo"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
        if (ui == 1) {
            ui = 1 + (int) +(Math.random() * ((4 - 1) + 1));
            if (ui == 1) {
                final MoMo chest = new MoMo(getFreeName("MoMo"));
                int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
                int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
                chest.x = wardenx;
                chest.y = wardeny;
                chest.xt = wardenx;
                chest.yt = wardeny;
                chest.UseRoom = currentRoom;
                chest.UseRoomInt = GameOtherVars.RoomNow;
                db.objects.put(chest.name, chest);
                currentRoom.objectsIDs.add(chest.name);


            }
        }
        if (ui == 1) {
            ui = 1 + (int) +(Math.random() * ((4 - 1) + 1));
            if (ui == 1) {
                final MoMo chest = new MoMo(getFreeName("MoMo"));
                int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
                int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
                chest.x = wardenx;
                chest.y = wardeny;
                chest.xt = wardenx;
                chest.yt = wardeny;
                chest.UseRoom = currentRoom;
                chest.UseRoomInt = GameOtherVars.RoomNow;
                db.objects.put(chest.name, chest);
                currentRoom.objectsIDs.add(chest.name);


            }
        }
    }
    public void NPC_Bandit_create() {
        int ui = 1 + (int) +(Math.random() * ((5 - 1) + 1));
        if (ui == 1) {
            final Bandit chest = new Bandit(getFreeName("Bandit"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
        if (ui == 1) {
            ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
            if (ui == 1) {
                final Bandit chest = new Bandit(getFreeName("Bandit"));
                int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
                int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
                chest.x = wardenx;
                chest.y = wardeny;
                chest.xt = wardenx;
                chest.yt = wardeny;
                chest.UseRoom = currentRoom;
                chest.UseRoomInt = GameOtherVars.RoomNow;
                db.objects.put(chest.name, chest);
                currentRoom.objectsIDs.add(chest.name);


            }
        }
        if (ui == 1) {
            ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
            if (ui == 1) {
                final Bandit chest = new Bandit(getFreeName("Bandit"));
                int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
                int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
                chest.x = wardenx;
                chest.y = wardeny;
                chest.xt = wardenx;
                chest.yt = wardeny;
                chest.UseRoom = currentRoom;
                chest.UseRoomInt = GameOtherVars.RoomNow;
                db.objects.put(chest.name, chest);
                currentRoom.objectsIDs.add(chest.name);


            }
        }
        if (ui == 1) {
            ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
            if (ui == 1) {
                final Bandit chest = new Bandit(getFreeName("Bandit"));
                int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
                int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
                chest.x = wardenx;
                chest.y = wardeny;
                chest.xt = wardenx;
                chest.yt = wardeny;
                chest.UseRoom = currentRoom;
                chest.UseRoomInt = GameOtherVars.RoomNow;
                db.objects.put(chest.name, chest);
                currentRoom.objectsIDs.add(chest.name);


            }
        }
        if (ui == 1) {
            ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
            if (ui == 1) {
                final Bandit chest = new Bandit(getFreeName("Bandit"));
                int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
                int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
                chest.x = wardenx;
                chest.y = wardeny;
                chest.xt = wardenx;
                chest.yt = wardeny;
                chest.UseRoom = currentRoom;
                chest.UseRoomInt = GameOtherVars.RoomNow;
                db.objects.put(chest.name, chest);
                currentRoom.objectsIDs.add(chest.name);


            }
        }
    }
    public void NPC_ChinaMAN_create() {
        int ui = 1 + (int) +(Math.random() * ((5 - 1) + 1));
        if (ui == 1) {
            final ChinaMan chest = new ChinaMan(getFreeName("ChinaMan"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }
    public void NPC_MegaBear_create() {
        int ui = 1 + (int) +(Math.random() * ((4 - 1) + 1));
        if (ui == 1) {
            final MegaBear chest = new MegaBear(getFreeName("MegaBear"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }
    public void NPC_Oblako() {
        int ui = 1 + (int) +(Math.random() * ((30 - 1) + 1));
        if (ui == 1) {
            final Cloud chest = new Cloud(getFreeName("Oblako"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 30;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
        if (ui == 1) {
            final Cloud chest = new Cloud(getFreeName("Oblako"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 30;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
        if (ui == 1) {
            final Cloud chest = new Cloud(getFreeName("Oblako"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 30;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
        if (ui == 1) {
            final Cloud chest = new Cloud(getFreeName("Oblako"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 30;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
        if (ui == 1) {
            final Cloud chest = new Cloud(getFreeName("Oblako"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 30;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }
    public void Maslo_create() {
        int ui = 1 + (int) +(Math.random() * ((15 - 1) + 1));
        if (ui == 1) {
            final Maslo chest = new Maslo(getFreeName("MASLO"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 5;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }
    public void NPC_GoblinMaster_create() {
        int ui = 1 + (int) +(Math.random() * ((6 - 1) + 1));
        if (ui == 1) {
            final Master_Goblin chest = new Master_Goblin(getFreeName("Goblin"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 5;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }
    public void NPC_Goblin_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Goblin chest = new Goblin(getFreeName("Goblin"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 5;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }
    public void DEC_spruce_create() {
        int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        if (ui == 1) {
            final Spruce dlg = new Spruce(getFreeName("Spruce"));
            int g = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int g1 = 70 + (int) (Math.random() * ((600 - 150) + 1));
            dlg.x = g;
            dlg.y = g1;
            dlg.z = g1+105;
            dlg.xt = g;
            dlg.yt = g1;
            dlg.UseRoom = currentRoom;
            dlg.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(dlg.name, dlg);
            currentRoom.objectsIDs.add(dlg.name);
            DEC_spruce_create();
        }


    }
    public void DEC_sock_create() {

        final Sock dlg = new Sock(getFreeName("Sock"));
        dlg.x =  70 + (int) (Math.random() * ((600 - 150) + 1));
        dlg.y = 70 + (int) (Math.random() * ((600 - 150) + 1));
        dlg.UseRoom = currentRoom;
        dlg.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(dlg.name, dlg);
        currentRoom.objectsIDs.add(dlg.name);
    }
    public void WinLogoCreate() {

        final WinLogo dlg = new WinLogo(getFreeName("WinLogo"));
        dlg.x = 0;
        dlg.y = 0;
        dlg.UseRoom = currentRoom;
        dlg.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(dlg.name, dlg);
        currentRoom.objectsIDs.add(dlg.name);
    }
    public void NPC_NWY_Ded_Moroz_create() {
        int ui = 1 + (int) +(Math.random() * ((10 - 1) + 1));
        if (ui == 1) {
            final NWY_DedMoroz chest = new NWY_DedMoroz(getFreeName("NWY_DEDMOROZ"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 30;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }
    public void NPC_NWY_Deer_create(int type) {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 2) {
            final NWY_Deer chest = new NWY_Deer(getFreeName("NWY_DEER"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 5;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            chest.UseRoom = currentRoom;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }
    public void NPC_Present_create(int xi,int yi) {

        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Present chest = new Present(getFreeName("Present"));
            int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
            int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));
            wardenx = xi;
            wardeny = yi;
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            if (chest.y < 400) {
                chest.z = chest.y;
            } else {
                chest.z = chest.y-200;
            }
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
        }
    }
    public void NPC_Present_create() {

        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Present chest = new Present(getFreeName("Present"));
            int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
            int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;

            chest.z = chest.y;

            chest.z = chest.y-200;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
        }
    }


    public void NPC_Shlakoblock_create() {

        int ui = 1 + (int) +(Math.random() * ((10 - 1) + 1));
        if (ui == 1) {
            final Shlacoblock chest = new Shlacoblock(getFreeName("Shlakoblock"));
            int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
            int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;
            chest.z = -5;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
        }
    }

    public void DEC_EarthCreate() {

        final DEC_Earth chest = new DEC_Earth(getFreeName("Blueman"));
        int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
        int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));
        chest.x = wardenx;
        chest.y = wardeny;
        chest.UseRoom = currentRoom;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);

    }


    public void NPC_Blueman_create() {
        int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        if (ui == 1) {
            final Blueman chest = new Blueman(getFreeName("Blueman"));
            int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
            int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            chest.UseRoom = currentRoom;
            chest.z = 5;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
        }
    }

    public void NPC_Ant_create() {
        int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        if (ui == 1) {
            final Ant chest = new Ant(getFreeName("Ant"));
            int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
            int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 5;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
        }
    }

    public void NPC_Lavaman_create() {
        int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        if (ui == 1) {
            final Lavaman chest = new Lavaman(getFreeName("Lavaman"));
            int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
            int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.UseRoom = currentRoom;
            chest.z = 5;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
        }
    }

    public void OBJ_APL_Portal_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 2) {
            final Portal chest = new Portal(getFreeName("Portal"));
            int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
            int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.UseRoom = currentRoom;
            chest.z = wardeny+4;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
        }
    }

    public void NPC_Deamon_create() {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 2) {
            final Deamon chest = new Deamon(getFreeName("Deamon"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 5;
            chest.UseRoom = currentRoom;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            chest.UseRoomInt = GameOtherVars.RoomNow;
        }
    }

    public void NPC_AppleW_create(int type) {
        int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 2) {
            final AppleW chest = new AppleW(getFreeName("AppleWar"));
            int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;
            chest.z = 5;
            chest.NPC_Type = type;
            chest.UseRoomInt = GameOtherVars.RoomNow;
            chest.UseRoom = currentRoom;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }

    public void DEC_chest_create() {
        final DEC_Chest chest = new DEC_Chest(getFreeName("chest"));
        int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
        int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));
        chest.x = wardenx;
        chest.y = wardeny;
        chest.xt = wardenx;
        chest.yt = wardeny;
        chest.z = 0;
        chest.UseRoomInt = GameOtherVars.RoomNow;
        chest.UseRoom = currentRoom;
        db.objects.put(chest.name, chest);
        chest.UseRoomInt = GameOtherVars.RoomNow;
        currentRoom.objectsIDs.add(chest.name);
    }

    public void DieLogoCreate() {

        final DieLogo dlg = new DieLogo(getFreeName("Dielogo"));
        dlg.x = 0;
        dlg.y = 0;
        dlg.UseRoom = currentRoom;
        dlg.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(dlg.name, dlg);
        currentRoom.objectsIDs.add(dlg.name);
    }


    public void AppleCalipse() {


        Applecalipses = 1;


    }

    public void AppleGet(int xp, int yp, int rep, int rey) {
        final AppleS aplk = new AppleS(getFreeName("appleDEC"));
        aplk.UseRoomInt = GameOtherVars.RoomNow;
        aplk.xplus = xp;
        aplk.yplus = yp;
        aplk.retplx = rep;
        aplk.retply = rey;
        aplk.UseRoom = currentRoom;
        db.objects.put(aplk.name, aplk);
        currentRoom.objectsIDs.add(aplk.name);
    }

    public void GetLevel_2() {
        currentRoom = db.rooms.get("new_game_splash_screen_room");
        final Animation acur = db.backgrounds.get(currentRoom.background).sprite;
        acur.reset();
        acur.isPlaying = true;
    }


    public void Mdoor_create(int xau, int yau, int type) {
        final main_door md = new main_door(getFreeName("Main_Door"));
        md.x = xau;
        md.y = yau;
        md.xt = xau;
        md.yt = yau;
        md.Door_type = type;
        md.UseRoomInt = GameOtherVars.RoomNow;
        md.UseRoom = currentRoom;
        db.objects.put(md.name, md);
        currentRoom.objectsIDs.add(md.name);
    }


    public static void MessageAkey_create() {
        KeyMessage kms1 = new KeyMessage("Message");

        kms1.x = 32;
        kms1.y = 32;
        kms1.z = 50;
        kms1.UseRoom = currentRoom;
        kms1.UseRoomInt = GameOtherVars.RoomNow;
        db.objects.put(kms1.name, kms1);
        currentRoom.objectsIDs.add(kms1.name);
    }

    public void Crate_create(int xa, int ya, int ga) {
        {
            final Crate c = new Crate(getFreeName("crate"));


            c.x = xa;
            c.y = ya;
            c.xt = xa;
            c.yt = ya;
            c.z = ga;
            c.UseRoomInt = GameOtherVars.RoomNow;
            c.UseRoom = currentRoom;
            db.objects.put(c.name, c);

            currentRoom.objectsIDs.add(c.name);
        }


    }


    public void AppleCreate(int rt, int rt1) {
        {
            final AppleD fr = new AppleD(getFreeName("apple"));
            int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
            int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));

            fr.x = wardenx;
            fr.y = wardeny;
            fr.xt = wardenx;
            fr.yt = wardeny;
            fr.z = -5;
            fr.UseRoomInt = GameOtherVars.RoomNow;
            fr.UseRoom = currentRoom;
            db.objects.put(fr.name, fr);
            currentRoom.objectsIDs.add(fr.name);
        }


    }

    public void Apple_Dublicate(int rt, int rt1) {
        {
            final AppleS fr = new AppleS(getFreeName("apple"));
            fr.x = rt;
            fr.y = rt1;
            fr.z = -5;


        }


    }






    public class MusicPlayer {

        public String filename;

        public MusicPlayer(String filename) {
            this.filename = filename;
        }
        public void Load(String f)
        {
            filename = f;
        }
        public void play() {
            try {
                File file = new File("sounds/Queen - Bicycle Race.wma");

                InputStream in = new FileInputStream(file);

                AudioStream as = new AudioStream(in);


                //AudioPlayer.player.start(as);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class Sound {
        private boolean released = false;
        private Clip clip = null;
        private FloatControl volumeC = null;
        private boolean playing = false;

        public Sound(File f) {
            try {
                AudioInputStream stream = AudioSystem.getAudioInputStream(f);
                clip = AudioSystem.getClip();
                clip.open(stream);
                clip.addLineListener(new Listener());
                volumeC = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                released = true;
            } catch(IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
                exc.printStackTrace();
                released = false;
            }
        }

        //true если звук успешно загружен, false если произошла ошибка
        public boolean isReleased() {
            return released;
        }

        //проигрывается ли звук в данный момент
        public boolean isPlaying() {
            return playing;
        }

        //Запуск
    /*
      breakOld определяет поведение, если звук уже играется
      Если reakOld==true, о звук будет прерван и запущен заново
      Иначе ничего не произойдёт
    */
        public void play(boolean breakOld) {
            if (released) {
                if (breakOld) {
                    clip.stop();
                    clip.setFramePosition(0);
                    clip.start();
                    playing = true;
                } else if (!isPlaying()) {
                    clip.setFramePosition(0);
                    clip.start();
                    playing = true;
                }
            }
        }

        //То же самое, что и play(true)
        public void play() {
            play(true);
        }

        //Останавливает воспроизведение
        public void stop() {
            if (playing) {
                clip.stop();
            }
        }

        //Установка громкости
    /*
      x долже быть в пределах от 0 до 1 (от самого тихого к самому громкому)
    */
        public void setVolume(float x) {
            if (x<0) x = 0;
            if (x>1) x = 1;
            float min = volumeC.getMinimum();
            float max = volumeC.getMaximum();
            volumeC.setValue((max-min)*x+min);
        }

        //Возвращает текущую громкость (число от 0 до 1)
        public float getVolume() {
            float v = volumeC.getValue();
            float min = volumeC.getMinimum();
            float max = volumeC.getMaximum();
            return (v-min)/(max-min);
        }

        //Дожидается окончания проигрывания звука
        public void join() {
            if (!released) return;
            synchronized(clip) {
                try {
                    while (playing) clip.wait();
                } catch (InterruptedException exc) {}
            }
        }
        /*
        //Статический метод, для удобства
        public static Sound playSound(String s) {
            File f = new File(s);
            Sound snd = new Sound(f);
            snd.play();
            return snd;
        }
        */
        private class Listener implements LineListener {
            public void update(LineEvent ev) {
                if (ev.getType() == LineEvent.Type.STOP) {
                    playing = false;
                    synchronized(clip) {
                        clip.notify();
                    }
                }
            }
        }
    }

    public int GetRandom(int one, int two)
    {
        int reply;
        reply = one + (int) (Math.random() * ((two - one) + 1));
        return reply;
    }
    public String getFreeName(String prefix) {
        int i = 0;
        while (db.objects.containsKey(prefix + i)) {
            i++;
        }
        return prefix + i;
    }

    private final MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            PointerInfo a = MouseInfo.getPointerInfo();
            Point point = new Point(a.getLocation());
            SwingUtilities.convertPointFromScreen(point, e.getComponent());
            for (GameObject o : db.objects.values()) {
                o.onGlobalMouseClick(point.getX(), point.getY());
            }
        }
    };

    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final MediaTracker tracker = new MediaTracker(this);
    private final Map<String, Integer> imgMap = new HashMap<String, Integer>();

    public Sprite getSprite(String path) {
        Image image = toolkit.getImage("assets/" + path);

        {
            int id = 0;
            if (imgMap.containsKey(path)) {
                id = imgMap.get(path);
            } else {
                id = imgMap.size();
                imgMap.put(path, id);
            }
            tracker.addImage(image, id);
        }
        try {
            tracker.waitForAll();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        Sprite sprite = new Sprite(image);
        sprite.name = path;

        return sprite;
    }


    class Keyboard extends KeyAdapter {
        public void keyReleased(KeyEvent w) {
            final int kCode = w.getKeyCode();
            for (GameObject o : db.objects.values()) {
                o.onKey(kCode);
            }
        }

        public void keyPressed(KeyEvent e) {
            final int kCode = e.getKeyCode();
            for (GameObject o : db.objects.values()) {
                o.onKeyPress(kCode);
            }
        }
    }

}
