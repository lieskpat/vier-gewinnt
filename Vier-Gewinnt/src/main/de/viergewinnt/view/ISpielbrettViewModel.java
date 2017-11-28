package de.viergewinnt.view;

import java.util.List;

import de.viergewinnt.model.Spielbrett;

public interface ISpielbrettViewModel {

	/**
	 * @return the commands
	 */
	List<SpalteCommand> getCommands();

	/**
	 * @return the spielbrett
	 */
	Spielbrett getSpielbrett();

}