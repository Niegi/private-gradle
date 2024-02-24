package other.cryptography;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionExample {

  public static void main(String[] args) throws Exception {
    String plaintext = "Sensitive data to be encrypted";
    String secretKey = "YourSecretKey";

    // Encrypt data
    byte[] encryptedData = encrypt(plaintext, secretKey);
    System.out.println("Encrypted Data: " + Base64.getEncoder().encodeToString(encryptedData));

    // Decrypt data
    String decryptedData = decrypt(encryptedData, secretKey);
    System.out.println("Decrypted Data: " + decryptedData);
  }

  public static byte[] encrypt(String plaintext, String secretKey) throws Exception {
    SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, key);
    return cipher.doFinal(plaintext.getBytes());
  }

  public static String decrypt(byte[] ciphertext, String secretKey) throws Exception {
    SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, key);
    return new String(cipher.doFinal(ciphertext));
  }
}