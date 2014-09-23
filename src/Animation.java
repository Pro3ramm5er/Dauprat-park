import java.util.HashMap;
import java.util.Map;

/**
 * Animation class, to make creating animations easier
 * 
 * @author STALKER_2010
 */
public class Animation {
	private final Map<Integer, Step> steps = new HashMap<Integer, Step>();
	public boolean isPlaying = false;
	private long lastTime = System.currentTimeMillis();
	public long startStepTime = -1;
	public int currentStep = -1;
	public long defaultSpeed = 2 * 1000;
	public Runnable runAfterEnd = null;

	/**
	 * Update current step number
	 * 
	 * @param delta
	 *            delta time from last call
	 */
	public void update(long delta) {
		lastTime = lastTime + delta;
		if (isPlaying) {
			if (startStepTime == -1) {
				startStepTime = System.currentTimeMillis();
			}
			final int newStep = Long
					.valueOf((lastTime - startStepTime) / defaultSpeed).intValue();
			currentStep = newStep;
			if (currentStep == steps.size()) {
				runAfterEnd.run();
				isPlaying = false;
			} else {
				System.out.println("currentStep=" + currentStep);
				try {
					final Runnable r = steps.get(currentStep).onChangeTo;
					if (r != null) {
						r.run();
					}
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Reset current step number
	 */
	public void reset() {
		currentStep = -1;
		startStepTime = -1;
	}

	/**
	 * Get current step to draw.
	 * 
	 * @return Animation.Step container for one picture
	 */
	public Step getStep() {
		if (steps.containsKey(currentStep)) {
			Step s = steps.get(currentStep);
			final Runnable r = s.onGet;
			if (r != null) {
				r.run();
			}
			return s;
		}
		System.err.println("Step No. " + currentStep + " not found!");
		return null;
	}

	/**
	 * Add step in the end of queue
	 * 
	 * @param sprite
	 *            Sprite to add
	 */
	public Step addStep(Sprite sprite) {
		Step s = new Step();
		s.id = steps.size();
		s.sprite = sprite;
		steps.put(s.id, s);
		return s;
	}

	/**
	 * One frame in animation
	 * 
	 * @author STALKER_2010
	 */
	public class Step {
		public Sprite sprite = null;
		public int id = -1;
		public int nextSpeed = 2;
		public Runnable onChangeTo = null;
		public Runnable onGet = null;

		public long getMyTime() {
			long d = 0;
			for (int i = 0; i < id; i++) {
				d += steps.get(i).nextSpeed;
			}
			return d;
		}
	}
}
