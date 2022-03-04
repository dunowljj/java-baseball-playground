package study2.operator;

public class DivideOperator implements Operator{

    @Override
    public int operate(int value, int nextValue) throws ArithmeticException{
        int result = (int)Math.round((double) value / nextValue); //소수 첫째자리에서 반올림한 값 리턴
        return result;
    }
}
