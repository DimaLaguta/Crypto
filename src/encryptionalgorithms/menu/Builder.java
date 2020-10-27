package encryptionalgorithms.menu;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private Menu rootMenu;
    private static List<Menu> menuList;

    public List<Menu> getMenuList() {
        if (menuList == null) {
            menuList = new ArrayList<>();
        }

        return menuList;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    public void buildMenu(String name, List<MenuItem> menuItems) {
        rootMenu = new Menu(name, menuItems);

        if (menuList == null) {
            menuList = new ArrayList<>();
        }
        menuList.add(rootMenu);
    }
}
