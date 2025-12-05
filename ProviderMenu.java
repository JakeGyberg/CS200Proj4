import java.util.*;

public class ProviderMenu {

    private MemberDatabase memberDB;
    private ProviderDatabase providerDB;
    private ServiceDatabase serviceDB;
    private ServiceRecordDatabase recordDB;

    // Constructor receives the shared databases
    public ProviderMenu(MemberDatabase memberDB, ProviderDatabase providerDB,
                           ServiceDatabase serviceDB, ServiceRecordDatabase recordDB) {
        this.memberDB = memberDB;
        this.providerDB = providerDB;
        this.serviceDB = serviceDB;
        this.recordDB = recordDB;
    }

    // Run the operator menu
    public void run(Scanner sc) {
        Provider currentProvider = null;

    // Require provider login first
        while (currentProvider == null) {
            System.out.print("Enter provider number to access system: ");
            String provNum = sc.nextLine();
            currentProvider = providerDB.verifyProvider(provNum);
        if (currentProvider == null) {
            System.out.println("Invalid");
        } else {
            System.out.println("Valid");
        }
    }
         while (true) {
            System.out.println("\n==== ChocAn System ====");
            System.out.println("1. Verify Member");
            System.out.println("2. Look Up Service Code");
            System.out.println("3. Bill Service");
            System.out.println("4. Show Provider Directory");
            System.out.println("5. View Billing History");
            System.out.println("6. Exit");

            




            System.out.print("Choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    verifyMember(sc);                    
                    break;
                case 2:
                    System.out.println("Please enter the service code you are looking for:");
                    String numberLook = sc.nextLine(); 
                    Service checked = serviceDB.lookup(numberLook);
                    System.out.println("\nThe service is: \n" + "Name: " + checked.getName() + "\nFee:" + checked.getFee());
                    break;
                case 3:
                    billService(sc, currentProvider);
                    break;
                case 4:
                    serviceDB.printProviderDirectory();
                    break;
                case 5:
                    recordDB.printRecordsByProvider(currentProvider.getValue());
                    break;
                case 6:
                    recordDB.printAllRecords();
                    return;
                    
                default:
                    System.out.println("Invalid choice.");
            }
        }
        // while (true) {
        //     System.out.println("\n=== Operator Menu ===");
        //     System.out.println("1. Verify Member");
        //     System.out.println("2. Verify Provider");
        //     System.out.println("3. Bill Service");
        //     System.out.println("4. Show Provider Directory");
        //     System.out.println("5. View Billing History");
        //     System.out.println("6. Return to Main Menu");
        //     System.out.print("Choice: ");

        //     int choice;
        //     try {
        //         choice = Integer.parseInt(sc.nextLine());
        //     } catch (NumberFormatException e) {
        //         System.out.println("Invalid input.");
        //         continue;
        //     }

        //     switch (choice) {
        //         case 1:
        //             verifyMember(sc);
        //             break;
        //         case 2:
        //             verifyProvider(sc);
        //             break;
        //         case 3:
        //             billService(sc, currentProvider);
        //             break;
        //         case 4:
        //             serviceDB.printProviderDirectory();
        //             break;
        //         case 5:
        //             recordDB.printAllRecords();
        //             break;
        //         case 6:
        //             return; // Back to Main Menu
        //         default:
        //             System.out.println("Invalid choice.");
        //     }
        // }
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

    private void billService(Scanner sc, Provider currentProvider) {
        // System.out.print("Enter provider number: ");
        // String provNum = sc.nextLine();
        // Provider p = providerDB.verifyProvider(provNum);
        // if (p == null) {
        //     System.out.println("Invalid provider.");
        //     return;
        // }

        System.out.print("Enter member number: ");
        String memNum = sc.nextLine();
        Member m = memberDB.verifyMember(memNum);
        if (m == null || !m.getActive()) {
            System.out.println("Member invalid/suspended.");
            return;
        }
        System.out.println("Validated.");

        System.out.print("Enter service date (MM-DD-YYYY): ");
        String serviceDate = sc.nextLine();

        System.out.print("Enter 6-digit service code: ");
        String code = sc.nextLine();



        Service s = serviceDB.lookup(code);
        if (s == null) {
            System.out.println("Invalid service code.");
            return;
        }
        System.out.println("Service: " + s.getName());
        System.out.println("Fee: $" + s.getFee());
        System.out.print("Valid?(Y/N): ");
        String check = sc.nextLine();

        if(!check.equals("Y")){
            System.out.println("Invalid.");
            return;
        }


        System.out.print("Comments: ");
        String comments = sc.nextLine();

        recordDB.addRecord(
            new ServiceRecord(
                new Date(),
                serviceDate,
                currentProvider.getValue(),
                memNum,
                code,
                comments
            )
        );

        System.out.println("Service recorded successfully.");
    
    }
}
