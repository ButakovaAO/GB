/**
 * Java Core. Homework 4
 * 
 * @author Butakova A.O.
 * 14.12.2021
 */

import java.util.*;

public class HomeWork4 {
    public static void main(String[] args){
        List<String> words = Arrays.asList(
                "apple", "pineapple", "grapefruit", "grapefruit", "banana", "grapefruit", "banana", "grapefruit", "pineapple", "pineapple",
                "banana", "grapefruit", "apple", "pineapple", "grapefruit", "pineapple", "grapefruit", "apple", "pineapple", "apple"
        );

        Set<String> unique = new HashSet<String>(words);

        System.out.println("Задание 1.");
        System.out.println();
        System.out.println("Массив данных :");
        System.out.println(words.toString());
        System.out.println();
        System.out.println("Уникальные слова :");
        System.out.println(unique.toString());
        System.out.println();
        System.out.println("Частота появления слов :");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
    
        System.out.println();
        System.out.println("Задание 2.");
        System.out.println();
        System.out.println("Создаем справочник");
        Phonebook phonebook = new Phonebook();
        System.out.println();

        System.out.println("Добавление записи");
        phonebook.add("Nabokov", "89992224455");
        phonebook.add("Nabokov", "89993336655");
        phonebook.add("Nabokov", "89992229955");
        phonebook.add("Tolstoy", "89994447788");
        phonebook.add("Chekhov", "89996664455");
        System.out.println();

        System.out.println("Поиск номера по фамилии");
        System.out.println("Nabokov");
        System.out.println(phonebook.get("Nabokov"));
        System.out.println("Chekhov");
        System.out.println(phonebook.get("Chekhov"));
        System.out.println("Tolstoy");
        System.out.println(phonebook.get("Tolstoy"));
        System.out.println();

        System.out.println("Не удается найти строку");
        System.out.println("Shakespeare");
        System.out.println(phonebook.get("Shakespeare"));
        System.out.println();

        System.out.println("Добавление существующего номера");
        phonebook.add("Nabokov", "89992224455");
        System.out.println("Nabokov");
        System.out.println(phonebook.get("Nabokov"));
    }

    public static class Phonebook {

        private HashMap<String, List<String>> book;

        public Phonebook(){
            this.book = new HashMap<>();
        }

        public void add(String surname, String number){
            if(book.containsKey(surname)){
                List<String> numbers = book.get(surname);
                if(!numbers.contains(number)){
                    numbers.add(number);
                    System.out.println(String.format("Номер %s добавлен для фамилии %s", number, surname));
                } else {
                    System.out.println(String.format("Дублирование номера %s для фамилии %s", number, surname));
                }
            } else {
                book.put(surname, new ArrayList<>(Arrays.asList(number)));
                System.out.println(String.format("Номер %s добавлен для фамилии %s", number, surname));
            }
        }

        public List<String> get(String surname){
            if(book.containsKey(surname)){
                return book.get(surname);
            } else {
                System.out.println(String.format("В справочнике отсутствуют данные для фамилии %s", surname));
                return new ArrayList<>();
            }
        }
    }
}
