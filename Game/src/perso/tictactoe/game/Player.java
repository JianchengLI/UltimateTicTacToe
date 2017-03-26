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

	public boolean play(Position px, Position py){
		return _game.play(this, px, py);
	}
	
	public boolean play(int x, int y){
		return _game.play(this, x, y);
	}
	
	public void update() {
		// TODO: notify by game
	}
}
