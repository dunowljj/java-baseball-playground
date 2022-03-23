package baseball;

public class BallNumber {
    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;
    private int no;


    public BallNumber(int no) {
        if (no < MIN_NO || no > MAX_NO) {
            throw new IllegalArgumentException("1-9 사이 숫자를 입력하세요.");
        }
        this.no = no;
    }

    public int getNo() {

        return no;
    }
}
