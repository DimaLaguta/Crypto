package encryptionalgorithms.algorithms.util;

public interface Cipher {

    String encrypt(String message, Object... key);
    String decrypt(String message, Object... key);
}
