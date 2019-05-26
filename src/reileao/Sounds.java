/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reileao;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author igord
 */
public class Sounds {
    private static Clip bgsound;
    private static boolean bsound=true;
    
    public static void setBgsound(boolean bgsound) {
        Sounds.bsound = bgsound;
    }
    public static void deathSong() throws Exception{
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("Data/Sound/death.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(1);
    }
    public static void bgSound() throws Exception{
        if(bsound){
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("Data/Sound/lion1.wav"));
            bgsound = AudioSystem.getClip();
            bgsound.open(inputStream);
            bgsound.loop(Clip.LOOP_CONTINUOUSLY);
        } else bgsound.stop();
    }
    public static void damageSound() throws Exception{
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("Data/Sound/damage.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(0);
    }
    public static void mobSound() throws Exception{
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("Data/Sound/Boing.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(0);
    }
    public static void hyenaSound() throws Exception{
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("Data/Sound/hyena.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(0);
    }
}