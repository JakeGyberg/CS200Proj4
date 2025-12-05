import java.util.Map;
import java.util.Scanner;

public class ManagerMenu {
    private final Scanner sc;

    private MemberDatabase memberDB;
    private ProviderDatabase providerDB;
    private ServiceDatabase serviceDB;
    private ServiceRecordDatabase recordDB;


    public ManagerMenu(MemberDatabase memberDB, ProviderDatabase providerDB, ServiceDatabase serviceDB, ServiceRecordDatabase recordDB) {
        this.sc = new Scanner(System.in);
        this.memberDB = memberDB;
        this.providerDB = providerDB;
        this.serviceDB = serviceDB;
        this.recordDB = recordDB;
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

                    /* 
                    Summary report contains: 
                    For each provider, list
                    provider name, number of consultations this week, total fee this week

                    At the end, write: # of providers, total consultations, overall fee total
                    */
                    Map<String, Provider> allProviders = providerDB.getAllProviders();

                    int numProviders = 0;
                    int numConsultations = 0;
                    int totalFee = 0;

                    for (Provider p : allProviders.values()) {
                        // print data in a line
                        int consultations = p.();
                        int fee = p.getWeeklyFeeTotal();
                    }

                    
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
