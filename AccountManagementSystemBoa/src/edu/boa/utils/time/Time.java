package edu.boa.utils.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 * The class represents time in UTC 24 hr format
 * @author sidharth.mishra
 * Created by sidmishraw on 11/1/16.
 * * Value type - Immutable - get
 */
public class Time implements Serializable, Comparable<Time> {

    private static final long serialVersionUID  = 1L;

    private Integer day                         = null;
    private Integer month                       = null;
    private Integer year                        = null;
    private Integer hour                        = null;
    private Integer min                         = null;

    /**
     *
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Time o) {

        if ( null == o ) throw new NullPointerException("Specifed object has null value.");

        if ( o instanceof Time ) {

            if (this.equals(o)) return 0;
            else if ( this.year > ((Time) o).getYear() ) return 1;
            else if ( this.year == ((Time) o).getYear()
                    && this.month == ((Time) o).getMonth() ) return 1;
            else if ( this.year == ((Time) o).getYear()
                    && this.month == ((Time) o).getMonth()
                    && this.day > ((Time) o).getDay() ) return 1;
            else if ( this.year == ((Time) o).getYear()
                    && this.month == ((Time) o).getMonth()
                    && this.day == ((Time) o).getDay()
                    && this.hour > ((Time) o).getHour() ) return 1;
            else if ( this.year == ((Time) o).getYear()
                    && this.month == ((Time) o).getMonth()
                    && this.day == ((Time) o).getDay()
                    && this.hour == ((Time) o).getHour()
                    && this.min > ((Time) o).getMin() ) return 1;
            else return -1;
        } else  throw new ClassCastException("The specified object cannot" +
                " be compared to Time type since it's not of Time type.");
    }

    /**
     * @param day
     * @param month
     * @param year
     * @param hour
     * @param min
     */
    public Time(Integer day, Integer month, Integer year, Integer hour, Integer min) {
        this.day        = day;
        this.month      = month;
        this.year       = year;
        this.hour       = hour;
        this.min        = min;
    }

    /**
     * Takes the time in ms - long format
     * Use the Calendar class to get the long time and use it to instantiate the Time object
     * @param timeInMilliSeconds
     */
    public Time(Long timeInMilliSeconds) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(timeInMilliSeconds);

        this.year       = calendar.get(Calendar.YEAR);
        this.month      = calendar.get(Calendar.MONTH);
        this.day        = calendar.get(Calendar.DATE);
        this.hour       = calendar.get(Calendar.HOUR_OF_DAY);
        this.min        = calendar.get(Calendar.MINUTE);
    }

    public Integer getDay() {
        return day;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getHour() {
        return hour;
    }

    public Integer getMin() {
        return min;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Time)) return false;

        Time time = (Time) o;

        return Objects.equals(getDay(), time.getDay()) &&
                Objects.equals(getMonth(), time.getMonth()) &&
                Objects.equals(getYear(), time.getYear()) &&
                Objects.equals(getHour(), time.getHour()) &&
                Objects.equals(getMin(), time.getMin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDay(), getMonth(), getYear(), getHour(), getMin());
    }

    @Override
    public String toString() {
        return "Time{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", hour=" + hour +
                ", min=" + min +
                '}';
    }
}
