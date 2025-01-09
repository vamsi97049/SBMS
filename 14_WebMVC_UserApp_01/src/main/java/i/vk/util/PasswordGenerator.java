package i.vk.util;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class PasswordGenerator {

    private static final Random RANDOM = new Random();

    public String generatePassword(String email, String name) {
        String namePart = name.length() > 1 ? name.substring(0, 5) : name;
        String emailPart = email.length() > 3 ? email.substring(0, 4) : email;
        String randomDigits = generateRandomDigits(3);
        String basePassword = namePart + emailPart + randomDigits;
        return shufflePassword(basePassword);
    }

    private String generateRandomDigits(int count) {
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < count; i++) {
            digits.append(RANDOM.nextInt(10));
        }
        return digits.toString();
    }

    

    private String shufflePassword(String password) {
        char[] chars = password.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
