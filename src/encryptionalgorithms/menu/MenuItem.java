package encryptionalgorithms.menu;

public class MenuItem {
    private String title;
    private IAction action;

    public MenuItem(String title, IAction action) {
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public void doAction() {
        action.execute();
        System.out.println("OPERATION COMPLETED SUCCESSFUL\n");
    }
}
