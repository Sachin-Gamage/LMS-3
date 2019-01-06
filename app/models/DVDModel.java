package models;

import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name = "dvds")
public class DVDModel extends Model {

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

    @Column(name = "languages")
    private String languages;

    @Column(name = "subtitles")
    private String subtitles;

    @Column(name = "producer")
    private String producer;

    @Column(name = "actors")
    private String actors;

    @Column(name = "currentReader")
    private int currentReader;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
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

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(String subtitles) {
        this.subtitles = subtitles;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getCurrentReader() {
        return currentReader;
    }

    public void setCurrentReader(int currentReader) {
        this.currentReader = currentReader;
    }
}
