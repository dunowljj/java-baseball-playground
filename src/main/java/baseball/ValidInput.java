package baseball;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class ValidInput {
    private String input;



    public static final String INPUT_REGEX = "^[1-9]{3}$";

    public ValidInput(String input) {
        if (isValidInput(input)) {
            this.input = input;
            return;
        }
        throw new InputMismatchException("잘못된 입력입니다. 3자리 숫자를 입력하세요. ex) 123");
    }

    private boolean isValidInput(String input) {
        return Pattern.matches(INPUT_REGEX, input);
    }
    public String checkInput() {
        return input;
    }

}
