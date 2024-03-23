package Zad4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class setOperations {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        out.println("Enter set operations:");
        String operationsLine=s.nextLine();
        String[] elements=operationsLine.split("[\\]\\[]",0);
        TreeSet<Integer> firstSet= Arrays.stream(elements[1].split(",")).map(x -> Integer.parseInt(x.trim())).collect(Collectors.toCollection(TreeSet::new));
        TreeSet<Integer> secondSet=Arrays.stream(elements[3].split(",")).map(x -> Integer.parseInt(x.trim())).collect(Collectors.toCollection(TreeSet::new));
        String operation=elements[2].trim();
        switch (operation) {
            case "+" -> firstSet.addAll(secondSet);
            case "*" -> firstSet.retainAll(secondSet);
            case "-" -> firstSet.removeAll(secondSet);
        }
        out.println(firstSet);
    }
}
