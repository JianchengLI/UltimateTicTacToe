package perso.tictactoe.game;

@FunctionalInterface
public interface FICaseGenerator{
	public Case create(Case parent);
}