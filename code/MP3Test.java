import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * A class to demonstrate how to use the JAudioTagger and JLayer libraries.
 * @author srollins
 *
 */
public class MP3Test {

	/**
	 * Main method used for testing.
	 * FOR THE EXAMPLE ONLY the exceptions are propagated. A solution should use try/catch and handle exceptions
	 * appropriately.
	 * @param args
	 * @throws CannotReadException
	 * @throws IOException
	 * @throws TagException
	 * @throws ReadOnlyFileException
	 * @throws InvalidAudioFrameException
	 * @throws JavaLayerException
	 */
	public static void main(String[] args) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, JavaLayerException {
		
		//example from http://www.jthink.net/jaudiotagger/examples_read.jsp
		//assumes a file test.mp3 is the directory where this program is run	
		//create an audio file
		AudioFile f = AudioFileIO.read(new File("test.mp3"));
		//get the tag object
		Tag tag = f.getTag();
		//print the various fields from the tag
		System.out.println(tag.getFirst(FieldKey.ARTIST));
		System.out.println(tag.getFirst(FieldKey.ALBUM));
		System.out.println(tag.getFirst(FieldKey.TITLE));
		System.out.println(tag.getFirst(FieldKey.COMMENT));
		System.out.println(tag.getFirst(FieldKey.YEAR));
		System.out.println(tag.getFirst(FieldKey.TRACK));
		System.out.println(tag.getFirst(FieldKey.DISC_NO));
		System.out.println(tag.getFirst(FieldKey.COMPOSER));
		System.out.println(tag.getFirst(FieldKey.ARTIST_SORT));
	
		//create a new player for specific mp3 file
		Player player = new Player(new FileInputStream("test.mp3"));
		
		//create a new thread to start playback
		//the run method will not be called until the thread is started
		//if the play method is not called from a thread the the rest of the program
		//will block until the entire song has played
		Thread t = new Thread() {
		    public void run() {
		        try {
		            player.play();
		        } catch(Exception e) {
		            e.printStackTrace();
		        }
		    }
		};         		
		//start the thread
		//only when start is called does the run method of the thread get called
		t.start();
		
		//FOR THE EXAMPLE ONLY
		//wait for 4 seconds
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//stop playback by calling close on the player
		player.close();
	}
	
}
