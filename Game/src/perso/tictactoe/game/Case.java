package perso.tictactoe.game;


public class Case {
	private Placement placement;

	public Case() {
		this.placement = Placement.EMPTY;
	}

	public Case(Placement placement) {
		this.placement = placement;
	}
	
	public Placement getPlacement() {
		return placement;
	}

	public void setPlacement(Placement placement) {
		this.placement = placement;
	}
	
	public boolean isEmpty(){
		return placement == Placement.EMPTY;
	}
	
	public static Case createEmptyCase(){
		return new Case();
	}

}
