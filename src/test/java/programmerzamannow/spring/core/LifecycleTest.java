package programmerzamannow.spring.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Connection;
import programmerzamannow.spring.core.data.Server;

public class LifecycleTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(LifecycleConfiguration.class);
        context.registerShutdownHook();
    }

//    @AfterEach
//    void tearDown() {
//        context.close();
//    }

    @Test
    void testLifecycle() {
        Connection connection = context.getBean(Connection.class);
    }

    @Test
    void testServer() {
        Server server = context.getBean(Server.class);
    }
}
