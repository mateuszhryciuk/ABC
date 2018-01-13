package application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.AudioClip;

import java.util.*;
//import java.io.File;
//import javafx.scene.image.Image;


	
	
		
		
	
			
			
public class AudioPlayer {
	
	ArrayList<AudioClip> player =  new ArrayList<>();

	
	AudioPlayer(){
	
	
	player.add(new AudioClip (getClass().getClassLoader().getResource("A.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("B.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("C.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("D.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("E.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("F.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("G.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("H.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("I.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("J.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("K.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("L.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("M.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("N.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("O.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("P.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("Q.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("R.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("S.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("T.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("U.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("V.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("W.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("X.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("Y.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("Z.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("xylophone.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("hit.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("miss.wav").toString()));
	player.add(new AudioClip (getClass().getClassLoader().getResource("brawo.wav").toString()));
	


	
	}

}
 