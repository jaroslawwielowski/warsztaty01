package zadanie2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoSimulator {

    private static int[] randomNumbers(){
        int[] lottoNumbers = new int[6];
        for (int i = 0; i < lottoNumbers.length; i++) {
            int num = 0;
            Random random = new Random();
            do {
                num = random.nextInt(49)+1;
            }while (equolsNumWithArr(num, lottoNumbers));
            lottoNumbers[i] = num;
        }
        Arrays.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static int[] requestNumber(){
        int[] yourNum = new int[6];
            for (int i = 0; i < yourNum.length; i++) {
                int num = 0;
                Scanner scanner = new Scanner(System.in);
                    do {
                        try {
                            System.out.printf("podaj liczbę %s z 6 : ", i+1);
                            num = Integer.parseInt(scanner.next());
                        }catch (NumberFormatException e){
                            System.out.println("to nie jest liczba");
                        }
                    }while (equolsNumWithArr(num, yourNum));
                    yourNum[i]=num;
            }
        Arrays.sort(yourNum);
        return yourNum;
    }

    private static boolean equolsNumWithArr( int a, int[] arr){
        boolean types = false;
        for (int i = 0; i < arr.length; i++) {
            if (a > 49 || a < 1){
                System.out.println("podałeś liczbę z poza zakresu");
                types= true;
                break;
            }
            if (a == arr[i]) {
                System.out.println("nie powtarzaj liczb!");
                types= true;
                break;
            }else {
                types= false;
            }
        }
        return types;
    }

    private static int howMany(int[] lottoNum, int[] yourNum){
        int count = 0;
        for (int i = 0; i < lottoNum.length; i++) {
            for (int j = 0; j < yourNum.length; j++) {
                if (lottoNum[i] == yourNum[j]){
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println("To jest gra Lotto! Podaj 6 liczb z zakresu od 1 do 49 i traf jak najwięcej :)");
        int[] randomArr = randomNumbers();
        int[] clientArr = requestNumber();
        System.out.println("Twoje Wpisane liczby to : " + Arrays.toString(clientArr));
        System.out.println("Wylosowane liczby to : " + Arrays.toString(randomArr));
        System.out.printf("Posiadasz %s celnych trafień :)", howMany(randomArr, clientArr));
    }
}
