package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NumberBaseball {
    boolean isCorrect = false;
    Grader grader = new Grader();
    Examiner examiner = new Examiner();
    Scanner sc = new Scanner(System.in);
    public void processGame(){
        boolean willRetry;
        do {
            String[] answers = examiner.makeExam();
            playGameUntilCorrectWith(answers);

            willRetry = decideRetryOrThrow();
        } while(willRetry);
    }
    public void playGameUntilCorrectWith(String[] answers){
        while(!isCorrect){
            System.out.print("숫자를 입력해 주세요 : ");

            String input = sc.nextLine();
            String checkedInput = validateInput(input);
            String[] submittedAnswers = makeInputToArr(checkedInput);

            Grader score = getScore(submittedAnswers,answers);
            printResultByScore(score);
        }
    }
    public String validateInput(String input){
        try {
            checkInput(input);
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
            validateInput(sc.nextLine());
        }
        return input;
    }
    public void checkInput(String input) throws InputMismatchException{
        String pattern = "^[1-9]{3}$";
        boolean regex = Pattern.matches(pattern,input);
        if(!regex){
            throw new InputMismatchException("3자리 숫자를 연속해서 입력해주세요. ex) 123");
        }
    }
    public Grader getScore(String[] submittedAnswers, String[] answers) {
        Grader score = grader.countStrikeAndBall(submittedAnswers, answers);
        return score;
    }

    // 1,2번 외에 다른 것 입력 시 다시 물어본다.
    public boolean decideRetryOrThrow(){
        boolean willRetry = false;
        try {
            willRetry = askContinue();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            willRetry = decideRetryOrThrow();
        }
        return willRetry;
    }
    public boolean askContinue() throws InputMismatchException{
        String input = "";
        input = sc.nextLine();

        if (input.equals("1")){
            isCorrect = false;
            return true;
        }
        if (input.equals("2")){
            System.exit(0);
        }
        throw new InputMismatchException("1 또는 2를 입력하세요");
    }

    public String[] makeInputToArr(String input){
        String[] inputArr = new String[3];

        for (int i=0; i<inputArr.length; i++){
            inputArr[i] = input.substring(i,i+1);
        }
        return inputArr;
    }

    public void printResultByScore(Grader grade) {
        printMessageIfQuit(grade);

        printMessageIfNothing(grade);

        printMessageIfBall(grade);

        printMessageIfStrike(grade);

        printMessageIfBallAndStrike(grade);
    }
    private void printMessageIfQuit(Grader grade){
        int strike = grade.getStrike();

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            isCorrect = true;
        }
    }
    private void printMessageIfNothing(Grader grade){
        int strike = grade.getStrike();
        int ball = grade.getBall();

        if (strike == 0 && ball == 0) {
            System.out.println("nothing");
        }
    }
    private void printMessageIfBall(Grader grade){
        int strike = grade.getStrike();
        int ball = grade.getBall();

        if (strike == 0 && ball > 0) {
            System.out.println(ball+"볼");
        }
    }
    private void printMessageIfStrike(Grader grade){
        int strike = grade.getStrike();
        int ball = grade.getBall();

        if (strike > 0 && ball == 0) {
            System.out.println(strike+"스트라이크");
        }
    }
    private void printMessageIfBallAndStrike(Grader grade){
        int strike = grade.getStrike();
        int ball = grade.getBall();

        if (strike > 0 && ball > 0){
            System.out.println(ball+"볼"+strike+"스트라이크");
        }
    }
}
