package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import programmerzamannow.spring.core.listener.LoginAgainSuccessListener;
import programmerzamannow.spring.core.listener.LoginSuccessListener;
import programmerzamannow.spring.core.service.UserService;

public class EventListenerTest {

    @Configuration
    @Import({
        UserService.class,
        LoginSuccessListener.class,
        LoginAgainSuccessListener.class
    })
    public static class TestConfiguration {

    }

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void testEventListener() {
        UserService userService = context.getBean(UserService.class);
        boolean loginSuccess = userService.login("admin", "admin");
        boolean loginFailed = userService.login("user", "<PASSWORD>");

        Assertions.assertTrue(loginSuccess);
        Assertions.assertFalse(loginFailed);
    }
}
