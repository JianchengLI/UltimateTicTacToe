package perso.tictactoe.game;

public class Game {
	private TableCase checkerboard;

	public Game() {
		this.checkerboard = new TableCase((parent)-> new TableCase(parent, (e)-> new Case(e)));
	}
	
	/**
	 * Console display methods
	 */
	public void display(){
		final TableCase[] tableCases  = (TableCase[]) checkerboard.getCases();
		for (int i = 0; i < tableCases.length; i++) {
			final Case[] cases = tableCases[i].getCases();
			for (int j = 0; j < cases.length; j++) {
				
			}
		};
	};
	
}
