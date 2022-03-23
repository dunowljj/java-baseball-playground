package baseball;

public class Ball{

    private int index;



    private BallNumber ballNum;

    public Ball(int index, int num) {
        this.index = index;
        this.ballNum = new BallNumber(num);
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
        return ballNum.getNo() == user.getBallNum() && index != user.getIndex();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return index == ball.index && ballNum.getNo() == ball.ballNum.getNo();
    }

    public int getIndex() {
        return index;
    }
    public int getBallNum() {
        return ballNum.getNo();
    }

}
