/**
 * 
 */
package de.viergewinnt.view.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import de.viergewinnt.model.ISpalte;
import de.viergewinnt.model.Spielbrett;
import de.viergewinnt.model.SpielbrettFactory;
import de.viergewinnt.model.SpielbrettZelleFactory;
import de.viergewinnt.view.IMainViewModel;
import de.viergewinnt.view.ISpielbrettViewModel;
import de.viergewinnt.view.SpalteCommand;
import de.viergewinnt.view.SpielerViewModel;

/**
 * @author lies
 *
 */
public class SpielbrettViewModelTest extends TestCase {
	
	private IMainViewModel mainViewModelMock;
	
	private ISpielbrettViewModel spielbrettViewModelMock;
	
	private List<SpielerViewModel> spielerViewModels;
	
	private Spielbrett spielbrett;
	
	private List<SpalteCommand> commands;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		mainViewModelMock = new MainViewModelMock(spielerViewModels, spielbrettViewModelMock);
		spielbrett = new SpielbrettFactory(new SpielbrettZelleFactory()).create(7, 6);
		commands = new ArrayList<>();
		for (ISpalte spalte : spielbrett.getSpalten()) {
			commands.add(new SpalteCommand(mainViewModelMock, spalte));
		}
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
