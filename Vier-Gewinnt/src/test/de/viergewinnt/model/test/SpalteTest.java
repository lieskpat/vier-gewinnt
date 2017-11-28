/**
 * 
 */
package de.viergewinnt.model.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import viergewinnt.core.model.Farbe;
import viergewinnt.core.model.ISpielbrettZelle;
import viergewinnt.core.model.ISpielstein;
import viergewinnt.core.model.Spalte;
import viergewinnt.core.model.SpielbrettZelle;
import viergewinnt.core.model.Spielstein;
import viergewinnt.core.model.ZellenTyp;

/**
 * @author lies
 *
 */
public class SpalteTest extends TestCase {
	
	private List<ISpielbrettZelle> leereListe;
	
	private List<ISpielbrettZelle> volleListe;
	
	private Spalte testTarget;
	
	private ISpielstein stein;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		
		leereListe = new ArrayList<ISpielbrettZelle>(4);
		
		volleListe = new ArrayList<ISpielbrettZelle>(6);
		
		for (int i = 0; i < 6; i++) {
			volleListe.add(new SpielbrettZelle(0, 0, ZellenTyp.SPIELSTEINZELLE));
		}
		
		for (int i = 0; i < 4; i++) {
			leereListe.add(new SpielbrettZelle(0, 0, ZellenTyp.LEERZELLE));
		}
		testTarget = new Spalte(leereListe, 0);
		stein = new Spielstein(new Farbe(0, 0, 0), "Foo");
	}

	/**
	 * Test method for {@link viergewinnt.core.model.Spalte#lasseSpielsteinFallen(viergewinnt.core.model.ISpielstein)}.
	 */
	@Test
	public void testLasseSpielsteinFallen() {
		
		testTarget.lasseSpielsteinFallen(stein);
		
		for (int i = 0; i < leereListe.size(); i++) {
			
			if (i == 0)
			{
				assertEquals(ZellenTyp.SPIELSTEINZELLE, leereListe.get(0).getZellenTyp());
				continue;
			}
			assertEquals(ZellenTyp.LEERZELLE, leereListe.get(i).getZellenTyp());
		}
	}
	
	@Test
	public void testeExceptionBeiVollerSpalte() {
		
		Spalte testTarget = new Spalte(volleListe, 1);
		try {
			testTarget.lasseSpielsteinFallen(stein);
			fail("Die Spalte ist nicht voll.");
		} catch (UnsupportedOperationException expected) {
		}
	}
	
	@Test
	public void testeIstSpalteVollTrue(){
		
		Spalte testTarget = new Spalte(volleListe, 6);
		assertTrue(testTarget.istSpalteVoll());
	}
	
	@Test
	public void testeIstSpalteVollFalse(){
		
		assertFalse(testTarget.istSpalteVoll());
	}

}
