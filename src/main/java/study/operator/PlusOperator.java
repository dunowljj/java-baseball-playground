package study.operator;

public class PlusOperator implements Operator {

    @Override
    public int operate(int value, int nextValue) {
        return value + nextValue;
    }
}
