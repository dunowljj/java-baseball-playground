package study;

import study.operator.Operator;
import study.operator.OperatorFactoryImpl;

public class StringCalculator {
    OperatorFactoryImpl operatorFactory = new OperatorFactoryImpl();

    public int calculate(String input) {
        String[] inputArr = input.split(" ");

        int fristValue = Integer.parseInt(inputArr[0]);
        int value = fristValue;

        for (int i = 0; i < inputArr.length; i += 2) {
            int nextValue = Integer.parseInt(inputArr[i + 1]);
            Operator operator = operatorFactory.create(inputArr[i]);

            value = tryToCalculate(value, nextValue, operator);
        }
        return value;
    }
    public int tryToCalculate(int value, int nextValue, Operator operator){
        try {
            value = operator.operate(value, nextValue);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("0은 나누는 수가 될 수 없습니다.");
        }
        return value;
    }
}

