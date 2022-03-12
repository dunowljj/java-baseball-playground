package baseball;

import java.util.Arrays;

public class Examiner {
    private String[] answers;



    public Examiner() {
        this.answers = new String[3];
    }

    public String[] makeExam(){
        Arrays.setAll(answers, (i) -> String.valueOf((int)(Math.random()*9+1)));
        return answers;
    }
}
