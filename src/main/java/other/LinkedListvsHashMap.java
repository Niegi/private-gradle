package other;

import java.util.*;
import java.lang.*;

public class LinkedListvsHashMap {
    public static void main (String[] args) {

        List<Book> list = new LinkedList<>();
        for(int n = 0; n < 200000; n++) {
            list.add(new Book());
        }

        System.out.println("List size: " + list.size());

        long begin = System.nanoTime();
        list.remove(list.size()-1);
        long end = System.nanoTime();
        System.out.println("Removing last element has taken: " + (end - begin) + " nanoseconds");

        begin = System.nanoTime();
        list.remove(0);
        end =  System.nanoTime();
        System.out.println("Removing first element has taken: " + (end - begin) + " nanoseconds");

        begin = System.nanoTime();
        list.add(0, new Book());
        end =  System.nanoTime();
        System.out.println("Adding element at the beginning of the collection has taken: " + (end - begin) + " nanoseconds");

        begin = System.nanoTime();
        list.add(new Book());
        end =  System.nanoTime();
        System.out.println("Adding element at the end of the collection has taken: " + (end - begin) + " nanoseconds");

        System.out.println("\n***************************************************************************************\n");

        Map<String, Book> map = new HashMap<>();
        for(int n = 0; n < 200000; n++) {
            String key = String.valueOf(n);
            map.put(key, new Book());
        }

        System.out.println("Map size is: " + map.size());

        String randomKey = String.valueOf(new Random().nextInt(200000));
        begin = System.nanoTime();
        map.get(randomKey);
        end = System.nanoTime();
        System.out.println("Searching for key " + randomKey + " in map has taken: " + (end - begin) + " nanoseconds");

        randomKey = String.valueOf(new Random().nextInt(200000));
        begin = System.nanoTime();
        map.remove(String.valueOf(new Random().nextInt(200000)));
        end =  System.nanoTime();
        System.out.println("Removing element with key " + randomKey + "  in map has taken: " + (end - begin) + " nanoseconds");

        begin = System.nanoTime();
        map.put(String.valueOf(map.size()), new Book());
        end =  System.nanoTime();
        System.out.println("Adding new element to map has taken: " + (end - begin) + " nanoseconds");
    }
}

class Book {
    private String author;
    private String title;

    public Book() {};

    public Book(String author, String title){
        this.author=author;
        this.title=title;
    }

    public int hashCode(){
        return author.length();
    }

    public boolean equals(Object o){
        Book e = (Book) o;
        return (author.equals(e.getAuthor()))&&
                (title.equals(e.getTitle()));
    }

    public String toString(){
        return "title: " + title + ", author: " + author;
    }

    public String getAuthor(){
        return author;
    }

    public String getTitle(){
        return title;
    }
}