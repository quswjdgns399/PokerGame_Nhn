package date;

public enum DaysInWeek {
    MON("Monday"),
    TUE("Tuesday"),
    WEN("Wendsday"),
    THU("Thursdsy"),
    FRI("Friday"),
    SAT("Saterday"),
    SUN("Sunday");

    public final String dayName;

    DaysInWeek(String dayName) {  //public으로 생성하면 안됨.
        this.dayName = dayName;
    }

    public String toString() {
        return this.dayName;
    }

}
