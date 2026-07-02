import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Demonstrates verifying that a mocked dependency's method is actually
 * invoked as expected, using Mockito's verify().
 */
public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create a mock object.
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Call the method with specific arguments (via the service).
        MyService service = new MyService(mockApi);
        service.fetchData();

        // 3. Verify the interaction.
        verify(mockApi).getData();

        System.out.println("testVerifyInteraction passed. Verified that mockApi.getData() was called exactly once.");
    }
}
