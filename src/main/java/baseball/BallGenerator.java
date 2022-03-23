package baseball;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallGenerator {
    public Balls generateBalls() {
        return new Balls(Stream.generate(() -> (int) (Math.random() * 9 + 1))
                .distinct().limit(3)
                .collect(Collectors.toList()));
    }
}
