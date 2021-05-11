package util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    //    public static final String dateTimePattern = "uuuu-MM-dd'T'HH:mmXXXXX";
    //
    //    private static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
    //        .ofPattern(dateTimePattern);
    //
    //    public static ZonedDateTime getDateFromString(String dateStr) {
    //
    //        ZonedDateTime date = ZonedDateTime.parse(dateStr, DATE_TIME_FORMATTER);
    //        return date;
    //
    //    }
    public static final String dateTimePattern = "uuuu-MM-dd'T'HH:mm:ss.SSSXXXXX";

    private static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
        .ofPattern(dateTimePattern);

    public static ZonedDateTime getDateFromString(String dateStr) {

        ZonedDateTime date = ZonedDateTime.parse(dateStr, DATE_TIME_FORMATTER);
        return date;

    }
    public static String getFormattedDateString(ZonedDateTime date) {

        return date.format(DateTimeFormatter.ofPattern("MMM. dd, uuuu"));

    }
}
