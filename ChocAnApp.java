// import java.util.*;

// public class ChocAnApp {

//     public static void main(String[] args) {
//         ChocAnSystem system = new ChocAnSystem();
//         system.runConsole();
//     }
// }

// /* ================================
//       CHOCAN SYSTEM CONTROLLER
//    ================================ */
// class ChocAnSystem {

//     private MemberDatabase memberDB = new MemberDatabase();
//     private ProviderDatabase providerDB = new ProviderDatabase();
//     private ServiceDatabase serviceDB = new ServiceDatabase();
//     private ServiceRecordDatabase recordDB = new ServiceRecordDatabase();

//     // Main console loop for testing (as required by assignment)
//     public void runConsole() {
//         Scanner sc = new Scanner(System.in);
//         Provider currentProvider = null;

//     // Require provider login first
//         while (currentProvider == null) {
//             System.out.print("Enter provider number to access system: ");
//             String provNum = sc.nextLine();
//             currentProvider = providerDB.verifyProvider(provNum);
//         if (currentProvider == null) {
//             System.out.println("Invalid provider number. Try again.");
//         } else {
//             System.out.println("Welcome, " + currentProvider.name + "!");
//         }
//     }

//         while (true) {
//             System.out.println("\n==== ChocAn System ====");
//             System.out.println("1. Verify Member");
//             System.out.println("2. Verify Provider");
//             System.out.println("3. Bill Service");
//             System.out.println("4. Show Provider Directory");
//             System.out.println("5. Exit");
//             System.out.println("6. View Billing History");
//             System.out.println("7. Add Member");
//             System.out.println("8. Edit Member");
//             System.out.println("9. Delete Member");


//             System.out.print("Choice: ");

//             int choice = Integer.parseInt(sc.nextLine());

//             switch (choice) {
//                 case 1:
//                     verifyMemberConsole(sc);
//                     break;
//                 case 2:
//                     verifyProviderConsole(sc);
//                     break;
//                 case 3:
//                     billServiceConsole(sc, currentProvider);
//                     break;
//                 case 4:
//                     serviceDB.printProviderDirectory();
//                     break;
//                 case 5:
//                     return;
//                 case 6:
//                     recordDB.printRecordsByProvider(currentProvider.getValue());
//                     break;
//                 case 7:
//                     System.out.println("What is their name?");
//                     String name = sc.nextLine();
//                     MemberDatabase.addMember(name);


//                     break;
//                 case 8:
//                     break;
//                 case 9:
//                     break;
//                 default:
//                     System.out.println("Invalid choice.");
//             }
//         }
//     }

//     private void verifyMemberConsole(Scanner sc) {
//         System.out.print("Enter member number: ");
//         String num = sc.nextLine();

//         Member m = memberDB.verifyMember(num);

//         if (m == null) {
//             System.out.println("Invalid number.");
//         } else if (!m.isActive) {
//             System.out.println("Member suspended.");
//         } else {
//             System.out.println("Validated.");
//         }
//     }

//     private void verifyProviderConsole(Scanner sc) {
//         System.out.print("Enter provider number: ");
//         String num = sc.nextLine();

//         Provider p = providerDB.verifyProvider(num);
//         if (p == null)
//             System.out.println("Invalid provider number.");
//         else
//             System.out.println("Provider validated.");
//     }

//     private void billServiceConsole(Scanner sc, Provider currentProvider) {
//         // System.out.print("Enter provider number: ");
//         // String provNum = sc.nextLine();
//         // Provider p = providerDB.verifyProvider(provNum);
//         // if (p == null) {
//         //     System.out.println("Invalid provider.");
//         //     return;
//         // }

//         System.out.print("Enter member number: ");
//         String memNum = sc.nextLine();
//         Member m = memberDB.verifyMember(memNum);
//         if (m == null || !m.isActive) {
//             System.out.println("Member invalid/suspended.");
//             return;
//         }
//         System.out.println("Validated.");

//         System.out.print("Enter service date (MM-DD-YYYY): ");
//         String serviceDate = sc.nextLine();

//         System.out.print("Enter 6-digit service code: ");
//         String code = sc.nextLine();



//         Service s = serviceDB.lookup(code);
//         if (s == null) {
//             System.out.println("Invalid service code.");
//             return;
//         }
//         System.out.println("Service: " + s.name);
//         System.out.println("Fee: $" + s.fee);
//         System.out.print("Valid?(Y/N): ");
//         String check = sc.nextLine();

//         if(!check.equals("Y")){
//             System.out.println("Invalid.");
//             return;
//         }


