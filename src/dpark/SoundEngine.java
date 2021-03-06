package dpark;

import dpark.Game;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

import javax.sound.sampled.*;

/**
 * @author STALKER_2010
 */
public class SoundEngine {
    public SoundEngine(final Game game) {
    }
    public Map<String, Media> sounds = new HashMap<>();
    public void load(final String path) {
        Media m = new Media(path);
        sounds.put(path, m);
    }
    public void play(final String path) {
        if (sounds.containsKey(path)) {
            final MediaPlayer mediaPlayer = new MediaPlayer(sounds.get(path));
            mediaPlayer.play();
        } else {
            System.err.println("SoundEngine: Attempt to play not loaded sound");
        }
    }
}
