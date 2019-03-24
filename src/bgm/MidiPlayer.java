package bgm;

import java.net.*;

import javax.sound.midi.*;

import java.io.IOException;

/**
 * Plays a midi file
 * @author Ashwin
 *
 */
public class MidiPlayer {
	
	private Sequencer sequencer;
	private String filename;
	private boolean bgm;
	
	public MidiPlayer(String file, boolean b) {
		filename = file;
		bgm = b;
	}
	
	public void start() {
		try {
			Sequence sequence = MidiSystem.getSequence(getClass().getClassLoader().getResourceAsStream(filename));
		    sequencer = MidiSystem.getSequencer();
		    sequencer.open();
		    sequencer.setSequence(sequence);
		    //sequencer.getTransmitter().setReceiver(synth.getReceiver());
		    //synth.getTransmitter().setReceiver(sequencer.getReceiver());
		    if (bgm == true) {
		    	sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		    }
		    sequencer.start();
		}
		catch (MalformedURLException e) {}
		catch (IOException e) {}
    	catch (MidiUnavailableException e) {}
    	catch (InvalidMidiDataException e) {}
	}

	public void stop() {
		sequencer.stop();
	}
}