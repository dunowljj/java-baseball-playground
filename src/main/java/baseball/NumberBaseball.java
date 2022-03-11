package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberBaseball {
    boolean isCorrect = false;
    Grader grader = new Grader();
    Examiner examiner = new Examiner();
    Scanner sc = new Scanner(System.in);
    public void doGame(){

        while(!isCorrect){
            System.out.print("숫자를 입력해 주세요 : ");

            String input = sc.nextLine();
            String[] answers = examiner.makeExam();

            Grader score = getScore(input,answers);
            printResultByScore(score);

            decideRetryOrThrow();
        }
    }
    public Grader getScore(String input, String[] answers) {

        String[] submittedAnswers = readInput(input);

        return grader.countStrikeAndBall(submittedAnswers, answers);
    }

    public void decideRetryOrThrow(){
        try {
            decideRetry();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
    public void decideRetry(){
        String input = "";
        if (isCorrect){
            examiner.setSolved(true);
            input = sc.nextLine();
        }
        if (input.equals("1")){
            isCorrect = false;
            return;
        }
        if (input.equals("2")){
            System.exit(0);
        }
       /* if(!input.equals("1") && !input.equals("2")){
            throw new InputMismatchException("1 또는 2를 입력하세요");
        }*/
    }

    public String[] readInput(String input){
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
    public void printMessageIfQuit(Grader grade){
        int strike = grade.getStrike();

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            isCorrect = true;
        }
    }
    public void printMessageIfNothing(Grader grade){
        int strike = grade.getStrike();
        int ball = grade.getBall();

        if (strike == 0 && ball == 0) {
            System.out.println("nothing");
        }
    }
    public void printMessageIfBall(Grader grade){
        int strike = grade.getStrike();
        int ball = grade.getBall();

        if (strike == 0 && ball > 0) {
            System.out.println(ball+"볼");
        }
    }
    public void printMessageIfStrike(Grader grade){
        int strike = grade.getStrike();
        int ball = grade.getBall();

        if (strike > 0 && ball == 0) {
            System.out.println(strike+"스트라이크");
        }
    }
    public void printMessageIfBallAndStrike(Grader grade){
        int strike = grade.getStrike();
        int ball = grade.getBall();

        if (strike > 0 && ball > 0){
            System.out.println(ball+"볼"+strike+"스트라이크");
        }
    }
}
