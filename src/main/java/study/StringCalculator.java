package study;

import study.exception.ErrorCode;
import study.exception.OperatorException;
import study.exception.StringCalculatorException;
import study.operator.OperatorType;

public class StringCalculator{

    public int calculateOrThrow(String input){
        int value = 0;
        try {
            value = calculate(input);
        } catch (NumberFormatException e){ //숫자 자리에 문자
            throw new StringCalculatorException(ErrorCode.ILLEGAL_NUMBER_FORMAT,"숫자를 입력해야할 자리에 다른 값이 존재합니다.");
        } catch (ArithmeticException e) { //나누기 0 예외
            throw new StringCalculatorException(ErrorCode.ARITHMETIC_BY_ZERO,"0은 나누는 수가 될 수 없습니다.");
        } catch (OperatorException e) { //존재하지 않는 연산자 사용
            throw new OperatorException(ErrorCode.INVALID_OPERATOR,"존재하지 않는 연산자입니다.");
        }
        return value;
    }

    private int calculate(String input){
        String[] inputArr = input.split(" ");

        int startValue = Integer.parseInt(inputArr[0]);
        int value = startValue;
        int nextValue = 0;

        for(int i=1; i<inputArr.length; i+=2){
            String symbol = inputArr[i];
            nextValue = Integer.parseInt(inputArr[i + 1]);

            OperatorType operator = OperatorType.findOperatorBySymbol(symbol);
            value = operator.operate(value, nextValue);
        }
        return value;
    }
}

