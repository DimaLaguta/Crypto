package encryptionalgorithms.menu;


import java.util.Scanner;

public class ViewUtils {

    public static int getId(int numberOfItems) {
        Scanner in = new Scanner(System.in);
        if (!(numberOfItems == 0)) {
            int id;
            do {
                id = in.nextInt();
                if (id < 1 || id > numberOfItems) {
                    System.out.println("Incorrect id, please, enter again");
                }
            } while (id < 1 || id > numberOfItems);

            return id - 1;
        }

        return -1;
    }

    public static int getId() {
        Scanner in = new Scanner(System.in);
        int id;
        do {
            id = in.nextInt();

            if (id < 1) {
                System.out.println("Incorrect id, please, enter again");
            }
        } while(id < 1);

        return id - 1;
    }
}
