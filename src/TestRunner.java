/**
 * testRunner.java
 * 
 * A simple class to test the alphabetizer
 * 
 * @author Kyle Mitard
 * Created 3 May 2020
 */

import java.io.IOException;

public class TestRunner
{
	
	/**
	 * the test audio, which consists of me reading from the back of the case of Crash Bandicoot Warped
	 */
	final static String FILE_NAME = "audio1.wav";
	
	/**
	 * the transcript of the test audio, which is in all lowercase with no punctuation
	 */
	final static String TRANSCRIPT = "all new style gameplay action scuba dive ride a motorcycle a baby t rex and go free roaming airborne in a plane";


	public static void main(String[] args) throws IOException
	{
		Alphabetizer a = new Alphabetizer();
		
		a.alphabetize(FILE_NAME, TRANSCRIPT);
	}

}
