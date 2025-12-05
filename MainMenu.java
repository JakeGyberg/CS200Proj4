import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    private final Scanner sc;

    private MemberDatabase memberDB;
    private ProviderDatabase providerDB;
    private ServiceDatabase serviceDB;
    private ServiceRecordDatabase recordDB;


    public MainMenu(MemberDatabase memberDB, ProviderDatabase providerDB, ServiceDatabase serviceDB, ServiceRecordDatabase recordDB) {
        this.sc = new Scanner(System.in);
        this.memberDB = memberDB;
        this.providerDB = providerDB;
        this.serviceDB = serviceDB;
        this.recordDB = recordDB;
    }

    public void run() {
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1) Summary Report");
            System.out.println("2) Member Report");
            System.out.println("3) Provider Report");
            System.out.println("4) Back");
            System.out.print("Choose an option: ");

            switch (sc.nextLine()) {
                case "1":
                    System.out.println("=== Summary Report ===");

                    /* 
                    Summary report contains: 
                    For each provider, list
                    provider name, number of consultations this week, total fee this week

                    At the end, write: # of providers, total consultations, overall fee total
                    */
                    Map<String, Provider> allProviders = providerDB.getAllProviders();

                    int totalProviders = 0;
                    int totalConsultations = 0;
                    double totalFee = 0;

                    for (Provider p : allProviders.values()) {
                        // print data in a line
                        int subTotalConsultations = 0;
                        int subTotalFee = 0;
                        for (ServiceRecord r : p.getAllRecords()) {
                            subTotalConsultations += 1;
                            subTotalFee += r.getService(serviceDB).getFee();
                        }
                        System.out.println("Provider name: " + p.getName() + " | Consultations this week: " + subTotalConsultations + " | Total amount billed: $" + subTotalFee);
                        totalProviders += 1;
                        totalConsultations += subTotalConsultations;
                        totalFee += subTotalFee;
                    }
                    System.out.println("\nTotal providers: " + totalProviders + " | Total consultaions: " + totalConsultations + " | Total amount billed: $" + totalFee);
                    
                    
                    break;

                case "2":
                    System.out.println("=== Member Report ===");
                    Member member;
                    while (true) {

                        System.out.println("Enter member number to run report or enter (ls) to list members");
                        String userInput = sc.nextLine();
                        if (userInput.equals("ls")) {
                            for (Member m : memberDB.getAllMembers().values()) {
                                System.out.println(m.toString());
                            }
                            continue;
                        }
                        Member temp = memberDB.lookup(userInput);
                        if (temp.getNumber().equals("-1")) {
                            System.out.println("Invalid member number");
                            continue;
                        }
                        member = temp;
                        break;
                    }
                    
                    
                    System.out.println("Member name: " + member.getName());
                    System.out.println("Member number: " + member.getNumber());
                    System.out.println("Member street address: " + member.getStreetAddress());
                    System.out.println("Member city: " + member.getCity());
                    System.out.println("Member state: " + member.getState());
                    System.out.println("Member zip: " + member.getZipCode());
                    System.out.println("\nServices this week:");

                    for (ServiceRecord sr : member.getServices()) {
                        System.out.println(
                            "Service name: " + sr.getService(serviceDB).getName() +
                            " | Service date: " + sr.getServiceDate() +
                            " | Provider name: " + sr.getProvider(providerDB).getName()
                        ); 
                    }

                    break;

                case "3":
                    System.out.println("=== Provider Report ===");
                    Provider provider;
                    while (true) {

                        System.out.println("Enter provider number to run report or enter (ls) to list providers");
                        String userInput = sc.nextLine();
                        if (userInput.equals("ls")) {
                            for (Provider p : providerDB.getAllProviders().values()) {
                                System.out.println(p.toString());
                            }
                            continue;
                        }
                        Provider temp = providerDB.lookup(userInput);
                        if (temp.getNumber().equals("-1")) {
                            System.out.println("Invalid provider number");
                            continue;
                        }
                        provider = temp;
                        break;
                    }
                    
                    System.out.println("Provider name: " + provider.getName());
                    System.out.println("Provider number: " + provider.getNumber());
                    System.out.println("Provider street address: " + provider.getStreetAddress());
                    System.out.println("Provider city: " + provider.getCity());
                    System.out.println("Provider state: " + provider.getState());
                    System.out.println("Provider zip: " + provider.getZipCode());

                    System.out.println("\nServices this week:");
                    int totalConsultations_02 = 0;
                    double totalFee_02 = 0;
                    for (ServiceRecord sr : provider.getAllRecords()) {
                        totalConsultations_02++;
                        totalFee_02 += sr.getService(serviceDB).getFee();
                        System.out.println("Service name: " + sr.getService(serviceDB).getName());
                        System.out.println("Service date: " + sr.getServiceDate());
                        System.out.println("Service date and time data were received by the computer: " + sr.getServiceDate());
                        System.out.println("Member name: " + sr.getMember(memberDB).getName());
                        System.out.println("Member name: " + sr.getMemberNum());
                        System.out.println("Member name: " + sr.getServiceCode());
                        System.out.println("Service fee to be paid: $" + sr.getService(serviceDB).getFee());
                    }
                    System.out.println("Total services this week: " + totalConsultations_02 + " | Total amount billed this week: $" + totalFee_02);

                    break;

                case "4":
                    return;

                default:
                    System.out.println("Invalid option.");
            }

        }
    }
}
