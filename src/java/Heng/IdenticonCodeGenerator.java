/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Heng;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author hdr
 */
public class IdenticonCodeGenerator {

    static int getIdenticonCode(String codeString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md=MessageDigest.getInstance("MD5");
        byte[] hashedCode=md.digest(codeString.getBytes("UTF-8"));
        int code= ((hashedCode[0] & 0xFF) << 24) | ((hashedCode[4] & 0xFF) << 16) | ((hashedCode[8] & 0xFF) << 8) | (hashedCode[12] & 0xFF);
        return code;
    }
    
}
