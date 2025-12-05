import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProviderDatabase {
    private static Map<String, Provider> providers = new HashMap<>();

    public ProviderDatabase() {
        providers.put("111222333", new Provider( "Dr. Sweet", "111222333", "", "", "", ""));
        providers.put("222333444", new Provider("Fit Trainer", "222333444", "", "", "", ""));
    }

    public Provider verifyProvider(String number) {
        return providers.get(number);
    }

     public static Provider addProvider() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please add the updated information one at a time starting with their name.");
        String newName = sc.nextLine();
        System.out.println("Number?");
        String newNumber = sc.nextLine();
                    
        Provider p = new Provider(newNumber, newName, "", "", "", "");
        providers.put(newNumber, p);
        return p;
    }

    public  Provider editProvider(String number){
        Scanner c = new Scanner(System.in);
        Provider p = providers.get(number);

        System.out.println("Please add the updated information one at a time starting with their name.");
        p.setName(c.nextLine());
        return p;
    }

    public void deleteProvider(String number){
         providers.remove(number);
    }

    public static Map<String, Provider> getAllProviders() {
        return providers;
    }

    public Provider lookup(String providerNumber) {
        // Check if the member exists in the map
        if (providers.containsKey(providerNumber)) {
            return providers.get(providerNumber);
        } else {
            // Create a dummy member with number "-1"
            Provider nonExistentProvider = new Provider(
                "N/A",
                "-1",
                "N/A",
                "N/A",
                "N/A",
                "N/A"
            );
            return nonExistentProvider;
        }
    }
}
