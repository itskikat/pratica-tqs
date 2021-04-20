package tqs;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class Book {

    private String title;
    private String author;
    private Date published;

    public Book(String title, String author, LocalDateTime published) {
        Instant instant = published.toInstant(ZoneOffset.UTC);
        Date date = Date.from(instant);
        this.title = title;
        this.author = author;
        this.published = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }
}
