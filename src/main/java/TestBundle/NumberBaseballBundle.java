package TestBundle;

import baseball.Examiner;
import baseball.Grader;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NumberBaseballBundle {
    boolean isCorrect = false;
    Scanner sc = new Scanner(System.in);
    public void processGame(){
        Examiner examiner = new Examiner();
        boolean willRetry;

        do {
            String[] answers = examiner.makeExam();
            playGameUntilCorrectWith(answers);
            String input = "1";
            willRetry = decideRetryOrThrow(input);
        } while(willRetry);
    }
    public void playGameUntilCorrectWith(String[] answers){
        Grader grader = new Grader();
        while(!isCorrect){
            System.out.print("숫자를 입력해 주세요 : ");

            String input = sc.nextLine();
            String checkedInput = validateInput(input);
            String[] submittedAnswers = makeInputToArr(checkedInput);

            grader.countStrikeAndBall(submittedAnswers,answers);
            grader.printResult();
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
    // 1,2번 외에 다른 것 입력 시 다시 물어본다.
    public boolean decideRetryOrThrow(String input){
        boolean willRetry;
        try {
            willRetry = askContinue(input);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            willRetry = true;
        }
        return willRetry;
    }
    public boolean askContinue(String input) throws InputMismatchException{
        if (input.equals("1")){
            isCorrect = false;
            return true;
        }
        if (input.equals("2")){
            return false;
//            System.exit(0);
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

}