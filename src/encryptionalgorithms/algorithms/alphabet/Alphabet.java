package encryptionalgorithms.algorithms.alphabet;

public class Alphabet {

    private static final String russianAlphabet;

    static {
        russianAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    }

    public static String getRussianAlphabet() {
        return russianAlphabet;
    }
}
