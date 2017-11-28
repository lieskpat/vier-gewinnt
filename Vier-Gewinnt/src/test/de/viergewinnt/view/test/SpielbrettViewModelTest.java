/**
 * 
 */
package de.viergewinnt.view.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import viergewinnt.core.model.ISpalte;
import viergewinnt.core.model.Spielbrett;
import viergewinnt.core.model.SpielbrettFactory;
import viergewinnt.core.model.SpielbrettZelleFactory;
import view.IMainViewModel;
import view.ISpielbrettViewModel;
import view.SpalteCommand;
import view.SpielerViewModel;

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
