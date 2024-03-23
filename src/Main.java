import Zad1.Student;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Nina Kałuża","123456");
        Student s2= new Student("Mikołaj Jabłoński", "439764",true,22);
        Student s3= new Student("Mikołaj Jabłoński", "439764",true,22);
        System.out.println(s2); //niejawne wywołanie metody toString()
        System.out.println(s2.equals(s3));
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
    }
}