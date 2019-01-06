package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.*;
import models.BookModel;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.LibraryManager;
import services.WestminsterLibraryManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    LibraryManager libraryManager = new WestminsterLibraryManager();

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {

        return ok(Json.toJson("Welcome to lms"));
    }

    public Result addBook() {

        JsonNode body = request().body().asJson();
        Book book = new Book();
        if(body !=null){
            book = mapBookObj(body);
        }else{
            System.out.println("");
        }
        libraryManager.addBook(book);

        return ok("Adding new book successful");
    }

    public Result addDvd(){
        JsonNode body = request().body().asJson();
        Dvd dvd = new Dvd();
        if(body !=null){
            dvd = mapDvdObj(body);
        }else{
            System.out.println("");
        }
        libraryManager.addDvd(dvd);

        return ok("Adding new dvd successful");
    }

    public Result  books() {

        List<Book> books = libraryManager.getAllBooks();

        return ok(Json.toJson(books));
    }

    public Result  dvds() {

        List<Dvd> dvds = libraryManager.getAllDvds();

        return ok(Json.toJson(dvds));
    }

    public Result deleteBook(){
        String isbn  = request().getQueryString("isbn");


        DeleteView deleteView = libraryManager.deleteBook(isbn);

        return ok(Json.toJson(deleteView));
    }

    public Result deleteDvd(){
        String isbn  = request().getQueryString("isbn");


        libraryManager.deleteDvd(isbn);

        return ok("dvd deleted");
    }

    public Result getBookByISBN(){
        String isbn = request().getQueryString("isbn");
        Book book;
        if(isbn != null) {
            book = libraryManager.getBookByISBN(isbn);
            return ok(Json.toJson(book));
        }else{
            return ok(Json.toJson("Book Not found"));
        }

    }
    public Result getDVDByISBN(){
        String isbn = request().getQueryString("isbn");
        Dvd dvd;
        if(isbn != null) {
            dvd = libraryManager.getDVDByISBN(isbn);
            return ok(Json.toJson(dvd));
        }else{
            return ok(Json.toJson("Dvd Not found"));
        }

    }

    public Result getAllItems(){
        List<Book> books = libraryManager.getAllBooks();
        List<Dvd> dvds = libraryManager.getAllDvds();

        List<LibraryItem> libraryItems = new ArrayList<LibraryItem>();

        for (Book book : books) {
            book.setType("book");
            libraryItems.add(book);
        }

        for (Dvd dvd : dvds) {
            dvd.setType("dvd");
            libraryItems.add(dvd);
        }

        return ok(Json.toJson(libraryItems));



    }

    public Result burrowBook(){
        JsonNode body = request().body().asJson();

        int reader = body.get("reader").asInt();
        String isbn = body.get("isbn").asText();

        String results = libraryManager.updateBook(isbn,true,reader);

        return ok(Json.toJson(results));

    }

    public Result returnBook(){
        JsonNode body = request().body().asJson();

        int reader = body.get("reader").asInt();
        String isbn = body.get("isbn").asText();


        String results = libraryManager.updateBook(isbn,false,reader);

        return ok(Json.toJson(results));

    }

    public Result burrowDvd(){
        JsonNode body = request().body().asJson();
        int reader = body.get("reader").asInt();
        String isbn = body.get("isbn").asText();

        String results = libraryManager.updateDvd(isbn,true,reader);

        return ok(Json.toJson(results));

    }

    public Result returnDvd(){
        JsonNode body = request().body().asJson();
        int reader = body.get("reader").asInt();
        String isbn = body.get("isbn").asText();

        String results = libraryManager.updateDvd(isbn,false,reader);

        return ok(Json.toJson(results));

    }

    public Result generateReport(){
        List<ReportView> reportViews = libraryManager.generateReport();

        return ok(Json.toJson(reportViews));
    }

    private Book mapBookObj(JsonNode body){
        Book book = new Book();
        if(
            body.get("ISBN") !=null &&
            body.get("title") != null &&
            body.get("sector") != null &&
            body.get("pubDate") != null &&
            body.get("publisher") != null &&
            body.get("noOfPages") != null &&
            body.get("authors") != null
        ){
            book.setIsbn(body.get("ISBN").asText());
            book.setTitle(body.get("title").asText());
            book.setSector(body.get("sector").asText());
            book.setPublicationDate(body.get("pubDate").asText());
            book.setPublisher(body.get("publisher").asText());
            book.setNumberOfPages(body.get("noOfPages").asInt());
            String[] authors = body.get("authors").asText().split(",");
            book.setAuthors(authors);


            if(body.get("borrowedDate") != null){
                book.setBorrowedDate(body.get("borrowedDate").asText());
            }

            if(body.get("borrowedTime") != null){
                book.setBorrowedTime(body.get("borrowedTime").asText());
            }

            if(body.get("currentReader") != null){
                book.setCurrentReader(body.get("borrowedTime").asInt());
            }
            return book;


        }else{
            return null;
        }
    }

    private Dvd mapDvdObj(JsonNode body){
        Dvd dvd = new Dvd();
        if(
            body.get("ISBN") !=null &&
            body.get("title") != null &&
            body.get("sector") != null &&
            body.get("pubDate") != null &&
            body.get("producer") != null &&
            body.get("languagesAvailable") != null &&
            body.get("subsAvailablae") != null &&
            body.get("actors") != null
        ){
            dvd.setIsbn(body.get("ISBN").asText());
            dvd.setTitle(body.get("title").asText());
            dvd.setSector(body.get("sector").asText());
            dvd.setPublicationDate(body.get("pubDate").asText());
            dvd.setActors(body.get("actors").asText().split(","));
            dvd.setLanguages(body.get("languagesAvailable").asText().split(","));
            dvd.setSubtitles(body.get("subsAvailablae").asText().split(","));
            dvd.setProducer(body.get("producer").asText());

            if(body.get("borrowedDate") != null){
                dvd.setBorrowedDate(body.get("borrowedDate").asText());
            }

            if(body.get("borrowedTime") != null){
                dvd.setBorrowedTime(body.get("borrowedTime").asText());
            }

            if(body.get("currentReader") != null){
                dvd.setCurrentReader(body.get("borrowedTime").asInt());
            }
            return dvd;


        }else{
            return null;
        }
    }



}
