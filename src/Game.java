import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	public boolean leftPressed = false;
	public boolean rightPressed = false;
	public boolean one_pressed = false;
	public static Sprite main_img;
	public static Sprite hero_img;
	public BufferStrategy bss;
	public Graphics gl;
	public int gmlevel = 0; // 0 - Меню, 1 - начало игры
	public static JFrame frame;
	private static final long serialVersionUID = 1L;
	Boolean running;
	public JFrame fr_level_1;
	public int pi = 0;
	public static int plx = 50;
	public static int ply = 50;
	public int is_st22 = 0;
	public boolean gm_an_1 = false;
	public Graphics gl_2;
	Map<Integer, Integer> Wxx = new HashMap<Integer, Integer>();
	Map<Integer, Integer> Wyy = new HashMap<Integer, Integer>();
	int Wxx_now = 1;
	int Wyy_now = 1;
	private List<Animation> animations = new ArrayList<Animation>();

	public int pl_st = 0; // Сторона просмотра, 1 - up, 2 - right, 3 - down, 4 -
							// left

	public void clearImage(Graphics gtest) {

		gtest.setColor(Color.BLACK);
		gtest.fillRect(0, 0, getWidth(), getHeight());
		gtest.setColor(Color.BLACK);
	}

	public void start() {
		running = true;

		new Thread(this).start();
	}

	public void run() {
		long lastTime = System.currentTimeMillis();
		long delta = 0;
		init();

		while (running) {
			{
				delta = System.currentTimeMillis() - lastTime;
				lastTime = System.currentTimeMillis();
				for (Animation a : animations) {
					a.update(delta);
				}
			}
			update(delta);
			{
				delta = System.currentTimeMillis() - lastTime;
				lastTime = System.currentTimeMillis();
				for (Animation a : animations) {
					a.update(delta);
				}
			}
			Sprite cur = null;
			for (Animation a : animations) {
				if (a.isPlaying) {
					final Animation.Step st = a.getStep();
					if (st != null) {
						final Sprite c = st.sprite;
						if (c != null) {
							cur = c;
						}
					}
				}
			}
			render(cur);
		}
		// функция run появляется после того, как мы добавили
		// "implements Runnable"
	}

	public void init() {
		main_img = getSprite("logo.png");
		hero_img = getSprite("hero.png");
		addKeyListener(new Keyboard());
		{
			final Animation a = new Animation();
			a.isPlaying = false;
			a.addStep(getSprite("stop_22.png"));
			a.addStep(getSprite("stop_dest.png"));
			a.addStep(getSprite("video.png"));
			a.addStep(getSprite("video_2.png"));
			a.addStep(getSprite("video_3.png"));
			a.addStep(getSprite("video_4.png"));
			a.addStep(getSprite("video_5.png"));
			a.addStep(getSprite("video_6.png"));
			a.addStep(getSprite("video_7.png"));
			a.addStep(getSprite("video_8.png"));
			a.addStep(getSprite("video_9.png"));
			a.addStep(getSprite("video_10.png"));
			a.addStep(getSprite("stop_dest.png"));
			a.runAfterEnd = new Runnable() {
				@Override
				public void run() {
					Get_Start();
				}
			};
			animations.add(a);
		}
	}

	public void render(Sprite bg) {
		bss = getBufferStrategy();
		if (bss == null) {
			createBufferStrategy(2);
			requestFocus();
			return;
		}
		gl = bss.getDrawGraphics();
		gl.setColor(Color.black);
		gl.fillRect(0, 0, getWidth(), getHeight());
		if (bg != null) {
			bg.draw(gl, 5, 5);
		} else {
			main_img.draw(gl, 5, 5);
		}
		hero_img.draw(gl, plx, ply);
		bss.show();
		gl.dispose();

	}

	public void update(long delta) {
		if (leftPressed == true) {
			for (int i = 1; i < Wxx_now; i++) {
				if (plx == Wxx.get(i)) {
					plx--;
				}
			}

		}
		if (rightPressed == true) {
			for (int i = 1; i < Wxx_now; i++) {
				if (plx == Wxx.get(i)) {
					plx++;
				}
			}

		}
		if (one_pressed == true) {

			GetLevel_2();
			one_pressed = false;

		}
		if (pl_st == 2) {
			hero_img = getSprite("hero.png");
		}
		if (pl_st == 4) {
			hero_img = getSprite("hero_left.png");
		}

	}

	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	public static String NAME = "Daupret park, debug";

	public static void main(String[] args) {

		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		JFrame frame = new JFrame(Game.NAME);

		frame.setLayout(new BorderLayout());
		frame.add(game, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		game.start();

	}

	public void Get_Start() {
		GRPHS_ins_2lvl();
		gmlevel = 1;
		hero_img = getSprite("hero.png");

	}

	public void GetLevel_2() {

		pi = 0;

		final Animation acur = animations.get(0);
		acur.reset();
		acur.isPlaying = true;
		// main_img = getSprite("stop_dest.png");

		// one_pressed = false;

	}

	public void GRPHS_ins_2lvl() {

		// gl_2 = bss.getDrawGraphics();
		// gl_2.setColor(Color.black);
		// gl_2.fillRect(0, 0, getWidth(), getHeight());
		Crate_create(0, 0);
		Crate_create(16, 16);
		Crate_create(32, 32);
		Crate_create(48, 48);
		// gl_2.dispose();
	}

	public void Crate_create(int xa, int ya) {
		Sprite tex;
		tex = getSprite("Blockstone.png");
		tex.draw(gl, xa, ya);
		Wxx.put(Wxx_now, xa);
		Wyy.put(Wyy_now, ya);
		Wxx_now++;
		Wyy_now++;
	}

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

		public void keyPressed(KeyEvent w) {
			if (gmlevel == 1) {
				if (w.getKeyCode() == KeyEvent.VK_A) {
					leftPressed = true;
					pl_st = 4;
				}
				if (w.getKeyCode() == KeyEvent.VK_D) {
					rightPressed = true;
					pl_st = 2;
				}
			}
			if (w.getKeyCode() == KeyEvent.VK_1) {

				one_pressed = true;

			}

		}

		public void keyReleased(KeyEvent w) { // клавиша отпущена
			if (gmlevel == 1) {
				if (w.getKeyCode() == KeyEvent.VK_A) {
					leftPressed = false;
				}
				if (w.getKeyCode() == KeyEvent.VK_D) {
					rightPressed = false;
				}
			}
		}

	}

}
