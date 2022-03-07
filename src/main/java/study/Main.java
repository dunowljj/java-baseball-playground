package study;

import study.exception.OperatorException;
import study.exception.StringCalculatorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            stringCalculator.calculateOrThrow(input);
        } catch (StringCalculatorException e) {
            System.out.println(e.getMessage());
        } catch (OperatorException e){
            System.out.println(e.getMessage());
        }
    }
}
