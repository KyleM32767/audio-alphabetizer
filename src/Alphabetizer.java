/**
 * Alphabetizer.java
 * 
 * A class that alphabetizes 
 * 
 * @author Kyle Mitard
 * Created 3 May 2020
 */

import java.io.IOException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import edu.cmu.sphinx.api.SpeechAligner;
import edu.cmu.sphinx.result.WordResult;

public class Alphabetizer
{
	
	/* ===============================================================================================================================
	 * INSTANCE VARIABLES
	 * =============================================================================================================================== */
	
	/**
	 * the default path to the acoustic model, which is just the standard Endlish one included with CMUSphinx
	 */
	final String DEFAULT_ACOUSTIC_MODEL = "resource:/edu/cmu/sphinx/models/en-us/en-us";
	
	
	/**
	 * the default path to the dictionary, which is just the standard English one included with CMUSphinx
	 */
	final String DEFAULT_DICTIONARY = "resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict";
	
	
	/**
	 * The object that aligns the audio to the transcript
	 */
	private SpeechAligner aligner;
	
	
	/**
	 * the URL to the audio file
	 */
	private URL fileURL;
	
	
	/**
	 * ArrayList containing the words with their timestamps
	 */
	private ArrayList<WordResult> alignedTranscriptt;

	
	/* ===============================================================================================================================
	 * METHODS
	 * =============================================================================================================================== */

	/**
	 * Default Constructor, which uses the default acoustic model 
	 */
	public Alphabetizer() throws MalformedURLException, IOException
	{
		aligner = new SpeechAligner(DEFAULT_ACOUSTIC_MODEL, DEFAULT_DICTIONARY, null);
	}
	
	public void alphabetize(String fileName, String transcript) throws IOException
	{
		//initialize some things
		fileURL = (new File(fileName)).toURI().toURL();
		
		
	}

}
