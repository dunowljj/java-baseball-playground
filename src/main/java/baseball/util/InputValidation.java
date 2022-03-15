package baseball.util;

import java.util.regex.Pattern;

public class InputValidation {

    public static final String INPUT_REGEX = "^[1-9]{3}$";

    public boolean isValidInput(String input) {
        return Pattern.matches(INPUT_REGEX, input);
    }
}
