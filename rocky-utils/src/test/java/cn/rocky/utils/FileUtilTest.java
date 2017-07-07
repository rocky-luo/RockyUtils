package cn.rocky.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by rocky on 17/7/7.
 */
public class FileUtilTest {
    @Test
    public void bytes() throws Exception {
        byte[] bytes = FileUtil.bytes("/Users/rocky/node_modules.zip");
        Assert.assertTrue(bytes.length > 0);
    }

    @Test
    public void file() throws IOException {
        String f = "/Users/rocky/node_modules.zip";
        byte[] bytes = FileUtil.bytes(f);
        FileUtil.file("/Users/rocky/a.zip", bytes);
    }

}