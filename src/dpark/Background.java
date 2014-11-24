package dpark;

public class Background {
	public Animation sprite;
	public String name = "";
	public boolean visible = true;

	public Background(String name, Sprite sprite) {
		this.name = name;
		this.sprite = new Animation(name + "_synth_anm");
		this.sprite.isPlaying = false;
		this.sprite.currentStep = 0;
		if (sprite != null) {
			this.sprite.addStep(sprite);
		}
	}
}
