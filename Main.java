import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Choc An System ===");
            System.out.println("(1) Main Menu");
            System.out.println("(2) Operator Menu");
            System.out.println("(3) Provider Menu");
            System.out.println("(4) Manager Menu");
            System.out.println("(exit) Exit program");
            System.out.print("Choose an option: ");

            switch (sc.nextLine()) {
                case "1":
                    //new MainMenu(sc).run();
                    break;
                case "2":
                    //new OperatorMenu(sc).run();
                    break;
                case "3":
                    //new ProviderMenu(sc).run();
                    break;
                case "4":
                    new ManagerMenu(sc).run();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
