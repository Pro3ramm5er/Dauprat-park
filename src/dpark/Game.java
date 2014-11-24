package dpark;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dpark.GameObject;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import dpark.objects.DEC_Chest;

import dpark.objects.*;

import static dpark.DB.db;

/**
 * 
 * @author Pro3ramm5er, STALKER_2010
 * 
 */
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = -5445130295019858065L;
	public BufferStrategy bss;
	public Graphics gl;
	private boolean running = false;
	public static Game instance;
	public Map<Integer, Integer> Wxx = new HashMap<Integer, Integer>();
	public Map<Integer, Integer> Wyy = new HashMap<Integer, Integer>();
	public int Wxx_now = 1;
	public int Wyy_now = 1;
    public int ismescrt = 0;
    public static int Applecalipses = 0;
	public static Room currentRoom;
    public static int VisibleDieLogo = 0;


	public Game() {
		instance = this;
	}

	public void clearImage(Graphics gtest) {
		gtest.setColor(Color.BLACK);
		gtest.fillRect(0, 0, getWidth(), getHeight());
		gtest.setColor(Color.BLACK);
	}

	public void start() {
		running = true;

		new Thread(this).start();
	}

	public static final int FPS = 25;
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
				currentRoom.update();
				for (GameObject o : db.objects.values()) {
					o.update();
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
		addKeyListener(new Keyboard());
		addMouseListener(mouseListener);
		db.onGameLoaded(this);
		currentRoom = db.rooms.get("main_menu_room");
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

	public static void main(String[] args) {

		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		JFrame frame = new JFrame(Game.NAME);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(game, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		game.start();

	}
    public static void Get_End()
    {

        currentRoom = db.rooms.get("main_menu_room");

    }
    public void Get_Die()
    {

    }
	public void Get_Start() {
        GameObject.PlayerCanMovie = 0;
        currentRoom = db.rooms.get("map1_room");
        db.objects.get("player").visible = true;


        //db.objects.get("key_need").visible = true;
        /*
		Crate_create(0, 0);
        Crate_create(0, 32);
        Crate_create(0, 64);
        Crate_create(0, 96);
        Crate_create(0, 128);
        Crate_create(0, 160);
        Crate_create(0, 192);
        Crate_create(0, 224);
        Crate_create(0, 256);
        Crate_create(0, 288);
        Crate_create(0, 320);
        Crate_create(0, 352);
        Crate_create(0, 384);
        Crate_create(0, 416);
        Crate_create(0, 448);
        Crate_create(0, 480);
        Crate_create(0, 512);
        Crate_create(0, 544);
        Crate_create(0, 576);
        Crate_create(0, 608);
        Crate_create(0, 640);
        Crate_create(0, 672);
        Crate_create(0, 704);
        Crate_create(0, 736);
        Crate_create(0, 768);
        Crate_create(0, 800);
        */
        int xcr = 0;
        int icr = 0;
        int i = 0;
        for (i = 0; i < 25; i++) {
            Crate_create(xcr, icr);
            xcr += 32;
        }


        i = 0;
        xcr = 0;
        icr = 0;
        for (i = 0; i <= 10; i++) {

            icr += 32;
            Crate_create(xcr, icr);
        }


        i = 0;
        xcr = 0;
        icr = icr + 128;
        for (i = 0; i <= 2; i++) {

            icr += 32;
            Crate_create(xcr, icr);
        }

        i = 0;
        xcr = 0;
        //icr = icr+760;
        for (i = 0; i <= 23; i++) {

            xcr += 32;
            Crate_create(xcr, icr);
        }


        i = 0;
        xcr = 768;
        icr = 0;
        for (i = 0; i <= 22; i++) {

            icr += 32;
            Crate_create(xcr, icr);
        }

        Mdoor_create(0, 384);
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
        DEC_chest_create();
        DEC_chest_create();
        DEC_chest_create();
        DEC_chest_create();
        DEC_chest_create();
        DEC_chest_create();
        DEC_chest_create();
        DEC_chest_create();





	}
    public void DEC_chest_create()
    {
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
    public void DieLogoCreate()
    {

      final DieLogo dlg = new DieLogo(getFreeName("Dielogo"));
        dlg.x = 0;
        dlg.y = 0;

        db.objects.put(dlg.name, dlg);
        currentRoom.objectsIDs.add(dlg.name);
    }


    public void AppleCalipse()
    {


        Applecalipses = 1;
        //System.out.println("Game/Applecalipses = 1");



    }
    public void AppleGet(int xp, int yp, int rep, int rey)
    {
        final AppleS aplk = new AppleS(getFreeName("appleDEC"));
        //System.out.println("Ready.");
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

	public void GRPHS_ins_2lvl() {


		
		
		
		// gl_2.dispose();
	}
    public  void Mdoor_create(int xau, int yau)
    {
        final main_door md = new main_door(getFreeName("Main_Door"));
        md.x = xau;
        md.y = yau;
        md.xd = xau;
        md.yd = yau;

        db.objects.put(md.name, md);
        currentRoom.objectsIDs.add(md.name);
    }


    public static void MessageAkey_create()
    {
        KeyMessage kms1 = new KeyMessage("Message");

        kms1.x = 32;
        kms1.y = 32;
        kms1.z = 50;
        db.objects.put(kms1.name, kms1);
        currentRoom.objectsIDs.add(kms1.name);
    }
	public void Crate_create(int xa, int ya) {
		{
			final Crate c = new Crate(getFreeName("crate"));
			
			

			c.x = xa;
			c.y = ya;
			c.xa1 = xa;
			c.ya1 = ya;
            //c.xa2 = xa;
            //c.ya2 = ya;

			/*
			GameObject.Coll_init(xa-16, ya-16);
			GameObject.x_use++;
			GameObject.y_use++;
			*/
			db.objects.put(c.name, c);
			currentRoom.objectsIDs.add(c.name);
		}
		//Wxx.put(Wxx_now, xa);
		//Wyy.put(Wyy_now, ya);
		//Wxx_now++;
		//Wyy_now++;
		
	}


    public void AppleCreate(int rt, int rt1) {
        {
            final AppleD fr = new AppleD(getFreeName("apple"));
            int wardenx = 50 + (int) (Math.random() * ((600 - 50) + 1));
            int wardeny = 50 + (int) (Math.random() * ((600 - 50) + 1));
            /*
            if (wardenx == 1)
            {
                fr.x = 250;
                fr.y = 200;
                fr.xt = 250;
                fr.yt = 200;

            }
            if (wardenx == 2)
            {
                fr.x = 50;
                fr.y = 0;
                fr.xt = 50;
                fr.yt = 0;

            }
            if (wardenx == 3)
            {
                fr.x = 350;
                fr.y = 30;
                fr.xt = 350;
                fr.yt = 30;

            }
            if (wardenx == 4)
            {
                fr.x = 150;
                fr.y = 100;
                fr.xt = 150;
                fr.yt = 100;

            }
            */
            fr.x = wardenx;
            fr.y = wardeny;
            fr.xt = wardenx;
            fr.yt = wardeny;
            fr.z = -5;

            //System.out.println("Game/Objects/AppleD created" + ":" + rt + ":" + rt1);

            db.objects.put(fr.name, fr);
            currentRoom.objectsIDs.add(fr.name);
        }
        //Wxx.put(Wxx_now, xa);
        //Wyy.put(Wyy_now, ya);
        //Wxx_now++;
        //Wyy_now++;

    }

    public void Apple_Dublicate(int rt, int rt1) {
        {
            final AppleS fr = new AppleS(getFreeName("apple"));
            fr.x = rt;
            fr.y = rt1;
            fr.z = -5;

            //System.out.println("Game/Objects/AppleD dublicated" + ":" + rt + ":" + rt1);

            //db.objects.put(fr.name, fr);
            //currentRoom.objectsIDs.add(fr.name);
        }
        //Wxx.put(Wxx_now, xa);
        //Wyy.put(Wyy_now, ya);
        //Wxx_now++;
        //Wyy_now++;

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
