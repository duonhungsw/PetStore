/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class RandomCoupon {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 10;
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

    public static List<String> generateMultipleRandomStrings(int count) {
        List<String> randomStrings = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomStrings.add(generateRandomString());
        }
        return randomStrings;
    }

    public static void main(String[] args) {
        // Số lần cần random
        int count = 5;  // Thay đổi số lượng tùy ý
        List<String> randomStrings = generateMultipleRandomStrings(count);

        // In ra các chuỗi ngẫu nhiên
        for (String str : randomStrings) {
            System.out.println("Chuỗi ngẫu nhiên: " + str);
        }
    }
}
