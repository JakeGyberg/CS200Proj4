import java.util.HashMap;
import java.util.Map;

public class ProviderDatabase {
    private Map<String, Provider> providers = new HashMap<>();

    public ProviderDatabase() {
        providers.put("111222333", new Provider("111222333", "Dr. Sweet"));
        providers.put("222333444", new Provider("222333444", "Fit Trainer"));
    }

    public Provider verifyProvider(String number) {
        return providers.get(number);
    }

    public Map<String, Provider> getAllProviders() {
        return providers;
    }
}
