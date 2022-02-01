/**
 * Java 1. Homework 5
 * 
 * @author Butakova A.O.
 * @version 24.10.2021
 */
 
import java.util.Arrays;

class HomeWork5 {

    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivanov Ivan Ivanovich", "Engineer", "ivivan@mailbox.com", "+79123456789", 70000, 27);
        empArray[1] = new Employee("Nikolaev Nikolay Nikolaevich", "Director", "niknikolay@mailbox.com", "+79123456788", 100000, 45);
        empArray[2] = new Employee("Petrov Petr Petrovich", "Electrician", "petrpetr@mailbox.com", "+79123456787", 50000, 39);
        empArray[3] = new Employee("Andreev Andrey Andreevich", "Mechanic", "anandrey@mailbox.com", "+79123456786", 40000, 48);
        empArray[4] = new Employee("Leonidov Leonid Leonidovich", "Analyst", "leoleonid@mailbox.com", "+79123456785", 60000, 33);
        for (int i = 0; i < empArray.length; i++) {
            System.out.println(empArray[i]);
        }
        System.out.println("\nEmployees over 40: ");
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i].getAge() > 40) {
                System.out.println(empArray[i]);
            }
        }
    }
}

class Employee {
    private String fullname;
    private String post;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String fullname, String post, String email, String phone, int salary, int age) {
        this.fullname = fullname;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "fullname: " + fullname + ", post: " + post + ", email: " + email + ", phone: " + phone + ", salary: " + salary + ", age: " + age + ".";
    }
}
