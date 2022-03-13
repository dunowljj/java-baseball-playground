package baseball;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Examiner {
    private String[] answers;



    public Examiner() {
        this.answers = new String[3];
    }

    public String[] makeExam(){
        Set<String> set = new HashSet<>();
        while(set.size() != 3){
            set.add(String.valueOf((int) (Math.random() * 9 + 1)));
        }

        Iterator<String> iter = set.iterator();
        for(int i=0; i<3; i++){
            answers[i] = iter.next();
        }
        return answers;
    }
}
