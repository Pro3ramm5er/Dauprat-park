package dpark;
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

import javax.sound.sampled.*;
/**
 * @author Nickita
 */
import sun.audio.*;
import java.io.*;

public class MusicPlayer {

    public String filename;

    public MusicPlayer(String filename) {
        this.filename = filename;
    }
    public void Load(String f)
    {
        filename = f;
    }
    public void play() {
        try {
            InputStream in = new FileInputStream(filename);
            AudioStream as = new AudioStream(in);
            AudioPlayer.player.start(as);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
