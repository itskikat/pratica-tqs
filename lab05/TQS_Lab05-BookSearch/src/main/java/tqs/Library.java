package tqs;

import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private final List<Book> store = new ArrayList<>();

    public void addBook(final Book book){
        store.add(book);
    }

    public List<Book> findBooks(final Date from, final Date to){
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        end.roll(Calendar.YEAR, 1);

        return store.stream().filter(book -> {
            return from.before(book.getPublished()) && end.getTime().after(book.getPublished());
        }).sorted(Comparator.comparing(Book::getPublished).reversed()).collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(final String author_name) {
        List<Book> output = new ArrayList<>();
        for(Book b: store){
            if(b.getAuthor().equals(author_name)){
                output.add(b);
            }
        }
        return output;
    }

    public List<Book> findBooksByTitle(final String book_title) {
        List<Book> output = new ArrayList<>();
        for(Book b: store){
            if(b.getTitle().equals(book_title)){
                output.add(b);
            }
        }
        return output;
    }
}
