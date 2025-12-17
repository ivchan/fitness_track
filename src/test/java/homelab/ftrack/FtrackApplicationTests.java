package homelab.ftrack;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

class FtrackApplicationTests {

  @Test
  void mainMethodShouldCallSpringApplicationRunWithCorrectArguments() {
    // Mock the static SpringApplication.run() method
    try (MockedStatic<SpringApplication> mockedSpringApplication = Mockito.mockStatic(SpringApplication.class)) {
      // Define behavior: return a mock context when run() is called
      ConfigurableApplicationContext mockContext = Mockito.mock(ConfigurableApplicationContext.class);
      mockedSpringApplication.when(() -> SpringApplication.run(FtrackApplication.class, new String[] {}))
          .thenReturn(mockContext);

      // Call the main method (with empty args for this example)
      FtrackApplication.main(new String[] {});

      // Verify that run() was called exactly once with the expected arguments
      mockedSpringApplication.verify(() -> SpringApplication.run(eq(FtrackApplication.class), any(String[].class)));
    }
  }

  @Test
  void mainMethodWithArguments() {
    try (MockedStatic<SpringApplication> mocked = Mockito.mockStatic(SpringApplication.class)) {
      ConfigurableApplicationContext mockContext = Mockito.mock(ConfigurableApplicationContext.class);
      String[] args = { "--spring.profiles.active=test", "--debug" };

      mocked.when(() -> SpringApplication.run(FtrackApplication.class, args)).thenReturn(mockContext);

      FtrackApplication.main(args);

      mocked.verify(() -> SpringApplication.run(eq(FtrackApplication.class), eq(args)));
    }
  }

}
