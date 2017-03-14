package perso.tictactoe.game;
/**
 * Simple Factory function interface
 * Create Instance of "Case" with a parent
 * @author Jiancheng
 *
 */
@FunctionalInterface
public interface FICaseGenerator{
	public Case create(Case parent);
}