package dto;

public class ReportView {
    private String burrowedDate;
    private int burrowedBy;
    private Double fine;
    private String itemType;
    private String ISBN;
    private String title;

    public String getBurrowedDate() {
        return burrowedDate;
    }

    public void setBurrowedDate(String burrowedDate) {
        this.burrowedDate = burrowedDate;
    }

    public int getBurrowedBy() {
        return burrowedBy;
    }

    public void setBurrowedBy(int burrowedBy) {
        this.burrowedBy = burrowedBy;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
