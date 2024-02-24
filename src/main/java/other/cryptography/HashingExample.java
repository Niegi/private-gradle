package other.cryptography;

import java.security.MessageDigest;
import java.util.Base64;

public class HashingExample {

  public static void main(String[] args) throws Exception {
    String plaintext = "Data to be hashed";

    // Generate hash value
    byte[] hashValue = hash(plaintext);
    System.out.println("Hash Value: " + Base64.getEncoder().encodeToString(hashValue));
  }

  public static byte[] hash(String plaintext) throws Exception {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    return digest.digest(plaintext.getBytes());
  }
}