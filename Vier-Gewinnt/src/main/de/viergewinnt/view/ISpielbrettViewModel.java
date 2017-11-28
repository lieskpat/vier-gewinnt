package de.viergewinnt.view;

import java.util.List;

import viergewinnt.core.model.Spielbrett;

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