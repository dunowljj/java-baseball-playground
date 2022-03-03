package study2.operator;

public class MinusOperator implements Operator{
    @Override
    public int operate(int value, int nextValue) {
        return value - nextValue;
    }
}
