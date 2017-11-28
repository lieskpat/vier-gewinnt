/**
 * 
 */
package de.viergewinnt.model;

/**
 * @author lies
 *
 */
public interface ISpielbrettZelleFactory {

	ISpielbrettZelle create(int x, int y, ZellenTyp zellenTyp);
}
