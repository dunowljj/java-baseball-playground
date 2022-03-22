package baseball;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallGenerator {

    public Balls generateBalls() {
        List<Integer> ballList = Stream.generate(() -> (int)(Math.random() * 9 + 1))
                .distinct().limit(3)
                .collect(Collectors.toList());

        return new Balls(ballList);
    }
}
