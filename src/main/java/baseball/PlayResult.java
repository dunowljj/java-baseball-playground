package baseball;

public class PlayResult {

    private String resultMessage;

    public String getResult() {
        return resultMessage;
    }

    public void grade(int ball, int strike) {
        if(isCorrect(strike)){
            resultMessage = strike + "스트라이크\n3개의 숫자를 모두 맞히셨습니다!";
            System.out.println(resultMessage);
            return;
        }
        if(isNOTHING(ball, strike)){
            resultMessage = "nothing";
            System.out.println(resultMessage);
            return;
        }
        if(hasBothBALLAndSTRIKE(ball, strike)){
            resultMessage = ball + "볼 " + strike + "스트라이크";
            System.out.println(resultMessage);
            return;
        }
        if(hasOnlyBALL(ball, strike)){
            resultMessage = ball + "볼";
            System.out.println(resultMessage);
            return;
        }
        if(hasOnlySTRIKE(ball, strike)){
            resultMessage = strike + "스트라이크";
            System.out.println(resultMessage);
        }
    }
    public boolean isCorrect(int strike) {
        return strike == 3;
    }
    private boolean isNOTHING(int ball, int strike) {
        return ball == 0 && strike == 0;
    }
    private boolean hasBothBALLAndSTRIKE(int ball, int strike) {
        return ball > 0 && strike > 0;
    }
    private boolean hasOnlySTRIKE(int ball, int strike) {
        return ball == 0 && strike > 0;
    }
    private boolean hasOnlyBALL(int ball, int strike) {
        return ball > 0 && strike == 0;
    }
}
