# audio-alphabetizer

An automated tool for alphabetizing audio files, inspired by weird videos such as [this one,](https://www.youtube.com/watch?v=5GFW-eEWXlc) which I find to be strangely funny for no particular reason.

This project uses the following libraries:
* [CMUSphinx](https://cmusphinx.github.io/) to obtain the timing of the words
* [PyDub](http://pydub.com/) to splice and join the audio accordingly 

With that said, the usage of PyDub is only temporary at the moment, since I would eventually like to have all of the source code in Java so I can make it all into one executable JAR file.

**Please note** that CMUSphinx is *very* picky in the format of the audio it aligns. The audio must have the following format **exactly,** as per the CMUSphinx website:

> RIFF (little-endian) data, WAVE audio, Microsoft PCM, 16 bit, mono 16000 Hz

Also, in order for it to pick up every word there must be little to no background noise in the recording. Here is what I've tried:

| Source | Result |
| :---: | :---: |
| [Road work ahead?](https://www.youtube.com/watch?v=9sPthPleEKo) | Works flawlessly |
| [Scott Bradford](https://www.youtube.com/watch?v=Pbkn21NNduc) | Works well until the end |
| [I can't believe you've done this](https://www.youtube.com/watch?v=8lBO23Dh23I) | Works flawlessly (although I did cut out the last ~2 seconds) |
| [No Vegetal](https://www.youtube.com/watch?v=BozJwAFK2Io) | A few words are missed (particularly the ones with the overboosted audio) |
| [Icced](https://www.youtube.com/watch?v=akGpGA3jYek) | Barely anything is picked up |