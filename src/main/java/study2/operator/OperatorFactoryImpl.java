package study2.operator;

import java.util.MissingFormatArgumentException;

public class OperatorFactoryImpl {
    Operator operator;
    public OperatorFactoryImpl(){
    }
    public Operator create(String symbol){
        if (symbol.equals("+")) {
            return operator = new PlusOperator();
        }
        if (symbol.equals("-")) {
            return operator = new MinusOperator();
        }
        if (symbol.equals("*")) {
            return operator = new MultiplyOperator();
        }
        if (symbol.equals("/")) {
            return operator = new DivideOperator();
        }
        throw new MissingFormatArgumentException("사용가능한 연산자가 없습니다.");
    }
}
