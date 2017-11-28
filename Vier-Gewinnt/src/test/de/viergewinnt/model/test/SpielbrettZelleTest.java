/**
 * 
 */
package de.viergewinnt.model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import viergewinnt.core.model.Farbe;
import viergewinnt.core.model.ISpielbrettZelle;
import viergewinnt.core.model.SpielbrettZelle;
import viergewinnt.core.model.Spielstein;
import viergewinnt.core.model.ZellenTyp;

/**
 * @author lies
 *
 */
public class SpielbrettZelleTest {
	
	private ISpielbrettZelle testTarget;
	
	private ISpielbrettZelle testTarget2;
	
	@Before
	public void setUp() {
		testTarget = new SpielbrettZelle(0, 0, ZellenTyp.LEERZELLE);
		
		testTarget2 = new SpielbrettZelle(0, 0, ZellenTyp.LEERZELLE);
	}

	@Test
	public void wirdSpielsteinGesetztErhalteSpielsteinZellenTyp() {
		
		testTarget2.setSpielstein(new Spielstein(new Farbe(0, 0, 0), "Foo"));
		assertEquals(ZellenTyp.SPIELSTEINZELLE, testTarget2.getZellenTyp());
	}
	
	@Test
	public void wirdSpielsteinNichtGesetztErhalteLeerZellenTyp() {
		
		assertEquals(ZellenTyp.LEERZELLE, testTarget.getZellenTyp());
	}
	
	@Test
	public void wirdSpielsteinGesetztErhalteZellenTypSpielstein(){
		
		testTarget.setSpielstein(new Spielstein(new Farbe(0, 0, 0), "Foo"));
		assertEquals(ZellenTyp.SPIELSTEINZELLE, testTarget.getZellenTyp());
	}

}
