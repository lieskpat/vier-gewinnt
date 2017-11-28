/**
 * 
 */
package de.viergewinnt.view.test;

import java.util.List;

import viergewinnt.core.model.Spielbrett;
import view.ISpielbrettViewModel;
import view.SpalteCommand;

/**
 * @author lies
 *
 */
public class SpielbrettViewModelMock implements ISpielbrettViewModel {

	private List<SpalteCommand> spalteCommands;

	private Spielbrett spielbrett;

	/**
	 * @param spalteCommands
	 * @param spielbrett
	 */
	public SpielbrettViewModelMock(List<SpalteCommand> spalteCommands, Spielbrett spielbrett) {
		this.spalteCommands = spalteCommands;
		this.spielbrett = spielbrett;
	}

	@Override
	public List<SpalteCommand> getCommands() {

		return spalteCommands;
	}

	@Override
	public Spielbrett getSpielbrett() {

		return spielbrett;
	}

}
