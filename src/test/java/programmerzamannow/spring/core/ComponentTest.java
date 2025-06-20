package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.repository.CategoryRepository;
import programmerzamannow.spring.core.repository.CustomerRepository;
import programmerzamannow.spring.core.repository.ProductRepository;
import programmerzamannow.spring.core.service.CategoryService;
import programmerzamannow.spring.core.service.CustomerService;
import programmerzamannow.spring.core.service.ProductService;

public class ComponentTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void testService() {
        ProductService productService1 = context.getBean(ProductService.class);
        ProductService productService2 = context.getBean("productService", ProductService.class);

        Assertions.assertSame(productService1, productService2);
    }

    @Test
    void testConstructorDI() {
        ProductService productService = context.getBean(ProductService.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        Assertions.assertSame(productService.getProductRepository(), productRepository);
    }

    @Test
    void testSetterDI() {
        CategoryService categoryService = context.getBean(CategoryService.class);
        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);

        Assertions.assertSame(categoryService.getCategoryRepository(), categoryRepository);
    }

    @Test
    void testFieldDI() {
        CustomerService customerService = context.getBean(CustomerService.class);
        CustomerRepository normalCustomerRepository = context.getBean("normalCustomerRepository", CustomerRepository.class);
        CustomerRepository premiumCustomerRepository = context.getBean("premiumCustomerRepository", CustomerRepository.class);

        Assertions.assertSame(customerService.getNormalCustomerRepository(), normalCustomerRepository);
        Assertions.assertSame(customerService.getPremiumCustomerRepository(), premiumCustomerRepository);
    }
}
