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

# imports
from pydub import AudioSegment
import sys

# returns an AudioSegment that starts at a given timestamp and ends at the next word
def getWordAudio(x):
	global sortedTimestamps, inAudio
	i = sortedTimestamps.index(x)
	print(sortedTimestamps[i], sortedTimestamps[i+1])
	return inAudio[x:sortedTimestamps[i+1]]

# get information from the arguements
inFile = sys.argv[1]
outFile = sys.argv[2]
timestamps = sys.argv[3].split(',')[:-1]

# typecast timestamps from string to int
for i in range(0,len(timestamps)):
	timestamps[i] = int(timestamps[i])

# import audio segment
inAudio = AudioSegment.from_wav(inFile)

# sort timestamps in chronological order
sortedTimestamps = sorted(timestamps)

# add the end of the track to the sorted timestamps
sortedTimestamps.append(len(inAudio))
print(sortedTimestamps)

# initialize output audio
outAudio = getWordAudio(timestamps[0])

# increment through the timestamps list, adding to the output audio
for i in range(1,len(timestamps)):
	outAudio += getWordAudio(timestamps[i])

# export the output audio
outAudio.export(outFile, format='wav')