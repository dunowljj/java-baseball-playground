package baseball;

public class Ball {


    private int index;
    private int num;

    public int getNum() {
        return num;
    }

    public int getIndex() {
        return index;
    }

    public Ball() {
    }

    public Ball(int index, int num) {
        this.index = index;
        this.num = num;
    }

    public BallStatus check(Ball userBall) {
        if (this.isBall(userBall)) {
            return BallStatus.BALL;
        }
        if (this.isSTRIKE(userBall)) {
            return BallStatus.STRIKE;
        }
        //아무것도 안 걸리면 NOTHING이다.
        return BallStatus.NOTHING;
    }

    private boolean isSTRIKE(Ball user) {
        return this.equals(user);
    }

    private boolean isBall(Ball user) {
        return num == user.getNum() && index != user.getIndex();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return index == ball.index && num == ball.num;
    }

}
