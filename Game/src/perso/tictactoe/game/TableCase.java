package perso.tictactoe.game;

import java.util.Optional;

/**
 * Case 9x9
 * Can "setPlacement" direct OR
 * Can "setPlacement" by position ( set child's placement )
 * @author Jiancheng
 *
 */
public class TableCase extends Case{
	
	private Case[] _cases =  new Case[9];
	private ICaseFactoryMethod _factoryMethod;
	
	public TableCase(ICaseFactoryMethod factoryMethod){
		super();
		_factoryMethod = factoryMethod;
		initTable();
	};
	
	public TableCase(Case parent, ICaseFactoryMethod factoryMethod) {
		super(parent);
		_factoryMethod = factoryMethod;
		initTable();
	}

	protected void initTable() {
		for (int i = 0; i < _cases.length; i++) {
			_cases[i] = _factoryMethod.createCase(this);
		}
	}
	
	@Override
	public Optional<Case[]> getChildren(){
		return Optional.of(_cases);
	}

	@Override
	public void setPlacement(Position position, Placement placement){
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

