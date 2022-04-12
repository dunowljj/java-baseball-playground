package baseball;

// import baseball.util.InputValidation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Baseball {
    public static final String THE_NUMBER_FOR_RESTART = "1";
    public static final String THE_NUMBER_FOR_QUIT = "2";
    private int gameCount = 1;
    private int submitCount = 1;
    Scanner sc = new Scanner(System.in);

    public void startGame() {
        while(isRestart()){
            System.out.println("❗️"+ gameCount + "번째 게임");

            BallGenerator generator = new BallGenerator();
            Balls question = generator.generateQuestion();
            submitCount = 0;
            playUntilCorrect(question);
        }
    }

    private void playUntilCorrect(Balls balls) {
        PlayResult result = new PlayResult();

        while (!balls.isFinish(result)) {
            result = play(balls);
            askRestartIfAnswerCorrect(result);
        }
    }
    private PlayResult play(Balls question) {
        System.out.println("숫자를 입력해 주세요 : ");

        List<Integer> userBalls = refineInput(sc.nextLine());
        submitCount++;

        PlayResult result = question.play(userBalls);
        System.out.println(result.getMessage());
        return result;
    }
    private List<Integer> refineInput(String input) {
        String validInput = verifyInputUntilValid(input);

        List<Integer> userBalls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userBalls.add(validInput.charAt(i) - '0');
        }
        return userBalls;
    }
    private String verifyInputUntilValid(String input){
        String validResult;
        try {
            ValidInput validInput = new ValidInput(input);
            validResult = validInput.checkInput();
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
            validResult = verifyInputUntilValid(sc.nextLine());
        }
        return validResult;
    }

    private void askRestartIfAnswerCorrect(PlayResult playResult) {
        if (playResult.isCorrect()) {
            askUntilInputValid();
        }
    }
    private void askUntilInputValid(){
        try {
            isRestart();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            askUntilInputValid();
        }
    }
    private boolean isRestart() throws InputMismatchException {
        if(isFirstGame()){
            return true;
        }
        System.out.println("시도횟수 : "+submitCount);
        System.out.println("게임을 " + "새로 시작하려면 " + THE_NUMBER_FOR_RESTART
                +", 종료하려면 "+ THE_NUMBER_FOR_QUIT +"를 입력하세요.");

        String response = sc.nextLine();

        if (response.equals(THE_NUMBER_FOR_RESTART)) {
            gameCount++;
            //이전 코드 : startGame();
            return true;
        }
        if (response.equals(THE_NUMBER_FOR_QUIT)) {
            return false;
            //이전 코드 : System.exit(0); // 종료보다 플래그가 나을까?
        }
        throw new InputMismatchException(
                THE_NUMBER_FOR_RESTART +"또는 "+ THE_NUMBER_FOR_QUIT +"를 입력해주세요. "
                        +"(시작 "+ THE_NUMBER_FOR_RESTART +""+", 종료 "+ THE_NUMBER_FOR_QUIT +")");
    }

    private boolean isFirstGame() {
        return submitCount == 1;
    }
}
