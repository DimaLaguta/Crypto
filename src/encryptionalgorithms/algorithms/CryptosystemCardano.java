package encryptionalgorithms.algorithms;

import encryptionalgorithms.algorithms.util.Cipher;

public class CryptosystemCardano implements Cipher {

    @Override
    public String encrypt(String message, Object... key) {
        return algorithm(message, (int[][]) key);
    }

    @Override
    public String decrypt(String message, Object... key) {
        return algorithm(message, (int[][]) key);
    }

    private String algorithm(String message, int[][] table) {
        String[] words = message.split(" ");

        int rowLength = words[0].length();
        int columnLength = words.length;

        StringBuilder newMessage = new StringBuilder();

        for (int k = 0; k < 4; k++) {
            newMessage.append(getWord(words, table, rowLength, columnLength));
            table = rotateTable(table, rowLength, columnLength);
        }

        return newMessage.toString();
    }

    private int[][] rotateTable(int[][] table, int rowLength, int columnLength) {
        int[][] newTable = new int[columnLength][rowLength];

        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                newTable[i][j] = table[rowLength - 1 - j][i];
            }
        }

        return newTable;
    }

    private StringBuilder getWord(String[] words, int[][] table, int rowLength, int columnLength) {
        StringBuilder newMessage = new StringBuilder();

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (table[i][j] == 1) {
                    newMessage.append(words[j].charAt(i));
                }
            }
        }
        newMessage.append(" ");
        return newMessage;
    }
}