//         System.out.print("Comments: ");
//         String comments = sc.nextLine();

//         recordDB.addRecord(
//             new ServiceRecord(
//                 new Date(),
//                 serviceDate,
//                 currentProvider.getValue(),
//                 memNum,
//                 code,
//                 comments
//             )
//         );

//         System.out.println("Service recorded successfully.");
//     }
// }

// /* ================================
//       MEMBER / PROVIDER CLASSES
//    ================================ */

// class Member {
//     String number;
//     String name;
//     boolean isActive; // false = suspended

//     Member(String num, String nm, boolean active) {
//         this.number = num;
//         this.name = nm;
//         this.isActive = active;
//     }
// }

// class Provider {
//     String number;
//     String name;

//     Provider(String num, String nm) {
//         this.number = num;
//         this.name = nm;
//     }

//     public String getValue(){
//         return number;
//     }

//     public void setValue(String newData){
//         this.number = newData;
//     }

// }

// /* ================================
//       DATABASE MOCKS (IN-MEMORY)
//    ================================ */

// class MemberDatabase {

//     private static Map<String, Member> members = new HashMap<>();

//     MemberDatabase() {
//         members.put("123456789", new Member("123456789", "Alice Choc", true));
//         members.put("987654321", new Member("987654321", "Bob Suspended", false));
//     }
//     static int memberNumfirst = 100000000;
//     static void addMember(String name){
//         memberNumfirst = memberNumfirst+1;
//         members.put(Integer.toString(memberNumfirst), new Member(Integer.toString(memberNumfirst), name, true));
//         return;
//     }
//     Member verifyMember(String number) {
//         return members.get(number);
//     }
// }

// class ProviderDatabase {

//     private Map<String, Provider> providers = new HashMap<>();

//     ProviderDatabase() {
//         providers.put("111222333", new Provider("111222333", "Dr. Sweet"));
//         providers.put("222333444", new Provider("222333444", "Fit Trainer"));
//     }

//     Provider verifyProvider(String number) {
//         return providers.get(number);
//     }
// }

// class Service {
//     String code;
//     String name;
//     double fee;

//     Service(String c, String n, double f) {
//         code = c;
//         name = n;
//         fee = f;
//     }
// }

// class ServiceDatabase {

//     private Map<String, Service> directory = new HashMap<>();

//     ServiceDatabase() {
//         directory.put("598470", new Service("598470", "Dietitian Session", 80.00));
//         directory.put("883948", new Service("883948", "Aerobics Exercise", 65.00));
//     }

//     Service lookup(String code) {
//         return directory.get(code);
//     }

//     void printProviderDirectory() {
//         System.out.println("\n=== Provider Directory ===");
//         for (Service s : directory.values()) {
//             System.out.println(s.code + " - " + s.name + " - $" + s.fee);
//         }
//     }
// }

// class ServiceRecord {
//     Date timestamp;
//     String serviceDate;
//     String providerNum;
//     String memberNum;
//     String serviceCode;
//     String comments;

//     ServiceRecord(Date t, String sd, String p, String m, String sc, String c) {
//         timestamp = t;
//         serviceDate = sd;
//         providerNum = p;
//         memberNum = m;
//         serviceCode = sc;
//         comments = c;
//     }
// }

// class ServiceRecordDatabase {
//     private List<ServiceRecord> records = new ArrayList<>();

//     void addRecord(ServiceRecord r) {
//         records.add(r);
//         System.out.println("Record saved.");
//     }

//     // Print all records
//     void printAllRecords() {
//         System.out.println("\n=== Billing History ===");
//         if(records.isEmpty()) {
//             System.out.println("No records found.");
//             return;
//         }
//         for(ServiceRecord r : records) {
//             System.out.println("Date of Service: " + r.serviceDate +
//                                ", Provider: " + r.providerNum +
//                                ", Member: " + r.memberNum +
//                                ", Service Code: " + r.serviceCode +
//                                ", Comments: " + r.comments);
//         }
//     }

//     // Print records for a specific provider
//     void printRecordsByProvider(String providerNum) {
//         System.out.println("\n=== Billing History for Provider " + providerNum + " ===");
//         boolean found = false;
//         for(ServiceRecord r : records) {
//             if(r.providerNum.equals(providerNum)) {
//                 found = true;
//                 System.out.println("Date of Service: " + r.serviceDate +
//                                    ", Member: " + r.memberNum +
//                                    ", Service Code: " + r.serviceCode +
//                                    ", Comments: " + r.comments);
//             }
//         }
//         if(!found) System.out.println("No records found for this provider.");
//     }
// }

