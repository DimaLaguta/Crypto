package encryptionalgorithms;

import encryptionalgorithms.algorithms.CaesarCipher;
import encryptionalgorithms.algorithms.ColumnarTransposition;
import encryptionalgorithms.algorithms.CryptosystemCardano;
import encryptionalgorithms.algorithms.ElgamalCipher;
import encryptionalgorithms.algorithms.GibberishLetter;
import encryptionalgorithms.algorithms.RabinCipher;
import encryptionalgorithms.algorithms.RsaCipher;
import encryptionalgorithms.algorithms.VigenereCipher;
import encryptionalgorithms.controllers.MenuController;
import encryptionalgorithms.controllers.ViewController;
import encryptionalgorithms.menu.Builder;
import encryptionalgorithms.menu.Navigator;

public class Main {

    public static void main(String[] args) {

        ViewController viewController = new ViewController(new CaesarCipher(), new GibberishLetter(), new ColumnarTransposition(),
                new VigenereCipher(), new CryptosystemCardano(), new RsaCipher(), new RabinCipher(), new ElgamalCipher());
        MenuController menuController = new MenuController(new Builder(), new Navigator(), viewController);

        menuController.run();
    }
}
