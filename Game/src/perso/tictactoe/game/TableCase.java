package perso.tictactoe.game;

import java.util.ArrayList;

public class TableCase<T extends Case> extends Case{
	
	private ArrayList<T> cases = new ArrayList<>();

	public TableCase(ArrayList<T> cases) {
		super();
		this.cases = cases;
	}
	
	public ArrayList<T> getCases(){
		return cases;
	}
	
	public void setCase(Position position, Placement placement){
		cases.get(position.getValue()).setPlacement(placement);
		if (isTablePlacement())
			this.setPlacement(placement);
	}
	
	protected boolean isTablePlacement(){
		return (
		    ( cases.get(Position.TOP_LEFT.getValue()).getPlacement() == cases.get(Position.TOP.getValue()).getPlacement() && cases.get(Position.TOP.getValue()).getPlacement() == cases.get(Position.TOP_RIGHT.getValue()).getPlacement()) && cases.get(Position.TOP.getValue()).getPlacement() != Placement.EMPTY
		 || ( cases.get(Position.LEFT.getValue()).getPlacement() == cases.get(Position.MID.getValue()).getPlacement() && cases.get(Position.MID.getValue()).getPlacement() == cases.get(Position.RIGHT.getValue()).getPlacement()) && cases.get(Position.MID.getValue()).getPlacement() != Placement.EMPTY
		 || ( cases.get(Position.BOT_LEFT.getValue()).getPlacement() == cases.get(Position.BOT.getValue()).getPlacement() && cases.get(Position.BOT.getValue()).getPlacement() == cases.get(Position.BOT_RIGHT.getValue()).getPlacement()) && cases.get(Position.BOT.getValue()).getPlacement() != Placement.EMPTY
		 || ( cases.get(Position.TOP_LEFT.getValue()).getPlacement() == cases.get(Position.LEFT.getValue()).getPlacement() && cases.get(Position.LEFT.getValue()).getPlacement() == cases.get(Position.BOT_LEFT.getValue()).getPlacement()) && cases.get(Position.LEFT.getValue()).getPlacement() != Placement.EMPTY
		 || ( cases.get(Position.TOP.getValue()).getPlacement() == cases.get(Position.MID.getValue()).getPlacement() && cases.get(Position.MID.getValue()).getPlacement() == cases.get(Position.BOT.getValue()).getPlacement()) && cases.get(Position.MID.getValue()).getPlacement() != Placement.EMPTY
		 || ( cases.get(Position.TOP_RIGHT.getValue()).getPlacement() == cases.get(Position.RIGHT.getValue()).getPlacement() && cases.get(Position.RIGHT.getValue()).getPlacement() == cases.get(Position.BOT_RIGHT.getValue()).getPlacement()) && cases.get(Position.RIGHT.getValue()).getPlacement() != Placement.EMPTY
		 || ( cases.get(Position.TOP_LEFT.getValue()).getPlacement() == cases.get(Position.MID.getValue()).getPlacement() && cases.get(Position.MID.getValue()).getPlacement() == cases.get(Position.BOT_RIGHT.getValue()).getPlacement()) && cases.get(Position.MID.getValue()).getPlacement() != Placement.EMPTY
		 || ( cases.get(Position.TOP_RIGHT.getValue()).getPlacement() == cases.get(Position.MID.getValue()).getPlacement() && cases.get(Position.MID.getValue()).getPlacement() == cases.get(Position.BOT_LEFT.getValue()).getPlacement()) && cases.get(Position.MID.getValue()).getPlacement() != Placement.EMPTY
		);
	}
}

