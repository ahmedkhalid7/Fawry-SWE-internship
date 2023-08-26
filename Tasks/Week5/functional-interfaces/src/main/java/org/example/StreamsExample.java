package org.example;

import java.util.List;
import java.util.function.*;

public class StreamsExample {
    public static void main(final String[] args) {

        List<Author> authors = Library.getAuthors();
        
        banner("Authors information");
        // TODO With functional interfaces declared
        Consumer<Author> authorPrinterConsumer = System.out::println;
        authors
            .stream()
            .forEach(authorPrinterConsumer);

        // TODO With functional interfaces used directly
        authors
            .stream()
            .forEach(System.out::println);

        banner("Active authors");
        // TODO With functional interfaces declared
        Predicate<Author> activeAuthorPredicate = author -> author.active;
        authors
                .stream()
                .filter(activeAuthorPredicate)
                .forEach(authorPrinterConsumer);

        // TODO With functional interfaces used directly
        authors
                .stream()
                .filter(author -> author.active)
                .forEach(System.out::println);

        banner("Active books for all authors"); // Published books
        // TODO With functional interfaces declared
        Predicate<Book> bookPublishedPredicate = book -> book.published;
        Consumer<Book> bookPrinterConsumer = System.out::println;
        authors
                .stream()
                .flatMap(author -> author.books.stream()).filter(bookPublishedPredicate)
                .forEach(bookPrinterConsumer);

        // TODO With functional interfaces used directly
        authors
                .stream()
                .flatMap(author -> author.books.stream()).filter(book -> book.published)
                .forEach(System.out::println);

        banner("Average price for all books in the library");
        // TODO With functional interfaces declared
        ToDoubleFunction<Book> bookToDoubleFunction = book -> (double) book.price;
        System.out.println(authors
                .stream()
                .flatMap(author -> author.books.stream())
                .mapToDouble(bookToDoubleFunction).average());

        // TODO With functional interfaces used directly
        System.out.println(authors
                .stream()
                .flatMap(author -> author.books.stream())
                .mapToDouble(book -> book.price)
                .average());

        banner("Active authors that have at least one published book");
        // TODO With functional interfaces declared
        authors.stream()
                .filter(activeAuthorPredicate)
                .filter(author -> author.books.stream().anyMatch(bookPublishedPredicate))
                .forEach(System.out::println);

        // TODO With functional interfaces used directly
        authors
                .stream()
                .filter(author -> author.active)
                .filter(author -> author.books.stream().anyMatch(book -> book.published))
                .forEach(System.out::println);
    }

    private static void banner(final String m) {
        System.out.println("\n#### " + m + " ####");
    }
}


