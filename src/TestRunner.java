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
	final static String INPUT_FILE = //"audio_files/audio1.wav";
			//"roadwork.wav";
			//"scottbradford.wav";
			//"cantbelieve.wav";
			//"novegetal.wav";
			//"icced.wav";
			"steamedhams.wav";
									
	
	/**
	 * the transcript of the test audio, which is in all lowercase with no punctuation
	 */
	final static String TRANSCRIPT = //"all new style gameplay action scuba dive ride a motorcycle a baby t rex and go free roaming airborne in a plane";
			//"road work ahead uh yeah i sure hope it does";
			//"my names scott bradford i'm nineteen i'm gonna be twenty in like december";
			//"so basically um what i was thinking of was um ah fuck i can't believe you done this";
			//"where is my food her es your stank with no vegetal as you ordered sir cool and good did someone said no vegetals i taste a vegetal angry";
			//"hello friend may i acquire bepsu i pay you virtuale monet yes here you have it now you can drink your bepes in freedom from any form of interruption or disturbance ooh ahh refreshing i feel moisten but i am disrupted by the absence of ice cuboids i feel angry did some carbon based lifeform just say ice get icced dummy retweet for free ipod you may now access the octahedron";
			"Well, Seymour, I made it despite your directions. Ah. Superintendent Chalmers. Welcome. I hope you're prepared for an unforgettable luncheon. Yeah. Oh, egads! My roast is ruined. But what if I were to purchase fast food and disguise it as my own cooking? Delightfully devilish, Seymour. Ah Skinner with his crazy explanations The superintendent's gonna need his medication When he hears Skinner's lame exaggerations There'll be trouble in town tonight Seymour! Superintendent, I was just uh, just stretching my calves on the window sill. Isometric exercise. Care to join me? Why is there smoke coming out of your oven, Seymour? Uh Oh. That isn't smoke. It's steam. Steam from the steamed clams we're having. Mm Steamed clams. Whew. Superintendent, I hope you're ready for mouth watering hamburgers. I thought we were having steamed clams. oh, no. I said steamed hams. That's what I call hamburgers. You call hamburgers steamed hams? Yes. It's a regional dialect. Uh huh. Uh, what region? - Uh, upstate New York. Really. Well, I'm from Utica, and I've never heard anyone use the phrase \"steamed hams. \" Oh, not in Utica. No. It's an Albany expression. I see. You know, these hamburgers are quite similar to the ones they have at crusty Burger. Oh, no. Patented Skinner burgers. Old family recipe. For steamed hams. Yes. Yes. And you call them steamed hams despite the fact that they are obviously grilled. Ye You know, the One thing I should - Excuse me for one second. Of course. Well, that was wonderful. A good time was had by all. I'm pooped. Yes. I should be Good Lord! What is happening in there? - Aurora borealis. Uh Aurora borealis at this time of year at this time of day in this part of the country localized entirely within your kitchen? - Yes. May I see it? No. Seymour. ! The house is on fire. ! No, Mother. It's just the northern lights. Well, Seymour, you are an odd fellow but I must say you steam a good ham.";

	
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		//initialize the aplhabetizer
		Alphabetizer a = new Alphabetizer();
		
		//alphabetize the audio file
		a.prepareAudio(INPUT_FILE, TRANSCRIPT);
		
		//a.alphabetize("audio_files/output.wav");
		a.alphabetizeNoGap("audio_files/output_NOGAP.wav");
		
		System.out.println("Done!");
		
		//TODO somehow make the output file
	}

}
