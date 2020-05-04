/**
 * Alphabetizer.java
 * 
 * A class that splices and joins audio in such a way that all of the words are
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
	
	/**
	 * flag for when I am testing/debugging in order to print information
	 */
	private boolean TESTING = true;
	
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
	 * the audio file being alphabetized
	 */
	private File audioFile;
	
	
	/**
	 * the URL to the audio file
	 */
	private URL audioURL;
	
	
	/**
	 * ArrayList containing the words with their timestamps
	 */
	private ArrayList<WordResult> alignedTranscript;

	
	/* ===============================================================================================================================
	 * METHODS
	 * =============================================================================================================================== */

	/**
	 * Default Constructor, which uses the default acoustic model 
	 * 
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public Alphabetizer() throws MalformedURLException, IOException
	{
		aligner = new SpeechAligner(DEFAULT_ACOUSTIC_MODEL, DEFAULT_DICTIONARY, null);
	}
	
	
	/**
	 * Constructor for overriding the default configurations of CMUSphinx
	 * 
	 * @param amPath 	path to an acoustic model
	 * @param dictPath	path to a dictionary
	 * @param g2pPath	not exactly sure what this is but it can just be left as null
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public Alphabetizer(String amPath, String dictPath, String g2pPath) throws MalformedURLException, IOException
	{
		aligner = new SpeechAligner(amPath, dictPath, g2pPath);
	}
	
	
	@SuppressWarnings("unchecked")
	/**
	 * Alphabetizes a given audio file using a transcript
	 * 
	 * In order to make sure for this to work properly, CMUSphinx must get exactly what it
	 * needs. This means:
	 * 
	 * - The audio must be the following format EXACTLY (pasted from the CMUSphinx website):
	 * 		RIFF (little-endian) data, WAVE audio, Microsoft PCM, 16 bit, mono 16000 Hz
	 * 
	 * - The transcript supposedly has to be all lowercase with no punctuation (but I find that
	 * 	some things you can get away with like apostraphes in contractions like "don't")
	 * 
	 * With that said, if you know what you're doing with CMUSphinx then I guess you could
	 * ignore me and configure it however you desire. I'm neither your dad nor CMUSphinx's.
	 * 
	 * @param fileName		the path to the audio file, which MUST be a wav file
	 * @param transcript	the transcript
	 * @throws IOException
	 * @throws IllegalArguementException if fileName does not end with ".wav"
	 */
	public void alphabetize(String fileName, String transcript) throws IOException
	{
		// throw an IllegalArguementException if the file referenced is not a wav file
		if (!fileName.substring(fileName.length() - 4, fileName.length()).equalsIgnoreCase(".wav"))
			throw new IllegalArgumentException("Audio file must be in WAV format");
		
		
		//initialize the audio file and URL
		audioFile = new File(fileName);
		audioURL = audioFile.toURI().toURL();
		
		
		//allign the transcript
		alignedTranscript = (ArrayList) (aligner.align(audioURL, transcript));
		
		
		//if testing flag is true, print information pertaining to the alignment
		if (TESTING)
		{
			for (WordResult w: alignedTranscript)
			{
				System.out.println(w);
			}
			System.out.println("number of words: " + alignedTranscript.size());
		}
		
		
		//sort the aligned transcript in alphabetical order using insertion sort
		int minIndex;
		
		for (int i = 0; i < alignedTranscript.size() - 1; i++)
		{
			minIndex = i;
			
			for (int j = i; j < alignedTranscript.size(); j++)
			{
				if (alignedTranscript.get(j).getWord().toString().compareTo(alignedTranscript.get(minIndex).getWord().toString()) < 0)
					minIndex = j;
			}
			
			alignedTranscript.add(i, alignedTranscript.remove(minIndex));
		}
		
		
		//if testing flag is true, print information pertaining to the alignment
		if (TESTING)
		{
			for (WordResult w: alignedTranscript)
			{
				System.out.println(w);
			}
			System.out.println("number of words: " + alignedTranscript.size());
		}
		
		
		Runtime.getRuntime().exec("python spliceAudio.py " + fileName + " output.wav");
	}

}
