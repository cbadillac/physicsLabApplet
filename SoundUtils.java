import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class SoundUtils {

  public static float SAMPLE_RATE = 8000f;
  static byte[] buf = new byte[1];
  static AudioFormat af = 
	        new AudioFormat(
	            SAMPLE_RATE, // sampleRate
	            8,           // sampleSizeInBits
	            1,           // channels
	            true,        // signed
	            false);

  
  public void SoundUtils(int hz, int msecs) 
     throws LineUnavailableException 
  {
    
  }

  public static void play(int hz, int msecs, double vol)
      throws LineUnavailableException 
  {

 
    SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
    sdl.open(af);
    sdl.start();
    for (int i=0; i < msecs*8; i++) {
      double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
      buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
      sdl.write(buf,0,1);
    }
    sdl.drain();
    sdl.stop();
    sdl.close();
  }
  
  public static void playBeep(){
	  try {
		  File yourFile;
		  AudioInputStream stream;
		  AudioFormat format;
		  DataLine.Info info;
		  Clip clip;
		  
		  yourFile = new File("clock.wav");

		  stream = AudioSystem.getAudioInputStream(yourFile);
		  format = stream.getFormat();
		  info = new DataLine.Info(Clip.class, format);
		  clip = (Clip) AudioSystem.getLine(info);
		  clip.open(stream);
		  clip.start();
		  clip.close();
	  }
	  catch (Exception e) {
		  //whatevers
	  }
  }
 
}