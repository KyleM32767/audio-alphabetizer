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

# returns a list of ints that are converted from a given string of values separated by commas
def toIntList(string):
	strList = string.split(',')[:-1]
	intList = []
	for s in strList:
		intList.append(int(s))
	return intList

# get information from the arguements
inFile = sys.argv[1]
outFile = sys.argv[2]
start_timestamps = toIntList(sys.argv[3])

# import audio segment
inAudio = AudioSegment.from_wav(inFile)

# if the end timestamps are given as a fourth argument, end splices using those timestamps (no gap mode)
if len(sys.argv) == 5:
	
	end_timestamps = toIntList(sys.argv[4])

	# initialize output audio
	outAudio = inAudio[start_timestamps[0]:end_timestamps[0]]

	# increment through the start timestamps list, adding to the output audio
	for i in range(1,len(start_timestamps)):
		outAudio += inAudio[start_timestamps[i]:end_timestamps[i]]


# if they aren't given, end splices at the start of the next word
else:

	# sort start_timestamps in chronological order
	sortedTimestamps = sorted(start_timestamps)

	# add the end of the track to the sorted start timestamps
	sortedTimestamps.append(len(inAudio))
	print(sortedTimestamps)

	# initialize output audio
	outAudio = getWordAudio(start_timestamps[0])

	# increment through the start timestamps list, adding to the output audio
	for i in range(1,len(start_timestamps)):
		outAudio += getWordAudio(start_timestamps[i])

# export the output audio
outAudio.export(outFile, format='wav')