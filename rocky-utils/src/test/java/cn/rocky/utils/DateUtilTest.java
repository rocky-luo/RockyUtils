package cn.rocky.utils;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by rocky on 17/1/13.
 */
public class DateUtilTest {
    @Test
    public void format() throws Exception {
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sdfFormat = sdf.format(nowDate);
        String utilFormat = DateUtil.format(nowDate.getTime());
        Assert.assertEquals(null, sdfFormat, utilFormat);
    }

    @Test
    public void format1() throws Exception {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String sdfFormat = sdf.format(nowDate);
        String utilFormat = DateUtil.format(nowDate.getTime(), pattern);
        Assert.assertEquals(null, sdfFormat, utilFormat);
    }

    @Test
    public void parse() throws Exception {
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(nowDate);
        Assert.assertEquals(null, sdf.parse(format).getTime(), DateUtil.parse(format));
    }

    @Test
    public void parse1() throws Exception {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(nowDate);
        Assert.assertEquals(null, sdf.parse(format).getTime(), DateUtil.parse(format, pattern));
    }

}