package programmerzamannow.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Foo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BeanFactoryTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ScanConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void testBeanFactory() {
        ObjectProvider<Foo> beanProvider = context.getBeanProvider(Foo.class);
        List<Foo> fooList = beanProvider.stream().collect(Collectors.toList());
        Map<String, Foo> beansOfType = context.getBeansOfType(Foo.class);

//        System.out.println(fooList);
        System.out.println(beansOfType);
    }
}
