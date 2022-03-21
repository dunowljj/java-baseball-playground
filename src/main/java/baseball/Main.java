package baseball;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PlayResult playResult = new PlayResult();
        Baseball baseball = new Baseball();
        Scanner sc = new Scanner(System.in);

        String ballNumbers = sc.nextLine();
        int num1 = ballNumbers.charAt(0) - '0';
        int num2 = ballNumbers.charAt(1) - '0';
        int num3 = ballNumbers.charAt(2) - '0';

        Balls userBalls = new Balls(Arrays.asList(num1,num2,num3));

    }
}
