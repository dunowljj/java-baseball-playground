package baseball;

public class Baseball {
    private String resultMessage;
    public void play(PlayResult playResult) {
        if(isCorrect(playResult)){
            resultMessage = playResult.getStrike() + "스트라이크\n3개의 숫자를 모두 맞히셨습니다!";
            System.out.println(resultMessage);
            return;
        }
        if(isNOTHING(playResult)){
            resultMessage = "nothing";
            System.out.println(resultMessage);
            return;
        }
        if(hasBothBALLAndSTRIKE(playResult)){
            resultMessage = playResult.getBall() + "볼 " + playResult.getStrike() + "스트라이크";
            System.out.println(resultMessage);
            return;
        }
        if(hasOnlyBALL(playResult)){
            resultMessage = playResult.getBall() + "볼";
            System.out.println(resultMessage);
            return;
        }
        if(hasOnlySTRIKE(playResult)){
            resultMessage = playResult.getStrike() + "스트라이크";
            System.out.println(resultMessage);
        }
    }
    public boolean isCorrect(PlayResult playResult) {
        return playResult.getStrike() == 3;
    }
    private boolean isNOTHING(PlayResult playResult) {
        return playResult.getBall() == 0 && playResult.getStrike() == 0;
    }
    private boolean hasBothBALLAndSTRIKE(PlayResult playResult) {
        return playResult.getBall() > 0 && playResult.getStrike() > 0;
    }
    private boolean hasOnlySTRIKE(PlayResult playResult) {
        return playResult.getBall() == 0 && playResult.getStrike() > 0;
    }
    private boolean hasOnlyBALL(PlayResult playResult) {
        return playResult.getBall() > 0 && playResult.getStrike() == 0;
    }
    public String getResult() {
        return resultMessage;
    }
}
