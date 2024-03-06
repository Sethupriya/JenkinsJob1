package org.example.utils;

import java.util.Base64;

public final class DecodeUtils {

    /**
     * Private constructor to avoid external instantiation
     */
    private DecodeUtils() {}

    public static String getDecodedString(String encodedString) {
        return new String(Base64.getDecoder().decode(encodedString.getBytes()));
    }

}
