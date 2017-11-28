package de.viergewinnt.view;

import java.util.List;

import viergewinnt.core.model.ISpalte;

public interface IMainViewModel {

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IMainViewModel#getSpielerViewModel()
	 */
	List<SpielerViewModel> getSpielerViewModel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IMainViewModel#getSpielbrettViewModel()
	 */
	ISpielbrettViewModel getSpielbrettViewModel();

	void spieleZug(ISpalte spalte);

}