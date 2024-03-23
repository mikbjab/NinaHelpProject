package Zad3;

import java.util.*;

import static java.lang.System.out;

public class randomNumbers {
    public static void getRandomNumbers(int MAX,int N,int S){
        Random rand=new Random();

        List<Integer> numbers=new ArrayList<>();
        while(true){
            int tempNumber=rand.nextInt(MAX);
            numbers.add(tempNumber);
            if(tempNumber==S)
                break;
        }
        int range=Math.min(N,numbers.size());
        out.print("First "+ N +" numbers: ");
        for(int i=0;i<range;i++){
            out.print(numbers.get(i) +" ");
        }
        out.print("\nLast "+ N +" numbers: ");
        for(int i=numbers.size()-1;i>numbers.size()-1-range;i--){
            out.print(numbers.get(i) +" ");
        }
        Set<Integer> uniqueNumbers=new TreeSet<>(numbers);
        out.println("\nAll unique numbers: "+uniqueNumbers);
    }
    public static void main(String[] args) {
        getRandomNumbers(10,3,7);
    }
}
