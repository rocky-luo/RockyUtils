package cn.rocky.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rocky on 17/8/14.
 */
public class AesUtilTest {
    @Test
    public void test(){
        String hello = "hello world";
        String key = "Bar12345Bar12345";
        String ch = AesUtil.encrypt(hello, key);
        System.out.println(ch);
        Assert.assertEquals(hello, AesUtil.decrypt(ch, key));

    }
}
