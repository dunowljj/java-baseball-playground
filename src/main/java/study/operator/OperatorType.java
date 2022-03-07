package study.operator;

import study.exception.ErrorCode;
import study.exception.OperatorException;
import java.util.function.BinaryOperator;

public enum OperatorType{
    PLUS("+", (value, nextValue) -> value + nextValue),
    MINUS("-",(value, nextValue) -> value - nextValue),
    MULTIPLY("*",(value, nextValue) -> value * nextValue),
    DIVIDE("/",(value, nextValue) -> (value / nextValue));

    private String symbol;
    private BinaryOperator<Integer> expression;



    OperatorType(String symbol, BinaryOperator<Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }
    public int operate(int value, int nextValue){
        return expression.apply(value, nextValue);
    }

    public static OperatorType findOperatorBySymbol(String symbol){
        for(OperatorType operator : OperatorType.values()){
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new OperatorException(ErrorCode.INVALID_OPERATOR,"존재하지 않는 연산자입니다.");
    }
    public BinaryOperator<Integer> getExpression() {
        return expression;
    }

    public String getSymbol() {
        return symbol;
    }
}
