package de.viergewinnt.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public abstract class FXMLView implements FXMLViewable {

	private Parent root;

	private FXMLLoader loader;

	/**
	 * @return the parent
	 */
	public Parent getRootNode() {
		return root;
	}

	/**
	 * @return the loader
	 */
	public FXMLLoader getLoader() {
		return loader;
	}

	public void initFXMLLoader(String resource) {
		loader = new FXMLLoader(getClass().getResource(resource));
		loader.setController(this);
		try {
			this.root = loader.load();
		} catch (Exception ex) {
			throw new IllegalStateException("Can not load", ex);
		}
	}

}