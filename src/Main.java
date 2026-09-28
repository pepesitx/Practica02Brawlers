import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Brawler> brawlers = new ArrayList<>();
    private static final int MAX_ROUNDS = 10;

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.println();
            option = readInt("Option: ");
            
            switch (option) {
                case 1 -> login();
                case 2 -> System.out.println("Bye");
                default -> System.out.println("Select a valid option");
            }
            System.out.println();
        } while (option != 2);
    }

    private static void login() {
        String user = readText("User: ").toLowerCase();
        switch (user) {
            case "guest" -> guestMenu();
            case "admin" -> adminMenu();
            default -> System.out.println("Unknown user");
        }
    }

    private static void guestMenu() {
        int option;
        do {
            System.out.println();
            System.out.println("1. See brawlers");
            System.out.println("2. Combat");
            System.out.println("3. Log out");
            System.out.println();
            option = readInt("Option: ");

            switch (option) {
                case 1 -> showBrawlers();
                case 2 -> combat();
                case 3 -> System.out.println("Session closed");
                default -> System.out.println("Select a valid option");
            }
        } while (option != 3);
    }

    private static void adminMenu() {
        int option;
        do {
            System.out.println();
            System.out.println("1. See brawlers");
            System.out.println("2. Create Epic brawler");
            System.out.println("3. Create Legendary brawler");
            System.out.println("4. Log out");
            System.out.println();
            option = readInt("Option: ");

            switch (option) {
                case 1 -> showBrawlers();
                case 2 -> createEpic();
                case 3 -> createLegendary();
                case 4 -> System.out.println("Session closed");
                default -> System.out.println("Select a valid option");
            }
        } while (option != 4);
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }
        }
    }

    private static String readText(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }

    private static void showBrawlers() {
        if (brawlers.isEmpty()) {
            System.out.println("No brawlers created yet");
            return;
        }
        for (int i = 0; i < brawlers.size(); i++) {
            System.out.println((i + 1) + ". " + brawlers.get(i));
        }
    }

    private static void createLegendary() {
        String name = readText("Name: ");
        int health = readInt("Health: ");
        int damage = readInt("Damage: ");
        brawlers.add(new Legendario(name, health, damage));
    }

    private static void createEpic() {
        String name = readText("Name: ");
        int health = readInt("Health: ");
        int points = readInt("Points: ");
        brawlers.add(new Epic(name, health, points));
    }

    private static Brawler pick(String message) {
        int index = readInt(message) - 1;
        if (index < 0 || index >= brawlers.size()) {
            return null;
        }
        return brawlers.get(index);
    }

    private static void combat() {
        if (brawlers.size() < 2) {
            System.out.println("You need at least 2 brawlers");
            return;
        }
        showBrawlers();
        Brawler a = pick("First brawler: ");
        Brawler b = pick("Second brawler: ");

        if (a == null || b == null || a == b) {
            System.out.println("Select two different valid brawlers");
            return;
        }
        if (a.getHealth() <= 0 || b.getHealth() <= 0) {
            System.out.println("Both brawlers must be alive");
            return;
        }

        int round = 1;
        while (a.getHealth() > 0 && b.getHealth() > 0 && round <= MAX_ROUNDS) {
            System.out.println("--- Round " + round + " ---");
            a.actionByCategory(b);
            if (b.getHealth() > 0) {
                b.actionByCategory(a);
            }
            System.out.println(a.getName() + ": " + a.getHealth() + " | " + b.getName() + ": " + b.getHealth());
            round++;
        }

        if (a.getHealth() <= 0) {
            System.out.println(b.getName() + " wins");
        } else if (b.getHealth() <= 0) {
            System.out.println(a.getName() + " wins");
        } else if (a.getHealth() == b.getHealth()) {
            System.out.println("Draw");
        } else {
            System.out.println((a.getHealth() > b.getHealth() ? a : b).getName() + " wins on health");
        }
    }
}