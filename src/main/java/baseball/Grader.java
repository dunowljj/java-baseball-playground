package baseball;


public class Grader {
    private boolean isCorrect = false;
    private int strike = 0;
    private int ball = 0;


    public Grader() {
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void checkIsAnswerCorrect() {
        if(strike == 3){
            isCorrect = true;
        }
    }
    public void countStrikeAndBall(String[] submittedAnswers, String[] answers){
        strike = 0;
        ball = 0;
        for(int i=0; i<answers.length; i++){
            strike = countStrike(submittedAnswers,answers,i);
            ball = countBall(submittedAnswers,answers,i);
        }
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

    public void printResult() {
        printMessageIfQuit();

        printMessageIfNothing();

        printMessageIfBall();

        printMessageIfStrike();

        printMessageIfBallAndStrike();
    }
    private void printMessageIfQuit(){

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        }
    }
    private void printMessageIfNothing(){

        if (strike == 0 && ball == 0) {
            System.out.println("nothing");
        }
    }
    private void printMessageIfBall(){

        if (strike == 0 && ball > 0) {
            System.out.println(ball+"볼");
        }
    }
    private void printMessageIfStrike(){

        if (strike > 0 && ball == 0) {
            System.out.println(strike+"스트라이크");
        }
    }
    private void printMessageIfBallAndStrike(){

        if (strike > 0 && ball > 0){
            System.out.println(ball+"볼"+strike+"스트라이크");
        }
    }
}
