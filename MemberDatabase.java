import java.util.HashMap;
import java.util.Map;

public class MemberDatabase {
    private Map<String, Member> members = new HashMap<>();
    private int memberNumCounter = 100000000;

    public MemberDatabase() {
        members.put("123456789", new Member("Alice Choc", "123456789", "123 street lane", "city city", "Alabama", "12345", true));
        members.put("987654321", new Member("Bob Suspended", "987654321", "321 street lane", "town city", "Texas", "54321", false));

    }

    public Member verifyMember(String number) {
        return members.get(number);
    }

    public Member addMember(String name) {
        memberNumCounter++;
        String newNum = Integer.toString(memberNumCounter);
        Member m = new Member(name, newNum, "123 street lane", "city city", "Alabama", "12345", true);
        members.put(newNum, m);
        return m;
    }

    public Map<String, Member> getAllMembers() {
        return members;
    }
}
