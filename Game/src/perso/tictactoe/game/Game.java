package perso.tictactoe.game;

import java.util.Stack;
import java.util.Vector;

public class Game {
	
	private TableCase _checkerboard;
	private Case[][] _tableboard = new Case[9][9]; // another container to fetch checkerboard easily
	private Vector<Player> _players = new Vector<>();
	private Player _current;
	private boolean _console_active = false;
	private Stack<Moves> _history = new Stack<>() ;
	

	public Game() {
		this._checkerboard = new TableCase((parent)-> new TableCase(parent, (e)-> new Case(e)));
		
		Case[] tableCases = _checkerboard.getChildren().get();
		for (int i = 0; i < tableCases.length; i++) {
			Case[] cases = tableCases[i].getChildren().get();
			for (int j = 0; j < cases.length; j++) {
				_tableboard[j/3+(i/3)*3][j%3+(i%3)*3] = cases[j];
			}
		}
	}
	
	/**
	 * Register Player
	 * @param player
	 */
	public void addPlayer(Player player){
		if(_players.size() == 0)
			_current = player;
		
		if (_players.size() <= 2) {
			_players.addElement(player);
		}
	}
	
	/*
	 * Setters and Getters
	 */
	public Case[][] getTableBoard() {return _tableboard;}
	public TableCase getCheckerBoard() {return _checkerboard;}
	public void enableConsole(){_console_active = true; }
	public void disableConsole(){_console_active = false; }
	public Vector<Player> getPlayers() {return _players;}
	public Player getCurrentPlayer() {return _current;}
	
	
	/**
	 * Play by _checkerboard ( TableCase ) 
	 * @param pos_t : Table Position
	 * @param pos_c : Case Position
	 * @return boolean
	 */
	public boolean play(Player player, Position pos_t, Position pos_c){
		boolean isPlacement = _checkerboard.getChildren().get()[pos_t.getValue()].getChildren().get()[pos_c.getValue()].isPlacement();
		boolean isTableEnable = _checkerboard.getChildren().get()[pos_t.getValue()].isEnable();
		boolean isEnable = isTableEnable && _checkerboard.getChildren().get()[pos_t.getValue()].getChildren().get()[pos_c.getValue()].isEnable();
		boolean isCurrentPlayer = player.equals(_current);
		
		if (isPlacement || !isEnable || !isCurrentPlayer)
			return false;
		
		_checkerboard.getChildren().get()[pos_t.getValue()].getChildren().get()[pos_c.getValue()].setPlacement(_current.getPlacement());
		_history.push(new Moves(pos_t, pos_c));
		
		_switchPlayer();
		_switchEnableCase();
		display();
		notifyAllPlayers();
		return true;
	}
	
	/**
	 * Play by _tableboard ( Case[][] ) 
	 * @param index_x : 0 < x < 9
	 * @param index_y : 0 < y < 9
	 * @return boolean
	 */
	public boolean play(Player player, int index_x, int index_y){
		boolean isPlacement =  _tableboard[index_x][index_y].isPlacement();
		boolean isTableEnable = _checkerboard.getChildren().get()[Moves.getPostionXByIndex(index_x, index_y).getValue()].isEnable();
		boolean isEnbale = isTableEnable && _tableboard[index_x][index_y].isEnable();
		boolean isCurrentPlayer = player.equals(_current);
		
		if ( isPlacement || !isEnbale || !isCurrentPlayer)
			return false;
		
		_tableboard[index_x][index_y].setPlacement(_current.getPlacement());
		_history.push(new Moves(index_x, index_y));
		
		_switchPlayer();
		_switchEnableCase();
		display();
		notifyAllPlayers();
		return true;
	}
	
	/**
	 * Console display methods
	 */
	public void display(){
		if (_console_active) {
			System.out.println("");
			System.out.println("Moves : " + (_history.size()));
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
		}
	};	
	
	/**
	 * After play success, switch to another player
	 */
	private void _switchPlayer() {
		_current = _players.get(_history.size()%2);
	}
	
	/**
	 * Game Rules
	 * Only enable the TableCase by last movement
	 * example : if last move play( somewhere, MID ), the next player must play( MID, somewhere )
	 *   except, MID isPlacement already, the next player can play( anywhere, somewhere )
	 */
	private void _switchEnableCase(){
		Moves move = _history.lastElement();
		int enableIndex = move.getPositionY().getValue();

		Case[] tablecases = _checkerboard.getChildren().get();
		Case enableCase = tablecases[enableIndex];
		
		if (enableCase.isPlacement()) {
			for (int i = 0; i < tablecases.length; i++) 
				tablecases[i].enable();
		}
		else{
			for (int i = 0; i < tablecases.length; i++) 
				tablecases[i].disable();
		}
		enableCase.enable();
	}
	
	public void notifyAllPlayers(){
		// TODO: do something here
	}
}
