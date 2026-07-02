/**
 * A service that depends on an external API to fetch data.
 * The dependency is injected through the constructor, which makes it
 * easy to substitute a mock implementation during testing.
 */
public class MyService {

    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    /**
     * Fetches data by delegating to the external API.
     *
     * @return the data obtained from the external API
     */
    public String fetchData() {
        return externalApi.getData();
    }
}
