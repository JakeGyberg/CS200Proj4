import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProviderDatabase {
    private static Map<String, Provider> providers = new HashMap<>();

    public ProviderDatabase() {
        providers.put("111222333", new Provider("111222333", "Dr. Sweet"));
        providers.put("222333444", new Provider("222333444", "Fit Trainer"));
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
                    
        Provider p = new Provider(newNumber, newName);
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
}
