package dpark.objects;

import dpark.Game;
import dpark.GameObject;

public class Crate extends GameObject {
	@Override
	public void init() {
		super.init();
		depth = -5;
		sprite.currentStep = 0;
		sprite.isPlaying = false;
		sprite.addStep(Game.instance.getSprite("Blockstone.png"));
	}
}
