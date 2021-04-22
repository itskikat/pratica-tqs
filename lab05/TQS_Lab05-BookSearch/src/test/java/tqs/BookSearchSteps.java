package tqs;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookSearchSteps {

    Library library = new Library();
    List<Book> result = new ArrayList<>();

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDateTime iso8601Date(String year, String month, String day){
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),0, 0);
    }

    @Given("a book with the title {string}, written by {string}, published in {iso8601Date}")
    public void addNewBook(final String title, final String author, final LocalDateTime published){
        Book book = new Book(title, author, published);
        library.addBook(book);
    }

    @When("the customer searches for books published between {int} and {int}")
    public void setSearchParameters(final int from, final int to){
        // month - day - hr - min
        LocalDateTime ldt_from = LocalDateTime.of(from, 1, 1, 0, 0);
        Date newfrom = Date.from(ldt_from.atZone(ZoneId.systemDefault()).toInstant());
        LocalDateTime ldt_to = LocalDateTime.of(to, 12, 31, 0, 0);
        Date newto = Date.from(ldt_to.atZone(ZoneId.systemDefault()).toInstant());

        result = library.findBooks(newfrom, newto);
    }

    @Then("{int} books should have been found")
    public void verifyAmountOfBooksFound(final int booksFound){
        assertEquals(result.size(), booksFound);
    }

    @And("Book {int} should have the title {string}")
    public void verifyBookAtPosition(final int position, final String title){
        assertEquals(result.get(position-1).getTitle(), title);
    }


    @When("the customer searches for books written by {string}")
    public void setSearchParamAuthorName(final String author_name){
        result = library.findBooksByAuthor(author_name);
    }


    @When("the customer searches for books with the title {string}")
    public void setSearchParamBookTitle(final String book_title){
        result = library.findBooksByTitle(book_title);
    }

    @And("Book {int} should have been written by {string}")
    public void verufyBookAtPositionAuthor(final int position, final String author){
        assertEquals(result.get(position-1).getAuthor(), author);
    }

}
