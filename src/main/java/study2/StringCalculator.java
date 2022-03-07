package study2;

import study2.operator.OperatorType;

import java.util.MissingFormatArgumentException;

public class StringCalculator{

    public int calculateOrThrow(String input){
        int value = 0;
        try {
            value = calculate(input);
        }catch (NumberFormatException e){
            throw new NumberFormatException("숫자를 입력해야할 자리에 다른 값이 존재합니다.");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("0은 나누는 수가 될 수 없습니다.");
        } catch (MissingFormatArgumentException e) {
            throw new MissingFormatArgumentException("존재하지 않는 연산자입니다.");
    }
        return value;
    }

    public int calculate(String input) {
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