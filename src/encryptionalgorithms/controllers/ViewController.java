package encryptionalgorithms.controllers;

import encryptionalgorithms.algorithms.CaesarCipher;
import encryptionalgorithms.algorithms.ColumnarTransposition;
import encryptionalgorithms.algorithms.CryptosystemCardano;
import encryptionalgorithms.algorithms.ElgamalCipher;
import encryptionalgorithms.algorithms.GibberishLetter;
import encryptionalgorithms.algorithms.RabinCipher;
import encryptionalgorithms.algorithms.RsaCipher;
import encryptionalgorithms.algorithms.VigenereCipher;

import java.util.Scanner;

public class ViewController {

    private CaesarCipher caesarCipher;
    private GibberishLetter gibberishLetter;
    private ColumnarTransposition columnarTransposition;
    private VigenereCipher vigenereCipher;
    private CryptosystemCardano cryptosystemCardano;
    private RsaCipher rsaCipher;
    private RabinCipher rabinCipher;
    private ElgamalCipher elgamalCipher;

    public ViewController(CaesarCipher caesarCipher, GibberishLetter gibberishLetter, ColumnarTransposition columnarTransposition,
                          VigenereCipher vigenereCipher, CryptosystemCardano cryptosystemCardano, RsaCipher rsaCipher,
                          RabinCipher rabinCipher, ElgamalCipher elgamalCipher) {
        this.caesarCipher = caesarCipher;
        this.gibberishLetter = gibberishLetter;
        this.columnarTransposition = columnarTransposition;
        this.vigenereCipher = vigenereCipher;
        this.cryptosystemCardano = cryptosystemCardano;
        this.rsaCipher = rsaCipher;
        this.rabinCipher = rabinCipher;
        this.elgamalCipher = elgamalCipher;
    }


    public void caesarEncrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();
        System.out.println("Enter key: ");
        String key = in.nextLine();

        System.out.println(caesarCipher.encrypt(message, key));
    }

    public void caesarDecrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();
        System.out.println("Enter key: ");
        String key = in.nextLine();

        System.out.println(caesarCipher.decrypt(message, key));
    }

    public void gibberishEncrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();

        System.out.println(gibberishLetter.encrypt(message));
    }

    public void gibberishDecrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();

        System.out.println(gibberishLetter.decrypt(message));
    }

    public void columnarTranspositionEncrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();

        System.out.println(columnarTransposition.encrypt(message));
    }

    public void columnarTranspositionDecrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();

        System.out.println(columnarTransposition.decrypt(message));
    }

    public void vigenereCipherEncrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();
        System.out.println("Enter key: ");
        String key = in.nextLine();

        System.out.println(vigenereCipher.encrypt(message, key));
    }

    public void vigenereCipherDecrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();
        System.out.println("Enter key: ");
        String key = in.nextLine();

        System.out.println(vigenereCipher.decrypt(message, key));
    }

    public void cryptosystemCardanoEncrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();
        System.out.println("Enter key: ");
        System.out.println("Enter size of the table: ");
        System.out.print("Enter number of rows: ");
        int n = in.nextInt();
        System.out.print("Enter number of columns: ");
        int m = in.nextInt();

        System.out.println("Enter array (only 0 and 1 values): ");
        int[][] array = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = in.nextInt();
            }
        }

        System.out.println(cryptosystemCardano.encrypt(message, array));
    }

    public void cryptosystemCardanoDecrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();
        System.out.println("Enter key: ");
        System.out.println("Enter size of the table: ");
        System.out.print("Enter number of rows: ");
        int n = in.nextInt();
        System.out.print("Enter number of columns: ");
        int m = in.nextInt();

        System.out.println("Enter array (only 0 and 1 values): ");
        int[][] array = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = in.nextInt();
            }
        }

        System.out.println(cryptosystemCardano.decrypt(message, array));
    }

    public void rsaEncrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();

        rsaCipher.init();

        System.out.println(rsaCipher.encrypt(message, rsaCipher.getE(), rsaCipher.getN()));
    }

    public void rsaDecrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();

        //rsaCipher.init();

        System.out.println(rsaCipher.decrypt(message, rsaCipher.getD(), rsaCipher.getN()));
    }

    public void rabinEncrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();

        rabinCipher.init();

        System.out.println(rabinCipher.encrypt(message, rabinCipher.getN()));
    }

    public void rabinDecrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();

        //rsaCipher.init();

        System.out.println(rabinCipher.decrypt(message, rabinCipher.getP(), rabinCipher.getQ(), rabinCipher.getN()));
    }

    public void elgamalEncrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();

        elgamalCipher.init();

        System.out.println(elgamalCipher.encrypt(message, elgamalCipher.getP(), elgamalCipher.getG(), elgamalCipher.getY()));
    }

    public void elgamanlDecrypt() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter message: ");
        String message = in.nextLine();

        //rsaCipher.init();

        System.out.println(elgamalCipher.decrypt(message, elgamalCipher.getP(), elgamalCipher.getX()));
    }
}
