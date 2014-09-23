package dpark.objects;

import dpark.Game;
import dpark.GameObject;

public class Player extends GameObject {
	@Override
	public void init() {
		super.init();
		sprite.currentStep = 0;
		sprite.isPlaying = false;
		sprite.addStep(Game.instance.getSprite("hero.png"));
		sprite.addStep(Game.instance.getSprite("hero_left.png"));
	}
}
