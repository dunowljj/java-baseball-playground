package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NumberBaseball {
    Grader grader = new Grader();
    Scanner sc = new Scanner(System.in);
    public void processGame(){
        Examiner examiner = new Examiner();
        boolean willRetry;

        do {
            String[] answers = examiner.makeExam();
            playGameUntilCorrectWith(answers);

            willRetry = decideRetryOrThrow();
        } while(willRetry);
    }
    public void playGameUntilCorrectWith(String[] answers){
        while(!grader.isCorrect()){
            System.out.print("숫자를 입력해 주세요 : ");

            String input = sc.nextLine();
            String checkedInput = validateInput(input);
            String[] submittedAnswers = makeInputToArr(checkedInput);

            grade(submittedAnswers, answers);
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
            throw new InputMismatchException("잘못된 입력입니다. 3자리 숫자를 연속해서 입력해주세요. ex) 123");
        }
    }

    private String[] makeInputToArr(String input){
        String[] inputArr = new String[3];

        for (int i=0; i<inputArr.length; i++){
            inputArr[i] = input.charAt(i)+"";
        }
        return inputArr;
    }

    private void grade(String[] submittedAnswers, String[] answers){
        grader.countStrikeAndBall(submittedAnswers,answers);
        grader.checkIsAnswerCorrect();
        grader.printResult();
    }

    // 1,2번 외에 다른 것 입력 시 다시 물어본다.
    private boolean decideRetryOrThrow(){
        boolean willRetry;
        try {
            willRetry = askContinue();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            willRetry = decideRetryOrThrow();
        }
        return willRetry;
    }
    private boolean askContinue() throws InputMismatchException{
        String input = sc.nextLine();

        if (input.equals("1")){
            grader.setCorrect(false);
            return true;
        }
        if (input.equals("2")){
            System.exit(0);
        }
        throw new InputMismatchException("1 또는 2를 입력하세요");
    }



}
