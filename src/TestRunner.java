/**
 * testRunner.java
 * 
 * A simple class to test the alphabetizer using a simple recording
 * 
 * I know I could very well have put this on the Alphabetizer class but I already 
 * made it and can't be bothered to change it.
 * 
 * @author Kyle Mitard
 * 
 * Created 3 May 2020
 * Updated 4 May 2020
 */

import java.io.IOException;

public class TestRunner
{
	
	/**
	 * the test audio, which consists of me reading from the back of the case of Crash Bandicoot Warped
	 */
	final static String FILE_NAME = "audio_files/audio1.wav";
			//"roadwork.wav";
			//"scottbradford.wav";
			//"cantbelieve.wav";
			//"novegetal.wav";
			//"icced.wav";
									
	
	
	/**
	 * the transcript of the test audio, which is in all lowercase with no punctuation
	 */
	final static String TRANSCRIPT = "all new style gameplay action scuba dive ride a motorcycle a baby t rex and go free roaming airborne in a plane";
			//"road work ahead uh yeah i sure hope it does";
			//"my names scott bradford i'm nineteen i'm gonna be twenty in like december";
			//"so basically um what i was thinking of was um ah fuck i can't believe you done this";
			//"where is my food her es your stank with no vegetal as you ordered sir cool and good did someone said no vegetals i taste a vegetal angry";
			//"hello friend may i acquire bepsu i pay you virtuale monet yes here you have it now you can drink your bepes in freedom from any form of interruption or disturbance ooh ahh refreshing i feel moisten but i am disrupted by the absence of ice cuboids i feel angry did some carbon based lifeform just say ice get icced dummy retweet for free ipod you may now access the octahedron";
			

	public static void main(String[] args) throws IOException, InterruptedException
	{
		//initialize the aplhabetizer
		Alphabetizer a = new Alphabetizer();
		
		//alphabetize the audio file
		a.alphabetize(FILE_NAME, TRANSCRIPT);
		
		System.out.println("Done!");
		
		//TODO somehow make the output file
	}

}
