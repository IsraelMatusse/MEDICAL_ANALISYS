package com.personalprojects.MEDIC_ANALISYS.infrastructure.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class GenerateCodes {
    private static final int BARCODE_LENGTH = 12;
    private static final int SKU_LENGTH = 8;
    private static final int MIN_DIGIT = 0;
    private static final int MAX_DIGIT = 9;
    public static String generateBarcode() {
        StringBuilder barcodeBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < BARCODE_LENGTH; i++) {
            barcodeBuilder.append(random.nextInt(10));
        }
        return barcodeBuilder.toString();
    }
    public static String generateSKU() {
        StringBuilder skuBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < SKU_LENGTH; i++) {
            int digit = random.nextInt(MAX_DIGIT - MIN_DIGIT + 1) + MIN_DIGIT;
            skuBuilder.append(digit);
        }
        return skuBuilder.toString();
    }
    public static String generateStringCodes() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        int pin = sr.nextInt(9000000) + 1000000;
        return String.valueOf(pin);
    }

}
