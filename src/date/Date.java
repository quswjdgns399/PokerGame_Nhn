package date;

public class Date {

    private int year;
    private int month;
    private int day;
    private DaysInWeek daysInWeek;

    public Date(int year, int month, int day, DaysInWeek daysInWeek) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.daysInWeek = daysInWeek;
    }

    public String toString() {
        return this.year + "-" + this.month + "-" + this.day + " : " + this.daysInWeek;
    }
}
