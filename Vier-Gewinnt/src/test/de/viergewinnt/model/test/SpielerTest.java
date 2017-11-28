package de.viergewinnt.model.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import viergewinnt.core.model.Farbe;
import viergewinnt.core.model.ISpieler;
import viergewinnt.core.model.Spieler;
import viergewinnt.core.model.Spielstein;

public class SpielerTest {
	
	private List<Spielstein> spielsteine;
	
	private SpalteMock spalte;
	
	private ISpieler testTarget;
	
	@Before
	public void setUp(){
		spielsteine = new ArrayList<Spielstein>();
		
		for (int i = 0; i < 4; i++) {
			spielsteine.add(0, new Spielstein(new Farbe(0, 0, 0), "Foo"));
		}
	
		testTarget = new Spieler(spielsteine,"Foo", true);
		spalte = new SpalteMock();
	}
	

	@Test
	public void spieleZugEntferntSpielstein() {
		
		int count = spielsteine.size();
		testTarget.spieleZug(spalte);
		assertEquals(count - 1, testTarget.getSpielsteine().size());
	}
	
	@Test
	public void lasseSpielsteinFallenWirdVonSpieleZugAufgerufen(){
		
		testTarget.spieleZug(spalte);
		assertTrue(spalte.wurdeLasseSpielsteinFallenNurEinmalAufgerufen());
	}
	
	@Test(expected=NullPointerException.class)
	public void funktioniertGuardClauseKorrektBeiSpielsteine(){
		
		new Spieler(null, "Foo", false);
	}
	
	@Test(expected=NullPointerException.class)
	public void funktioniertGuardClauseKorrektBeiName(){
		
		new Spieler(spielsteine, null, false);
	}

}
