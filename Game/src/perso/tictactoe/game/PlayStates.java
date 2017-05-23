package perso.tictactoe.game;

public enum PlayStates {
	SUCCESS(0), OCCUPIED(1), DISABLED(2), OPPONENT(3);
	
	private final int value;
	PlayStates(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
