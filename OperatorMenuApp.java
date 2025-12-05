import java.util.Scanner;

public class OperatorMenuApp {

    private MemberDatabase memberDB;
    private ProviderDatabase providerDB;
    private ServiceDatabase serviceDB;
    private ServiceRecordDatabase recordDB;

    // Constructor receives the shared databases
    public OperatorMenuApp(MemberDatabase memberDB, ProviderDatabase providerDB,
                           ServiceDatabase serviceDB, ServiceRecordDatabase recordDB) {
        this.memberDB = memberDB;
        this.providerDB = providerDB;
        this.serviceDB = serviceDB;
        this.recordDB = recordDB;
    }

    // Run the operator menu
    public void run(Scanner sc) {
        while (true) {
            System.out.println("\n=== Operator Menu ===");
            System.out.println("1. Verify Member");
            System.out.println("2. Verify Provider");
            System.out.println("3. Bill Service");
            System.out.println("4. Show Provider Directory");
            System.out.println("5. View Billing History");
            System.out.println("6. Return to Main Menu");
            System.out.print("Choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    verifyMember(sc);
                    break;
                case 2:
                    verifyProvider(sc);
                    break;
                case 3:
                    billService(sc);
                    break;
                case 4:
                    serviceDB.printProviderDirectory();
                    break;
                case 5:
                    recordDB.printAllRecords();
                    break;
                case 6:
                    return; // Back to Main Menu
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Example method to verify member
    private void verifyMember(Scanner sc) {
        System.out.print("Enter member number: ");
        String number = sc.nextLine();
        Member m = memberDB.verifyMember(number);
        if (m == null) {
            System.out.println("Member not found.");
        } else if (!m.getActive()) {
            System.out.println("Member is suspended.");
        } else {
            System.out.println("Member validated: " + m.getName());
        }
    }

    private void verifyProvider(Scanner sc) {
        System.out.print("Enter provider number: ");
        String number = sc.nextLine();
        Provider p = providerDB.verifyProvider(number);
        if (p == null) {
            System.out.println("Provider not found.");
        } else {
            System.out.println("Provider validated: " + p.getName());
        }
    }

    private void billService(Scanner sc) {
        System.out.println("Billing service not implemented yet");
    }
}
