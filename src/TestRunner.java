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
	
	
	/**
	 * the transcript of the test audio, which is in all lowercase with no punctuation
	 */
	final static String TRANSCRIPT = "all new style gameplay action scuba dive ride a motorcycle a baby t rex and go free roaming airborne in a plane";


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
