package baseball;

import java.util.Arrays;

public class Examiner {
    private String[] answers;
    private boolean isSolved = true;



    public Examiner() {
        this.answers = new String[3];
    }

    public String[] makeExam(){
        if(isSolved){
            Arrays.setAll(answers, (i) -> String.valueOf((int)(Math.random()*9+1)));
            isSolved = false;
        }
        return answers;
    }
    public boolean isSolved() {
        return isSolved;
    }
    public void setSolved(boolean solved) {
        isSolved = solved;
    }
}
