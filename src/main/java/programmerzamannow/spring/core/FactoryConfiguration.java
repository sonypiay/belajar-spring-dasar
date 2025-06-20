package programmerzamannow.spring.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import programmerzamannow.spring.core.factory.PaymentGatewayClientFactory;

@Configuration
@Import({
    PaymentGatewayClientFactory.class
})
public class FactoryConfiguration {

}
