package cn.rocky.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Created by rocky on 17/8/14.
 */
public class AesUtil {

    //算法名称
    private static final String KEY_ALGORITHM = "AES";
    //加密算法/工作模式/填充方式
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    private static final String UTF8 = "utf-8";

    public static String encrypt(String content, String password) {
        try {
            if (password == null) {
                return null;
            }
            // 判断Key是否为16位
            if (password.length() != 16) {
                return null;
            }
            byte[] raw = password.getBytes(UTF8);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);//"算法/模式/补码方式"
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(content.getBytes(UTF8));
            return Base64.getUrlEncoder().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String decrypt(String content, String password) {
        try {
            // 判断Key是否正确
            if (password == null) {
                return null;
            }
            // 判断Key是否为16位
            if (password.length() != 16) {
                return null;
            }
            byte[] raw = password.getBytes(UTF8);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = Base64.getUrlDecoder().decode(content);//先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, UTF8);
            return originalString;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
