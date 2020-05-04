'''

	spliceAudio.py

	The portion of the audio alphabetizer that actually splices
	and rejoins the alphabetized audio.

	Author: Kyle Mitard
	Created 4 May 2020

	I am doing this in Python because this task is so needlessly
	complicated in Java, and PyDub allows me to just get this
	working for the moment as a proof of concept. I can learn
	the Java stuff later when I want to make a polished version
	that is just one standalone executable JAR file 

'''

from pydub import audioSegment
import sys

inFile = sys.argv[1]
outFile = sys.argv[2]

# import audio segment
audio = AudioSegment.from_mp3(inFile)

# get duration in milliseconds
duration = len(audio)

# split it in half
lastHalf = audio[-duration // 2:]
firstHalf = audio[:duration // 2]

# recombine the halves in reverse order
swappedHalvesAudio = lastHalf + firstHalf

swappedHalvesAudio.export('outFile', format='wav')
