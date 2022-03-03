package study.operator;

public class OperatorFactoryImpl implements OperatorFactory{
    Operator operator;

    public Operator create(String symbol){
        if (symbol.equals("+")) {
            operator = new PlusOperator();;
        }
        if (symbol.equals("-")) {
            operator = new MinusOperator();
        }
        if (symbol.equals("*")) {
            operator = new MultiplyOperator();
        }
        if (symbol.equals("/")) {
            operator = new DivideOperator();
        }
        return operator;
    }
}
