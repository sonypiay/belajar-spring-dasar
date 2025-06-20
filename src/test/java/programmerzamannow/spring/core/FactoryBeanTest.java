package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.client.PaymentGatewayClient;

public class FactoryBeanTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(FactoryConfiguration.class);
    }

    @Test
    void testFactoryBean() {
        PaymentGatewayClient client = context.getBean(PaymentGatewayClient.class);;

        Assertions.assertEquals("http://localhost:8080/", client.getEndpoint());
        Assertions.assertEquals("12345678", client.getPublicKey());
        Assertions.assertEquals("rahasia", client.getPrivateKey());
    }
}
