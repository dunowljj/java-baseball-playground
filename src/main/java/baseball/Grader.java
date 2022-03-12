package baseball;


public class Grader {
    private int strike = 0;
    private int ball = 0;

    public Grader() {
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public Grader(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Grader countStrikeAndBall(String[] submittedAnswers, String[] answers){
        strike = 0;
        ball = 0;
        for(int i=0; i<answers.length; i++){
            strike = countStrike(submittedAnswers,answers,i);
            ball = countBall(submittedAnswers,answers,i);
        }
        return new Grader(strike, ball);
    }
    private int countStrike(String[] submittedAnswers, String[] answers, int index){
        if(submittedAnswers[index].equals(answers[index])){
            strike++;
        }
        return strike;
    }
    private int countBall(String[] submittedAnswers, String[] answers, int index) {
        if(submittedAnswers[0].equals(answers[index]) && index != 0){
            ball++;
        }
        if (submittedAnswers[1].equals(answers[index]) && index != 1) {
            ball++;
        }
        if (submittedAnswers[2].equals(answers[index]) && index != 2) {
            ball++;
        }
        return ball;
    }
}
