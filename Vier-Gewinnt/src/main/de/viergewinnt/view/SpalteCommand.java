/**
 * 
 */
package de.viergewinnt.view;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import viergewinnt.core.model.ISpalte;

/**
 * @author lies
 *
 */
public class SpalteCommand implements ISpalteCommand {
	
	private BooleanProperty isButtonInactiv;

	private IMainViewModel mainViewModel;

	private ISpalte spalte;

	/**
	 * @param mainViewModel
	 * @param spalte
	 */
	public SpalteCommand(IMainViewModel mainViewModel, ISpalte spalte) {
		this.mainViewModel = mainViewModel;
		this.spalte = spalte;
		this.isButtonInactiv = new SimpleBooleanProperty();
	}

	/**
	 * @return the mainViewModel
	 */
	public IMainViewModel getMainViewModel() {
		return mainViewModel;
	}

	/**
	 * @return the spalte
	 */
	public ISpalte getSpalte() {
		return spalte;
	}
	
	/**
	 * @return the isActiveButton
	 */
	public BooleanProperty getButtonActivity() {
		return isButtonInactiv;
	}

	@Override
	public void execute() {
		mainViewModel.spieleZug(spalte);
		if (spalte.istSpalteVoll()) {
			System.out.println("Die Spalte ist voll");
			isButtonInactiv.set(true);
		}
	}
		

}
