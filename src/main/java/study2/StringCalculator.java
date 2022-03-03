package study2;

import study2.operator.*;

import java.util.MissingFormatArgumentException;

public class StringCalculator{
    private StringAnalyzer stringAnalyzer;
    private OperatorFactoryImpl operatorFactoryImpl;
    private int value;
    private int nextValue;
    private int startValue;
    public StringCalculator() {
        this.stringAnalyzer = new StringAnalyzer();
        this.operatorFactoryImpl = new OperatorFactoryImpl();
    }

    public int calculate(String input){
        StringAnalyzer source = stringAnalyzer.refine(input);
        String[] operatorSources = source.getOperatorSources();
        int[] numberSources = source.getNumberSources();

        calculate(operatorSources, numberSources);
        return value;
    }
    public int calculate(String[] operatorSources, int[] numberSources){
        startValue = numberSources[0];
        value = startValue;

        for(int i=0; i<numberSources.length-1; i++) {

            Operator operator = operatorFactoryImpl.create(operatorSources[i]);
            nextValue = numberSources[i + 1];

            value = tryTocalculate(value, nextValue, operator);
        }
        return value;
    }

    public int tryTocalculate(int value, int nextValue, Operator operator){
        try {
            value = operator.operate(value, nextValue);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("0은 나누는 수가 될 수 없습니다.");
        } catch (MissingFormatArgumentException e) {
            e.printStackTrace();
        }
        return value;
    }
}
