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
import viergewinnt.core.model.Farbe;
import viergewinnt.core.model.ISpalte;
import viergewinnt.core.model.ISpielbrettZelleFactory;
import viergewinnt.core.model.Spielbrett;
import viergewinnt.core.model.SpielbrettFactory;
import viergewinnt.core.model.SpielbrettZelleFactory;
import viergewinnt.core.model.Spieler;
import viergewinnt.core.model.Spielstein;
import view.IMainViewModel;
import view.MainViewModel;
import view.SpalteCommand;
import view.SpielbrettViewModel;
import view.SpielerViewModel;

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
