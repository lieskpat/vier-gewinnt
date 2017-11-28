/**
 * 
 */
package de.viergewinnt.view.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import viergewinnt.core.model.Farbe;
import viergewinnt.core.model.Spieler;
import viergewinnt.core.model.Spielstein;
import view.SpielerViewModel;

/**
 * @author lies
 *
 */
public class SpielerViewModelTest extends TestCase {

	private SpielerViewModel spielerViewModel;

	private SpielerViewMock spielerViewMock;

	private int count;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@SuppressWarnings("serial")
	@Before
	protected void setUp() throws Exception {
		super.setUp();

		List<Spielstein> spielsteine = new ArrayList<Spielstein>() {
			{
				for (int i = 0; i < 21; i++) {
					add(new Spielstein(new Farbe(0, 0, 0), "Spieler A"));
				}
			}
		};
		Spieler spieler = new Spieler(spielsteine, "Spieler A", false);

		spielerViewModel = new SpielerViewModel(spieler);
		spielerViewMock = new SpielerViewMock(spielerViewModel);

	}

	@Test
	public void testDataBindingFromSpielerViewModelToSpielerViewSpielerName() {
		spielerViewMock.getSpielerNameProperty().bind(spielerViewModel.getSpielerNameProperty());
		assertTrue(spielerViewMock.getSpielerNameProperty().get().equals(spielerViewModel.getSpieler().getName()));
	}

	@Test
	public void testFeuernListenerWennPropertyGeaendertWerden() {

		count = 0;
		spielerViewModel.getSpielerNameProperty().addListener(fire -> {
			count++;
		});
		spielerViewModel.getSpielerNameProperty().set("NEW VALUE");
		assertEquals(1, count);
	}

}
