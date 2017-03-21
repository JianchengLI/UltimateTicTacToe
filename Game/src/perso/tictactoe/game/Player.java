package perso.tictactoe.game;

public class Player {
	private String name;
	private Placement placement;
	
	public Player(String name, Placement placement) {
		super();
		this.name = name;
		this.placement = placement;
	}

	public String getName() {
		return name;
	}

	public Placement getPlacement() {
		return placement;
	}
}
