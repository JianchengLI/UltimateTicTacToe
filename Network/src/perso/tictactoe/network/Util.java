package perso.tictactoe.network;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	public static Optional<String> parserProtocolBeforeBegin(String message){
		Pattern pattern = Pattern.compile("\\{name\\:(\\S+)};");
		Matcher matcher = pattern.matcher(message);
		return matcher.matches() ? Optional.of(matcher.group(1)) : Optional.empty();
	}
}
