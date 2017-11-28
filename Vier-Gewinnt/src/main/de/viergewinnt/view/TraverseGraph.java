/**
 * 
 */
package de.viergewinnt.view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 * @author lies
 *
 */
public class TraverseGraph {

	public List<Node> traverse(Parent parent) {
		List<Node> nodeList = new ArrayList<>();
		for (Node node : parent.getChildrenUnmodifiable()) {
			if(node instanceof Pane) {
				nodeList.addAll(traverse((Parent) node));
			} else {
				nodeList.add(node);
			}
		}
		return nodeList;
	}
}
