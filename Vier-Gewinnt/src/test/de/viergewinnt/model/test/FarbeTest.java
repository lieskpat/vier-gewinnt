/**
 * 
 */
package de.viergewinnt.model.test;

import org.junit.Test;

import junit.framework.TestCase;
import de.viergewinnt.model.Farbe;

/**
 * @author lies
 *
 */
public class FarbeTest extends TestCase {

	/**
	 * Test method for {@link viergewinnt.core.model.Farbe#Farbe(int, int, int)}.
	 */
	@Test
	public void testRotWertebereich() {
		try {
			new Farbe(256, 10, 5);
			fail("Rot liegt im Wertebereich");
		} catch (IllegalArgumentException expected) {
		}
	}
	
	@Test
	public void testGruenWertebereich() {
		try {
			new Farbe(10, -256, 5);
			fail("Gruen liegt im Wertebereich");
		} catch (IllegalArgumentException expected) {
		}
	}
	
	@Test
	public void testBlauWertebereich() {
		try {
			new Farbe(100, 10, -300);
			fail("Rot liegt im Wertebereich");
		} catch (IllegalArgumentException expected) {
		}
	}

}
