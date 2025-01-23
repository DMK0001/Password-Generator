package io.github.dmk0001.passgen.utils;

import java.security.SecureRandom;

public class Utils {

    public static int randomInt(int maxValue){
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(maxValue);
    }
}