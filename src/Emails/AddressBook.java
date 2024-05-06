package Emails;

import TextConvert.Paragraphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AddressBook {
    private Map<String, Set<String>> address;

    public Map<String,Set<String>> getMap(){
        return address;
    }

    public AddressBook(){
        this.address=new HashMap<>();
    }

    public void read(String filename){
        try {
            File file=new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String currentLine = scanner.nextLine();
                List<String> data= new ArrayList<>(List.of(currentLine.split(";")));
                String name=data.get(0);
                data.remove(0);
                Set<String> emails=new HashSet<>(data);
                this.address.put(name,emails);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void addAddress(String username,String email){
        Set<String> usersEmails=this.address.get(username);
        if (usersEmails == null) {
            usersEmails=new HashSet<>();

        }
        usersEmails.add(email);
        this.address.put(username,usersEmails);
    }

    public String[] getAddresses(String username){
        Set<String> emails=this.address.get(username);
        int numOfEmails;
        if (emails == null) {
            String[] array={};
            return array;
        }
            numOfEmails=emails.size();

        String[] emailsArray=new String[numOfEmails];
        return emails.toArray(emailsArray);
    }

    public void write(String filename){
        try {
            FileWriter fileWriter=new FileWriter(filename,false);

            Set<String> nameSet=this.address.keySet();

            for(String name:nameSet){
                StringBuilder currentLine=new StringBuilder(name);
                for(String email:this.address.get(name)){
                    currentLine.append(";");
                    currentLine.append(email);
                }
                fileWriter.write(currentLine.toString()+"\n");
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }


    public static void main(String[] args) {
        String inputfile="src/Emails/input.txt";
        AddressBook addressBook=new AddressBook();
        addressBook.read(inputfile);
        addressBook.addAddress("essa","trololo");
        System.out.println(Arrays.toString(addressBook.getAddresses("ala ala")));
        addressBook.write("src/Emails/output.txt");

    }
}
