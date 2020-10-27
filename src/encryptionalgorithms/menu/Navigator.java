package encryptionalgorithms.menu;

import java.util.List;

public class Navigator {
    private Menu currentMenu;

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void printMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("***").append(currentMenu.getName()).append("***\n");
        List<MenuItem> items = currentMenu.getMenuItems();

        for (int i = 0; i < items.size(); i++) {
            menu.append(i + 1).append(" ").append(items.get(i).getTitle()).append("\n");
        }

        System.out.println(menu);
    }

    public void navigate(Integer index) {
        currentMenu.getMenuItems().get(index).doAction();
    }
}
