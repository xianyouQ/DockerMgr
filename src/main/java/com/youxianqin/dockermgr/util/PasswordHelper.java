package com.youxianqin.dockermgr.util;

import com.youxianqin.dockermgr.models.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private static String algorithmName = "md5";
    private static int hashIterations = 2;
    private static String defaultSalt = "youxian";

    public static void encryptPassword(User user) {
        String salt=randomNumberGenerator.nextBytes().toHex();
        String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(defaultSalt), hashIterations).toHex();
        user.setPassword(newPassword);
    }
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("youxianqin");
        user.setPassword("123456");
        encryptPassword(user);
        System.out.println(user.getPassword());
    }
}
