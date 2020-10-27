package encryptionalgorithms.algorithms;

import encryptionalgorithms.algorithms.alphabet.Alphabet;
import encryptionalgorithms.algorithms.util.Cipher;

public class CaesarCipher implements Cipher {

    @Override
    public String encrypt(String message, Object... key) {
        return algorithm(message, String.valueOf(key[0]), true);
    }

    @Override
    public String decrypt(String message, Object... key) {
        return algorithm(message, String.valueOf(key[0]), false);
    }

    private String algorithm(String message, String key, boolean isEncrypt) {
        String alphabet = Alphabet.getRussianAlphabet();
        int intKey = Integer.parseInt(key);
        if (!isEncrypt) {
            intKey *= -1;
            intKey += alphabet.length();
        }

        StringBuilder newMessage = new StringBuilder();
        for (Character character : message.toLowerCase().toCharArray()) {
            newMessage.append(
                    alphabet.contains(character.toString())
                            ? alphabet.charAt((alphabet.indexOf(character) + intKey) % alphabet.length())
                            : character);
        }
        return newMessage.toString();
    }
}
