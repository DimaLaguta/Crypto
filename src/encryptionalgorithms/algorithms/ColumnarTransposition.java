package encryptionalgorithms.algorithms;

import encryptionalgorithms.algorithms.util.Cipher;

public class ColumnarTransposition implements Cipher {

    @Override
    public String encrypt(String message, Object... key) {
       return algorithm(message);
    }

    @Override
    public String decrypt(String message, Object... key) {
        return algorithm(message);
    }

    private String algorithm(String message) {
        String[] words = message.toLowerCase().split(" ");
        int columnLength = words[0].length();

        StringBuilder newMessage = new StringBuilder();

        for (int j = 0 ; j < columnLength; j++) {
            for (String word : words) {
                newMessage.append(word.charAt(j));
            }
            newMessage.append(" ");
        }

        return newMessage.toString();
    }
}
