package generator;

import java.util.Scanner;

public class PasswordGenerator {
    public static String generatePassword(){
        System.out.println("Input the length of a password:");
        int passwordLength = new Scanner(System.in).nextInt();
        StringBuffer sb = new StringBuffer(passwordLength);
        for (int i = 0; i < passwordLength; i++) {
            sb.append(RandomService.getRandomSymbol());
        }
       return sb.toString();
    }
}
