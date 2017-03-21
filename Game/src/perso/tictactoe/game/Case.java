package perso.tictactoe.game;

import java.util.Optional;
/**
 * Maybe has a parent Case. 
 * Can "setPlacement" and check "isPlacement?" of all its parent(s) state
 * Parent "isPlacement?" then "setPlacement" by child's state
 * @author Jiancheng
 *
 */
public class Case {
	protected Placement _placement;
	protected Optional<Case> _parent = Optional.empty();
	private boolean enable = true;
	
	/**
	 * Case maybe has children
	 * @return
	 */
	protected Optional<Case[]> getChildren(){
		return Optional.empty();
	};

	public Case() {
		_placement = Placement.EMPTY;
	}
	
	public Case(Case parent) {
		this();
		_parent = Optional.of(parent);

	}
	
	/*
	 * Setters and Getters
	 */
	public boolean isEnable() { return enable; }
	public void enable() { this.enable = true; }
	public void disable() { this.enable = false; }
	public Placement getPlacement() { return _placement; }

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
	
	public void setPlacement(Position position, Placement placement){
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

	public void display(){
		switch (_placement) {
		case CROSS:
			System.out.print("X");
			break;
		case CIRCLE:
			System.out.print("O");
			break;
		default:
			System.out.print("E");
			break;
		}
	}
}
