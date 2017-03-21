package perso.tictactoe.game;

public class Game {
	
	private TableCase _checkerboard;
	private Case[][] _tableboard = new Case[9][9]; // another container to fetch checkerboard easily
	private Player[] _players = new Player[2];
	private Player _current;
	private int _moves = 0;

	public Game(Player player1, Player player2) {
		this._checkerboard = new TableCase((parent)-> new TableCase(parent, (e)-> new Case(e)));
		
		Case[] tableCases = _checkerboard.getChildren().get();
		for (int i = 0; i < tableCases.length; i++) {
			Case[] cases = tableCases[i].getChildren().get();
			for (int j = 0; j < cases.length; j++) {
				_tableboard[j/3+(i/3)*3][j%3+(i%3)*3] = cases[j];
			}
		}
		_players[0] = player1;
		_players[1] = player2;
		_current = player1;
	}
	
	public Player[] getPlayers() {
		return _players;
	}

	public int getMoves() {
		return _moves;
	}
	
	public Player getCurrentPlayer() {
		return _current;
	}
	/**
	 * After play success, switch to another player
	 */
	private void switchPlayer() {
		_moves++;
		_current = _players[_moves%2];
	}
	
	/**
	 * Play by _checkerboard ( TableCase ) 
	 * @param pos_t : Table Position
	 * @param pos_c : Case Position
	 * @return boolean
	 */
	public boolean play(Position pos_t, Position pos_c){
		if (_checkerboard.getChildren().get()[pos_t.getValue()].getChildren().get()[pos_c.getValue()].getPlacement() == Placement.EMPTY)
			return false;
		
		
		switchPlayer();
		return true;
	}
	
	/**
	 * Play by _tableboard ( Case[][] ) 
	 * @param index_x : 0 < x < 9
	 * @param index_y : 0 < y < 9
	 * @return boolean
	 */
	public boolean play(int index_x, int index_y){
		switchPlayer();
		return false;
	}
	
	/**
	 * Console display methods
	 */
	public void display(){
		for (int i = 0; i < 9; i++) {
			if(i%3 == 0 && i > 0)
				System.out.println("-----------");
			for (int j = 0; j < 9; j++) {
				if(j%3 == 0 && j > 0)
					System.out.print("|");
				_tableboard[i][j].display();
			}
			System.out.println("");
		}
	};	
	
}
