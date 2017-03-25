package perso.tictactoe.game;
/**
 * TicTacToe Enumeration
 * @author Jiancheng
 *
 */
public enum Position {
	TOP_LEFT(0), TOP(1), TOP_RIGHT(2),
	LEFT(3),MID(4), RIGHT(5),
	BOT_LEFT(6), BOT(7), BOT_RIGHT(8); 
	
	private final int value;
    Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
