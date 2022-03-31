package UitlTest;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zxx
 * @date 2022/03/29 14:26
 **/
public class TestDate {

    public static void main(String[] args) {
        Date nowDate = new Date();
        System.out.println(nowDate);

        System.out.println(addMonth(nowDate,-6));

    }

    public static Date addMonth(Date date, int imonth) {
        Calendar cd = Calendar.getInstance();

        cd.setTime(date);

        cd.add(Calendar.MONTH, imonth);

        return cd.getTime();
    }
}
