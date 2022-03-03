package study.operator;

public class DivideOperator implements Operator {

    @Override
    public int operate(int value, int nextValue) {
        return value / nextValue;
    }
}
