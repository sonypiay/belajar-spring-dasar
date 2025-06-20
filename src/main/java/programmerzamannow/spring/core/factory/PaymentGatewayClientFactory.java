package programmerzamannow.spring.core.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import programmerzamannow.spring.core.client.PaymentGatewayClient;

@Component("paymentGatewayClient")
public class PaymentGatewayClientFactory implements FactoryBean<PaymentGatewayClient> {

    @Override
    public PaymentGatewayClient getObject() throws Exception {
        PaymentGatewayClient client = new PaymentGatewayClient();
        client.setEndpoint("http://localhost:8080/");
        client.setPublicKey("12345678");
        client.setPrivateKey("rahasia");

        return client;
    }

    @Override
    public Class<?> getObjectType() {
        return PaymentGatewayClient.class;
    }
}
