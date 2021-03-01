package ua.nure.hospital.utils;

import org.apache.log4j.Logger;
import ua.nure.hospital.command.common.LoginCommand;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptPassword {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    public String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "1" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException(exception);
        }
    }

}
