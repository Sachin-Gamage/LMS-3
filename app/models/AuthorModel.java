package models;

import io.ebean.Model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
public class AuthorModel extends Model {

    @Id
    @Column(name = "isbn")
    private int isbn;

    @Column(name = "name")
    private String name;

    @ManyToMany
    private List<BookModel> books;

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int id) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
