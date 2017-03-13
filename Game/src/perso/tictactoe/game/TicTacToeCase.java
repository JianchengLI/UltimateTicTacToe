package perso.tictactoe.game;


public class TicTacToeCase extends Case{
	
	protected Case[] _cases =  new Case[9];

	public TicTacToeCase(){
		super();
		_initCases();
	};
	
	public TicTacToeCase(Case parent) {
		super(parent);
		_initCases();
	}

	protected void _initCases() {
		for (int i = 0; i < _cases.length; i++) {
			_cases[i] = new Case(this);
		}
	}
	
	public Case[] getCases(){
		return _cases;
	}
	
	@Override
	public void setCasePlacement(Position position, Placement placement){
		_cases[position.getValue()].setPlacement(placement);
	}
	
	@Override
	public boolean isPlacement(){
		return (
		    ( _cases[Position.TOP_LEFT.getValue()].getPlacement() == _cases[Position.TOP.getValue()].getPlacement() && _cases[Position.TOP.getValue()].getPlacement() == _cases[Position.TOP_RIGHT.getValue()].getPlacement()) && _cases[Position.TOP.getValue()].getPlacement() != Placement.EMPTY
		 || ( _cases[Position.LEFT.getValue()].getPlacement() == _cases[Position.MID.getValue()].getPlacement() && _cases[Position.MID.getValue()].getPlacement() == _cases[Position.RIGHT.getValue()].getPlacement()) && _cases[Position.MID.getValue()].getPlacement() != Placement.EMPTY
		 || ( _cases[Position.BOT_LEFT.getValue()].getPlacement() == _cases[Position.BOT.getValue()].getPlacement() && _cases[Position.BOT.getValue()].getPlacement() == _cases[Position.BOT_RIGHT.getValue()].getPlacement()) && _cases[Position.BOT.getValue()].getPlacement() != Placement.EMPTY
		 || ( _cases[Position.TOP_LEFT.getValue()].getPlacement() == _cases[Position.LEFT.getValue()].getPlacement() && _cases[Position.LEFT.getValue()].getPlacement() == _cases[Position.BOT_LEFT.getValue()].getPlacement()) && _cases[Position.LEFT.getValue()].getPlacement() != Placement.EMPTY
		 || ( _cases[Position.TOP.getValue()].getPlacement() == _cases[Position.MID.getValue()].getPlacement() && _cases[Position.MID.getValue()].getPlacement() == _cases[Position.BOT.getValue()].getPlacement()) && _cases[Position.MID.getValue()].getPlacement() != Placement.EMPTY
		 || ( _cases[Position.TOP_RIGHT.getValue()].getPlacement() == _cases[Position.RIGHT.getValue()].getPlacement() && _cases[Position.RIGHT.getValue()].getPlacement() == _cases[Position.BOT_RIGHT.getValue()].getPlacement()) && _cases[Position.RIGHT.getValue()].getPlacement() != Placement.EMPTY
		 || ( _cases[Position.TOP_LEFT.getValue()].getPlacement() == _cases[Position.MID.getValue()].getPlacement() && _cases[Position.MID.getValue()].getPlacement() == _cases[Position.BOT_RIGHT.getValue()].getPlacement()) && _cases[Position.MID.getValue()].getPlacement() != Placement.EMPTY
		 || ( _cases[Position.TOP_RIGHT.getValue()].getPlacement() == _cases[Position.MID.getValue()].getPlacement() && _cases[Position.MID.getValue()].getPlacement() == _cases[Position.BOT_LEFT.getValue()].getPlacement()) && _cases[Position.MID.getValue()].getPlacement() != Placement.EMPTY
		);
	}
}

