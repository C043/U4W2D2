package Es1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> words = new HashSet<>();
        Set<String> duplicateWords = new HashSet<>();
        System.out.println("Inserisci il numero di parole che vuoi scrivere!");
        boolean noException = false;
        while (!noException) {
            try {
                int n = Integer.parseInt(scanner.nextLine());
                noException = true;
                for (int i = 0; i < n; i++) {
                    System.out.println("Inserisci la prossima parola!");
                    try {
                        String word = scanner.nextLine();
                        if (words.contains(word)) duplicateWords.add(word);
                        else words.add(word);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        i--;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Devi inserire un numero, riprova!");
            }
        }
        System.out.println("Le parole duplicate sono:");
        printSet(duplicateWords);
        System.out.println("Il numero di parole distinte sono: " + words.size());
        System.out.println("L'elenco delle parole distinte è:");
        printSet(words);
    }

    public static void printSet(Set<String> set) {
        for (String el : set) {
            System.out.println(el);
        }
    }
}
