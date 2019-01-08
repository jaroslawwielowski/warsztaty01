package zadanie3;

import java.util.Scanner;

public class RandomNumebrGame2 {

    public static void main(String[] args) {
        System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w max 10 próbach.");
        Scanner scan = new Scanner(System.in);
        boolean equolsNum = true;
        int min = 0;
        int max = 1001;
        while (equolsNum) {
            int guess = ((max - min) / 2) + min;
            System.out.println("Zgaduję: " + guess);
            String userAnswer = scan.nextLine();
            if (userAnswer.equals("za dużo")) {
                max = guess;
            } else if (userAnswer.equals("za mało")) {
                min = guess;
            } else if (userAnswer.equals("trafiłeś")){
                System.out.println("Wygrałem!");
                equolsNum = false;
            }
        }
    }
}
