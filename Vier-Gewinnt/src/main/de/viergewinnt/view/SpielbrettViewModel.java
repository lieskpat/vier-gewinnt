/**
 * 
 */
package de.viergewinnt.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import de.viergewinnt.model.Farbe;
import de.viergewinnt.model.ISpielbrettZelle;
import de.viergewinnt.model.Spielbrett;
import de.viergewinnt.model.ZellenTyp;

/**
 * @author lies
 *
 */
public class SpielbrettViewModel implements ISpielbrettViewModel {

	private Spielbrett spielbrett;

	private List<SpalteCommand> commands;

	public SpielbrettViewModel(Spielbrett spielbrett, List<SpalteCommand> commands) {

		this.spielbrett = spielbrett;
		this.commands = commands;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.ISpielbrettViewModel#getCommands()
	 */
	@Override
	public List<SpalteCommand> getCommands() {
		return commands;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.ISpielbrettViewModel#getSpielbrett()
	 */
	@Override
	public Spielbrett getSpielbrett() {
		return spielbrett;
	}

	public SpalteCommand getSpalteCommandInIndex(int index) {
		SpalteCommand command = null;
		for (SpalteCommand cmd : commands) {
			if (cmd.getSpalte().getIndex() == index) {
				command = cmd;
				break;
			}
		}
		return command;
	}

	public ISpielbrettZelle getSpielbrettZelleFromSpielbrett(int x, int y) {
		ISpielbrettZelle zelle = null;
		List<ISpielbrettZelle> zellenList = Arrays.stream(spielbrett.getZellen()).flatMap(Arrays::stream)
				.collect(Collectors.toList());

		for (ISpielbrettZelle spielbrettZelle : zellenList) {
			if (spielbrettZelle.getX() == x && spielbrettZelle.getY() == y) {
				zelle = spielbrettZelle;
				break;
			}
		}
		return zelle;
	}

	@SuppressWarnings("static-access")
	public void spielbrettUpdate(Object arg, GridPane spielbrettGridPane) {
		int x = ((ISpielbrettZelle) arg).getX();
		int y = ((ISpielbrettZelle) arg).getY();
		ZellenTyp typ = (ZellenTyp) ((ISpielbrettZelle) arg).getZellenTyp();
		System.out.println("X: " + x + " Y: " + y + " ZellenTyp: " + typ.toString() + " hat sich geändert");
		Farbe spielsteinFarbe = getSpielbrettZelleFromSpielbrett(x, y).getSpielstein().getFarbe();
		Circle circle = new Circle(20.0,
				Color.rgb(spielsteinFarbe.getRot(), spielsteinFarbe.getGruen(), spielsteinFarbe.getBlau()));
		spielbrettGridPane.setHalignment(circle, HPos.CENTER);
		spielbrettGridPane.add(circle, x, y);
	}

	public void handleButtonEvent(ActionEvent event, List<Button> buttonList) {
		for (int i = 0; i < buttonList.size(); i++) {
			if (event.getSource() == buttonList.get(i)) {
				getSpalteCommandInIndex(i).execute();
				break;
			}
		}

	}

}
