package services;

import dto.*;

import java.util.List;

public interface LibraryManager {

    default void addBook(Book book) {
    }
    void addDvd(Dvd dvd);

    DeleteView deleteBook(String isbn);
    DeleteView deleteDvd(String isbn);

    List<Book> getAllBooks();
    List<Dvd> getAllDvds();


    Book getBookByISBN(String Isbn);
    Dvd getDVDByISBN(String Isbn);

    String updateBook(String isbn,boolean isBurrow,int reader);
    String updateDvd(String isbn,boolean isBurrow,  int reader);

    List<ReportView> generateReport();
}
