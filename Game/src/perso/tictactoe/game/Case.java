package perso.tictactoe.game;

import java.util.Optional;

public class Case {
	protected Placement _placement;
	protected Optional<Case> _parent = Optional.empty();
	
	public Case() {
		_placement = Placement.EMPTY;
	}
	
	public Case(Case parent) {
		this();
		_parent = Optional.of(parent);

	}
	
	public Placement getPlacement() {
		return _placement;
	}

	/**
	 * Set Placement for this case
	 * Attention : after set placement, notify the parent case
	 * @param placement
	 */
	public void setPlacement(Placement placement) {
		_placement = placement;
		if(_parent.isPresent() && _parent.get().isPlacement()){
			_parent.get().setPlacement(placement);
		}
	}
	
	public void setCasePlacement(Position position, Placement placement){
		setPlacement(placement);
	};
	/** 
	 * Check Case has already placement or not ? 
	 * Override this method, if have specific logic in sub class
	 */
	public boolean isPlacement(){
		return !isEmpty();
	}
	
	public boolean isEmpty(){
		return _placement == Placement.EMPTY;
	}

}
