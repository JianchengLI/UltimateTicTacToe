package perso.tictactoe.network;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import perso.tictactoe.game.Moves;

public class Util {
	public static Optional<String> parserProtocolBeforeBegin(String message){
		Pattern pattern = Pattern.compile("\\{name\\:(\\S+)};");
		Matcher matcher = pattern.matcher(message);
		return matcher.matches() ? Optional.of(matcher.group(1)) : Optional.empty();
	}
	
	public static Optional<Moves> parserProtocolBeginState(String message){
		Pattern pattern = Pattern.compile("\\{move:(\\d),(\\d)};");
		Matcher matcher = pattern.matcher(message);
		return matcher.matches() ?
			Optional.of(new Moves(Integer.valueOf(matcher.group(1)), Integer.valueOf(matcher.group(2)))) :
			Optional.empty();
	}
}
