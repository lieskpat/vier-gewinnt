/**
 * 
 */
package de.viergewinnt.model.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import viergewinnt.core.model.Diagonale;
import viergewinnt.core.model.DiagonaleRichtung;
import viergewinnt.core.model.ISpielbrettZelle;
import viergewinnt.core.model.ISpielbrettZelleFactory;
import viergewinnt.core.model.Linie;
import viergewinnt.core.model.Reihe;
import viergewinnt.core.model.Spalte;
import viergewinnt.core.model.Spielbrett;
import viergewinnt.core.model.SpielbrettFactory;
import viergewinnt.core.model.SpielbrettZelleFactory;
import viergewinnt.core.model.ZellenTyp;

/**
 * @author lies
 *
 */
public class SpielbrettFactoryTest {

	private ISpielbrettZelleFactory zellenFactory;
	
	private Spielbrett testTarget;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp(){
		
		zellenFactory = new SpielbrettZelleFactory();
		testTarget = new SpielbrettFactory(zellenFactory).create(7, 6);
	}
	
	@Test
	public void testeKorrekteAnzahlSpalten(){
		
		assertEquals(7, testTarget.getSpalten().size());
	}

	@Test
	public void testeKorrekteAnzahlReihen(){
		
		assertEquals(6, testTarget.getReihen().size());
	}

	
	@SuppressWarnings("unused")
	@Test
	public void testeAnzahlSpielbrettZellenGleichAnzahlSpaltenSpielbrettZellen() {
		
		List<Spalte> spalteList = testTarget.getSpalten();
		int zaehler = 0;
		
		for (Linie spalte : spalteList) {
			
			for (ISpielbrettZelle zelle: spalte.getZellen()) {
				zaehler++;
			}
		}

		assertEquals(42, zaehler);
	
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testeAnzahlSpielbrettZellenGleichAnzahlReihenSpielbrettZellen() {
		
		List<Reihe> reiheList = testTarget.getReihen();
		int zaehler = 0;
		
		for (Linie reihe : reiheList) {
			
			for (ISpielbrettZelle zelle: reihe.getZellen()) {
				zaehler++;
			}
		}

		assertEquals(42, zaehler);
	
	}

	@Test
	public void testeSpielbrettZellenGleichLeer() {
		
		List<Spalte> spalteList = testTarget.getSpalten();
		
		for (Linie spalte : spalteList) {
			
			for (ISpielbrettZelle zelle : spalte.getZellen()) {
				
				assertTrue(zelle.getZellenTyp() == ZellenTyp.LEERZELLE);
			}
		}
	}
	
	@Test
	public void testeKorrekteXKoordinateInSpalte(){
		
		List<Spalte> spalteList = testTarget.getSpalten();
		
		Linie spalte = spalteList.get(4);
		List<ISpielbrettZelle> zellenList = spalte.getZellen();
		
		for (int i = 0; i < zellenList.size(); i++) {
			
			assertTrue(zellenList.get(i).getX() == 4);
		}
	}
	
	@Test
	public void testeHabenAlleDiagonalenMindestensVierZellen(){
		
		List<Diagonale> diagonalenList = testTarget.getDiagonalen();
		for (Diagonale diagonale : diagonalenList) {
			assertTrue(diagonale.getZellen().size() >= 4);
		}
	}
	
	@Test
	public void testeEineDiagonaleMitRichtungNachRechtsUnten() {
		
		List<Diagonale> diagonalenList = testTarget.getDiagonalen();
		Diagonale testDiagonale = null;
		ISpielbrettZelle zelle;
		
		for (Diagonale diagonale : diagonalenList) {
			
			if (diagonale.getRichtung() == DiagonaleRichtung.NACHRECHTSUNTEN){
				if (diagonale.getStartKoordinateX() == 0 && 
						diagonale.getStartKoordinateY() == 2) {
					testDiagonale = diagonale;
				}
			}
		}
		zelle = testDiagonale.getZellen().get(testDiagonale.getZellen().size() - 1);
		assertTrue(zelle.getX() == 3 && zelle.getY() == 5 && testDiagonale.getZellen().size() == 4) ;
	}
	
	
	@Test
	public void testeEineDiagonaleMitRichtungNachLinksUnten() {
	
		List<Diagonale> diagonalenList = testTarget.getDiagonalen();
		Diagonale testDiagonale = null;
		ISpielbrettZelle zelle;
		
		for (Diagonale diagonale : diagonalenList) {
			
			if (diagonale.getRichtung() == DiagonaleRichtung.NACHLINKSUNTEN){
				if (diagonale.getStartKoordinateX() == 6 && 
						diagonale.getStartKoordinateY() == 0) {
					testDiagonale = diagonale;
				}
			}
		}
		zelle = testDiagonale.getZellen().get(testDiagonale.getZellen().size() - 1);
		assertTrue(zelle.getX() == 1 && zelle.getY() == 5 && testDiagonale.getZellen().size() == 6) ;
	}
}
