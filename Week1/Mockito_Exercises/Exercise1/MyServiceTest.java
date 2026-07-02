import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Demonstrates mocking and stubbing an external API dependency with
 * Mockito so that MyService can be tested in isolation.
 */
public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // 1. Create a mock object for the external API.
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Stub the method to return a predefined value.
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Write a test case that uses the mock object.
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
        System.out.println("testExternalApi passed. fetchData() returned: " + result);

        // Verify the mock's method was actually invoked.
        verify(mockApi, times(1)).getData();
    }
}
