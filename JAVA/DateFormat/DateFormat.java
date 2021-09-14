import java.util.*;

public class DateFormat {

    public static void main(String[] args){

        Date now = new Date();

        System.out.println(now);
        Date d1 = new Date(1_00_00_00_000);
        System.out.println(d1);

        Calendar c = Calendar.getInstance();
        c.setTime(d1);

        // set date to 10 09 1999
        c.set(1999,9,10);
        // change date to 14
        c.set(Calendar.DATE,14);
        // add 1 month
        c.add(Calendar.MONTH,1);
        Date d2 = c.getTime();
        System.out.println(d2);
        // printing the year
        System.out.println(c.get(Calendar.YEAR));

        // maximum number of weeks in a year
        System.out.println(c.getMaximum(Calendar.WEEK_OF_YEAR));

        // actual maximum number of weeks in a year
        System.out.println(c.getActualMaximum(Calendar.WEEK_OF_YEAR));

        // minimum number of weeks in a year
        System.out.println(c.getMinimum(Calendar.WEEK_OF_YEAR));

        System.out.println(c.getTime());

        // Cloning the calendar
        Calendar c2 = (Calendar) c.clone();

        // clearing the calender
        c.clear();

        System.out.println(c.getTime());
        System.out.println(c2.getTime());
    }

}
