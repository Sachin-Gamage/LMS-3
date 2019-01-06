package dto;

public class DateTime {
    private int day;
    private int month;
    private int year;
    private int hours;
    private int mins;

    public DateTime(int day, int month, int year, int hours, int mins) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.mins = mins;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMins() {
        return mins;
    }

    public void setMins(int mins) {
        this.mins = mins;
    }
}
