import java.util.*;

public class VigenereCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Vigenère Cipher Encryption/Decryption Tool ---");
        System.out.print("Enter plaintext: ");
        String text = sc.nextLine();
        System.out.print("Enter keyword: ");
        String key = sc.nextLine();

        String encrypted = encrypt(text, key);
        System.out.println("\n[+] Encrypted: " + encrypted);
        
        String decrypted = decrypt(encrypted, key);
        System.out.println("[+] Decrypted: " + decrypted);
    }

    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase();
        int keyIndex = 0;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                int shift = key.charAt(keyIndex % key.length()) - 'A';
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + shift) % 26 + base));
                keyIndex++;
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase();
        int keyIndex = 0;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                int shift = key.charAt(keyIndex % key.length()) - 'A';
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base - shift + 26) % 26 + base));
                keyIndex++;
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
