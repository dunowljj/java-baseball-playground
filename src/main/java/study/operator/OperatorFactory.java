package study.operator;

import study.operator.Operator;

public interface OperatorFactory {
    Operator create(String symbol);
}
