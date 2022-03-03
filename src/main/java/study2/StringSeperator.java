package study2;

import java.util.MissingFormatArgumentException;
import java.util.regex.Pattern;

public class StringSeperator {
    private final String NUMBER_REGEX_PATTERN = "^[0-9]+$";
    private int[] numberSources;
    private String[] operatorSources;
    public StringSeperator(){}
    private StringSeperator(int[] numbers, String[] operators) {
        this.numberSources = numbers;
        this.operatorSources = operators;
    }

    /*
    refine : 입력값을 split 후, 만들어진 배열의 길이를 체크하고, 두 개의 배열에 배분하여 반환한다.
     */
    public StringSeperator refine(String input) throws IllegalArgumentException{
        String[] inputArr = input.split(" ");

        checkLengthIsEvenAndThrow(inputArr);

        StringSeperator result = divideOperatorsWithNumsFrom(inputArr);
        return result;
    }
    public void checkLengthIsEvenAndThrow(String[] inputArr){
        if(inputArr.length % 2 ==0){
            throw new IllegalArgumentException("연산자와 숫자의 개수가 맞지 않습니다.");
        }
    }
    /*
    String 배열로부터 연산자와 숫자를 두 배열로 분리하기
     */
    public StringSeperator divideOperatorsWithNumsFrom(String[] inputArr){
        int[] numbers = new int[inputArr.length - inputArr.length/2];
        String[] operators = new String[inputArr.length/2];

        int countNum =0;
        int countOper = 0;
        
        for(int i=0; i<inputArr.length; i++){
            if(i % 2 == 0){
                isNumber(inputArr[i]);
                numbers[countNum++] = Integer.parseInt(inputArr[i]);
            } else{
                operators[countOper++] = inputArr[i];
            }
        }
        return new StringSeperator(numbers, operators);
    }
    public void isNumber(String number){
        boolean regex = Pattern.matches(NUMBER_REGEX_PATTERN, number);
        if(!regex){
            throw new MissingFormatArgumentException("홀수번째에는 숫자를 입력하세요.");
        }
    }

    public int[] getNumberSources() {
        return numberSources;
    }
    public String[] getOperatorSources() {
        return operatorSources;
    }

}
