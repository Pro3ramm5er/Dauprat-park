package dpark;

import dpark.objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.*;
import java.util.List;
import dpark.GameObject.*;
import static dpark.DB.db;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;


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
    public static int VisibleDieLogo = 0;
    public static int AllDelete = 0; // If 1 - SelfRemove for all objects.
    public static int StopUpdate = 0;
    public static int IsCreated = 0;
    public static int AppleCreate = 1;
    public static int BeforeMain = 0;
    public static int BluemanCreated = 1;
    public static int RatCreated = 1;
    public static int xo;
    public static int yo;
    public static int Shlakoblock_magic = 0;
    public static int GameUpdateType = 1; // 0 - normal, 1 - New Year Update;
    public static int SantaX;
    public static int SantaY;
    public static int NWY_Present_create = 1;
    public static int Shlakoblock_create = 1;
    public static int CardCreate = 1;
    public static int DedMoroz_create = 0;
    public static int MainKey = 0;
    public static int WinVisible = 0;
    public static int WinTimer = 50;
    public static int Maslo_Create = 1;
    public static int Restart_type = 1; // 1 - to main. 2 - easy delete. 3 - 3 location
    public static int Reload_on = 1;
    public static int Bananar_bad = 0;
    public static int Fullimmortality = 0;
    public static int InitOn = 0;
    public static int blindness_on = 0;
    public static int Level = 1;
    public static int Snow_MST = 0;
    public static int Snow_x;
    public static int Snow_y;
    public static int Snow_create = 1;
    public static int Health = 2;


    public Game() {
        instance = this;
    }


    public void start() {
        running = true;

        new Thread(this).start();
    }

    public static final int FPS = 30;
    private static final int FrameDuration = 1000 / FPS;
    private static final int MaxFrameSkip = 10;
    private long nextFrameTime = System.currentTimeMillis();

    public void run() {
        int loops;
        init();

        while (running) {
            loops = 0;
            while (System.currentTimeMillis() > nextFrameTime
                    && loops < MaxFrameSkip) {

                update();

                if (BeforeMain == 1) {
                    if (Level == 1) {
                        Get_Start();

                    }
                    if (Level == 2) {
                        Get_start_location_2();

                    }
                    if (Level == 3) {
                        Get_start_location_3();

                    }
                }
                currentRoom.update();

                if (AllDelete == 0 && StopUpdate == 0) {

                    for (GameObject o : db.objects.values()) {
                        if (AllDelete == 0 && StopUpdate == 0) {
                            o.update();
                        }
                    }
                }

                if (AllDelete == 1) {


                    currentRoom.objectsIDs.clear();

                    db.objects.clear();

                    WinVisible = 0;
                    VisibleDieLogo = 0;
                    AllDelete = 0; // If 1 - SelfRemove for all objects.
                    StopUpdate = 0;
                    IsCreated = 0;
                    AppleCreate = 1;

                    BluemanCreated = 0;
                    RatCreated = 0;
                    xo = 0;
                    yo = 0;
                    MainKey = 0;
                    Shlakoblock_magic = 0;
                    BeforeMain = 0;
                    Reload_on = 1;
                    Health = 2;
                    if (Restart_type == 1) {
                        init();
                    }
                    if (Restart_type == 2) {
                        init_location_2();
                    }
                    if (Restart_type == 3) {
                        init_location_3();
                    }
                    IsCreated = 0;
                    AllDelete = 0;

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
        //if (InitOn == 0) {
            addKeyListener(new Keyboard());
            addMouseListener(mouseListener);
         //   InitOn = 1;
        //}
        db.onGameLoaded(this);

        //Sound.playSound("sounds/Deep_Purple-Burn.wav").join();



        currentRoom = db.rooms.get("main_menu_room");
    }
    public void init_location_2() {
        addKeyListener(new Keyboard());
        addMouseListener(mouseListener);
        db.onGameLoaded(this);
        currentRoom = db.rooms.get("map2_room");
        Restart_type = 1;
        Get_start_location_2();

    }
    public void init_location_3() {
        addKeyListener(new Keyboard());
        addMouseListener(mouseListener);
        db.onGameLoaded(this);
        currentRoom = db.rooms.get("map3_room");
        Restart_type = 2;
        Get_start_location_3();

    }

    public void render(Room room) {
        bss = getBufferStrategy();
        if (bss == null) {
            createBufferStrategy(2);
            requestFocus();
            return;
        }
        gl = bss.getDrawGraphics();
        gl.setColor(Color.black);
        gl.fillRect(0, 0, getWidth(), getHeight());
        db.backgrounds.get(room.background).sprite.getStep().sprite.draw(gl, 5,
                5);
        List<GameObject> objs = new ArrayList<GameObject>(db.objects.values());
        Collections.sort(objs, GameObject.compareByDepth);
        for (GameObject o : objs) {
            if (room.objectsIDs.contains(o.name)) {
                o.render(gl);
            }
        }
        bss.show();
        gl.dispose();
    }

    public void update() {
        // final GameObject player = objects.get("player");
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
        WinVisible = 1;

    }
    public static void Get_win_2()
    {
        AllDelete = 1;
        VisibleDieLogo = 0;
    }
    public static void Get_Die() {

        AllDelete = 1;
        VisibleDieLogo = 0;


    }
    public void Get_start_location_3() {
        Level = 3;
        if (IsCreated == 0) {
            AllDelete = 0;
            BeforeMain = 1;

            GameObject.PlayerCanMovie = 0;
            currentRoom = db.rooms.get("map3_room");
            db.objects.get("player").visible = true;
            IsCreated = 1;
            int xcr = 0;
            int icr = 0;
            int i = 0;
            int zex = 0;
            for (i = 0; i < 5; i++) {
                Crate_create(xcr, icr, zex);
                xcr += 32;
                //zex += 32;
            }
            Mdoor_create(160,icr, 2);
            xcr = xcr + 128;
            icr = 0;
            i = 0;
            zex = 0;
            for (i = 0; i < 20; i++) {
                Crate_create(xcr, icr, zex);
                xcr += 32;
                //zex += 32;
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

                //icr += 32;
                xcr+=32;
                //zex+= 32;
                Crate_create(xcr, icr, zex);
            }
            //i = 0;
            //xcr = 0;
            //icr = icr + 128;
            //for (i = 0; i <= 2; i++) {
//
            //    icr += 32;
             //   Crate_create(xcr, icr, zex);
            //}

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
//

               Crate_create(xcr, icr, zex);
                icr += 32;
                zex += 32;
            }




            i = 0;
            xcr = 0;
            //icr = 0;
            for (i = 0; i <= 25; i++) {
//
                xcr += 32;
                Crate_create(xcr, icr, zex);
            }


            i = 0;
            xcr = 32;
            icr = 768;
            for (i = 0; i <= 24; i++) {
//

                Crate_create(xcr, icr, zex);
                xcr += 32;
            }


            //Mdoor_create(0, 384);
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
            //DEC_chest_create();
            //DEC_chest_create();

            //NPC_AppleW_create(0);
            //NPC_AppleW_create(1);
            //NPC_AppleW_create(0);
            //NPC_AppleW_create(1);
            //NPC_AppleW_create(0);
            //NPC_AppleW_create(1);

            //NPC_Deamon_create();
            //NPC_Deamon_create();
            //NPC_Deamon_create();

            //NPC_Lavaman_create();
            //OBJ_APL_Portal_create();
            //NPC_Ant_create();
            //NPC_Ant_create();
            NPC_Ant_create();
            NPC_Ant_create();
            //NPC_Blueman_create();
            //NPC_Rat_create(0, 0, 0);
            Maslo_create();
            Maslo_create();
            Maslo_create();
            if (GameUpdateType == 0) {
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
            } else {
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                //DEC_spruce_create();
                //DEC_spruce_create();
                //DEC_spruce_create();
                DEC_spruce_create();
                DEC_spruce_create();
                DEC_spruce_create();
                DEC_spruce_create();
                DEC_spruce_create();
                //NPC_Present_create();
                //NPC_Present_create();
                //NPC_Present_create();
                //NPC_Present_create();
                //NPC_Present_create();
                //NPC_Present_create();
                //NPC_NWY_Deer_create(0);
                //NPC_NWY_Deer_create(0);
                //NPC_NWY_Deer_create(0);
                //NPC_NWY_Deer_create(0);
                //NPC_NWY_Ded_Moroz_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
                // NPC_Goblin_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
                NPC_GoblinMaster_create();
                NPC_GoblinMaster_create();
                NPC_HoMonster_create();
            }
            NPC_Shlakoblock_create();
            NPC_EvilWorm_create();
            NPC_EvilWorm_create();
            NPC_EvilWorm_create();
            NPC_HoMonster_create();
            NPC_IRT_create();
            NPC_IRT_create();
            //OBJ_APL_Snow_create();
            NPC_Slim_create();
            NPC_Alpinos_create();
            NPC_Tres_create();
            NPC_Healthbar_create();
            //if (GameUpdateType == 1) {

            //}
        }

        if (WinVisible == 1) {
            if (WinTimer <= 0) {
                AllDelete = 1;
                WinTimer = 15;
            } else {
                WinTimer--;
            }
        }
        if (AppleCreate == 0) {
            NPC_Deamon_create();
            AppleCreate = 1;
        }
        if (BluemanCreated == 0) {
            NPC_Blueman_create();
            BluemanCreated = 1;
        }
        if (RatCreated == 0) {
            //sNPC_Rat_create(1, xo, yo);
            RatCreated = 1;
        }

        if (NWY_Present_create == 0)
        {
            NPC_Present_create(SantaX, SantaY);
            NWY_Present_create = 1;
        }
        if (Shlakoblock_create  == 0)
        {
            NPC_Shlakoblock_create();
            Shlakoblock_create = 1;
        }
        if (DedMoroz_create  == 0)
        {
            NPC_NWY_Ded_Moroz_create();
            DedMoroz_create = 1;
        }
        if (Maslo_Create  == 0)
        {

            Maslo_Create = 0;
        }
        if (CardCreate  == 0)
        {
            Card_create();
            CardCreate = 1;
        }
        if (Snow_create  == 0)
        {
            NPC_Snow_create();
            Snow_create = 1;
        }
    }
    public void NPC_Healthbar_create() {
        //int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        //if (ui == 1) {
        final Healthbar chest = new Healthbar(getFreeName("Healthbar"));
        //int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
        //int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
        chest.x = 32;
        chest.y = 32;

        //chest.z = 5;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);
        //NPC_Tres_create();

        //}
    }
    public void NPC_Snow_create() {
        //int ui = 1 + (int) +(Math.random() * ((3 - 1) + 1));
        //if (ui == 1) {
            final Gun chest = new Gun(getFreeName("Gun"));
            //int wardenx = 70 + (int) (Math.random() * ((600 - 150) + 1));
            //int wardeny = 70 + (int) (Math.random() * ((600 - 150) + 1));
            chest.x = Snow_x;
            chest.y = Snow_y;
            chest.xt = Snow_x;
            chest.yt = Snow_y;
            chest.MST = Snow_MST;
            //chest.z = 5;

            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            //NPC_Tres_create();

        //}
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
            //chest.z = 5;

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
            //chest.z = 5;

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
            //chest.z = 5;

            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            NPC_Slim_create();

        }
    }









    public void Get_start_location_2() {
        Level = 2;
        if (IsCreated == 0) {
            AllDelete = 0;
            BeforeMain = 1;

            GameObject.PlayerCanMovie = 0;
            currentRoom = db.rooms.get("map2_room");
            db.objects.get("player").visible = true;
            IsCreated = 1;
            int xcr = 0;
            int icr = 0;
            int i = 0;
            int zex = 0;
            for (i = 0; i < 25; i++) {
                Crate_create(xcr, icr, zex);
                xcr += 32;
                //zex += 32;
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

            //NPC_AppleW_create(0);
            //NPC_AppleW_create(1);
            //NPC_AppleW_create(0);
            //NPC_AppleW_create(1);
            //NPC_AppleW_create(0);
            //NPC_AppleW_create(1);

            //NPC_Deamon_create();
            //NPC_Deamon_create();
            //NPC_Deamon_create();

            //NPC_Lavaman_create();
            //OBJ_APL_Portal_create();
            //NPC_Ant_create();
            //NPC_Ant_create();
            NPC_Ant_create();
            NPC_Ant_create();
            //NPC_Blueman_create();
            //NPC_Rat_create(0, 0, 0);
            Maslo_create();
            Maslo_create();
            Maslo_create();
            if (GameUpdateType == 0) {
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
            } else {
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                //DEC_spruce_create();
                //DEC_spruce_create();
                //DEC_spruce_create();
                DEC_spruce_create();
                DEC_spruce_create();
                DEC_spruce_create();
                DEC_spruce_create();
                DEC_spruce_create();
                //NPC_Present_create();
                //NPC_Present_create();
                //NPC_Present_create();
                //NPC_Present_create();
                //NPC_Present_create();
                //NPC_Present_create();
                //NPC_NWY_Deer_create(0);
                //NPC_NWY_Deer_create(0);
                //NPC_NWY_Deer_create(0);
                //NPC_NWY_Deer_create(0);
                //NPC_NWY_Ded_Moroz_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
               // NPC_Goblin_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
                //NPC_Goblin_create();
                NPC_GoblinMaster_create();
                NPC_GoblinMaster_create();
                NPC_HoMonster_create();
            }
            NPC_Shlakoblock_create();
            NPC_EvilWorm_create();
            NPC_EvilWorm_create();
            NPC_EvilWorm_create();
            NPC_HoMonster_create();
            NPC_IRT_create();
            NPC_IRT_create();
            //OBJ_APL_Snow_create();
            NPC_BrainWater_create();
            Card_create();
            Card_create();
            Card_create();
            eff_bil_create();
            NPC_TNT_create();
            NPC_Healthbar_create();
            //if (GameUpdateType == 1) {

            //}
        }

        if (WinVisible == 1) {
            if (WinTimer <= 0) {
                AllDelete = 1;
                WinTimer = 15;
            } else {
                WinTimer--;
            }
        }
        if (AppleCreate == 0) {
            NPC_Deamon_create();
            AppleCreate = 1;
        }
        if (BluemanCreated == 0) {
            NPC_Blueman_create();
            BluemanCreated = 1;
        }
        if (RatCreated == 0) {
            //NPC_Rat_create(1, xo, yo);
            RatCreated = 1;
        }
        /*
        if (NWY_Present_create == 0)
        {
            NPC_Present_create(SantaX, SantaY);
            NWY_Present_create = 1;
        }
        */
        if (Shlakoblock_create  == 0)
        {
            NPC_Shlakoblock_create();
            Shlakoblock_create = 1;
        }
        if (DedMoroz_create  == 0)
        {
            NPC_NWY_Ded_Moroz_create();
            DedMoroz_create = 1;
        }
        if (Maslo_Create  == 0)
        {

            Maslo_Create = 0;
        }

    }
    public void NPC_TNT_create() {

        //int ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        //if (ui == 1) {
            final TNT chest = new TNT(getFreeName("TNT"));
            int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
            int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));

            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;


            //chest.z = -5;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
       // }
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
            //chest.z = 5;

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
                //chest.z = 5;

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
                //chest.z = 5;

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
                //chest.z = 5;

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

            chest.z = 400;
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

            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);


        }
    }
    public void Get_Start() {

        Level = 1;

        if (IsCreated == 0) {
            AllDelete = 0;

            GameObject.PlayerCanMovie = 0;
            currentRoom = db.rooms.get("map1_room");
            db.objects.get("player").visible = true;
            IsCreated = 1;
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

            //NPC_AppleW_create(0);
            //NPC_AppleW_create(1);
            //NPC_AppleW_create(0);
            NPC_AppleW_create(1);
            NPC_AppleW_create(0);
            NPC_AppleW_create(1);

            NPC_Deamon_create();
            NPC_Deamon_create();
            NPC_Deamon_create();

            NPC_Lavaman_create();
            OBJ_APL_Portal_create();
            //NPC_Ant_create();
            //NPC_Ant_create();
            NPC_Ant_create();
            NPC_Ant_create();
            NPC_Healthbar_create();
            NPC_Blueman_create();
            //NPC_Rat_create(0, 0, 0);
            Maslo_create();
            Maslo_create();
            Maslo_create();
            NPC_MegaBear_create();
            NPC_ChinaMAN_create();
            NPC_Bandit_create();
            NPC_MoMo_create();
            NPC_Bananar_create();
            if (GameUpdateType == 0) {
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
            } else {
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                DEC_sock_create();
                //DEC_spruce_create();
                //DEC_spruce_create();
                //DEC_spruce_create();
                DEC_spruce_create();
                DEC_spruce_create();
                DEC_spruce_create();
                DEC_spruce_create();
                DEC_spruce_create();
                //NPC_Present_create();
                //NPC_Present_create();
                //NPC_Present_create();
                //NPC_Present_create();
                NPC_Present_create();
                NPC_Present_create();
                //NPC_NWY_Deer_create(0);
               // NPC_NWY_Deer_create(0);
               // NPC_NWY_Deer_create(0);
               // NPC_NWY_Deer_create(0);
                //NPC_NWY_Ded_Moroz_create();
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
            }
            NPC_Shlakoblock_create();
            Card_create();
            Card_create();
            Card_create();
            eff_bil_create();
            //NPC_EvilWorm_create();
            //NPC_EvilWorm_create();
            //NPC_EvilWorm_create();
            //NPC_Oblako();
            //if (GameUpdateType == 1) {

            //}
        }

        if (WinVisible == 1) {
            if (WinTimer <= 0) {
                AllDelete = 1;
                WinTimer = 15;
            } else {
                WinTimer--;
            }
        }
        if (AppleCreate == 0) {
            NPC_Deamon_create();
            AppleCreate = 1;
        }
        if (BluemanCreated == 0) {
            NPC_Blueman_create();
            BluemanCreated = 1;
        }
        if (RatCreated == 0) {
            //NPC_Rat_create(1, xo, yo);
            RatCreated = 1;
        }
        if (NWY_Present_create == 0)
        {
            NPC_Present_create(SantaX, SantaY);
            NWY_Present_create = 1;
        }
        if (Shlakoblock_create  == 0)
        {
            NPC_Shlakoblock_create();
            Shlakoblock_create = 1;
        }
        if (DedMoroz_create  == 0)
        {
            NPC_NWY_Ded_Moroz_create();
            DedMoroz_create = 1;
        }
        if (Maslo_Create  == 0)
        {

            Maslo_Create = 0;
        }
        if (CardCreate  == 0)
        {
            Card_create();
            CardCreate = 1;
        }
        if (Bananar_bad > 0)
        {
            Bananar_bad--;
            NPC_Bananar_create();
        }

    }
    public void eff_bil_create() {

            final blindness chest = new blindness(getFreeName("blindness"));
            int wardenx =0;
            int wardeny =0;
            chest.x = 0;
            chest.y = 0;

            chest.z = 15000000;

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
            //chest.z = 5;

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
            //chest.z = 5;

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
                //chest.z = 5;

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
            //chest.z = 5;

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
                //chest.z = 5;

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
                //chest.z = 5;

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
            //chest.z = 5;

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
                //chest.z = 5;

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
                //chest.z = 5;

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
                //chest.z = 5;

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
                //chest.z = 5;

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
            //chest.z = 5;

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
           // chest.z = 5;

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
            db.objects.put(dlg.name, dlg);
            currentRoom.objectsIDs.add(dlg.name);
        }
        ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Spruce dlg = new Spruce(getFreeName("Spruce"));
            int g = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int g1 = 70 + (int) (Math.random() * ((600 - 150) + 1));
            dlg.x = g;
            dlg.y = g1;
            dlg.z = g1+105;
            dlg.xt = g;
            dlg.yt = g1;
            db.objects.put(dlg.name, dlg);
            currentRoom.objectsIDs.add(dlg.name);
        }
        ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Spruce dlg = new Spruce(getFreeName("Spruce"));
            int g = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int g1 = 70 + (int) (Math.random() * ((600 - 150) + 1));
            dlg.x = g;
            dlg.y = g1;
            dlg.z = g1+105;
            dlg.xt = g;
            dlg.yt = g1;
            db.objects.put(dlg.name, dlg);
            currentRoom.objectsIDs.add(dlg.name);
        }
        ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Spruce dlg = new Spruce(getFreeName("Spruce"));
            int g = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int g1 = 70 + (int) (Math.random() * ((600 - 150) + 1));
            dlg.x = g;
            dlg.y = g1;
            dlg.z = g1+105;
            dlg.xt = g;
            dlg.yt = g1;
            db.objects.put(dlg.name, dlg);
            currentRoom.objectsIDs.add(dlg.name);
        }
        ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Spruce dlg = new Spruce(getFreeName("Spruce"));
            int g = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int g1 = 70 + (int) (Math.random() * ((600 - 150) + 1));
            dlg.x = g;
            dlg.y = g1;
            dlg.z = g1+105;
            dlg.xt = g;
            dlg.yt = g1;
            db.objects.put(dlg.name, dlg);
            currentRoom.objectsIDs.add(dlg.name);
        }
        /*
        ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Spruce dlg = new Spruce(getFreeName("Spruce"));
            int g = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int g1 = 70 + (int) (Math.random() * ((600 - 150) + 1));
            dlg.x = g;
            dlg.y = g1;
            dlg.z = g1+100;
            dlg.xt = g;
            dlg.yt = g1;
            db.objects.put(dlg.name, dlg);
            currentRoom.objectsIDs.add(dlg.name);
        }
        */
        /*
        ui = 1 + (int) +(Math.random() * ((2 - 1) + 1));
        if (ui == 1) {
            final Spruce dlg = new Spruce(getFreeName("Spruce"));
            int g = 70 + (int) (Math.random() * ((600 - 150) + 1));
            int g1 = 70 + (int) (Math.random() * ((600 - 150) + 1));
            dlg.x = g;
            dlg.y = g1;
            dlg.z = g1+100;
            dlg.xt = g;
            dlg.yt = g1;
            db.objects.put(dlg.name, dlg);
            currentRoom.objectsIDs.add(dlg.name);
        }
        */
    }
    public void DEC_sock_create() {

        final Sock dlg = new Sock(getFreeName("Sock"));
        dlg.x =  70 + (int) (Math.random() * ((600 - 150) + 1));
        dlg.y = 70 + (int) (Math.random() * ((600 - 150) + 1));

        db.objects.put(dlg.name, dlg);
        currentRoom.objectsIDs.add(dlg.name);
    }
    public void WinLogoCreate() {

        final WinLogo dlg = new WinLogo(getFreeName("WinLogo"));
        dlg.x = 0;
        dlg.y = 0;

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

            //chest.z = -5;
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

            //if (chest.y < 400) {
                chest.z = chest.y;
            //} else {
                chest.z = chest.y-200;
            //}
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

            chest.z = -5;
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


        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);

    }
    /*
    public void NPC_Rat_create(int type, int xf, int yf) {
        if (type == 0) {
            int ui = 1 + (int) +(Math.random() * ((4 - 1) + 1));
            if (ui == 1) {
                final Rat chest = new Rat(getFreeName("Rat"));
                int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
                int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));
                chest.x = wardenx;
                chest.y = wardeny;
                chest.xt = wardenx;
                chest.yt = wardeny;

                chest.z = -5;
                db.objects.put(chest.name, chest);
                currentRoom.objectsIDs.add(chest.name);
            }
        }
        if (type == 1) {
            //int ui = 1 + (int) +(Math.random() * ((4 - 1) + 1));
            //if (ui == 1) {
            final Rat chest = new Rat(getFreeName("Rat"));
            //int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
            //int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));
            chest.x = xf;
            chest.y = yf;
            chest.xt = xf;
            chest.yt = yf;

            chest.z = -5;
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            //}
        }
    }
    */

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

            chest.z = 5;
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

            chest.z = 15;
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
            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);

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
        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);
    }

    public void DieLogoCreate() {

        final DieLogo dlg = new DieLogo(getFreeName("Dielogo"));
        dlg.x = 0;
        dlg.y = 0;

        db.objects.put(dlg.name, dlg);
        currentRoom.objectsIDs.add(dlg.name);
    }


    public void AppleCalipse() {


        Applecalipses = 1;


    }

    public void AppleGet(int xp, int yp, int rep, int rey) {
        final AppleS aplk = new AppleS(getFreeName("appleDEC"));

        aplk.xplus = xp;
        aplk.yplus = yp;
        aplk.retplx = rep;
        aplk.retply = rey;
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

        db.objects.put(md.name, md);
        currentRoom.objectsIDs.add(md.name);
    }


    public static void MessageAkey_create() {
        KeyMessage kms1 = new KeyMessage("Message");

        kms1.x = 32;
        kms1.y = 32;
        kms1.z = 50;
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
