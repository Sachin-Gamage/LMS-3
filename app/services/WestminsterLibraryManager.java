package services;

import dto.*;
import io.ebean.Ebean;
import models.BookModel;
import models.DVDModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class WestminsterLibraryManager implements LibraryManager {


    @Override
    /**
     * Accept a book object as a param
     */
    public void addBook(Book book) {
        List<Book> books = getAllBooks();

        if(books.size() <=100){
            Ebean.save(mapBookModel(book));
        }else{
            throw  new Error("Out of storage");
        }

    }

    @Override
    public void addDvd(Dvd dvd) {
        List<Dvd> dvds = getAllDvds();

        if(dvds.size() <=50){
            Ebean.save(mapDvdModel(dvd));
        }else{
            throw  new Error("Out of storage");
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<BookModel> bookModels = Ebean.find(BookModel.class).findList();

        List<Book> books = new ArrayList<>();

        for (BookModel bookModel : bookModels) {
            Book book = getBookDTObyModel(bookModel);
            books.add(book);
        }

        return books;
    }

    @Override
    public List<Dvd> getAllDvds() {
        List<DVDModel> dvdModels = Ebean.find(DVDModel.class).findList();

        List<Dvd> dvds = new ArrayList<>();

        for (DVDModel dvdModel : dvdModels) {
            Dvd dvd = getDvdDTObyModel(dvdModel);
            dvds.add(dvd);
        }

        return dvds;
    }

    @Override
    public DeleteView deleteBook(String isbn) {

        Ebean.find(BookModel.class).where().eq("isbn",isbn).delete();

        List<Book> books = getAllBooks();

        int occupiedSpace = books.size();

        DeleteView deleteView = new DeleteView();

        deleteView.setItemType("Book");
        deleteView.setSpaceLeft(100 - occupiedSpace);

        return  deleteView;
    }

    @Override
    public DeleteView deleteDvd(String isbn) {

        Ebean.find(DVDModel.class).where().eq("isbn",isbn).delete();

        List<Dvd> Dvds = getAllDvds();

        int occupiedSpace = Dvds.size();

        DeleteView deleteView = new DeleteView();

        deleteView.setItemType("Dvd");
        deleteView.setSpaceLeft(50 - occupiedSpace);

        return  deleteView;
    }

    @Override
    public Book getBookByISBN (String Isbn){
        BookModel bookModels = Ebean.
                find(BookModel.class).
                where().
                eq("isbn",Isbn).
                findUnique();
        if(bookModels != null){
            return  getBookDTObyModel(bookModels);
        }else{

        }
        return null;
    }

    @Override
    public Dvd getDVDByISBN (String Isbn){
        DVDModel dvdModel = Ebean.find(DVDModel.class)
                            .where()
                            .eq("isbn",Isbn)
                            .findUnique();

        if(dvdModel != null){
            return  getDvdDTObyModel(dvdModel);
        }else{

        }
        return null;
    }

    @Override
    public String updateBook(String isbn,boolean isBurrow,int reader){
        Book bookObj = getBookByISBN(isbn);

        if(bookObj != null){
            if(isBurrow){
                if(bookObj.getCurrentReader() == 0 ){
                    bookObj.setCurrentReader(reader);
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Date date = new Date();
                    bookObj.setBorrowedDate(dateFormat.format(date));                Ebean.update(mapBookModel(bookObj));
                    return  "Burrow success";
                }else if(bookObj.getCurrentReader() != 0){
                    return "Book Already burrowed.";
                }
            }else{
                bookObj.setCurrentReader(0);
                bookObj.setBorrowedDate(null);
                Ebean.update(mapBookModel(bookObj));
                return  "Return success";
            }

        }else{
            throw new Error("Book not found");
        }

        return null;
    }

    @Override
    public String updateDvd(String isbn,boolean isBurrow,int reader){

        Dvd dvdObj = getDVDByISBN(isbn);

        if(dvdObj != null){
            if(isBurrow){
                if(dvdObj.getCurrentReader() == 0){
                    dvdObj.setCurrentReader(reader);
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Date date = new Date();
                    dvdObj.setBorrowedDate(dateFormat.format(date));
                    Ebean.update(mapDvdModel(dvdObj));
                    return  "Burrow Success";
                }
                else if(dvdObj.getCurrentReader() != 0){
                    return "Dvd Already burrowed.";
                }
            }else{
                dvdObj.setCurrentReader(0);
                dvdObj.setBorrowedDate(null);
                Ebean.update(mapDvdModel(dvdObj));
                return  "Return Success";
            }


        }else{
            throw  new Error("Dvd not found");
        }
        return  null;
    }


    private Book getBookDTObyModel(BookModel bookModel) {
        Book book = new Book();
        book.setIsbn(bookModel.getIsbn());
        book.setTitle(bookModel.getTitle());
        book.setSector(bookModel.getSector());
        book.setPublicationDate(bookModel.getPublicationDate());
        book.setBorrowedDate(bookModel.getBorrowedDate());
        book.setPublisher(bookModel.getPublisher());
        book.setNumberOfPages(bookModel.getTotalNumberOfPages());
        book.setCurrentReader(1);
        //book.setAuthors(bookModel.arrayToString());


        //TODO: write a method to get author list.

        return book;
    }

    private Dvd getDvdDTObyModel(DVDModel dvdModel) {
        Dvd dvd = new Dvd();
        dvd.setIsbn(dvdModel.getIsbn());
        dvd.setTitle(dvdModel.getTitle());
        dvd.setSector(dvdModel.getSector());
        dvd.setPublicationDate(dvdModel.getPublicationDate());
        dvd.setBorrowedDate(dvdModel.getBorrowedDate());
        dvd.setBorrowedTime(dvdModel.getBorrowedTime());
        dvd.setActors(stringToArray(dvdModel.getActors()));
        dvd.setLanguages(stringToArray(dvdModel.getLanguages()));
        dvd.setCurrentReader(dvd.getCurrentReader());
        dvd.setSubtitles(stringToArray(dvdModel.getSubtitles()));

        //TODO: write a method to get author list.

        return dvd;
    }

    public List<ReportView> generateReport(){
        List<Book> books= getAllBooks();
        List<Dvd> dvds = getAllDvds();
        List<ReportView> reportViews = new ArrayList<ReportView>();
        for (Book book:books) {
            ReportView reportView = mapReportView(book);
                reportViews.add(reportView);
        }

        for (Dvd dvd:dvds) {
            ReportView reportView = mapReportView(dvd);

                reportViews.add(reportView);

        }

        return  reportViews;
    }


    private BookModel mapBookModel(Book book){
        BookModel bookModel = new BookModel();

        bookModel.setIsbn(book.getIsbn());
        bookModel.setTitle(book.getTitle());
        bookModel.setSector(book.getSector());
        bookModel.setPublicationDate(book.getPublicationDate());
        bookModel.setBorrowedDate(book.getBorrowedDate());
        bookModel.setBorrowedTime(book.getBorrowedTime());
        bookModel.setPublisher(book.getPublisher());
        bookModel.setTotalNumberOfPages(book.getNumberOfPages());
        bookModel.setCurrentReader(book.getCurrentReader());
        bookModel.setAuthors(arrayToString(book.getAuthors()));

        return  bookModel;
    }

    private DVDModel mapDvdModel(Dvd dvd){
        DVDModel dvdModel = new DVDModel();

        dvdModel.setIsbn(dvd.getIsbn());
        dvdModel.setTitle(dvd.getTitle());
        dvdModel.setSector(dvd.getSector());
        dvdModel.setPublicationDate(dvd.getPublicationDate());
        dvdModel.setBorrowedDate(dvd.getBorrowedDate());
        dvdModel.setBorrowedTime(dvd.getBorrowedTime());
        dvdModel.setActors(arrayToString(dvd.getActors()));
        dvdModel.setLanguages(arrayToString(dvd.getLanguages()));
        dvdModel.setCurrentReader(dvd.getCurrentReader());
        dvdModel.setSubtitles(arrayToString(dvd.getSubtitles()));

        return  dvdModel;
    }

    private String arrayToString(String[] arr){
        String arrString = null;
        for (int i = 0; i <arr.length ; i++) {

            if(i == 0){
                arrString = arr[i];
            }else if(i != arr.length -1){
                arrString = "," + arr[i];
            }else{
                arrString = arr[i];
            }
        }
        return arrString;
    }

    private String[] stringToArray(String stringObj){
        return  stringObj.split(",");
    }



    private ReportView mapReportView(LibraryItem libraryItem){
        ReportView reportView = new ReportView();

        reportView.setISBN(libraryItem.getIsbn());
        reportView.setTitle(libraryItem.getTitle());
        reportView.setBurrowedBy(libraryItem.getCurrentReader());
        reportView.setBurrowedDate(libraryItem.getBorrowedDate());

        return  reportView;
    }

    private LocalDateTime stringToDate(String date){
        return LocalDateTime.parse(date);

    }

}
