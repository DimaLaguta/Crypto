package encryptionalgorithms.controllers;

import encryptionalgorithms.menu.Builder;
import encryptionalgorithms.menu.Menu;
import encryptionalgorithms.menu.MenuItem;
import encryptionalgorithms.menu.Navigator;
import encryptionalgorithms.menu.ViewUtils;

import java.util.ArrayList;
import java.util.List;

public class MenuController {

    private Builder builder;
    private Navigator navigator;
    private ViewController viewController;

    public MenuController(Builder builder, Navigator navigator, ViewController viewController) {
        this.builder = builder;
        this.navigator = navigator;
        this.viewController = viewController;
    }

    public void run() {
        this.initialize();


        int idMenuItem;
        returnToTheMainMenu();

        do {
            this.navigator.printMenu();

            idMenuItem = ViewUtils.getId(this.navigator.getCurrentMenu().getMenuItems().size());
            this.navigator.navigate(idMenuItem);

        } while (true);
    }

    private void initialize() {
        List<MenuItem> menuItems = new ArrayList<>();


        menuItems.add(new MenuItem("encrypt", viewController::caesarEncrypt));
        menuItems.add(new MenuItem("decrypt", viewController::caesarDecrypt));
        menuItems.add(new MenuItem("Return to the main menu", this::returnToTheMainMenu));
        builder.buildMenu("Caesar Cipher", menuItems);

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("encrypt", viewController::gibberishEncrypt));
        menuItems.add(new MenuItem("decrypt", viewController::gibberishDecrypt));
        builder.buildMenu("Gibberish Letter", menuItems);

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("encrypt", viewController::columnarTranspositionEncrypt));
        menuItems.add(new MenuItem("decrypt", viewController::columnarTranspositionDecrypt));
        menuItems.add(new MenuItem("Return to the main menu", this::returnToTheMainMenu));
        builder.buildMenu("Columnar Transposition", menuItems);

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("encrypt", viewController::vigenereCipherEncrypt));
        menuItems.add(new MenuItem("decrypt", viewController::vigenereCipherDecrypt));
        menuItems.add(new MenuItem("Return to the main menu", this::returnToTheMainMenu));
        builder.buildMenu("Vigenere Cipher", menuItems);

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("encrypt", viewController::cryptosystemCardanoEncrypt));
        menuItems.add(new MenuItem("decrypt", viewController::cryptosystemCardanoDecrypt));
        menuItems.add(new MenuItem("Return to the main menu", this::returnToTheMainMenu));
        builder.buildMenu("Cryptosystem Cardano", menuItems);

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("encrypt", viewController::rsaEncrypt));
        menuItems.add(new MenuItem("decrypt", viewController::rsaDecrypt));
        menuItems.add(new MenuItem("Return to the main menu", this::returnToTheMainMenu));
        builder.buildMenu("Rsa Cipher", menuItems);

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("encrypt", viewController::rabinEncrypt));
        menuItems.add(new MenuItem("decrypt", viewController::rabinDecrypt));
        menuItems.add(new MenuItem("Return to the main menu", this::returnToTheMainMenu));
        builder.buildMenu("Rabin Cipher", menuItems);

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("encrypt", viewController::elgamalEncrypt));
        menuItems.add(new MenuItem("decrypt", viewController::elgamanlDecrypt));
        menuItems.add(new MenuItem("Return to the main menu", this::returnToTheMainMenu));
        builder.buildMenu("Elgamel Cipher", menuItems);

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Return to the main menu", this::returnToTheMainMenu));
        menuItems.add(new MenuItem("Return to the main menu", this::returnToTheMainMenu));
        menuItems.add(new MenuItem("Really exit", this::exit));
        builder.buildMenu("Exit", menuItems);
    }

    private void printAllMenu() {
        List<Menu> menuList = builder.getMenuList();

        for (int i = 0; i < menuList.size(); i++) {
            System.out.println(i + 1 + " " + menuList.get(i).getName());
        }

        System.out.println();
    }

    private void returnToTheMainMenu() {
        List<Menu> menuList = builder.getMenuList();

        this.printAllMenu();
        int idMenu = ViewUtils.getId(builder.getMenuList().size());
        this.navigator.setCurrentMenu(menuList.get(idMenu));
    }

    private void exit() {
        System.exit(0);
    }
}
