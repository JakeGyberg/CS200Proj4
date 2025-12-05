import java.util.Scanner;

public class Main {

    // Shared databases
    static MemberDatabase memberDB = new MemberDatabase();
    static ProviderDatabase providerDB = new ProviderDatabase();
    static ServiceDatabase serviceDB = new ServiceDatabase();
    static ServiceRecordDatabase recordDB = new ServiceRecordDatabase();

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

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    // Placeholder for Main Menu
                    System.out.println("Main Menu selected");
                    break;
                case "2":
                    // Launch Operator Menu
                    OperatorMenuApp operatorMenu = new OperatorMenuApp(
                        memberDB, providerDB, serviceDB, recordDB
                    );
                    operatorMenu.run(sc);
                    break;
                case "3":
                    ProviderMenu providerMenu = new ProviderMenu(memberDB, providerDB, serviceDB, recordDB);
                    providerMenu.run(sc);
                    break;
                case "4":
                    System.out.println("Manager Menu not implemented yet");
                    break;
                case "exit":
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
