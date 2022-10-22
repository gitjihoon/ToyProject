package toyproject.bbank.settings;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class DateSetting {

    public static String AddDate(String strDate, int year, int month, int day) {

        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();

        Date dt = null;
        try {
            dt = dtFormat.parse(strDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        cal.setTime(dt);

        cal.add(Calendar.YEAR,  year);
        cal.add(Calendar.MONTH, month);
        cal.add(Calendar.DATE,  day);

        return dtFormat.format(cal.getTime());
    }

}
