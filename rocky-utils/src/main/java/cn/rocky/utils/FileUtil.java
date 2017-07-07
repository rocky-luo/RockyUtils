package cn.rocky.utils;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.io.*;

/**
 * Created by rocky on 17/7/7.
 */
public class FileUtil {
    /**
     * read file as bytes
     *
     * @param path
     * @return
     */
    public static byte[] bytes(String path) throws IOException {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(path));
        File file = new File(path);
        FileInputStream fileInputStream = null;
        int bytesLen = 1024;
        byte[] bytes = new byte[bytesLen];
        int len = 0;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            Preconditions.checkArgument(file.length() <= Integer.MAX_VALUE, "file is too large!");
            byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
            while (-1 != (len = fileInputStream.read(bytes, 0, bytesLen))) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
                fileInputStream = null;
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
                byteArrayOutputStream = null;
            }
        }
    }

    /**
     * bytes 2 file
     *
     * @param path
     * @param bytes
     */
    public static void file(String path, byte[] bytes) throws IOException {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(path));
        File file = new File(path);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
                fileOutputStream = null;
            }
        }
    }
}
