package zadanie1;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame1 {

    private static int randomNumbers(){
        Random random = new Random();
        int num = random.nextInt(100)+1;
        return num;
    }

    private static int yourNum(){
        int num = 0;
        try {
            System.out.print("zgadnij liczbę: ");
            Scanner scanner = new Scanner(System.in);
            num = Integer.parseInt(scanner.next());
        }catch (NumberFormatException e){
            System.out.println("to nie jest liczba");
        }
        return num;
    }

    public static void main(String[] args) {
        int ranNumber = randomNumbers();
        boolean equolsNum = true;
        System.out.println("podaj liczbę z zakresu od 1 do 100");
        do {
            System.out.println(ranNumber);

            int clientNum = yourNum();
            if (clientNum > 100 || clientNum < 1){
                System.out.println("liczba z poza zakresu");
            }else if (clientNum < ranNumber){
                System.out.println("Za mało!");
            }else if (clientNum > ranNumber){
                System.out.println("Za dużo!");
            }else {
                equolsNum = false;
                System.out.println("Zgadłeś!");
            }
        }while (equolsNum);
    }
}
