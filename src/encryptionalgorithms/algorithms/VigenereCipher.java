package encryptionalgorithms.algorithms;

import encryptionalgorithms.algorithms.alphabet.Alphabet;
import encryptionalgorithms.algorithms.util.Cipher;

public class VigenereCipher implements Cipher {

    @Override
    public String encrypt(String message, Object... key) {
        StringBuilder encryptedMessage = new StringBuilder();
        int keywordIndex = 0;

        String alphabet = Alphabet.getRussianAlphabet();
        int n = alphabet.length();

        for (Character character : message.toLowerCase().toCharArray())
        {
            if (!alphabet.contains(character.toString())) {
                encryptedMessage.append(character);
            } else {
                int encryptedChar = (alphabet.indexOf(character) +
                        alphabet.indexOf(String.valueOf(key[0]).toLowerCase().charAt(keywordIndex))) % n;

                encryptedMessage.append(alphabet.charAt(encryptedChar));

                keywordIndex = (keywordIndex + 1) == String.valueOf(key[0]).length() ? 0 : keywordIndex + 1;
            }
        }

        return encryptedMessage.toString();
    }

    @Override
    public String decrypt(String message, Object... key) {
        StringBuilder decryptedMessage = new StringBuilder();
        int keywordIndex = 0;

        String alphabet = Alphabet.getRussianAlphabet();
        int n = alphabet.length();

        for (Character character : message.toLowerCase().toCharArray()) {
            if (!alphabet.contains(character.toString())) {
                decryptedMessage.append(character);
            } else {
                int decryptedCharacter = (alphabet.indexOf(character) + n -
                        alphabet.indexOf(String.valueOf(key[0]).toLowerCase().charAt(keywordIndex))) % n;

                decryptedMessage.append(alphabet.charAt(decryptedCharacter));

                keywordIndex = (keywordIndex + 1) == String.valueOf(key[0]).length() ? 0 : keywordIndex + 1;
            }
        }

        return decryptedMessage.toString();
    }
}
