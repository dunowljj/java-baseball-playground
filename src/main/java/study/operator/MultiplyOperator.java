package study.operator;

public class MultiplyOperator implements Operator {

    @Override
    public int operate(int value, int nextValue) {
        return value * nextValue;
    }
}