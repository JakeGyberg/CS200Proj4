import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemberDatabase {
    private static Map<String, Member> members = new HashMap<>();
    private static int memberNumCounter = 100000000;

    public MemberDatabase() {
        members.put("123456789", new Member("Alice Choc", "123456789", "123 street lane", "city city", "Alabama", "12345", true));
        members.put("987654321", new Member("Bob Suspended", "987654321", "321 street lane", "town city", "Texas", "54321", false));

    }

    public Member verifyMember(String number) {
        return members.get(number);
    }

    public static Member addMember() {
        Scanner sc = new Scanner(System.in);
        memberNumCounter++;
        String newNum = Integer.toString(memberNumCounter);
        System.out.println("Please add the updated information one at a time starting with their name.");
                    String newName = sc.nextLine();
                    System.out.println("Number? (Recomended: " + memberNumCounter+1);
                    String newNumber = sc.nextLine();
                    System.out.println("Address?");
                    String newAddress = sc.nextLine();
                    System.out.println("City?");
                    String newCity = sc.nextLine();
                    System.out.println("State?");
                    String newState = sc.nextLine();
                    System.out.println("Zip Code?");
                    String newZip = sc.nextLine();
                    System.out.println("Active?(True or False)");
                    boolean newActive = sc.nextBoolean();
        Member m = new Member(newName, newNumber, newAddress, newCity, newState, newZip, newActive);
        members.put(newNumber, m);
        return m;
    }

    public  Member editMember(String number){
                Scanner c = new Scanner(System.in);
                Member m = members.get(number);
        
                    System.out.println("Please add the updated information one at a time starting with their name.");
                    m.setName(c.nextLine());
                    System.out.println("Address?");
                    m.setStreetAddress(c.nextLine());
                    System.out.println("City?");
                    m.setCity(c.nextLine());
                    System.out.println("State?");
                    m.setState(c.nextLine());
                    System.out.println("Zip Code?");
                    m.setZipCode(c.nextLine());
                    System.out.println("Active?(True or False)");
                    m.setActive(c.nextBoolean());                    
        return m;
    }

    public void deleteMember(String number){
         members.remove(number);
    }

    public static Map<String, Member> getAllMembers() {
        return members;
    }
}
