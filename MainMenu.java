import java.util.List;
import java.util.Map;
import java.util.Scanner;
//Jake and Gia Minh Do
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
                    List<ServiceRecord> allRecords = recordDB.getAllRecords();
                    Map<String, Provider> allProviders = providerDB.getAllProviders();

            switch (sc.nextLine()) {
                 case "1":  // SUMMARY REPORT
                    System.out.println("=== Main Menu Summary Report ===");


                    int totalProviders = allProviders.size();
                    int totalConsultations = allRecords.size();
                    double totalFee = 0;

                    for (Provider p : allProviders.values()) {
                        int subTotalConsultations = 0;
                        double subTotalFee = 0;

                        for (ServiceRecord r : allRecords) {
                            if (r.getProviderNum().equals(p.getNumber())) {
                                subTotalConsultations++;
                                subTotalFee += r.getService(serviceDB).getFee();
                            }
                        }

                        System.out.println("Provider name: " + p.getName() +
                                " | Consultations this week: " + subTotalConsultations +
                                " | Total amount billed: $" + subTotalFee);

                        totalFee += subTotalFee;
                    }

                    System.out.println("\nTotal providers: " + totalProviders +
                            " | Total consultations: " + totalConsultations +
                            " | Total amount billed: $" + totalFee);

                    break;

                case "2":  // MEMBER REPORT
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

                    System.out.println("=== Main Menu Member Report ===");
                    System.out.println("Member name: " + member.getName());
                    System.out.println("Member number: " + member.getNumber());
                    System.out.println("Member street address: " + member.getStreetAddress());
                    System.out.println("Member city: " + member.getCity());
                    System.out.println("Member state: " + member.getState());
                    System.out.println("Member zip: " + member.getZipCode());
                    System.out.println("\nServices this week:");

                    for (ServiceRecord sr : allRecords) {
                        if (sr.getMemberNum().equals(member.getNumber())) {
                            System.out.println(
                                    "Service name: " + sr.getService(serviceDB).getName() +
                                    " | Service date: " + sr.getServiceDate() +
                                    " | Provider name: " + sr.getProvider(providerDB).getName() +
                                    " | Service fee: $" + sr.getService(serviceDB).getFee()
                            );
                        }
                    }

                    break;

                case "3":  // PROVIDER REPORT
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

                    System.out.println("=== Main Menu Provider Report ===");
                    System.out.println("Provider name: " + provider.getName());
                    System.out.println("Provider number: " + provider.getNumber());
                    System.out.println("Provider street address: " + provider.getStreetAddress());
                    System.out.println("Provider city: " + provider.getCity());
                    System.out.println("Provider state: " + provider.getState());
                    System.out.println("Provider zip: " + provider.getZipCode());

                    System.out.println("\nServices this week:");
                    int totalConsultations_02 = 0;
                    double totalFee_02 = 0;
                    for (ServiceRecord sr : allRecords) {
                        if (sr.getProviderNum().equals(provider.getNumber())) {
                            totalConsultations_02++;
                            totalFee_02 += sr.getService(serviceDB).getFee();
                            System.out.println("Service name: " + sr.getService(serviceDB).getName());
                            System.out.println("Service date: " + sr.getServiceDate());
                            System.out.println("Member name: " + sr.getMember(memberDB).getName());
                            System.out.println("Service fee to be paid: $" + sr.getService(serviceDB).getFee());
                        }
                    }
                    System.out.println("Total services this week: " + totalConsultations_02 +
                            " | Total amount billed this week: $" + totalFee_02);

                    break;


                case "4":
                    return;

                default:
                    System.out.println("Invalid option.");
            }

        }
    }
}
