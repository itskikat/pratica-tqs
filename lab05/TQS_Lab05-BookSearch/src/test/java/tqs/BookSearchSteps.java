package tqs;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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

    @Given("(a|another) book with the title {string}, written by {string}, published in {iso8601Date}")
    public void addNewBook(final String title, final String author, final LocalDateTime published){
        Book book = new Book(title, author, published);
        library.addBook(book);
    }

    @When("the customer searches for books published between {int} and {int}")
    public void setSearchParameters(final LocalDateTime from, final LocalDateTime to){
        Instant oldfrom = from.toInstant(ZoneOffset.UTC);
        Date newfrom = Date.from(oldfrom);
        Instant oldto = to.toInstant(ZoneOffset.UTC);
        Date newto = Date.from(oldto);

        result = library.findBooks(newfrom, newto);
    }

    @Then("{int} books should have been found")
    public void verifyAmountOfBooksFound(final int booksFound){
        assertEquals(result.size(), booksFound);
    }

    @And("Book {int} should have the tile {string}")
    public void verifyBookAtPosition(final int position, final String title){
        assertEquals(result.get(position-1).getTitle(), title);
    }

}
