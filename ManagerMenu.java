import java.util.Scanner;

public class ManagerMenu {
    private final Scanner sc;

    public ManagerMenu(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        while (true) {
            System.out.println("\n=== MANAGER MENU ===");
            System.out.println("1) Summary Report");
            System.out.println("2) Member Report");
            System.out.println("3) Provider Report");
            System.out.println("4) Back");
            System.out.print("Choose an option: ");

            switch (sc.nextLine()) {
                case "1":
                    System.out.println("=== Manager Summary Report ===");
                    System.out.println("Summary Report (placeholder)");
                    System.out.println("Correct Data + Correct Format");
                    break;

                case "2":
                    System.out.println("=== Manager Member Report ===");
                    System.out.println("Member Report (placeholder)");
                    System.out.println("Correct Data + Correct Format");
                    break;

                case "3":
                    System.out.println("=== Manager Provider Report ===");
                    System.out.println("Provider Report (placeholder)");
                    System.out.println("Correct Data + Correct Format");
                    break;

                case "4":
                    return;

                default:
                    System.out.println("Invalid option.");
            }

        }
    }
}
