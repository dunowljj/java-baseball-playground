package study2.operator;

public class DivideOperator implements Operator{

    @Override
    public int operate(int value, int nextValue) throws ArithmeticException{
        return value / nextValue;
    }
}
