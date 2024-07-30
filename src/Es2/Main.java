package Es2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.util.Collections.sort;

public class Main {
    private static Random rand = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero!");
        boolean noError = false;
        while (!noError) {
            try {
                int n = parseInt(scanner.nextLine());
                noError = true;
                List<Integer> list = randomSortedList(n);
                System.out.println(list);
                System.out.println(reversedList(list));
                System.out.println("Numeri in posizione pari:");
                printEvenOrOdd(list, true);
                System.out.println("Numeri in posizione dispari:");
                printEvenOrOdd(list, false);
            } catch (NumberFormatException e) {
                System.out.println("Dovevi inserire un numero, riprova!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> randomSortedList(int n) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int randomNum = rand.nextInt(0, 100);
            numList.add(randomNum);
        }
        sort(numList);
        return numList;
    }

    public static List<Integer> reversedList(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        newList.addAll(list);
        newList.addAll(list.reversed());
        return newList;
    }

    public static void printEvenOrOdd(List<Integer> list, boolean bool) {
        List<Integer> evenOrOddList = new ArrayList<>();
        if (bool) {
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 == 0) evenOrOddList.add(list.get(i));
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 != 0) evenOrOddList.add(list.get(i));
            }
        }
        System.out.println(evenOrOddList);
    }
}
