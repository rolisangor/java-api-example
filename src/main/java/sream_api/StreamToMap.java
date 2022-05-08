package sream_api;
import data.Author;
import data.Book;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamToMap {

    public static void main(String[] args) {
        List<String> list = List.of("First", "Second", "Third", "Fourth", "Third", "First", "First");

        /*
        * Counting each word in list and create a map with key String as a word in list
        * and value how many times a word is repeated
        * */
        Map<String, Long> count = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(count);

        /*
        * First create new HashSet to remove duplicates from the list
        * after that create a map with key as word from the list and value length of this word
        * */
        Map<String, Integer> length = new HashSet<>(list).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(String::length)));
        System.out.println(length);


        /*
        * Convert List of Objects (Author) to a map
        * use method toMap to create key value
        * key is Author name and value is list of books
        * */
        Book road = new Book("Road");
        Book sky = new Book("Sky");
        Book wind = new Book("Wind");
        Book earth = new Book("Earth");

        Author henrik = new Author("Henrik", List.of(road, sky));
        Author mary = new Author("Mary", List.of(wind));
        Author patricia = new Author("Patricia", List.of(earth));

        List<Author> authors = List.of(henrik, mary, patricia);

        Map<String, List<Book>> groupAuthor = authors.stream().collect(Collectors.toMap(Author::getName, Author::getBooks));
        System.out.println(groupAuthor);
    }
}
