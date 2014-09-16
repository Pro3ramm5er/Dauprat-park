import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class Animation {
	private final Map<Integer, Step> steps = new HashMap<Integer, Step>();
	public boolean isPlaying = false;
	private long lastTime = System.currentTimeMillis();
	public long startStepTime = -1;
	public int currentStep = -1;
	public long speed = 2;

	public void update(long delta) {
		lastTime = lastTime + delta;
		if (isPlaying) {
			if (startStepTime == -1) {
				startStepTime = System.currentTimeMillis();
			}
			currentStep++;
			final int newStep = Long
					.valueOf((lastTime - startStepTime) / speed).intValue();
			currentStep = newStep;
		}
	}

	public void reset() {
		currentStep = -1;
		startStepTime = -1;
	}

	public Step getStep() {
		if (steps.containsKey(currentStep)) {
			return steps.get(currentStep);
		}
		System.err.println("Step No. " + currentStep + " not found!");
		return null;
	}

	public void addStep(Sprite sprite) {
		Step s = new Step();
		s.i = steps.size();
		s.sprite = new WeakReference<Sprite>(sprite);
		steps.put(s.i, s);
	}

	public class Step {
		public WeakReference<Sprite> sprite;
		public int i;
	}
}
