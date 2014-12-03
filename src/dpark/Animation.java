package dpark;

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
    private long countFrames = -1;
    public int currentStep = 0;
    public Runnable runAfterEnd = null;
    public String name = "";

    public Animation(String name) {
        this.name = name;
    }

    /**
     * Update current step number
     */
    public void update() {
        if (isPlaying) {
            countFrames++;
            {
                int curID = 0;
                currentStep = 0;
                for (int i = 0; i < steps.size(); i++) {
                    final Step st = steps.get(i);
                    if ((curID + st.nextSpeed) <= countFrames) {
                        curID += st.nextSpeed;
                        currentStep++;
                    }
                }
            }
            if (currentStep == steps.size()) {
                runAfterEnd.run();
                isPlaying = false;
            } else {
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
        currentStep = 0;
        countFrames = -1;
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
        new RuntimeException("Step No. " + currentStep + " not found!")
                .printStackTrace(System.err);
        return null;
    }

    /**
     * Add step in the end of queue
     *
     * @param sprite Sprite to add
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
        public long nextSpeed = (long) (0.05 * Game.FPS);
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
