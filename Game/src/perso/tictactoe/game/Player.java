package perso.tictactoe.game;


public class Player{
	private String _name;
	private Placement _placement;
	private Game _game;
	
	public Player(String name, Placement placement, Game game) {
		super();
		_name = name;
		_placement = placement;
		_game = game;
		_game.addPlayer(this);
	}

	public String getName() {
		return _name;
	}

	public Placement getPlacement() {
		return _placement;
	}

	public void update() {
		// TODO: notify by game
	}
}
