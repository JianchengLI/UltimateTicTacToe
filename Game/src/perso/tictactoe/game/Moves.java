package perso.tictactoe.game;

public class Moves {
	private int _x;
	private int _y;
	private Position _px;
	private Position _py;
	
	
	/*
	 * Getter and Setter
	 */
	public int getX() {return _x;}
	public int getY() {return _y;}
	public Position getPositionX() {return _px;}
	public Position getPositionY() {return _py;}

	public Moves(int x, int y) {
		_x = x;
		_y = y;
		
		_px = Position.values()[(x/3)*3+(y/3)];
		_py = Position.values()[(x%3)*3+y%3];
		
	}
	
	public Moves(Position px, Position py) {
		_x = py.getValue()/3+(px.getValue()/3)*3;
		_y = py.getValue()%3+(px.getValue()%3)*3;
		_px = px;
		_py = py;
		
	}
}
