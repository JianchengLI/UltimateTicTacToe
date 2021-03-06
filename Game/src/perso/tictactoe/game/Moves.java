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
		_px = getPostionXByIndex(x, y);
		_py = getPostionYByIndex(x, y);
	}
	
	public Moves(Position px, Position py) {
		_x = getXByPosition(px, py);
		_y = getYByPosition(px, py);
		_px = px;
		_py = py;
	}
	
	public static final int getXByPosition(Position px, Position py){
		return py.getValue()/3+(px.getValue()/3)*3; 
	}
	
	public static int getYByPosition(Position px, Position py){
		return py.getValue()%3+(px.getValue()%3)*3;
	}
	
	public static final Position getPostionXByIndex(int x, int y){
		return Position.values()[(x/3)*3+(y/3)];
	};
	
	public static final Position getPostionYByIndex(int x, int y){
		return Position.values()[(x%3)*3+y%3];
	};
}
