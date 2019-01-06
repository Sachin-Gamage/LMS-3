package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class BookModel {

    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "sector")
    private String sector;

    @Column(name = "publicationDate")
    private String publicationDate;

    @Column(name = "borrowedDate")
    private String borrowedDate;

    @Column(name = "borrowedTime")
    private String borrowedTime;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "totalNumberOfPages")
    private int totalNumberOfPages;

    @Column(name = "currentReader")
    private int currentReader;

    @Column(name="author")
    private String authors;

//    @ManyToMany(mappedBy = "books")
//    private List<AuthorModel> authors;



    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String id) {
        this.isbn = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getBorrowedTime() {
        return borrowedTime;
    }

    public void setBorrowedTime(String borrowedTime) {
        this.borrowedTime = borrowedTime;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getTotalNumberOfPages() {
        return totalNumberOfPages;
    }

    public void setTotalNumberOfPages(int totalNumberOfPages) {
        this.totalNumberOfPages = totalNumberOfPages;
    }

    public int getCurrentReader() {
        return currentReader;
    }

    public void setCurrentReader(int currentReader) {
        this.currentReader = currentReader;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
}
