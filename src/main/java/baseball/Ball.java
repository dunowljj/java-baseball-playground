package baseball;

public class Ball {
    private int num;
    private int index;

    public int getNum() {
        return num;
    }

    public int getIndex() {
        return index;
    }

    public Ball() {
    }

    public Ball(int num, int index) {
        this.num = num;
        this.index = index;
    }

    public BallType checkUserBall(Ball userBall) {
        if (isBall(userBall)) {
            return BallType.BALL;
        }
        if (isStrike(userBall)) {
            return BallType.STRIKE;
        }
        //아무것도 안 걸리면 NOTHING이다.
        return BallType.NOTHING;
    }

    private boolean isStrike(Ball user) {
        return num == user.getNum() && index == user.getIndex();
    }

    private boolean isBall(Ball user) {
        return num == user.getNum() && index != user.getIndex();
    }
}
