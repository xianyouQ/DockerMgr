package com.youxianqin.dockermgr.util;

import com.youxianqin.dockermgr.models.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private int hashIterations = 2;
    private String defaultSalt = "youxian";

    public void encryptPassword(User user) {
        String salt=randomNumberGenerator.nextBytes().toHex();
        String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getUsername()+defaultSalt), hashIterations).toHex();
        user.setPassword(newPassword);
    }
    public static void main(String[] args) {
        PasswordHelper passwordHelper = new PasswordHelper();
        User user = new User();
        user.setUsername("youxianqin");
        user.setPassword("youXIAN17");
        passwordHelper.encryptPassword(user);
        System.out.println(user.getPassword());
    }
}
