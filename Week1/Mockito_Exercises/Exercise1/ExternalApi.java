/**
 * Represents an external API dependency that MyService relies on.
 * In a real application this might wrap an HTTP client calling a
 * third-party REST service.
 */
public interface ExternalApi {

    /**
     * Fetches raw data from the external API.
     *
     * @return the data returned by the external API
     */
    String getData();
}
