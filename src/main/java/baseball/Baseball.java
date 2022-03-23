package baseball;

import baseball.util.InputValidation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Baseball {
    Scanner sc = new Scanner(System.in);

    public void startGame() {
        BallGenerator generator = new BallGenerator();
        Balls question = generator.generateQuestion();

        playUntilCorrect(question);
    }

    private void playUntilCorrect(Balls question) {
        while (true) {
            System.out.println("숫자를 입력해 주세요 : ");

            List<Integer> userBalls = refineInput(sc.nextLine());

            PlayResult result = question.play(userBalls);

            System.out.println(result.getMessage());

            askRetryIfCorrect(result);
        }
    }

    private List<Integer> refineInput(String input) {
        String validInput = verifyInput(input);

        List<Integer> userBalls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userBalls.add(validInput.charAt(i) - '0');
        }
        return userBalls;
    }
    private String verifyInput(String input){
        InputValidation validator = new InputValidation();
        while(!validator.isValidInput(input)){
            System.out.println("잘못된 입력입니다. 3자리 숫자를 입력하세요. ex) 123");
            input = sc.nextLine();
        }
        return input;
    }

    private void askRetryIfCorrect(PlayResult playResult) {
        if (playResult.isCorrect()) {
            askUntilValidIn();
        }
    }
    private void askUntilValidIn(){
        try {
            askRetry();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            askRetry();
        }
    }
    private void askRetry() throws InputMismatchException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int response = Integer.parseInt(sc.nextLine());

        if (response == 1) {
            startGame();
            return;
        }
        if (response == 2) {
            System.exit(0);
        }
        throw new InputMismatchException("1또는 2를 입력해주세요. (시작 1, 종료 2)");
    }


}
