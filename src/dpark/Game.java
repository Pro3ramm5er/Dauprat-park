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

import static dpark.DB.db;

import dpark.objects.Window;
import dpark.SoundEngine;


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
    public static int DedMoroz_create = 1;
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
    public static int Biome_type = 1 + (int) (Math.random() * ((6 - 1) + 1));
    public static int Player_bottle = 0;
    public static int Player_weed = 0;
    public static int UnderEffecr = 0;
    public static int Story = 0;
    public static int S_task = 0;
    public static int S_table = 0;
    public static int S_phone = 0;
    public static int S_moment = 0;
    public static int S_door = 0;
    public SoundEngine soundengine;


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
        addKeyListener(new Keyboard());
        addMouseListener(mouseListener);
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
                    if (Level == 4) {
                        Get_4_level();

                    }
                    if (Level == 5) {
                        GetStartStory();

                    }
                    if (Level == 6) {
                        GetStartS2();

                    }
                    if (Level == 7) {
                        GetStartS3();

                    }
                    if (Level == 8) {
                        GetStartS4();

                    }
                    if (Level == 9) {
                        GetStartS5();

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
                    Biome_type = 1 + (int) (Math.random() * ((6 - 1) + 1));
                    Player_bottle = 0;
                    UnderEffecr = 0;

                    if (Restart_type == 1) {
                        init();
                    }
                    if (Restart_type == 2) {
                        //init_location_2();
                        Get_start_location_2();
                    }
                    if (Restart_type == 3) {
                        Get_start_location_3();
                    }
                    if (Restart_type == 4) {
                        Get_4_level();
                    }
                    if (Restart_type == 5) {
                        GetStartStory();
                    }
                    if (Restart_type == 6) {
                        GetStartS2();
                    }
                    if (Restart_type == 7) {
                        GetStartS3();
                    }
                    if (Restart_type == 8) {
                        GetStartS4();
                    }
                    if (Restart_type == 9) {
                        GetStartS5();
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


        if (InitOn == 0) {
            addKeyListener(new Keyboard());
            addMouseListener(mouseListener);




            InitOn = 1;
        }
        db.onGameLoaded(this);
        //Sound.playSound("sounds/Deep_Purple-Burn.wav").join();



        currentRoom = db.rooms.get("main_menu_room");
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




        db.backgrounds.get(room.background).sprite.getStep().sprite.draw(gl, 0,
                0);
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
    public void GetStartS5() {


        Level = 9;
        Story = 1;

        if (IsCreated == 0) {
            db.onGameLoaded(this);
            currentRoom = db.rooms.get("Storyroom5");
            db.objects.get("player").visible = true;
            AllDelete = 0;

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


            IsCreated = 1;
        }


    }
    public void DEC_roomback13_create(int w, int e) {

        final Roomback_13 chest = new Roomback_13(getFreeName("Roomback_13"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback12_create(int w, int e) {

        final Roomback_12 chest = new Roomback_12(getFreeName("Roomback_12"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback11_create(int w, int e) {

        final Roomback_11 chest = new Roomback_11(getFreeName("Roomback_11"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS4() {


        Level = 8;
        Story = 1;

        if (IsCreated == 0) {
            db.onGameLoaded(this);
            currentRoom = db.rooms.get("Storyroom4");
            db.objects.get("player").visible = true;
            AllDelete = 0;

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

            IsCreated = 1;
        }


    }
    public void DEC_roomback10_create(int w, int e) {

        final Roomback_10 chest = new Roomback_10(getFreeName("Roomback_10"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback9_create(int w, int e) {

        final Roomback_9 chest = new Roomback_9(getFreeName("Roomback_9"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback8_create(int w, int e) {

        final Roomback_8 chest = new Roomback_8(getFreeName("Roomback_8"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback7_create(int w, int e) {

        final Roomback_7 chest = new Roomback_7(getFreeName("Roomback_7"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_scriptdoor_create(int w, int e) {

        final Door_forr2 chest = new Door_forr2(getFreeName("Door_forr2"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartS3() {

        Level = 7;
        Story = 1;
        
        if (IsCreated == 0) {
            db.onGameLoaded(this);

            currentRoom = db.rooms.get("Storymap3");
            db.objects.get("player").visible = true;
            AllDelete = 0;

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


            IsCreated = 1;
        }


    }
    public void GetStartS2() {

        Level = 6;
        Story = 1;

        if (IsCreated == 0) {
            db.onGameLoaded(this);
            currentRoom = db.rooms.get("Storymap2");
            db.objects.get("player").visible = true;
            AllDelete = 0;

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

            IsCreated = 1;
        }


    }
    public void DEC_door_prop_create(int w, int e) {

        final Door_prop chest = new Door_prop(getFreeName("Door_prop"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback6_create(int w, int e) {

        final Roomback_6 chest = new Roomback_6(getFreeName("Roomback_6"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void GetStartStory() {

        Level = 5;
        Story = 1;

        if (IsCreated == 0) {
            db.onGameLoaded(this);
            currentRoom = db.rooms.get("Storymap1");
            db.objects.get("player").visible = true;
            AllDelete = 0;

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

            xpp = 32;
            for (int u = 0; u<=15; u++)
            {
                DEC_unviswall_create(561-xpp, 419, 0);
                xpp+=32;
            }
            DEC_unviswall_create(29, 419, 0);
            IsCreated = 1;
        }


    }
    public void DEC_door_create(int w, int e) {

        final Door chest = new Door(getFreeName("Door"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;
        //chest.z = 5;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_s_task_create(int w, int e) {

        final s_task chest = new s_task(getFreeName("Table"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;


        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_table_create(int w, int e) {

        final Table chest = new Table(getFreeName("Table"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;


        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback_5_create(int w, int e) {

        final Roomback_5 chest = new Roomback_5(getFreeName("Roomback_5"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;


        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback_4_create(int w, int e) {

        final Roomback_4 chest = new Roomback_4(getFreeName("Roomback_4"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;


        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_dirt_create(int w, int e) {

        final Dirt chest = new Dirt(getFreeName("Dirt"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;


        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_board_create(int w, int e) {

        final Board chest = new Board(getFreeName("Board"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;


        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_computer_create(int w, int e) {

        final Computer chest = new Computer(getFreeName("Computer"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;


        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback_3_create(int w, int e) {

        final Roomback_3 chest = new Roomback_3(getFreeName("Roomback_3"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback_2_create(int w, int e) {

        final Roomback_2 chest = new Roomback_2(getFreeName("Roomback_2"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;


        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_roomback_create(int w, int e) {

        final Roomback_1 chest = new Roomback_1(getFreeName("Roomback_1"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;


        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_carpet_create(int w, int e) {

        final Carpet chest = new Carpet(getFreeName("Carpet"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_window_create(int w, int e) {

        final Window chest = new Window(getFreeName("Window"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;


        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_cupboard_create(int w, int e) {

        final Cupboard chest = new Cupboard(getFreeName("Cupboard"));

        chest.x = w ;
        chest.y = e;
        chest.xt = w;
        chest.yt = e;

        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_unviswall_create(int w, int e, int t) {

            final UnVisWall chest = new UnVisWall(getFreeName("UnVisWall"));
             chest.Type = t;
            int wardenx = w;
            int wardeny = e;

            chest.x = wardenx;
            chest.y = wardeny;
            chest.xt = wardenx;
            chest.yt = wardeny;


            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);



    }
    public void DEC_bed_create(int w, int e) {

            final Bed chest = new Bed(getFreeName("Bed"));

            chest.x = w ;
            chest.y = e;
            chest.xt = w;
            chest.yt = e;


            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);



    }



    public void Get_4_level() {

        Level = 4;
        if (GameObject.plx >= 900 || GameObject.plx >= 900) {
            Restart_type = 4;
            AllDelete  =1;
        }
        if (GameObject.plx <= -10 || GameObject.plx <= -10) {
            Restart_type = 4;
            AllDelete  =1;
        }
        if (GameObject.ply >= 900 || GameObject.ply >= 900) {
            Restart_type = 4;
            AllDelete  =1;
        }
        if (GameObject.ply <= -10 || GameObject.ply <= -10) {
            Restart_type = 4;
            AllDelete  =1;
        }
        if (IsCreated == 0) {
            AllDelete = 0;
            db.onGameLoaded(this);
            GameObject.PlayerCanMovie = 0;

            currentRoom = db.rooms.get("map4_room");
            db.objects.get("player").visible = true;

            IsCreated = 1;




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
            if (Biome_type == 1) {
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
            } if (Biome_type == 2) {
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
            if (Biome_type == 3)
            {
                Cactus_create();
                Rock_create();
                Pesokman_create();
                MonsterCactus_create();

            }
            if (Biome_type == 4)
            {
                Ship_create();

                Inoplanetanin_create();
                Tarakan_create();
                Sphuyna_create();

            }
            if (Biome_type == 5)
            {
                rad_dec_create();
                Zombie_create();


            }
            if (Biome_type == 6)
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
    public void Get_start_location_3() {
        Level = 3;
        if (IsCreated == 0) {
            db.onGameLoaded(this);
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
            if (Biome_type == 1) {
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
            } if (Biome_type == 2) {
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
            if (Biome_type == 3)
            {
                Cactus_create();
                Rock_create();
                Pesokman_create();
                MonsterCactus_create();

            }
            if (Biome_type == 4)
            {
                Ship_create();
                Inoplanetanin_create();
                Tarakan_create();
                Sphuyna_create();
                //Rock_create();

            }
            if (Biome_type == 5)
            {
                rad_dec_create();
                Zombie_create();
                //Rock_create();
                //Inoplanetanin_create();

            }
            if (Biome_type == 6)
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
        if (CardCreate  == 0) {
            Card_create();
            CardCreate = 1;
        }
        if (Snow_create  == 0)
        {
            NPC_Snow_create();
            Snow_create = 1;
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


            db.objects.put(chest.name, chest);
            currentRoom.objectsIDs.add(chest.name);
            NPC_SantaDemon_create();

        }
    }
    public void NPC_Healthbar_create() {

        final Healthbar chest = new Healthbar(getFreeName("Healthbar"));

        chest.x = 32;
        chest.y = 32;



        db.objects.put(chest.name, chest);
        currentRoom.objectsIDs.add(chest.name);

    }
    public void NPC_Snow_create() {

            final Gun chest = new Gun(getFreeName("Gun"));

            chest.x = Snow_x;
            chest.y = Snow_y;
            chest.xt = Snow_x;
            chest.yt = Snow_y;
            chest.MST = Snow_MST;


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
            db.onGameLoaded(this);
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
            if (Biome_type == 1) {
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
            } if (Biome_type == 2) {
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
            if (Biome_type == 3)
            {
                Cactus_create();
                Rock_create();
                Pesokman_create();
                MonsterCactus_create();

            }
            if (Biome_type == 4)
            {
                Ship_create();
                Inoplanetanin_create();
                Sphuyna_create();
                Tarakan_create();
                //Rock_create();

            }
            if (Biome_type == 5)
            {
                rad_dec_create();
                Zombie_create();


            }
            if (Biome_type == 6)
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

            RatCreated = 1;
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
            db.onGameLoaded(this);
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
            if (Biome_type == 1) {
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
            } if (Biome_type == 2) {
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
            if (Biome_type == 3)
            {
                Cactus_create();
                Rock_create();
                Pesokman_create();
                MonsterCactus_create();

            }
            if (Biome_type == 4)
            {
                Ship_create();

                Inoplanetanin_create();
                Tarakan_create();
                Sphuyna_create();

            }
            if (Biome_type == 5)
            {
                rad_dec_create();
                Zombie_create();


            }
            if (Biome_type == 6)
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
            DEC_spruce_create();
        }


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


                chest.z = chest.y;

                chest.z = chest.y-200;

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

            chest.z = wardeny+4;
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
