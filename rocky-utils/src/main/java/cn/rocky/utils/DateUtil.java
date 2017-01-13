package cn.rocky.utils;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Date util
 * Created by rocky on 17/1/13.
 */
public class DateUtil {
    private final static DateTimeFormatter COMMON_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 按照yyyy-MM-dd HH:mm:ss将mills对应的日期格式化
     * @param mills
     * @return
     */
    public static String format(long mills) {
        return COMMON_FORMATTER.print(mills);
    }

    /**
     * 按照pattern将mills对应的日期格式化
     * @param mills
     * @param pattern
     * @return
     */
    public static String format(long mills, String pattern) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        return formatter.print(mills);
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss将format生成对应日期的mills
     * @param format
     * @return
     */
    public static long parse(String format) {
        return COMMON_FORMATTER.parseDateTime(format).getMillis();
    }

    /**
     * 按照pattern将format生成对应日期的mills
     * @param format
     * @param pattern
     * @return
     */
    public static long parse(String format, String pattern) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        return formatter.parseDateTime(format).getMillis();
    }


}
