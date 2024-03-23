package Zad2;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class inputUsers {

    public static void main(String[] args) {
        Map<String,String> users= new Hashtable<>();
        Scanner s=new Scanner(System.in);
        while(true){
            out.println("Enter username:");
            String username=s.nextLine();
            if(username.equals("q"))
                    break;
            out.println("Enter password:");
            String password=s.nextLine();
            users.put(username,password);
        }
        out.println("Again enter your username:");
        String newUsername=s.nextLine();
        out.println(users.getOrDefault(newUsername, "Nie ma takiego użytkownika"));

    }
}
