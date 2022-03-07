package study2.operator;

import java.util.MissingFormatArgumentException;

public enum OperatorType implements Operator {
    PLUS("+") {
        public int apply(int value, int nextValue) {return value + nextValue;}
    },
    MINUS("-") {
        public int apply(int value, int nextValue) {return value - nextValue;}
    },
    MULTIPLY("*") {
        public int apply(int value, int nextValue) {return value * nextValue;}
    },
    DIVIDE("/") {
        public int apply(int value, int nextValue) throws ArithmeticException {return value /nextValue;}
    };
    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public static OperatorType findOperatorBySymbol(String symbol){
        for(OperatorType operator : OperatorType.values()) {
            if (symbol.equals(operator.symbol)) {
                return operator;
            }
        }
        throw new MissingFormatArgumentException("존재하지 않는 연산자입니다.");
    }

    public int operate(int value, int nextValue) {
        int result = operateOrThrow(value, nextValue);
        return result;
    }
    public int operateOrThrow(int value, int nextValue)  {
        int result = 0;
        try {
            result = this.apply(value, nextValue);
        }catch (ArithmeticException e){
            throw new ArithmeticException("0은 나누는 수가 될 수 없습니다.");
        }
        return result;
    }


}
