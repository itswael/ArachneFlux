package com.itswael;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {
    public static String toSha256(String inString){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String text = inString.toLowerCase();
            md.update(text.getBytes(StandardCharsets.US_ASCII));
            byte[] hash = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString().toUpperCase();
        }catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
