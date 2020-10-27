package encryptionalgorithms.algorithms;

import encryptionalgorithms.algorithms.util.Cipher;

import java.util.HashMap;
import java.util.Map;

public class GibberishLetter implements Cipher {

    private static Map<Character, Character> map = new HashMap<>();;

    static {
        map.put('б', 'щ'); map.put('щ', 'б');
        map.put('в', 'ш'); map.put('ш', 'в');
        map.put('г', 'ч'); map.put('ч', 'г');
        map.put('д', 'ц'); map.put('ц', 'д');
        map.put('ж', 'х'); map.put('х', 'ж');
        map.put('з', 'ф'); map.put('ф', 'з');
        map.put('к', 'т'); map.put('т', 'к');
        map.put('л', 'с'); map.put('с', 'л');
        map.put('м', 'р'); map.put('р', 'м');
        map.put('н', 'п'); map.put('п', 'н');
    }

    @Override
    public String encrypt(String message, Object... key) {
        return algorithm(message);
    }

    @Override
    public String decrypt(String message, Object... key) {
        return algorithm(message);
    }

    private String algorithm(String message) {
        StringBuilder newMessage = new StringBuilder();

        for (Character character : message.toLowerCase().toCharArray()) {
            newMessage.append(
                    map.getOrDefault(character, character)
            );
        }

        return newMessage.toString();
    }
}
