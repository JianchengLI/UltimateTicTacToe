package perso.tictactoe.game;

public class Checkboard extends TicTacToeCase {
	
	@Override
	protected void _initCases() {
		for (int i = 0; i < _cases.length; i++) {
			_cases[i] = new TicTacToeCase(this);
		}
	}

}
