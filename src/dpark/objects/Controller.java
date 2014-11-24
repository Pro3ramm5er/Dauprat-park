package dpark.objects;

import java.awt.event.KeyEvent;

import dpark.Game;
import dpark.GameObject;

public class Controller extends GameObject {
	public Controller(String name) {
		super(name);
		visible = false;
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
	}
}
