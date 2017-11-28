/**
 * 
 */
package de.viergewinnt.model.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
public class LinienTest {
	
	private LinienMock testTarget1;
	private List<ISpielbrettZelle> linieList1;
	private LinienMock testTarget2;
	private List<ISpielbrettZelle> linieList2;
	private LinienMock testTarget3;
	private List<ISpielbrettZelle> linieList3;
	
	@Before
	public void setUp() {
		linieList1 = new ArrayList<ISpielbrettZelle>();
		ISpielbrettZelle spielBrettZelle1 = new SpielbrettZelle(0, 0, ZellenTyp.LEERZELLE);
		for (int i = 0; i < 4; i++) {
			linieList1.add(spielBrettZelle1);
			spielBrettZelle1.setSpielstein(new Spielstein(
					new Farbe(0, 0, 0), "Foo"));
			
			
		}
		testTarget1 = new LinienMock(linieList1);
		
		
		linieList2 = new ArrayList<ISpielbrettZelle>();
		SpielbrettZelle spielBrettZelle2 = new SpielbrettZelle(0, 0, ZellenTyp.LEERZELLE);
		SpielbrettZelle spielBrettZelle3 = new SpielbrettZelle(0, 0, ZellenTyp.LEERZELLE);
		SpielbrettZelle spielBrettZelle4 = new SpielbrettZelle(0, 0, ZellenTyp.LEERZELLE);
		SpielbrettZelle spielBrettZelle5 = new SpielbrettZelle(0, 0, ZellenTyp.LEERZELLE);
			
		linieList2.add(spielBrettZelle2);
		spielBrettZelle2.setSpielstein(new Spielstein(new Farbe(0, 0, 0), "Foo"));
		linieList2.add(spielBrettZelle3);
		spielBrettZelle3.setSpielstein(new Spielstein(new Farbe(0, 0, 0), "Bar"));
		linieList2.add(spielBrettZelle4);
		spielBrettZelle4.setSpielstein(new Spielstein(new Farbe(0, 0, 0), "Foo"));
		linieList2.add(spielBrettZelle5);
		spielBrettZelle5.setSpielstein(new Spielstein(new Farbe(0, 0, 0), "Foo"));
		testTarget2 = new LinienMock(linieList2);
		
		linieList3 = new ArrayList<ISpielbrettZelle>();
		for (int i = 0; i < 4; i++) {
			linieList3.add(new SpielbrettZelle(0, 0, ZellenTyp.LEERZELLE));
		}
		testTarget3 = new LinienMock(linieList2);
	}

	@Test
	public void vierInEinerReiheWerdenKorrektErkannt() 
	{
		String spielerName = testTarget1.sindVierSpielsteineInEinerLinie();
		assertEquals("Foo", spielerName);
	}
	
	@Test
	public void vierSindNichtInEinerReiheWerdenKorrektErkannt()
	{
		String spielerName = testTarget2.sindVierSpielsteineInEinerLinie();
		assertEquals(null, spielerName);
	}
	
	@Test
	public void vierSindLeerWerdenKorrektErkannt()
	{
		String spielerName = testTarget3.sindVierSpielsteineInEinerLinie();
		assertEquals(null, spielerName);
	}

}
