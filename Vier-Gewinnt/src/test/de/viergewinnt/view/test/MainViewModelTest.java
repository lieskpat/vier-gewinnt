/**
 * 
 */
package de.viergewinnt.view.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import de.viergewinnt.model.Farbe;
import de.viergewinnt.model.ISpalte;
import de.viergewinnt.model.ISpielbrettZelleFactory;
import de.viergewinnt.model.Spielbrett;
import de.viergewinnt.model.SpielbrettFactory;
import de.viergewinnt.model.SpielbrettZelleFactory;
import de.viergewinnt.model.Spieler;
import de.viergewinnt.model.Spielstein;
import de.viergewinnt.view.IMainViewModel;
import de.viergewinnt.view.MainViewModel;
import de.viergewinnt.view.SpalteCommand;
import de.viergewinnt.view.SpielbrettViewModel;
import de.viergewinnt.view.SpielerViewModel;

/**
 * @author lies
 *
 */
public class MainViewModelTest {

	private IMainViewModel mainViewModel;

	private SpielbrettViewModel spielbrettViewModel;

	private List<SpielerViewModel> spielerViewModels;

	private Spieler spielerA;

	private Spieler spielerB;

	private Spielbrett spielbrett;

	private List<SpalteCommand> commands;

	private ISpielbrettZelleFactory zellenFactory;

	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("serial")
	@Before
	public void setUp() throws Exception {

		spielerA = erstelleSpieler("Spieler A", new Farbe(128, 0, 0), false);
		spielerB = erstelleSpieler("Spieler B", new Farbe(0, 0, 128), true);

		spielerViewModels = new ArrayList<SpielerViewModel>() {
			{
				add(new SpielerViewModel(spielerA));
				add(new SpielerViewModel(spielerB));
			}
		};

		commands = new ArrayList<>();
		zellenFactory = new SpielbrettZelleFactory();
		spielbrett = new SpielbrettFactory(zellenFactory).create(7, 6);
		spielbrettViewModel = new SpielbrettViewModel(spielbrett, commands);
		mainViewModel = new MainViewModel(spielerViewModels, spielbrettViewModel);
		for (ISpalte spalte : spielbrett.getSpalten()) {
			commands.add(new SpalteCommand(mainViewModel, spalte));
		}
	}

	private static Spieler erstelleSpieler(String spielerName, Farbe spielerFarbe, boolean anDerReihe) {
		List<Spielstein> spielsteine = new ArrayList<Spielstein>();
		ObservableList<Spielstein> observableList = FXCollections.observableList(spielsteine);
		{
			{
				for (int i = 0; i < 21; i++) {
					observableList.add(new Spielstein(spielerFarbe, spielerName));
				}
			}
		}
		;
		return new Spieler(spielsteine, spielerName, anDerReihe);
	}

	@Test
	public void testSpieleZugWerIstAnDerReihe() {
		ISpalte spalte = commands.get(0).getSpalte();
		assertTrue(!spielerA.isIstAnDerReihe());
		assertTrue(spielerB.isIstAnDerReihe());
		mainViewModel.spieleZug(spalte);
		assertTrue(spielerA.isIstAnDerReihe());
		assertTrue(!spielerB.isIstAnDerReihe());
		mainViewModel.spieleZug(spalte);
		assertTrue(!spielerA.isIstAnDerReihe());
		assertTrue(spielerB.isIstAnDerReihe());
		
	}

}
